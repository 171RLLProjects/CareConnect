package com.mphasis.ocs.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mphasis.ocs.util.StringPrefixedSequenceIdGenerator;
@Entity
public class Location {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "loc_seq")
	@GenericGenerator(name = "loc_seq", 
	strategy = "com.mphasis.ocs.util.StringPrefixedSequenceIdGenerator", 
	parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "LO_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	@Column(length=10)
	private String locid;
	@Column(length=15)
	private String streetName;
	@Column(length=15)
	private String areaName;
	@Column(length=15)
	private String city;
	@Column(length=10)
	private int pincode;
	@OneToMany(mappedBy="location",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Doctor> doctor=new ArrayList<Doctor>();
	public String getLocid() {
		return locid;
	}
	public void setLocid(String locid) {
		this.locid = locid;
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
	public List<Doctor> getDoctor() {
		return doctor;
	}
	public void setDoctor(List<Doctor> doctor) {
		this.doctor = doctor;
	}
	@Override
	public String toString() {
		return "Location [locid=" + locid + ", streetName=" + streetName + ", areaName=" + areaName + ", city=" + city
				+ ", pincode=" + pincode + ", doctor=" + doctor + "]";
	}

}
