package com.example.sb2train.login;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	
	@Column
	public String myName;
	
	@Column
	public String myPass;
}
