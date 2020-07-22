package com.antti.bankocr.model;

import com.antti.bankocr.exception.InvalidAccountNumberException;
import com.antti.bankocr.model.validator.AccountLinesValidator;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * @author Antti Ranta
 */
public class AccountLinesParserTest {

    private static final String DEFAULT_ERROR_MESSAGE = "Parser output is invalid.";
    
    private AccountLinesParser accountLinesParser;
    
    @Before
    public void setUp(){
        this.accountLinesParser = new AccountLinesParser(
                new DigitsMapper(), 
                new AccountLinesValidator()
        );
    }
    
    @Test(expected = InvalidAccountNumberException.class)
    public void testParse0() throws Exception {
        DigitChunk input = new DigitChunk(new ArrayList<String>() {
            {
                add(" _ ");
                add("| |");
                add("|_|");
                add("   ");
            }
        });
        accountLinesParser.parse(input);
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void testParse1() throws Exception {
         DigitChunk input = new DigitChunk(new ArrayList<String>() {
            {
                add("   ");
                add("  |");
                add("  |");
                add("   ");
            }
        });
        accountLinesParser.parse(input);
    }

    @Test
    public void testParse000000000() throws Exception {
         DigitChunk input = new DigitChunk(new ArrayList<String>() {
            {
                add(" _  _  _  _  _  _  _  _  _ ");
                add("| || || || || || || || || |");
                add("|_||_||_||_||_||_||_||_||_|");
                add("                           ");
            }
        });
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                "000000000",
                accountLinesParser.parse(input)
        );
    }

