package com.mphasis.ocs.pojos;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mphasis.ocs.util.StringPrefixedSequenceIdGenerator;


@Entity
public class Leave {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "lea_seq")
	@GenericGenerator(name = "lea_seq", 
	strategy = "com.mphasis.ocs.util.StringPrefixedSequenceIdGenerator", 
	parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "LE_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	@Column(length=10)
	private String lid;
	private Date fromDate;
	private Date toDate;
	@Column(length=15)
	private String leaveStatus;
	@ManyToOne
	@JoinColumn(name="doctorId")
	private Doctor doctor;
	public String getLid() {
		return lid;
	}
	public void setLid(String lid) {
		this.lid = lid;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public String getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}


	@Override
	public String toString() {
		return "Leave [lid=" + lid + ", fromDate=" + fromDate + ", toDate=" + toDate + ", leaveStatus=" + leaveStatus
				+ ", doctor=" + doctor + "]";
	}
}
