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
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_email")
	private String userEmail;

	private Boolean enable;

	private String name;

	private String token;

	// bi-directional many-to-one association to Transaction
	@OneToMany(mappedBy = "user")
	private List<Transaction> transactions;

	// bi-directional many-to-one association to UserType
	@ManyToOne
	@JoinColumn(name = "usty_id")
	private UserType userType;

}