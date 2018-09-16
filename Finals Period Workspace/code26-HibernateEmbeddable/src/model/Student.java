package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Embedded;

import java.util.Date;

@Entity
@Table(name = "MgaUSTExcellentEstudyante")
public class Student {

	@Id
	private long id;

	@Embedded
	private Address schoolAddress;
	
	@Embedded
	private HomeAddress homeAddress;

	@Column(name = "apelido", length = 50, nullable = false)
	private String lastName;

	@Column(name = "pangalan", length = 50, nullable = false)
	private String firstName;

	@Column(name = "baitang")
	private int yearLevel;

	@Column(name = "kurso", length = 50, nullable = false)
	private String course;

	// @Lob
	@Transient
	// @Column (name="ambisyon", nullable=true)
	private String ambition;

	@Temporal(TemporalType.TIMESTAMP)
	private Date enrolled;

	public long getId() {
		return id;
	}

	public String getAmbition() {
		return ambition;
	}

	public void setAmbition(String ambition) {
		this.ambition = ambition;
	}

	public Date getEnrolled() {
		return enrolled;
	}

	public void setEnrolled(Date enrolled) {
		this.enrolled = enrolled;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getYearLevel() {
		return yearLevel;
	}

	public void setYearLevel(int yearLevel) {
		this.yearLevel = yearLevel;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public Address getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(Address schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	public HomeAddress getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(HomeAddress homeAdd) {
		this.homeAddress = homeAdd;
	}
	

}
