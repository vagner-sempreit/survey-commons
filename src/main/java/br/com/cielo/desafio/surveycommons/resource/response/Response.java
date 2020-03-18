package br.com.cielo.desafio.surveycommons.resource.response;

import java.io.Serializable;

import br.com.cielo.desafio.surveycommons.util.builder.CommonsStringBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;



public class Response implements Serializable {

	private static final long serialVersionUID = -580224944695860217L;

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, true);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, true);
	}

	@Override
	public String toString() {
		return CommonsStringBuilder.toString(this);
	}
}