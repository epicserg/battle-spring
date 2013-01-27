package eu.korneev.sergey.battleships.services.implementations;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.korneev.sergey.battleships.dao.AccountDao;
import eu.korneev.sergey.battleships.models.RegistrationModel;
import eu.korneev.sergey.battleships.services.RegistrationService;



@Service
public class RegistrationServiceImpl implements RegistrationService{

	private static Logger log = Logger.getLogger(RegistrationService.class);
	
	@Autowired
	private AccountDao accountDao;
	
	
	
	@Override
	public boolean registerNewUser(RegistrationModel info) {
		return accountDao.register(info);
		
	}

	@Override
	public boolean validateRegisterInput(RegistrationModel info) {
		  if(!info.getPassWord().equals(info.getConfirmPassword())){
			  	return false;
			  }
		return true;
	}

}
