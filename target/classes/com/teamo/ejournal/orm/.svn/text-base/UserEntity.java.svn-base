package com.teamo.ejournal.orm;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "username")) //{"username","email"}
public class UserEntity {

	@Id
	@GeneratedValue
	@Column
	private Integer id;

	@NotEmpty
	@Column
	private String username; //email
	
	@NotEmpty
	@Column
	private String password;
	/*
	@OneToMany(mappedBy="user")
	private Set<Article> articleCollection;
	*/
	@JoinTable(name="UserRole",joinColumns={
	@JoinColumn(name="user_id",referencedColumnName="id")}, inverseJoinColumns={
	@JoinColumn(name="role_id",referencedColumnName="id")})
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> roleCollection;
/*	
	@JoinTable(name="UserSelectedArticle",joinColumns={
	@JoinColumn(name="userid",referencedColumnName="id")}, inverseJoinColumns={
	@JoinColumn(name="articleid",referencedColumnName="id")})
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Article> selectedArticle;
*/		
	@JoinTable(name="UserDownloadedArticle",joinColumns={
	@JoinColumn(name="user_id",referencedColumnName="id")}, inverseJoinColumns={
	@JoinColumn(name="article_downloaded_id",referencedColumnName="id")})
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Article> downloadedArticle;

	@Column
	private Integer numberReviewAvailable;
	
	@Column
	private Integer numberPublishAvailable;
	 
    @OneToMany(mappedBy="author", cascade=CascadeType.ALL) 
	private Set<Article> articleCollection;
	
    @OneToMany(mappedBy="reviewer", cascade=CascadeType.ALL) 
	private Set<ArticleReviewDetails> reviewCollection;
	 
	public UserEntity(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public UserEntity() {
	}

	public Set<Role> getRoleCollection() {
		return roleCollection;
	}

	public void setRoleCollection(Set<Role> roleCollection) {
		this.roleCollection = roleCollection;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
/* 
	public Set<Article> getArticleCollection() {
		return articleCollection;
	}

	public void setArticleCollection(Set<Article> articleCollection) {
		this.articleCollection = articleCollection;
	}
*/ 
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", username=" + username
				+ ", password=" + password + ", roleCollection="
				+ roleCollection + "]";
	}
 
 
	public Set<Article> getDownloadedArticle() {
		return downloadedArticle;
	}

	public void setDownloadedArticle(Set<Article> downloadedArticle) {
		this.downloadedArticle = downloadedArticle;
	}
 
	public int getNumberReviewAvailable() {
		return numberReviewAvailable;
	}

	public void setNumberReviewAvailable(int numberReviewAvailable) {
		this.numberReviewAvailable = numberReviewAvailable;
	}
 
	public Set<Article> getArticleCollection() {
		return articleCollection;
	}

	public void setArticleCollection(Set<Article> articleCollection) {
		this.articleCollection = articleCollection;
	}

	public Set<ArticleReviewDetails> getReviewCollection() {
		return reviewCollection;
	}

	public void setReviewCollection(Set<ArticleReviewDetails> reviewCollection) {
		this.reviewCollection = reviewCollection;
	}

	public int getNumberPublishAvailable() {
		return numberPublishAvailable;
	}

	public void setNumberPublishAvailable(int numberPublishAvailable) {
		this.numberPublishAvailable = numberPublishAvailable;
	}
 
	
}
