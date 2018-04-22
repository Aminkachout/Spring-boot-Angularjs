package org.sid.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AppRole {
	@Id @GeneratedValue
	private Long id ;
	public AppRole() {
		super();
	}
	public AppRole(Long id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}
	public Long getId() {
		return id;
	}
	public String getRoleName() {
		return roleName;
	}
	private String roleName;

}
