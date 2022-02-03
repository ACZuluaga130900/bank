package com.bank.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the registered_account database table.
 * 
 */
@Entity
@Table(name = "registered_account")
@NamedQuery(name = "RegisteredAccount.findAll", query = "SELECT r FROM RegisteredAccount r")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "reac_id")
	private Integer reacId;

	private Boolean enable;

	// bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name = "acco_id")
	private Account account;

	// bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name = "cust_id")
	private Customer customer;

}