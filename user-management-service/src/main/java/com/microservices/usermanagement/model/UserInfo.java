package com.microservices.usermanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "userinfo" )
public class UserInfo {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column( name="user_id" )
	private Long userInfoId;
	
	@Column( name="first_name" )
	private String firstName;
	
	@Column( name="last_name" )
	private String lastName;
	
	@Column( name="city" )
	private String city;
	
	@Column( name="cell_number" )
	private Long cellNumber;
	
	@Column( name="email" )
	private String email;
	
	@OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
	private User user;
	
	public Long getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(Long userInfoId) {
		this.userInfoId = userInfoId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getCellNumber() {
		return cellNumber;
	}

	public void setCellNumber(Long cellNumber) {
		this.cellNumber = cellNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserInfo [firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + ", cellNumber="
				+ cellNumber + ", email=" + email + "]";
	}
	
}
