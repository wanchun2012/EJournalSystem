package com.teamo.ejournal.orm;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "filePath"))
public class ArticleVersionDetails {
	public static final int TEMP = -1;
	public static final int INIT = 0;
	public static final int RIVISED = 1;	
	public static final int FINAL = 2;
	
	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Column
	@NotNull
	private int version;
	
	@Column
	@NotEmpty
	private String filePath;
	
	@Column
	@Type(type="date")
	private Date whenCreated;

    @ManyToOne (fetch=FetchType.EAGER)
    @JoinColumn(name = "article_id")  
    private Article article;  

    @Transient
	private String friendlyDate;
	
	public String getFriendlyDate() {
		//special set friendly date
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd MMMM yyyy");
		DateTime jodaDate = new DateTime(whenCreated);
		friendlyDate = formatter.print(jodaDate);
		return friendlyDate;
	}
    
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getVersion() {
		return version;
	}



	public void setVersion(int version) {
		this.version = version;
	}



	public String getFilePath() {
		return filePath;
	}



	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}



	public Date getWhenCreated() {
		return whenCreated;
	}



	public void setWhenCreated(Date whenCreated) {
		this.whenCreated = whenCreated;
	}

   
	public Article getArticle() {
		return article;
	}



	public void setArticle(Article article) {
		this.article = article;
	}



	@Override
	public String toString() {
		return "ArticleVersionDetails [id=" + id + ", filePath=" + filePath + "]";
	}
	
}
