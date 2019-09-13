package org.abn.crudpoc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="employee")
@EntityListeners(AuditingEntityListener.class)
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotBlank
	private String id;
	
@NotBlank
private String name1;
@NotBlank
private String designation;
@NotBlank
private String expertise;
@Temporal(TemporalType.TIMESTAMP)
@LastModifiedDate
private Date createdAt;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName1() {
	return name1;
}
public void setName(String name1) {
	this.name1 = name1;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public String getExpertise() {
	return expertise;
}
public void setExpertise(String expertise) {
	this.expertise = expertise;
}
public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}


}
