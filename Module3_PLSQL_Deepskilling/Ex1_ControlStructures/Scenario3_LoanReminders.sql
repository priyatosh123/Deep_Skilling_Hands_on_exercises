DECLARE
    CURSOR loan_cursor IS
        SELECT l.LoanID, l.DueDate, c.CustomerName
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30;

    v_loan loan_cursor%ROWTYPE;
BEGIN
    OPEN loan_cursor;
    LOOP
        FETCH loan_cursor INTO v_loan;
        EXIT WHEN loan_cursor%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || v_loan.CustomerName ||
                             ', your loan (ID: ' || v_loan.LoanID ||
                             ') is due on ' || TO_CHAR(v_loan.DueDate, 'DD-MON-YYYY') || '.');
    END LOOP;
    CLOSE loan_cursor;
END;
/
