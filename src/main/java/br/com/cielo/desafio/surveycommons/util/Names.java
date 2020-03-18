package br.com.cielo.desafio.surveycommons.util;

import org.apache.commons.lang3.StringUtils;

public class Names {

	public static String getFirstName(String fullName) {
		if(StringUtils.isNotBlank(fullName)) {
			String firstName = fullName.split(Strings.SPACE)[0];
			return firstName.substring(0, 1).toUpperCase().concat(firstName.substring(1).toLowerCase());
		}
		return Strings.EMPTY;
	}
}
