import java.io.File;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class XmlParser {
public static void main(String []args) {
	
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();	
	try {
		
		DocumentBuilder db = dbf.newDocumentBuilder();
		org.w3c.dom.Document doc = db.parse("file.xml");
		Element e = doc.getDocumentElement();
		System.out.println(e.getTagName());
		NodeList list = e.getElementsByTagName("Name");
		System.out.println(list.item(1).getNodeValue());
		for(int i=0; i<list.getLength();i++) {
		System.out.println(((Element)list.item(i)).getTextContent());
		}
		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	XPathFactory xPathfactory = XPathFactory.newInstance();
	XPath xpath = xPathfactory.newXPath();
	XPathExpression expr = xpath.compile("University/Student[2]/Address/City");
	String city = (String)expr.evaluate(xmlDoc, XPathConstants.STRING); 

	File inputFile = new File("student.xml");
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder = factory.newDocumentBuilder();
	Document doc = builder.parse(inputFile);
	System.out.println("Root element :" + doc.getDocumentElement().getNodeName()); //Just print root (university)
	NodeList nodeList = doc.getDocumentElement().getElementsByTagName("Student");
	for (int studentIdx = 0; studentIdx < nodeList.getLength(); studentIdx++){
		    Node studentNode = nodeList.item(studentIdx);
		    if (studentNode.getNodeType() == Node.ELEMENT_NODE){
		    	Element element = (Element) studentNode; 
	        Student student = new Student();
	        studentList.add(student);
	        System.out.println("Degree : " + element.getAttribute("degree"));
	        NodeList studentAllNodes = studentNode.getChildNodes();
	        for (int stIdx = 0; stIdx < studentAllNodes.getLength(); stIdx++){
	        	Node stInnerNode = studentAllNodes.item(stIdx);
	            switch (stInnerNode.getNodeName()){
	            case "FirstName": student.firstName = stInnerNode.getTextContent();
	            break;
	            case "LastName": student.lastName = stInnerNode.getTextContent();
	            break; 
	            case "id": student.id = Integer.parseInt(stInnerNode.getTextContent());
	            break;
	            case "age": student.age = Integer.parseInt(stInnerNode.getTextContent());
	            break;
	            case "Address":
	                    Address address = new Address();
	                    student.address = address;
	                    NodeList addressAllNodes = stInnerNode.getChildNodes();
	                    for (int adIdx = 0; adIdx < addressAllNodes.getLength(); adIdx++) {
	                    	Node adInnerNode = addressAllNodes.item(adIdx);
	                    	switch (adInnerNode.getNodeName()) {
	                    	case "Street": address.street = adInnerNode.getTextContent();
	                    	break;
	                    	case "City": address.city = adInnerNode.getTextContent(); 
	                    	break;
	                    	case "Zip": address.zip = adInnerNode.getTextContent();
	                    	break;
	                    	}
	                    	}
	                    break;
	                    }
	            }
	        }
		    }

}
}
