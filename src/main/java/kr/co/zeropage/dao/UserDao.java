package kr.co.zeropage.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
 
	public String selectPassword(String email) {
		return jdbcTemplate.queryForObject("SELECT password FROM user WHERE email = ?",
				new Object[]{ email }, String.class);
	}
	
	public int insertUser(String email, String password) {
		return jdbcTemplate.update("INSERT INTO user(email, password) VALUES(?, ?)",
									new Object[]{ email, password});
	}
	
	public int deleteUser(long id){
		return jdbcTemplate.update("delete From user WHERE id=?", new Object[]{id});
	}
}
