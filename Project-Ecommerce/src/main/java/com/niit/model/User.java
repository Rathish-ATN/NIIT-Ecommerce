package com.niit.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {

	@Id
	/*@GeneratedValue(strategy=GenerationType.AUTO)*/
	private String Username;
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	private String email;
	private String password;
	private String role="ROLE_USER";
	private boolean enabled;
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@OneToOne(mappedBy="user",cascade=CascadeType.ALL)
	private Authorities authorities;
	@OneToOne(mappedBy="user")
	private Customer customer;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Authorities getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Authorities authorities) {
		this.authorities = authorities;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
