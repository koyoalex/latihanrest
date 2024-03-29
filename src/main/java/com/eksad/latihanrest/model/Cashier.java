package com.eksad.latihanrest.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper= true)
@ToString(callSuper = true)
@Entity
@DiscriminatorValue("Cashier")
public class Cashier extends Person {
	@Column(name="shift")
	private String shift;
	

}
