package it.unibo.bank.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import it.unibo.bank.api.AccountHolder;
import it.unibo.bank.api.BankAccount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSimpleBankAccount {
    private AccountHolder mRossi;
    private AccountHolder aBianchi;
    private BankAccount bankAccount;

    /**
     * Configuration step: this is performed BEFORE each test.
     */
    @BeforeEach
    public void setUp() {
        this.mRossi = new AccountHolder("Mario", "Rossi", 1);
        this.aBianchi = new AccountHolder("Andrea", "Bianchi", 2);
        this.bankAccount = new SimpleBankAccount(mRossi, 0.0);
    }

    /**
     * Check that the initialization of the BankAccount is created with the correct values.
     */
    @Test
    public void testBankAccountInitialization() {
        assertEquals(0.0, bankAccount.getBalance());
        assertEquals(0, bankAccount.getTransactionsCount());
        assertEquals(mRossi, bankAccount.getAccountHolder());
    }

    /**
     * Check that the deposit is performed correctly on the Bank Account.
     */
    @Test
    public void testBankAccountDeposit() {
        int expectedValue = 0;
        assertFalse(bankAccount.getTransactionsCount() > 0);
        for(int i = 0; i < 10; i++) {
            expectedValue += i * 100;
            bankAccount.deposit(mRossi.getUserID(), i * 100);
        }
        assertEquals(expectedValue, bankAccount.getBalance());
        assertTrue(bankAccount.getTransactionsCount() > 0);
    }

    /**
     * Checks that if the wrong AccountHolder id is given, the deposit will return an IllegalArgumentException.
     */
    @Test
    public void testWrongBankAccountDeposit() {
        try {
            bankAccount.deposit(aBianchi.getUserID(), 10000);
            Assertions.fail();
        } catch (IllegalArgumentException e) {
            assertEquals("ID not corresponding: cannot perform transaction", e.getMessage());
        }
        // Alternative (with reflection): Assertions.assertThrows
    }

}
