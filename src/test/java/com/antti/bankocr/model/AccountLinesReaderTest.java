package com.antti.bankocr.model;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Antti Ranta
 */
public class AccountLinesReaderTest {

    private static final String DEFAULT_ERROR_MESSAGE = "Account lines are invalid.";
    private static final String DEFAULT_SIZE_ERROR_MESSAGE = "Account lines size is invalid.";

    private final String testLines000000000 = new StringBuilder()
                .append(" _  _  _  _  _  _  _  _  _ \n")
                .append("| || || || || || || || || |\n")
                .append("|_||_||_||_||_||_||_||_||_|\n")
                .append("                           \n").toString();
    
    private final String testLines111111111 = new StringBuilder()
                .append("                           \n")
                .append("  |  |  |  |  |  |  |  |  |\n")
                .append("  |  |  |  |  |  |  |  |  |\n")
                .append("                           \n").toString();
    
    private final String testLines222222222 = new StringBuilder()
                .append(" _  _  _  _  _  _  _  _  _ \n")
                .append(" _| _| _| _| _| _| _| _| _|\n")
                .append("|_ |_ |_ |_ |_ |_ |_ |_ |_ \n")
                .append("                           \n").toString();
    
    private final String testLines888888888 = new StringBuilder()
                .append(" _  _  _  _  _  _  _  _  _ \n")
                .append("|_||_||_||_||_||_||_||_||_|\n")
                .append("|_||_||_||_||_||_||_||_||_|\n")
                .append("                           \n").toString();
    
    private final String testLines999999999 = new StringBuilder()
                .append(" _  _  _  _  _  _  _  _  _ \n")
                .append("|_||_||_||_||_||_||_||_||_|\n")
                .append(" _| _| _| _| _| _| _| _| _|\n")
                .append("                           \n").toString();
    
    private final String testLines123456789 = new StringBuilder()
                .append("    _  _     _  _  _  _  _ \n")
                .append("  | _| _||_||_ |_   ||_||_|\n")
                .append("  ||_  _|  | _||_|  ||_| _|\n")
                .append("                           \n").toString();
    
    private final String testLines110101100 = new StringBuilder()
                .append("       _     _        _  _ \n")
                .append("  |  || |  || |  |  || || |\n")
                .append("  |  ||_|  ||_|  |  ||_||_|\n")
                .append("                           \n").toString();
    
    private final String testLines000000051 = new StringBuilder()
                .append(" _  _  _  _  _  _  _  _    \n")
                .append("| || || || || || || ||_   |\n")
                .append("|_||_||_||_||_||_||_| _|  |\n")
                .append("                           \n").toString();
    
    private final String testGarbledLines49006771X = new StringBuilder()
                .append("    _  _  _  _  _  _     _ \n")
                .append("|_||_|| || ||_   |  |  | _ \n")
                .append("  | _||_||_||_|  |  |  | _|\n")
                .append("                           \n").toString();
    
    private final String testLines490067715 = new StringBuilder()
                .append("    _  _  _  _  _  _     _ \n")
                .append("|_||_|| || ||_   |  |  ||_ \n")
                .append("  | _||_||_||_|  |  |  | _|\n")
                .append("                           \n").toString();
    
    private final String testGarbledLines11X10X1X0 = new StringBuilder()
                .append("       _     _           _ \n")
                .append("  |  || |  || |     || || |\n")
                .append("  |  | _|  ||_|  |  ||_||_|\n")
                .append("                           \n").toString();
    
    private final String testGarbledLines1234X678X = new StringBuilder()
                .append("    _  _     _  _  _  _  _ \n")
                .append("  | _| _||_| _ |_   ||_||_|\n")
                .append("  ||_  _|  | _||_|  ||_| _ \n")
                .append("                           \n").toString();
    
