package edu.course.lab02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class BankAccountTest {
    @Test 
    void testBnkAccount(){
        BankAccount account = new BankAccount(100);
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }
    @Test 
    void BankAccountWithdrawTest(){
        BankAccount account = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, 
            () -> account.withdraw(200));
    }
    @Test 
    void BankAccountSuccessfulWithdrawal(){
        BankAccount account = new BankAccount(100);
        account.withdraw(40);
        assertEquals(60, account.getBalance());
    }
}

