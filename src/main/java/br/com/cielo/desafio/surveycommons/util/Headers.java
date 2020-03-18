package br.com.cielo.desafio.surveycommons.util;

public interface Headers {

	String X_CPF = "X-Cpf";
	String X_PRODUCT_TYPE = "X-Product-Type";
	String X_FORWARDED_FOR = "X-Forwarded-For";
	String X_REQUEST_ID = "X-Request-Id";

	String ACESSO_DIGITAL_X_ACESSO_BIO_APIKEY = "X-AcessoBio-APIKEY";
	String ACESSO_DIGITAL_X_LOGIN = "X-Login";
	String ACESSO_DIGITAL_X_PASSWORD = "X-Password";

	String MATERA_API_ACCESS_KEY = "Api-Access-Key";
	String MATERA_TRANSACTION_HASH = "Transaction-Hash";
	
	String PIERLABS_ACCESS_TOKEN = "access_token";
	String PIERLABS_CLIENT_ID = "client_id";

	String TECBAN_X_API_KEY = "X-API-Key";
	String TECBAN_AUTHORIZATION = "Authorization";
	
	String DIGIO_PLATFORM_X_API_KEY = "X-API-KEY";
	String DIGIO_PLATFORM_ACCESS_TOKEN = "X-DIGIO-ACCESS-TOKEN";
	String DIGIO_BILL_X_APPLICATION_KEY = "x-application-key";
	String DIGIO_BILL_X_SECRET_KEY = "x-secret-key";

	String SECURITY_ANTI_FRAUD_X_APPLICATION_KEY = "X-Application-Key";
	String SECURITY_ANTI_FRAUD_X_SECRET_KEY = "X-Secret-Key";

	String X_OPERATOR_ID = "X-Operator-Id";
}