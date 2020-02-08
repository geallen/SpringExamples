package springboot.spring_boot_example.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean isValidUser(String userid, String pw) {
		return userid.equalsIgnoreCase("gamze") && pw.equalsIgnoreCase("sen");
	}

}
