package br.com.cielo.desafio.surveycommons.util;

import static java.util.Objects.isNull;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.helpers.MessageFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Strings {

	public static final String SPACE = " ";
	public static final String COLON = ":";
	public static final String COMMA = ",";
	public static final String DOT = ".";
	public static final String DASH = "-";
	public static final String UNDERSCORE = "_";
	public static final String EMPTY = "";
	public static final String NEW_LINE = "\n";
	public static final String SLASH = "/";
	public static final String PERCENTAGE = "%";
	public static final String SEMICOLON = ";";
	public static final String PIPE = "|";
	public static final String AT = "@";
	public static final String CARET = "^";
	public static final String DOLLAR = "$";
	public static final String ASTERISK = "*";
	public static final String BACK_SLASH = "\\";
	public static final String SHARP = "#";
	public static final String AND = "&";
	public static final String QUESTION_MARK = "?";
	public static final String EXCLAMATION_MARK = "!";
	

	public static String formatMessage(String message, Object... parameters) {
		var quantity = StringUtils.countMatches(message, "{}");
		if (isNull(parameters)) {
			parameters = getList(new Object[quantity], Numbers.ZERO, quantity);
		} else if (parameters.length < quantity) {
			parameters = getList(parameters, parameters.length, quantity);
		}
		var response = MessageFormatter.arrayFormat(message, parameters).getMessage();
		return StringUtils.isNotBlank(response) ? response.trim() : response;
	}

	private static Object[] getList(Object[] parameters, Integer init, Integer end) {
		var parametersList = new ArrayList<>(Arrays.asList(parameters));
		IntStream.range(init, end).forEach(n -> parametersList.add(EMPTY));
		return parametersList.toArray();
	}
}