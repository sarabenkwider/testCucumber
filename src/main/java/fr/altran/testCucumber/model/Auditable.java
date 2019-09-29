package fr.altran.testCucumber.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {

	/*
	 * Auteur : Sara BENKOUIDER
	 */

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@CreatedBy
	private U createdBy;

	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdateAt;

	@LastModifiedBy
	private U lastUpdateBy;

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public U getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(U createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastUpdateAt() {
		return lastUpdateAt;
	}

	public void setLastUpdateAt(Date lastUpdateAt) {
		this.lastUpdateAt = lastUpdateAt;
	}

	public U getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(U lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}
}