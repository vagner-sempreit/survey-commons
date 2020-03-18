package br.com.cielo.desafio.surveycommons.util;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;

public class Documents {

	private static final int[] CPF_WEIGHT = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] CNPJ_WEIGHT = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
 
    public static boolean isValidCPF(String document) {
        if ((Objects.isNull(document)) || (document.length() != 11)) {
            return false;    
        }
        Integer digit1 = calculate(document.substring(0,9), CPF_WEIGHT);
        Integer digit2 = calculate(document.substring(0,9) + digit1, CPF_WEIGHT);
        return document.equals(document.substring(0,9) + digit1.toString() + digit2.toString());
    }

    public static boolean isValidCNPJ(String document) {
        if ((Objects.isNull(document)) || (document.length() != 14)) {
            return false;
        }
        Integer digit1 = calculate(document.substring(0,12), CNPJ_WEIGHT);
        Integer digit2 = calculate(document.substring(0,12) + digit1, CNPJ_WEIGHT);
        return document.equals(document.substring(0,12) + digit1.toString() + digit2.toString());
    }
    
    public static boolean isValidDocument(String document) {
    	if (StringUtils.isBlank(document)) {
            return false;
        }
    	var formattedDocument = document.replaceAll(Regex.NOT_DIGIT_REGEX, Strings.EMPTY);
    	if(formattedDocument.length() == 11) {
    		return isValidCPF(formattedDocument);
    	} else if(formattedDocument.length() == 14) {
    		return isValidCNPJ(formattedDocument);
    	} else {
    		return false;
    	}
    }
    
    private static int calculate(String str, int[] weight) {
        int sum = 0;
        for (int i = str.length()-1, digit; i >= 0; i-- ) {
            digit = Integer.parseInt(str.substring(i,i+1));
            sum += digit * weight[weight.length - str.length() + i];
        }
        sum = 11 - sum % 11;
        return sum > 9 ? 0 : sum;
    }
}