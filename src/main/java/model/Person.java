package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "person",uniqueConstraints = {
	 	@UniqueConstraint(columnNames = "PERSON_NAME"),
		@UniqueConstraint(columnNames = "EMAIL"),
		})
public class Person {
	
	private int personId;
	private String personName;
	private String email;
	private Passport passport;
	private List<PersonDetails> personDetails;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PERSON_ID",nullable = false)
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	
	@Column(name = "PERSON_NAME", nullable = false, length = 10)
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	@Column(name = "EMAIL", nullable = false, length = 50)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToOne(targetEntity=Passport.class,mappedBy="person")
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="PERSON_ID")
	public List<PersonDetails> getPersonDetails() {
		return personDetails;
	}
	public void setPersonDetails(List<PersonDetails> personDetails) {
		this.personDetails = personDetails;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", email=" + email + "]";
	}
	

}
