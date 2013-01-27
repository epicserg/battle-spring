package eu.korneev.sergey.battleships.services;

import eu.korneev.sergey.battleships.models.RegistrationModel;


public interface RegistrationService {
	
	 boolean registerNewUser(RegistrationModel info);
	 boolean validateRegisterInput(RegistrationModel info);
	
	

}
