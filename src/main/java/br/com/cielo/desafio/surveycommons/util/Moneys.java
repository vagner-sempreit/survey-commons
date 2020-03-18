package br.com.cielo.desafio.surveycommons.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Locale;

public class Moneys {

	private static final Locale PT_BR = new Locale("pt", "BR");
	private static final DecimalFormat FORMATTER = (DecimalFormat) DecimalFormat.getCurrencyInstance(PT_BR);

	public static String format(BigDecimal value) {
		return FORMATTER.format(value.floatValue());
	}

}
