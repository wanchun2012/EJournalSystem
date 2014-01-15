package com.teamo.ejournal.orm;

import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Role {

	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Column
	private String name;

	@ManyToMany(mappedBy = "roleCollection")
	private Collection<UserEntity> userCollection;

	public Role() {
	}

	public Role(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Collection<UserEntity> getUserCollection() {
		return userCollection;
	}

	public void setUserCollection(Collection<UserEntity> userCollection) {
		this.userCollection = userCollection;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
