package eu.korneev.sergey.battleships.services;

import java.util.Map;

public interface PageUrlService {
	
	Map<String,String> getLinksForPage(String pageName,boolean userLoggedIn);


}
