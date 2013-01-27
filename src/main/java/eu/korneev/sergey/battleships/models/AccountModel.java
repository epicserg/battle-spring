package eu.korneev.sergey.battleships.models;

public class AccountModel {
	
	private Integer id;
	private String userName;
	private String passwordHashCode;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswordHashCode() {
		return passwordHashCode;
	}
	public void setPasswordHashCode(String passwordHashCode) {
		this.passwordHashCode = passwordHashCode;
	}
	
	

}
