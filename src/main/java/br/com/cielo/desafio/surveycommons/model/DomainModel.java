package br.com.cielo.desafio.surveycommons.model;

import br.com.cielo.desafio.surveycommons.util.TimeZones;
import br.com.cielo.desafio.surveycommons.util.builder.CommonsStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@MappedSuperclass
public class DomainModel implements Serializable {
	
	private static final long serialVersionUID = 4769823595867830152L;

	@Id
	@GeneratedValue
	private Long id;

	@Embedded
	private DateModel dateModel;
	
	@Version
	private Integer version;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DateModel getDateModel() {
		return dateModel;
	}

	public void setDateModel(DateModel dateModel) {
		this.dateModel = dateModel;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	@PrePersist
	public void initializeDates() {
	    LocalDateTime now = LocalDateTime.now(TimeZones.getDefault());
		dateModel = new DateModel(now, now);
	}

	@PreUpdate
	public void updateLastUpdatedDate() {
		dateModel.setLastUpdatedDate(LocalDateTime.now(TimeZones.getDefault()));
	}
	
	@Override
	public String toString() {
		return CommonsStringBuilder.toString(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateModel == null) ? 0 : dateModel.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		DomainModel other = (DomainModel) obj;
		if (dateModel == null) {
			if (other.dateModel != null)
				return false;
		} else if (!dateModel.equals(other.dateModel))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
}