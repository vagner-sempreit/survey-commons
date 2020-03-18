package br.com.cielo.desafio.surveycommons.util;

import static java.util.Objects.isNull;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class Formatter {

    public static String formatCpf(String cpf) {
        try {
            var mask = new MaskFormatter("###.###.###-##");
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(cpf);
        } catch (ParseException ex) {
            return cpf;
        }
    }

    public static String formatCnpj(String cnpj) {
        try {
            var mask = new MaskFormatter("##.###.###/####-##");
            mask.setValueContainsLiteralCharacters(false);
            return mask.valueToString(cnpj);
        } catch (ParseException ex) {
            return cnpj;
        }
    }

    public static String formatAccountBranch(String branch) {
        return StringUtils.leftPad(branch, Numbers.FOUR, String.valueOf(Numbers.ZERO));
    }

    public static String formatAccountNumber(String accountNumber) {
        return StringUtils.leftPad(accountNumber.substring(Numbers.ZERO, accountNumber.length() - Numbers.ONE) + Strings.DASH + accountNumber.substring(accountNumber.length() - Numbers.ONE), Numbers.SEVEN, String.valueOf(Numbers.ZERO));
    }

    public static String formatBankDescription(String bankCode, String bankDescription) {
        return bankCode + Strings.SPACE +  Strings.DASH + Strings.SPACE + WordUtils.capitalizeFully(bankDescription)
                .replaceAll("S\\.a\\.", "S.A.")
                .replaceAll("s\\.a\\.", "S.A.")
                .replaceAll("S\\.a", "S.A.")
                .replaceAll("s\\.a", "S.A.");

    }

    public static String capitalizeFully(String text) {
        return WordUtils.capitalizeFully(text);
    }

    public static String formatTypeableLine(String text) {
        if (isNull(text)) {
            return null;
        }

        if (text.length() != Numbers.FORTY_SEVEN || !StringUtils.isNumeric(text)) {
            throw new IllegalArgumentException("Typeableline does not have 47 characters or is not numeric");
        }

        return text.substring(Numbers.ZERO, Numbers.FIVE) + Strings.DOT +
                text.substring(Numbers.FIVE, Numbers.TEN) + Strings.SPACE +
                text.substring(Numbers.TEN, Numbers.FIFTEEN) + Strings.DOT +
                text.substring(Numbers.FIFTEEN, Numbers.TWENTY_ONE) + Strings.SPACE +
                text.substring(Numbers.TWENTY_ONE, Numbers.TWENTY_SIX) + Strings.DOT +
                text.substring(Numbers.TWENTY_SIX, Numbers.THIRTY_TWO) + Strings.SPACE +
                text.substring(Numbers.THIRTY_TWO, Numbers.THIRTY_THREE) + Strings.SPACE +
                text.substring(Numbers.THIRTY_THREE, Numbers.FORTY_SEVEN);
    }
}
