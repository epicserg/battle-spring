package eu.korneev.sergey.battleships.services.implementations;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import eu.korneev.sergey.battleships.services.PageUrlService;



@Service
public class PageUrlServiceImpl implements PageUrlService{
	
	private Map<String, String> openLinks;
	private Map<String, String> closedLinks;
	
	{
		openLinks=new HashMap<String,String>();
		openLinks.put("home","/");
		closedLinks=new HashMap<String,String>();
		closedLinks.put("lobby","sub/lobby");
	}

	@Override
	public Map<String, String> getLinksForPage(String pageName,boolean userLoggedIn) {
		Map<String,String> returnMap = new HashMap<String,String>();
		returnMap.putAll(openLinks);
		if(userLoggedIn){
			returnMap.putAll(closedLinks);
		}
		returnMap.remove(pageName);
		return returnMap;
	}


	

}
