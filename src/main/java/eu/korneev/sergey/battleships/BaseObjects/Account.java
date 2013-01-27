package eu.korneev.sergey.battleships.BaseObjects;

import eu.korneev.sergey.battleships.models.RegistrationModel;



public class Account {
	
	private String userName;
	private String passwordHashCode;
	
	
	
	
	public String getPasswordHashCode() {
		return passwordHashCode;
	}

	public Account(RegistrationModel regModel){
		userName=regModel.getUserName();
		passwordHashCode=Integer.toString(regModel.getPassWord().hashCode());
	}

	public String getUserName() {
		return userName;
	}
	
	
	
	
	
}
