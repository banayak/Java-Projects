package com.test.spring.mvc.delegate;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.spring.mvc.dao.EmployeeDO;
import com.test.spring.mvc.service.UserService;

@Component
public class LoginDelegate
{
	@Autowired
	private UserService userService;
	

	public boolean isValidUser(String username, String password) throws SQLException
	{
		return userService.isValidUser(username, password);
	}
	
	public List<EmployeeDO> fetchUserDetails(String username, String firstName) throws SQLException
	{
		return userService.retrieveUserDetails(username,firstName);
	}
}