    @Test
    public void testGetAllAccountLines000000000() throws Exception {
        AccountLinesReader accountLinesReader = new AccountLinesReader(testLines000000000);
        List<DigitChunk> allAccountLines = accountLinesReader.getAllAccountLines();

        assertEquals(DEFAULT_SIZE_ERROR_MESSAGE, 1, (long)allAccountLines.size());
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                testLines000000000,
                convertDigitChunkToString(allAccountLines.get(0))
        );
    }
    
    @Test
    public void testGetAllAccountLines111111111() throws Exception {
        AccountLinesReader accountLinesReader = new AccountLinesReader(testLines111111111);
        List<DigitChunk> allAccountLines = accountLinesReader.getAllAccountLines();

        assertEquals(DEFAULT_SIZE_ERROR_MESSAGE, 1, (long)allAccountLines.size());
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                testLines111111111,
                convertDigitChunkToString(allAccountLines.get(0))
        );
    }
    
    @Test
    public void testGetAllAccountLines222222222() throws Exception {
        AccountLinesReader accountLinesReader = new AccountLinesReader(testLines222222222);
        List<DigitChunk> allAccountLines = accountLinesReader.getAllAccountLines();

        assertEquals(DEFAULT_SIZE_ERROR_MESSAGE, 1, (long)allAccountLines.size());
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                testLines222222222,
                convertDigitChunkToString(allAccountLines.get(0))
        );
    }
    
    @Test
    public void testGetAllAccountLines888888888() throws Exception {
        AccountLinesReader accountLinesReader = new AccountLinesReader(testLines888888888);
        List<DigitChunk> allAccountLines = accountLinesReader.getAllAccountLines();

        assertEquals(DEFAULT_SIZE_ERROR_MESSAGE, 1, (long)allAccountLines.size());
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                testLines888888888,
                convertDigitChunkToString(allAccountLines.get(0))
        );
    }
    
    @Test
    public void testGetAllAccountLines999999999() throws Exception {
        AccountLinesReader accountLinesReader = new AccountLinesReader(testLines999999999);
        List<DigitChunk> allAccountLines = accountLinesReader.getAllAccountLines();

        assertEquals(DEFAULT_SIZE_ERROR_MESSAGE, 1, (long)allAccountLines.size());
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                testLines999999999,
                convertDigitChunkToString(allAccountLines.get(0))
        );
    }
    
    @Test
    public void testGetAllAccountLines123456789() throws Exception {
        AccountLinesReader accountLinesReader = new AccountLinesReader(testLines123456789);
        List<DigitChunk> allAccountLines = accountLinesReader.getAllAccountLines();

        assertEquals(DEFAULT_SIZE_ERROR_MESSAGE, 1, (long)allAccountLines.size());
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                testLines123456789,
                convertDigitChunkToString(allAccountLines.get(0))
        );
    }
    
    @Test
    public void testGetAllAccountLines000000051() throws Exception {
        AccountLinesReader accountLinesReader = new AccountLinesReader(testLines000000051);
        List<DigitChunk> allAccountLines = accountLinesReader.getAllAccountLines();

        assertEquals(DEFAULT_SIZE_ERROR_MESSAGE, 1, (long)allAccountLines.size());
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                testLines000000051,
                convertDigitChunkToString(allAccountLines.get(0))
        );
    }
    
    @Test
    public void testGetAllAccountLines110101100() throws Exception {
        AccountLinesReader accountLinesReader = new AccountLinesReader(testLines110101100);
        List<DigitChunk> allAccountLines = accountLinesReader.getAllAccountLines();

        assertEquals(DEFAULT_SIZE_ERROR_MESSAGE, 1, (long)allAccountLines.size());
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                testLines110101100,
                convertDigitChunkToString(allAccountLines.get(0))
        );
    }
    
    @Test
    public void testGetAllAccountLinesGarbled49006771X() throws Exception {
        AccountLinesReader accountLinesReader = new AccountLinesReader(testGarbledLines49006771X);
        List<DigitChunk> allAccountLines = accountLinesReader.getAllAccountLines();

        assertEquals(DEFAULT_SIZE_ERROR_MESSAGE, 1, (long)allAccountLines.size());
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                testGarbledLines49006771X,
                convertDigitChunkToString(allAccountLines.get(0))
        );
    }
    
    @Test
    public void testGetAllAccountLines490067715() throws Exception {
        AccountLinesReader accountLinesReader = new AccountLinesReader(testLines490067715);
        List<DigitChunk> allAccountLines = accountLinesReader.getAllAccountLines();

        assertEquals(DEFAULT_SIZE_ERROR_MESSAGE, 1, (long)allAccountLines.size());
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                testLines490067715,
                convertDigitChunkToString(allAccountLines.get(0))
        );
    }
    
    @Test
    public void testGetAllAccountLinestestGarbled11X10X1X0() throws Exception {
        AccountLinesReader accountLinesReader = new AccountLinesReader(testGarbledLines11X10X1X0);
        List<DigitChunk> allAccountLines = accountLinesReader.getAllAccountLines();

        assertEquals(DEFAULT_SIZE_ERROR_MESSAGE, 1, (long)allAccountLines.size());
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                testGarbledLines11X10X1X0,
                convertDigitChunkToString(allAccountLines.get(0))
        );
    }
    
    @Test
    public void testGetAllAccountLinestestGarbled1234X678X() throws Exception {
        AccountLinesReader accountLinesReader = new AccountLinesReader(testGarbledLines1234X678X);
        List<DigitChunk> allAccountLines = accountLinesReader.getAllAccountLines();

        assertEquals(DEFAULT_SIZE_ERROR_MESSAGE, 1, (long)allAccountLines.size());
        assertEquals(
                DEFAULT_ERROR_MESSAGE,
                testGarbledLines1234X678X,
                convertDigitChunkToString(allAccountLines.get(0))
        );
    }

    private String convertDigitChunkToString(DigitChunk digitChunk) {
        StringBuilder sb = new StringBuilder();

        for (String lineDigits : digitChunk.getOcrDigits()) {
            sb.append(lineDigits + "\n");
        }
        return sb.toString();
    }
}
