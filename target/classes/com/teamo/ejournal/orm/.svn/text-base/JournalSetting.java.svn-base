package com.teamo.ejournal.orm;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

@Entity
public class JournalSetting {

	public static final int PDF = 0;
	public static final int LATEX = 1;
	public static final int DOC = 2;
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String title;
	
	@Column
	private String academicGoals;
	
	@Column
	private String publishRules;
	
	@Column
	private int templateType;
	
	@Column
	private String templateURL;
	
	@Column
	@Type(type="date")
	private Date whenUpdated;

 
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAcademicGoals() {
		return academicGoals;
	}

	public void setAcademicGoals(String academicGoals) {
		this.academicGoals = academicGoals;
	}

	public Date getWhenUpdated() {
		return whenUpdated;
	}

	public void setWhenUpdated(Date whenUpdated) {
		this.whenUpdated = whenUpdated;
	}

	public int getTemplateType() {
		return templateType;
	}

	public void setTemplateType(int templateType) {
		this.templateType = templateType;
	}

	public String getTemplateURL() {
		return templateURL;
	}

	public void setTemplateURL(String templateURL) {
		this.templateURL = templateURL;
	}

	public String getPublishRules() {
		return publishRules;
	}

	public void setPublishRules(String publishRules) {
		this.publishRules = publishRules;
	}

	 
	
	
}
