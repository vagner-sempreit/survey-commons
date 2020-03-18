package br.com.cielo.desafio.surveycommons.util;

import static java.util.Objects.isNull;

public class SpecificationUtils {

    public static String like(String value) {
        return isNull(value) ? null : Strings.PERCENTAGE + value + Strings.PERCENTAGE;
    }
}
