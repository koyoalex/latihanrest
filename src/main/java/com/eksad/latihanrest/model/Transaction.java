package com.eksad.latihanrest.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name="transaction")

public class Transaction {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP) //yang akan disimpan itu yg mana 
	
	private Date date; //
	private String remark;
	
	
	@EqualsAndHashCode.Exclude // set gada duplikasi, standarnya hashset, intinya ngecek objek
	
	//hashcode adalah signature adalah nilai dari value suatu objek, 
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "transaction" , fetch= FetchType.EAGER)
	private Set<TransactionDetail> details;
}


