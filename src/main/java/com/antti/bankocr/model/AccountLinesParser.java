package com.antti.bankocr.model;

import com.antti.bankocr.exception.AccountNumberParseException;
import com.antti.bankocr.exception.InvalidAccountNumberException;
import com.antti.bankocr.model.validator.AccountLinesValidator;
import com.antti.bankocr.util.ListUtils;
import com.antti.bankocr.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antti Ranta
 */
public class AccountLinesParser {

    private final DigitsMapper digitsMapper;
    private final AccountLinesValidator accountLinesValidator;

    public AccountLinesParser(
            final DigitsMapper digitsMapper,
            final AccountLinesValidator accountLinesValidator
    ) {
        this.digitsMapper = digitsMapper;
        this.accountLinesValidator = accountLinesValidator;
    }

    public String parse(DigitChunk digitChunk) throws AccountNumberParseException, InvalidAccountNumberException {
        if (!this.accountLinesValidator.isValid(digitChunk)) {
            throw new InvalidAccountNumberException("Malformed account number");
        }

        List<List<String>> chunks = ListUtils.chunk(
                digitChunk.getOcrDigits(), 
                DigitChunk.ENTRY_LINES_AMOUNT
        );

        StringBuilder strBuilder = new StringBuilder();

        for (List<String> chunk : chunks) {
            try {
                List<List<String>> parts = this.explode(chunk);

                for (List<String> part : parts) {
                    strBuilder.append(this.digitsMapper.map(part));
                }
            } catch (IllegalArgumentException iae) {
                throw new AccountNumberParseException("Could not parse account number");
            }
        }

        return String.join(",", strBuilder.toString());
    }

    protected List<List<String>> explode(List<String> fragment) throws IllegalArgumentException {
        List<List<String>> exploded = new ArrayList<>();

        for (int i = 0; i < fragment.size(); i++) {
            exploded.add(StringUtils.splitString(
                    fragment.get(i),
                    DigitChunk.ACCOUNT_NUMBER_LINES_AMOUNT
            ));
        }

        return ListUtils.zip(exploded.get(0), exploded.get(1), exploded.get(2), exploded.get(3));
    }
}
