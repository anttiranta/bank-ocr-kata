package com.antti.bankocr.model.account;

import com.antti.bankocr.model.Account;
import com.antti.bankocr.model.ChecksumGenerator;
import com.antti.bankocr.model.validator.AccountNumberValidator;
import com.antti.bankocr.model.validator.ChecksumValidator;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * @author Antti Ranta
 */
public class BuilderTest {

    private Builder accountBuilder;

    @Before
    public void setUp() {
        this.accountBuilder = new Builder(
                new AccountNumberValidator(),
                new ChecksumValidator(),
                new ChecksumGenerator()
        );
    }

    @Test
    public void testCreateAccountFor000000000() {
        Account account = this.accountBuilder.build("000000000");
        assertEquals("000000000", account.getAccountNumber());
        assertEquals(0, (int)account.getChecksum());
        assertNull(account.getError());
    }
    
    @Test
    public void testCreateAccountFor123456789() {
        Account account = this.accountBuilder.build("123456789");
        assertEquals("123456789", account.getAccountNumber());
        assertEquals(0, (int)account.getChecksum());
        assertNull(account.getError());
    }
    
    @Test
    public void testCreateAccountFor490867715() {
        Account account = this.accountBuilder.build("490867715");
        assertEquals("490867715", account.getAccountNumber());
        assertEquals(0, (int)account.getChecksum());
        assertNull(account.getError());
    }
    
    @Test
    public void testCreateAccountFor711111111() {
        Account account = this.accountBuilder.build("711111111");
        assertEquals("711111111", account.getAccountNumber());
        assertEquals(0, (int)account.getChecksum());
        assertNull(account.getError());
    }
    
    @Test
    public void testCreateAccountWithIllegibleAccountNumber() {
        Account account = this.accountBuilder.build("11?10?1?0");
        assertEquals("11?10?1?0", account.getAccountNumber());
        assertNull(account.getChecksum());
        assertEquals(Account.ERROR.ILL, account.getError());
    }
    
    @Test
    public void testCreateAccountForInvalidAccountNumber664371495() {
        Account account = this.accountBuilder.build("664371495");
        assertEquals("664371495", account.getAccountNumber());
        assertNotEquals(0, (int)account.getChecksum());
        assertEquals(Account.ERROR.ERR, account.getError());
    }
    
    @Test
    public void testCreateAccountForInvalidAccountNumber012345678() {
        Account account = this.accountBuilder.build("012345678");
        assertEquals("012345678", account.getAccountNumber());
        assertNotEquals(0, (int)account.getChecksum());
        assertEquals(Account.ERROR.ERR, account.getError());
    }
}
