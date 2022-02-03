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
 * The persistent class for the user_type database table.
 * 
 */
@Entity
@Table(name = "user_type")
@NamedQuery(name = "UserType.findAll", query = "SELECT u FROM UserType u")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "usty_id")
	private Integer ustyId;

	private Boolean enable;

	private String name;

	// bi-directional many-to-one association to User
	@OneToMany(mappedBy = "userType")
	private List<User> users;

}