package com.sacksimplify.restservices.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonFilter;

@Entity
@Table(name = "user")
@JsonFilter(value= "userFilter")
//Static filtering json
//@JsonIgnoreProperties({"firstname","lastname"})
public class User extends RepresentationModel<User>  {
		
		@Id
		@GeneratedValue
		private Long userid;
		
		@NotEmpty(message = "Username is Mandatory field. Please provide username")
		@Size(min=2,message= "FirstName should have atleast 2 characters")
		@Column(name = "USER_NAME", length=50, nullable=false, unique=true)
		private String username;
		
		@Column(name = "FiRST_NAME", length=50, nullable=false)
		private String firstname;
		
		@Column(name = "LAST_NAME", length=50, nullable=false)
		private String lastname;
		
		@Column(name = "EMAIL_ADDRESS", length=50, nullable=false)
		private String email;
		
		@Column(name = "ROLE", length=50, nullable=false)
		private String role;
		
		//@JsonIgnore
		@Column(name = "SNN", length=50, nullable=false, unique=true)
		private String ssn;

		
		@OneToMany(mappedBy="user")
		private List<Order> orders;
		
		public User() {
			
		}

		public User(Long userid, String username, String firstname, String lastname, String email, String role,
				String ssn) {
			super();
			this.userid = userid;
			this.username = username;
			this.firstname = firstname;
			this.lastname = lastname;
			this.email = email;
			this.role = role;
			this.ssn = ssn;
		}

		public Long getuserId() {
			return userid;
		}

		public void setuserId(Long id) {
			this.userid = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getSsn() {
			return ssn;
		}

		public void setSsn(String ssn) {
			this.ssn = ssn;
		}

		
		public List<Order> getOrders() {
			return orders;
		}

		public void setOrders(List<Order> orders) {
			this.orders = orders;
		}
		
		
		
		
		
		
		
}
