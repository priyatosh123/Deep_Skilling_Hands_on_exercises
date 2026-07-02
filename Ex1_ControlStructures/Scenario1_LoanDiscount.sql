DECLARE
    CURSOR customer_cursor IS
        SELECT c.CustomerID, c.Age, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID;

    v_customer customer_cursor%ROWTYPE;
BEGIN
    OPEN customer_cursor;
    LOOP
        FETCH customer_cursor INTO v_customer;
        EXIT WHEN customer_cursor%NOTFOUND;

        IF v_customer.Age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = v_customer.LoanID;

            DBMS_OUTPUT.PUT_LINE('Discount applied for CustomerID: ' || v_customer.CustomerID);
        END IF;
    END LOOP;
    CLOSE customer_cursor;
    COMMIT;
END;
/
