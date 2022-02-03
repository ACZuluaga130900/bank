package com.bank.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the transaction_type database table.
 * 
 */
@Entity
@Table(name = "transaction_type")
@NamedQuery(name = "TransactionType.findAll", query = "SELECT t FROM TransactionType t")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "trty_id")
	private Integer trtyId;

	private Boolean enable;

	private String name;

	// bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy = "transactionType")
	private List<Transaction> transactions;

}