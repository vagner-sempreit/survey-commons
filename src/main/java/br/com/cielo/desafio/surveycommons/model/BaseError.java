package br.com.cielo.desafio.surveycommons.model;

public interface BaseError {

    String getCode();

    String getDescription();

    boolean getAcceptParameters();

}
