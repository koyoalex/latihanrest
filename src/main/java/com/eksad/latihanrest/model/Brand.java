package com.eksad.latihanrest.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Getter @Setter
//@EqualsAndHashCode
//@ToString
@Data
@EqualsAndHashCode(callSuper =  true)
@ToString(callSuper = true)
@Entity
@Table(name="brand")
public class Brand extends BaseEntity {
	
	
	private Long id;
	@Column(nullable = false)
	@EqualsAndHashCode.Include
	
	private String name;
	
	@Column (name="product_type")
	private String productType;
	

	
	
	
	

	
	
	

}
