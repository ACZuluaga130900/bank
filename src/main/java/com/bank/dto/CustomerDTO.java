package com.bank.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

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
	
	@NotNull
	@Min(0)
	private Integer dotyId;
}
