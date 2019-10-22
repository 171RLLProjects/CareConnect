package com.mphasis.ocs.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.ocs.util.StringPrefixedSequenceIdGenerator;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "adm_seq")
	@GenericGenerator(name = "adm_seq", 
	strategy = "com.mphasis.ocs.util.StringPrefixedSequenceIdGenerator", 
	parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "AD_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	@Column(length=10)
	private String aid;
	@Column(length=20)
	private String aname;
	@Column(length=15)
	private String password;
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", aname=" + aname + ", password=" + password + "]";
	}



}
