package com.mingo.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="contact_details")
public class ContactDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cId;
	private String cName;
	private String cEmail;
	private String cNumber;
	
}