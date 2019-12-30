package com.antti.bankocr;

import com.antti.bankocr.model.Account;
import com.antti.bankocr.model.AccountLinesParser;
import com.antti.bankocr.model.AccountLinesReader;
import com.antti.bankocr.model.ChecksumGenerator;
import com.antti.bankocr.model.DigitChunk;
import com.antti.bankocr.model.DigitsMapper;
import com.antti.bankocr.model.account.Builder;
import com.antti.bankocr.model.account.export.StdoutWriter;
import com.antti.bankocr.model.account.export.TextFileWriter;
import com.antti.bankocr.model.account.export.Writer;
import com.antti.bankocr.model.validator.AccountLinesValidator;
import com.antti.bankocr.model.validator.AccountNumberValidator;
import com.antti.bankocr.model.validator.ChecksumValidator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author Antti Ranta
 */
public class BankOcrApplication {

    public static void main(String[] args) throws Exception {
        if (args.length == 1) {
            new BankOcrApplication().process(args[0], null);
        } else if (args.length == 2) {
            new BankOcrApplication().process(args[0], args[1]);
        } else if (args.length == 0) {
            new BankOcrApplication().process(null, null);
        }
    }

    private void process(String inputFileName, final String outputFileName) {
        if (inputFileName == null) {
            inputFileName = this.getDefaultInputFileName();
        }
        
        try {
            File file = new File(inputFileName);
            if (!file.exists()) {
                throw new FileNotFoundException("Could not read accounts data.");
            }

            AccountLinesReader accountLinesReader = new AccountLinesReader(file);
            List<DigitChunk> allAccountLines = accountLinesReader.getAllAccountLines();

            AccountLinesParser accountLinesParser = new AccountLinesParser(
                    new DigitsMapper(),
                    new AccountLinesValidator()
            );
            Builder accountBuilder = new Builder(
                    new AccountNumberValidator(),
                    new ChecksumValidator(),
                    new ChecksumGenerator()
            );

            Writer outputWriter = null;
            if (outputFileName != null && !outputFileName.isEmpty()) {
                outputWriter = new TextFileWriter(outputFileName);
            } else {
                outputWriter = new StdoutWriter();
            }

            for (DigitChunk accountLines : allAccountLines) {
                String accountNumber = accountLinesParser.parse(accountLines);
                Account account = accountBuilder.build(accountNumber);
                outputWriter.addLine(account);
            }

            outputWriter.close();
        } catch (FileNotFoundException fnfe) {
            System.out.print(
                "Terminating application. Input file '" + inputFileName + "' could not be found. Please try different file."  
            ); 
        } catch (Exception e) {
            System.out.print("Terminating application. Error: " + e.getMessage());
        }
    }

    private String getDefaultInputFileName() {
        return "././././././data/example.txt";
    }
}
