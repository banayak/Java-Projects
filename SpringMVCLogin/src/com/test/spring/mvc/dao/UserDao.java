package com.test.spring.mvc.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Basanta
 * This interface will be used to communicate with the
 * Database
 */
public interface UserDao
{
		public boolean isValidUser(String username, String password) throws SQLException;
		
		public List<EmployeeDO> retrieveUserDetails(String employeeId, String firstName) throws SQLException;
}
