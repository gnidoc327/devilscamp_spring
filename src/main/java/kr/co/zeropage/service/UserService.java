package kr.co.zeropage.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import kr.co.zeropage.dao.UserDao;

@Configuration
@PropertySource("classpath:config.properties")
@Service
public class UserService {
	@Autowired
	private UserDao dao;

	public boolean authenticateUser(String email, String password) {
		boolean authenticated = false;
		
		String pw = dao.selectPassword(email);
		
		authenticated = password.equals(pw) ? true : false; 
		
		return authenticated;
	}
	
	public int addUser(String email, String password) {
		return dao.insertUser(email, password);
	}
	
	public int deleteUser(long userId){
		return dao.deleteUser(userId);
	}
}
