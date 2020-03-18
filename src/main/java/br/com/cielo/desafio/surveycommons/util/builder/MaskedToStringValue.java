package br.com.cielo.desafio.surveycommons.util.builder;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(ElementType.FIELD)
public @interface MaskedToStringValue {

	String mask() default "********";
}