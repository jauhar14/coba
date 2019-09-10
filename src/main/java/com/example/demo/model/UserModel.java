package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name="T_USER")
public class UserModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false)
	private Integer id;	
	
	@Column(name="USER_ID")
	private String userId;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="ENCRYPTED_PASSWORD")
	private String encryptedPassword;
	
	@Column(name="ENABLED")
	private String enabled;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<RoleModel> roleModel;
	
	public UserModel(Integer id, String userId, String userName, String encryptedPassword, String enabled, Set<RoleModel> roleModel) {
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.encryptedPassword = encryptedPassword;
		this.enabled = enabled;
		this.roleModel = roleModel;
	}
	/*
	 * public Integer getId() { return id; }
	 * 
	 * public void setId(Integer id) { this.id = id; }
	 * 
	 * public String getUserId() { return userId; }
	 * 
	 * public void setUserId(String userId) { this.userId = userId; }
	 * 
	 * public String getUserName() { return userName; }
	 * 
	 * public void setUserName(String userName) { this.userName = userName; }
	 * 
	 * public String getEncryptedPassword() { return encryptedPassword; }
	 * 
	 * public void setEncryptedPassword(String encryptedPassword) {
	 * this.encryptedPassword = encryptedPassword; }
	 * 
	 * public String getEnabled() { return enabled; }
	 * 
	 * public void setEnabled(String enabled) { this.enabled = enabled; }
	 */
	
	
	
	
}
