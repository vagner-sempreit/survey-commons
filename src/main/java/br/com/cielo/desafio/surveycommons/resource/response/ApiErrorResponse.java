package br.com.cielo.desafio.surveycommons.resource.response;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ApiErrorResponse extends Response {

	private static final long serialVersionUID = 7622195162214987627L;

	private Integer statusCode;

    private String statusError;

    private String path;

    private ApiError error;

    public Integer getStatusCode() {
        return statusCode;
    }

    public ApiErrorResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public String getStatusError() {
        return statusError;
    }

    public ApiErrorResponse setStatusError(String statusError) {
        this.statusError = statusError;
        return this;
    }

    public String getPath() {
        return path;
    }

    public ApiErrorResponse setPath(String path) {
        this.path = path;
        return this;
    }

    public ApiError getError() {
        return error;
    }

    public ApiErrorResponse setError(ApiError error) {
        this.error = error;
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
