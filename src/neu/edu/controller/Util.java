package neu.edu.controller;

import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.userdetails.UserDetails;

public class Util {
	
	
	public static String getId(){
		String id;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	if (principal instanceof UserDetails) {
			id = ((UserDetails)principal).getUsername();
		
		} else {
			id = principal.toString();
		}
		
	return id;
	
	
	}
}
