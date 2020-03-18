package br.com.cielo.desafio.surveycommons.util;

import static java.util.Objects.isNull;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import org.springframework.lang.Nullable;

public class ObjectUtils {

	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(@Nullable Object object) {
		if (isNull(object)) {
			return true;
		}

		if (object instanceof Optional) {
			return !((Optional) object).isPresent();
		}
		if (object instanceof CharSequence) {
			return ((CharSequence) object).length() == 0;
		}
		if (object.getClass().isArray()) {
			return Array.getLength(object) == 0;
		}
		if (object instanceof Collection) {
			return ((Collection) object).isEmpty();
		}
		if (object instanceof Map) {
			return ((Map) object).isEmpty();
		}

		return false;
	}
	
	public static boolean notEmpty(@Nullable Object object) {
		return !isEmpty(object);
	}
}