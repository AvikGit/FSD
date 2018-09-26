package com.cts.bean;

import java.io.Serializable;
import java.util.Set;

public class Subject implements Serializable, Comparable<Subject>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long subjectId;	
	private String subtitle;	
	private int durationInHours;	
	private Set<Book> references;
	
	public long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public int getDurationInHours() {
		return durationInHours;
	}
	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}
	public Set<Book> getReferences() {
		return references;
	}
	public void setReferences(Set<Book> references) {
		this.references = references;
	}	

	@Override
	public String toString() {
		return "Subject [subjectId=" + subjectId + ", subtitle=" + subtitle + ", durationInHours=" + durationInHours;
	}
	
	public Subject(long subjectId, String subtitle, int durationInHours,
			Set<Book> references) {
		super();
		this.subjectId = subjectId;
		this.subtitle = subtitle;
		this.durationInHours = durationInHours;
		this.references = references;
	}
	
	public Subject() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(Subject o) {
		return subtitle.compareTo(o.getSubtitle());		
	}
}
