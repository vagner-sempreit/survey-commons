package br.com.cielo.desafio.surveycommons.resource.response;

import static br.com.cielo.desafio.surveycommons.util.Strings.formatMessage;


import br.com.cielo.desafio.surveycommons.model.BaseError;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import java.util.List;

public class ApiError extends Response {

	private static final long serialVersionUID = 3673305337110772582L;

	private String code;

    private String message;

    private List<ApiErrorField> fields;

    private Object data;

	public ApiError(BaseError error, Object... parameters) {
		this.code = error.getCode();
		this.message = error.getAcceptParameters() ? formatMessage(error.getDescription(), parameters) : error.getDescription();
	}

	public ApiError(String code, String message, Object... parameters) {
		this.code = code;
		this.message = formatMessage(message, parameters);
	}

	public String getCode() {
		return code;
	}

	public ApiError setCode(String code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public ApiError setMessage(String message) {
		this.message = message;
		return this;
	}

	public List<ApiErrorField> getFields() {
		return fields;
	}

	public ApiError setFields(List<ApiErrorField> fields) {
		this.fields = fields;
		return this;
	}

	public Object getData() {
		return data;
	}

	public ApiError setData(Object data) {
		this.data = data;
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, true);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, true);
	}
}