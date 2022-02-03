package com.bank.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the transaction database table.
 * 
 */
@Entity
@NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "tran_id")
	private Integer tranId;

	private BigDecimal amount;

	private Timestamp date;

	// bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name = "acco_id")
	private Account account;

	// bi-directional many-to-one association to TransactionType
	@ManyToOne
	@JoinColumn(name = "trty_id")
	private TransactionType transactionType;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "user_email")
	private User user;

}