package org.example;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder((MethodOrderer.OrderAnnotation.class))
public class OrderedTests {
    @Test
    @Order(1)
    public void step1_CreateAccount(){
        System.out.println("Step 1: User Account Created.");
    }
    @Test
    @Order(2)
    public void step2_LoginUser() {
        System.out.println("Step 2: User Logged In successfully.");
    }

    @Test
    @Order(3)
    public void step3_DeleteAccount() {
        System.out.println("Step 3: User Account Deleted.");
    }
}
