package eu.korneev.sergey.battleships.services;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import eu.korneev.sergey.battleships.services.implementations.LoginServiceImpl;


public class RequestSupport {

	public static Cookie getCookie(Cookie [] cookies,String cookieType){
		Cookie sessionCookie=null;
		if(cookies!=null && cookies.length>0){
			for(Cookie cook : cookies){
				if(cookieType.equals(cook.getName())){
					sessionCookie=cook;
					break;
				}
			}
		}
		return sessionCookie;
	}
	
	public static boolean isUserLoggedIn(HttpServletRequest request){
		Cookie [] cookies = request.getCookies();
		Cookie sessionCookie=RequestSupport.getCookie(cookies,"SESSIONID");
		Cookie userCookie = RequestSupport.getCookie(cookies,"user");
		if(userCookie!=null && sessionCookie!=null && LoginServiceImpl.isSessionPresent(userCookie.getValue(), sessionCookie.getValue())){
			return true;
		}
		return false;
	}
	
	public static void removeCookies(HttpServletRequest request){
		Cookie[] cookies = request.getCookies();
		if(cookies!=null)
		for (int i = 0; i < cookies.length; i++) {
		 cookies[i].setMaxAge(0);
		}
	}
}
