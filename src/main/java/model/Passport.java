package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "passport")
public class Passport {

	private String passportNumber;
	private int passportId;
	private Person person;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "ID", unique = true, nullable = false)
	public int getPassportId() {
		return passportId;
	}


	public void setPassportId(int passportId) {
		this.passportId = passportId;
	}

	@Column(name = "PASSPORT_NUMBER")
	public String getPassportNumber() {
		return passportNumber;
	}


	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}




	@OneToOne(targetEntity=Person.class,cascade = CascadeType.ALL)
	@JoinColumn(name="PERSON_ID")
	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}

	
	
	
}
