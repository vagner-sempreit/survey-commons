package br.com.cielo.desafio.surveycommons.util;

import static java.time.LocalDateTime.now;

public class UUID {

    public static String randomUUID() {
        return java.util.UUID.randomUUID()
                .toString()
                .concat(Strings.DASH)
                .concat(Dates.getFormattedDate(now(), DatePatterns.YYYY_MM_DD_HH_MM_SS_SSS));
    }

}
