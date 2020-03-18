package br.com.cielo.desafio.surveycommons.model;

import java.io.Serializable;
import java.time.LocalDateTime;


import br.com.cielo.desafio.surveycommons.util.DatePatterns;
import br.com.cielo.desafio.surveycommons.util.Dates;
import br.com.cielo.desafio.surveycommons.util.builder.CommonsStringBuilder;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DateModel implements Serializable {

	private static final long serialVersionUID = -8379140358162252399L;

	@Column(nullable = false)
	private LocalDateTime inputDate;
	
	@Column(nullable = false)
	private LocalDateTime lastUpdatedDate;

	public DateModel(){}
	
	public DateModel(LocalDateTime inputDate, LocalDateTime lastUpdatedDate) {
		this.inputDate = inputDate;
		this.lastUpdatedDate = lastUpdatedDate;
	}
	
	public DateModel(LocalDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public LocalDateTime getInputDate() {
		return inputDate;
	}

	public void setInputDate(LocalDateTime inputDate) {
		this.inputDate = inputDate;
	}

	public LocalDateTime getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	
	public String getFormattedInputDate() {
		return Dates.getFormattedDate(inputDate, DatePatterns.DD_MM_YYYY_HH_MM_SS);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inputDate == null) ? 0 : inputDate.hashCode());
		result = prime * result + ((lastUpdatedDate == null) ? 0 : lastUpdatedDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DateModel other = (DateModel) obj;
		if (inputDate == null) {
			if (other.inputDate != null)
				return false;
		} else if (!inputDate.equals(other.inputDate))
			return false;
		if (lastUpdatedDate == null) {
			if (other.lastUpdatedDate != null)
				return false;
		} else if (!lastUpdatedDate.equals(other.lastUpdatedDate))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return CommonsStringBuilder.toString(this);
	}
}