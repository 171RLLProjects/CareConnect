package com.mphasis.ocs.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mphasis.ocs.util.StringPrefixedSequenceIdGenerator;

@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "doc_seq")
	@GenericGenerator(name = "doc_seq", 
	strategy = "com.mphasis.ocs.util.StringPrefixedSequenceIdGenerator", 
	parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "DO_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	@Column(length=10)
	private String did;
	@Column(length=20)
	private String dname;
	@Column(length=15)
	private String password;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="locId")
	private Location location;
	@ElementCollection
	private List<String> specializations=new ArrayList<>();
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public List<String> getSpecializations() {
		return specializations;
	}
	public void setSpecializations(List<String> specializations) {
		this.specializations = specializations;
	}
	



}
