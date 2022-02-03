package com.bank.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cust_id")
	@NotNull
	@Min(1)
	private Integer custId;

	@NotNull
	@NotEmpty
	@Size(min = 4, max = 255)
	private String address;

	@Size(min = 4, max = 255)
	@NotEmpty
	@Email
	private String email;

	@NotNull
	private Boolean enable;

	@NotNull
	@NotEmpty
	@Size(min = 4, max = 255)
	private String name;

	@NotNull
	@NotEmpty
	@Size(min = 4, max = 255)
	private String phone;

	private String token;

	// bi-directional many-to-one association to Account
	@OneToMany(mappedBy = "customer")
	private List<Account> accounts;

	// bi-directional many-to-one association to DocumentType
	@ManyToOne
	@JoinColumn(name = "doty_id")
	private DocumentType documentType;

	// bi-directional many-to-one association to RegisteredAccount
	@OneToMany(mappedBy = "customer")
	private List<RegisteredAccount> registeredAccounts;

}