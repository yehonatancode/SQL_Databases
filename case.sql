// Case example

SELECT student, grade, 
case when grade>90 then 'Excellent'
when grade <=90 AND grade >=75 then 'Not bad'
when grade <75 then 'We believe in you'

as status
FROM R;