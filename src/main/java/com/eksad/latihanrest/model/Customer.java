package com.eksad.latihanrest.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@ToString
@DiscriminatorValue("Customer")

public class Customer extends Person
{
	@Column(name="card_num")
	private String cardNum;
	
}
