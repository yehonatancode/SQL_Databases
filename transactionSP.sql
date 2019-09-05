CREATE DEFINER=`root`@`localhost` PROCEDURE `transfer_balance`(
    IN sender INT,
    IN receiver INT,
    IN trAmount REAL)
BEGIN

   DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
   BEGIN
     ROLLBACK;
     SELECT 'Error occurred' as Message;
   END;

   START TRANSACTION;
   SELECT @sBl = amount FROM bankBalances WHERE userId = sender;
   UPDATE bankBalances SET amount = @sBl - trAmount WHERE userId = sender;
   SELECT @rBl = amount FROM bankBalances WHERE userId = receiver;
   UPDATE bankBalances SET amount = @rBl  + trAmount WHERE userId = receiver;
   COMMIT;
    
END;
