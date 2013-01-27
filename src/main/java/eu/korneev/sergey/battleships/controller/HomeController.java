package eu.korneev.sergey.battleships.controller;

import eu.korneev.sergey.battleships.services.PageUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({ "/", "/error" })
public class HomeController {

  @Autowired
  private PageUrlService urlService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String printWelcome(ModelMap model) {
    model.addAttribute("barpage", "/WEB-INF/jsp/logoutbar.jsp");
    model.addAttribute("urls", urlService.getLinksForPage("home", true));// TODO
    // change
    // to
    // state

    return getMainPage(model);

  }

  private String getMainPage(ModelMap model) {
    model.addAttribute("page", "/WEB-INF/jsp/home.jsp");
    return "sceleton";

  }

  @RequestMapping(value = "/error")
  public String printErrorWelcome(ModelMap model) {
    model.addAttribute("error", "Access Denied");
    return printWelcome(model);
  }

}