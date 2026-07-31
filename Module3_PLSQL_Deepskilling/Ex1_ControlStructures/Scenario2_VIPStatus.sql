DECLARE
    CURSOR customer_cursor IS
        SELECT CustomerID, Balance
        FROM Customers;

    v_customer customer_cursor%ROWTYPE;
BEGIN
    OPEN customer_cursor;
    LOOP
        FETCH customer_cursor INTO v_customer;
        EXIT WHEN customer_cursor%NOTFOUND;

        IF v_customer.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = TRUE
            WHERE CustomerID = v_customer.CustomerID;

            DBMS_OUTPUT.PUT_LINE('VIP status set for CustomerID: ' || v_customer.CustomerID);
        ELSE
            UPDATE Customers
            SET IsVIP = FALSE
            WHERE CustomerID = v_customer.CustomerID;
        END IF;
    END LOOP;
    CLOSE customer_cursor;
    COMMIT;
END;
/
