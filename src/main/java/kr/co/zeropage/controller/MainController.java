package kr.co.zeropage.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.zeropage.model.result.Created;
import kr.co.zeropage.model.result.Error;
import kr.co.zeropage.model.result.Normal;
import kr.co.zeropage.model.result.Result;
import kr.co.zeropage.model.result.SingleResult;
import kr.co.zeropage.model.result.Unauthorized;
import kr.co.zeropage.service.UserService;

@RequestMapping("/v1")
@Controller
public class MainController {

	private Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	@ResponseBody
	public String registerUser(@RequestParam("email") String email, 
			@RequestParam("password") String password) {
		logger.info("Req : register a user / email : " + email);
		
		Result result = new Error();
		try {
			if(userService.addUser(email, password) > 0) {
				result = new Created();
			}
		} catch(Exception e) {
			logger.error(e.getMessage(), e);
			result.setMsg(e.getMessage());
		}
		
		return result.toString();
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	@ResponseBody
	public String getUserInfo(@PathVariable("id") long userId) {
		logger.info("Req : get user info");
		
		Result result = new Error();
		try {
			result = new SingleResult(userId);
		} catch(Exception e) {
			logger.error(e.getMessage(), e);
			result.setMsg(e.getMessage());
		}
		
		return result.toString();
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public String authUser(@RequestParam("email") String email, 
			@RequestParam("password") String password) {
		logger.info("Req : login / email : " + email);
		
		Result result = new Normal();
		try {
			if(userService.authenticateUser(email, password)) {
                result = new SingleResult(email);
			}
			else{
                result = new Unauthorized();
            }	
		} catch(Exception e) {
			logger.error(e.getMessage(), e);
			result = new Error(e.getMessage());
		}
		
		return result.toString();
	}
	
	@RequestMapping(value = "/leave/{userid}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteUser(@PathVariable("userid") long userId){		
		userService.deleteUser(userId);
		
		//logger.info("Req : delete user info");
		
		Result result = new Error();
		if(userService.deleteUser(userId) != 1){
			logger.info("Req : It not delete user");
		} else {
			logger.info("Req : Delete "+userId+" user");
			result = new Normal();
		}
		
		return result.toString();
	}
}
