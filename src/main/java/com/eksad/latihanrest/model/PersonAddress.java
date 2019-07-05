package com.eksad.latihanrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name="person_address")
public class PersonAddress {
	@Id
//	@Column(name="id_person")
//	@Column(name="id_person")
	private Long Id;
	
	@ToString.Exclude 
	@OneToOne
	@MapsId             //id person masuk ke person Id
	@JoinColumn(name = "id_person")
		private Person person;
	@Column(nullable=false)
		private String address;
		private String city;
	
	

}
