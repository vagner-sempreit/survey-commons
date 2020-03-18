package br.com.cielo.desafio.surveycommons.util.builder;


import static java.lang.reflect.Modifier.TRANSIENT;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CommonsStringBuilder {
	
	public static String toString(Object object) {
		return ToStringBuilder.reflectionToString(object, ToStringStyle.JSON_STYLE);
	}

	public static String toStringGson(Object object) {
		Gson gson = new GsonBuilder()
				.addSerializationExclusionStrategy(new ExclusionStrategy() {
					
					@Override
					public boolean shouldSkipField(FieldAttributes f) {
						return f.hasModifier(TRANSIENT);
					}
					
					@Override
					public boolean shouldSkipClass(Class<?> clazz) {
						return false;
					}
				})
				.create();
		return gson.toJson(object);
	}
}