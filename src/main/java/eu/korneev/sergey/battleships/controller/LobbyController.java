package eu.korneev.sergey.battleships.controller;

import eu.korneev.sergey.battleships.services.PageUrlService;
import eu.korneev.sergey.battleships.services.RequestSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping({"sub/lobby","sub/registerlobbyroom"})
public class LobbyController {
	
	@Autowired
	private PageUrlService urlService;
	
	@ModelAttribute("urls")
	public Map<String, String>  populateUrls(HttpServletRequest request){
		return urlService.getLinksForPage("home",false);
	}
	
	@RequestMapping(value = "sub/lobby", method = RequestMethod.GET)
	public String goToLobbyPage(Model model,HttpServletRequest request){
		model.addAttribute("page","/WEB-INF/jsp/lobby.jsp");
		model.addAttribute("urls",urlService.getLinksForPage("lobby",true));
		model.addAttribute("name", RequestSupport.getCookie(request.getCookies(), "user").getValue());//change name retrieval via sessionattribute
		model.addAttribute("barpage","/WEB-INF/jsp/logoutbar.jsp");
		return "sceleton";
	}
	
	@RequestMapping(value = "sub/registerlobbyroom",method=RequestMethod.GET)
	public @ResponseBody String create(@ModelAttribute (value="roomName") RoomName roomName, BindingResult result) {
		System.out.println("lol "+roomName.getRoomName());
		return "ok";
	}

	

}

class RoomName{
	private String roomName;

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	
}