    @Test
    public void testParse111111111() throws Exception {
         DigitChunk input = new DigitChunk(new ArrayList<String>() {
            {
                add("                           ");
                add("  |  |  |  |  |  |  |  |  |");
                add("  |  |  |  |  |  |  |  |  |");
                add("                           ");
            }
        });
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                "111111111",
                accountLinesParser.parse(input)
        );
    }

    @Test
    public void testParse222222222() throws Exception {
        DigitChunk input = new DigitChunk(new ArrayList<String>() {
            {
                add(" _  _  _  _  _  _  _  _  _ ");
                add(" _| _| _| _| _| _| _| _| _|");
                add("|_ |_ |_ |_ |_ |_ |_ |_ |_ ");
                add("                           ");
            }
        });
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                "222222222",
                accountLinesParser.parse(input)
        );
    }

    @Test
    public void testParse333333333() throws Exception {
        DigitChunk input = new DigitChunk(new ArrayList<String>() {
            {
                add(" _  _  _  _  _  _  _  _  _ ");
                add(" _| _| _| _| _| _| _| _| _|");
                add(" _| _| _| _| _| _| _| _| _|");
                add("                           ");
            }
        });
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                "333333333",
                accountLinesParser.parse(input)
        );
    }

    @Test
    public void testParse444444444() throws Exception {
        DigitChunk input = new DigitChunk(new ArrayList<String>() {
            {
                add("                           ");
                add("|_||_||_||_||_||_||_||_||_|");
                add("  |  |  |  |  |  |  |  |  |");
                add("                           ");
            }
        });
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                "444444444",
                accountLinesParser.parse(input)
        );
    }

    @Test
    public void testParse555555555() throws Exception {
        DigitChunk input = new DigitChunk(new ArrayList<String>() {
            {
                add(" _  _  _  _  _  _  _  _  _ ");
                add("|_ |_ |_ |_ |_ |_ |_ |_ |_ ");
                add(" _| _| _| _| _| _| _| _| _|");
                add("                           ");
            }
        });
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                "555555555",
                accountLinesParser.parse(input)
        );
    }

    @Test
    public void testParse666666666() throws Exception {
        DigitChunk input = new DigitChunk(new ArrayList<String>() {
            {
                add(" _  _  _  _  _  _  _  _  _ ");
                add("|_ |_ |_ |_ |_ |_ |_ |_ |_ ");
                add("|_||_||_||_||_||_||_||_||_|");
                add("                           ");
            }
        });
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                "666666666",
                accountLinesParser.parse(input)
        );
    }

    @Test
    public void testParse777777777() throws Exception {
        DigitChunk input = new DigitChunk(new ArrayList<String>() {
            {
                add(" _  _  _  _  _  _  _  _  _ ");
                add("  |  |  |  |  |  |  |  |  |");
                add("  |  |  |  |  |  |  |  |  |");
                add("                           ");
            }
        });
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                "777777777",
                accountLinesParser.parse(input)
        );
    }

    @Test
    public void testParse888888888() throws Exception {
        DigitChunk input = new DigitChunk(new ArrayList<String>() {
            {
                add(" _  _  _  _  _  _  _  _  _ ");
                add("|_||_||_||_||_||_||_||_||_|");
                add("|_||_||_||_||_||_||_||_||_|");
                add("                           ");
            }
        });
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                "888888888",
                accountLinesParser.parse(input)
        );
    }

    @Test
    public void testParse999999999() throws Exception {
        DigitChunk input = new DigitChunk(new ArrayList<String>() {
            {
                add(" _  _  _  _  _  _  _  _  _ ");
                add("|_||_||_||_||_||_||_||_||_|");
                add(" _| _| _| _| _| _| _| _| _|");
                add("                           ");
            }
        });
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                "999999999",
                accountLinesParser.parse(input)
        );
    }

    @Test
    public void testParse123456789() throws Exception {
        DigitChunk input = new DigitChunk(new ArrayList<String>() {
            {
                add("    _  _     _  _  _  _  _ ");
                add("  | _| _||_||_ |_   ||_||_|");
                add("  ||_  _|  | _||_|  ||_| _|");
                add("                           ");
            }
        });
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                "123456789",
                accountLinesParser.parse(input)
        );
    }

    @Test
    public void testParse000000051() throws Exception {
        DigitChunk input = new DigitChunk(new ArrayList<String>() {
            {
                add(" _  _  _  _  _  _  _  _    ");
                add("| || || || || || || ||_   |");
                add("|_||_||_||_||_||_||_| _|  |");
                add("                           ");
            }
        });
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                "000000051",
                accountLinesParser.parse(input)
        );
    }

    @Test
    public void testParse110101100() throws Exception {
        DigitChunk input = new DigitChunk(new ArrayList<String>() {
            {
                add("       _     _        _  _ ");
                add("  |  || |  || |  |  || || |");
                add("  |  ||_|  ||_|  |  ||_||_|");
                add("                           ");
            }
        });
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                "110101100",
                accountLinesParser.parse(input)
        );
    }
    
    @Test
    public void testParseGarbled() throws Exception {
        DigitChunk input = new DigitChunk(new ArrayList<String>() {
            {
                add("    _  _  _  _  _  _     _ ");
                add("|_||_|| || ||_   |  |  | _ ");
                add("  | _||_||_||_|  |  |  | _|");
                add("                           ");
            }
        });
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                "49006771?",
                accountLinesParser.parse(input)
        );
    }
    
    @Test
    public void testParseGarbled2() throws Exception {
        DigitChunk input = new DigitChunk(new ArrayList<String>() {
            {
                add("       _     _           _ ");
                add("  |  || |  || |     || || |");
                add("  |  | _|  ||_|  |  ||_||_|");
                add("                           ");
            }
        });
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                "11?10?1?0",
                accountLinesParser.parse(input)
        );
    }
    
    @Test(expected = InvalidAccountNumberException.class)
    public void testUnreadable() throws Exception {
        DigitChunk input = new DigitChunk(new ArrayList<String>() {
            {
                add("   ");
                add("  _");
                add("  |");
                add("   ");
            }
        });
        accountLinesParser.parse(input);
    }
    
    @Test(expected = InvalidAccountNumberException.class)
    public void testErrorWrongNumberOfLines() throws Exception {
        DigitChunk input = new DigitChunk(new ArrayList<String>() {
            {
                add(" _ ");
                add("| |");
                add("   ");
            }
        });
        accountLinesParser.parse(input);
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void testErrorWrongNumberOfColumns() throws Exception {
        DigitChunk input = new DigitChunk(new ArrayList<String>() {
            {
                add("    ");
                add("   |");
                add("   |");
                add("    ");
            }
        });
        accountLinesParser.parse(input);
    } 
    
    @Test
    public void testParseIllegalAlphabetsMixedWithDigits() throws Exception {
        DigitChunk input = new DigitChunk(new ArrayList<String>() {
            {
                add("    _  _     _  _  _  _  _ ");
                add("  ||_||_ |_||  |_ |_ | ||_|");
                add("  || ||    ||_ |_||_ |_| _|");
                add("                           ");
            }
        });
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                "1??4?6?09",
                accountLinesParser.parse(input)
        );
    }
}
