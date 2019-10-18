package com.mphasis.ocs.pojos;

import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.ocs.util.StringPrefixedSequenceIdGenerator;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "pat_seq")
	@GenericGenerator(name = "pat_seq", 
	strategy = "com.mphasis.ocs.util.StringPrefixedSequenceIdGenerator", 
	parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PA_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	@Column(length=10)
	private String pid;
	@Column(length=20)
	private String pname;
	@Column(length=5)
	private String gender;
	@Column(length=5)
	private int age;
	@Column(length=10)
	private long phnNo;
	@Column(length=20)
	private String email;
	@Column(length=15)
	private String streetName;
	@Column(length=15)
	private String areaName;
	@Column(length=15)
	private String city;
	@Column(length=10)
	private int pincode;
	@Column(length=20)
	private String symptom;
	@Column(length=15)
	private String password;
	private Clob history;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getPhnNo() {
		return phnNo;
	}
	public void setPhnNo(long phnNo) {
		this.phnNo = phnNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Clob getHistory() {
		return history;
	}
	public void setHistory(Clob history) {
		this.history = history;
	}
	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", pname=" + pname + ", gender=" + gender + ", age=" + age + ", phnNo=" + phnNo
				+ ", email=" + email + ", streetName=" + streetName + ", areaName=" + areaName + ", city=" + city
				+ ", pincode=" + pincode + ", symptom=" + symptom + ", password=" + password + ", history=" + history
				+ "]";
	}



}
