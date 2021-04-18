/**
 *
 */
package com.test.spring.mvc.service;

import java.sql.SQLException;
import java.util.List;

import com.test.spring.mvc.dao.EmployeeDO;

/**
 * @author Basanta
 *
 */
public interface UserService
{
		public boolean isValidUser(String employeeId, String firstName) throws SQLException;
		
		public List<EmployeeDO> retrieveUserDetails(String employeeId, String firstName) throws SQLException;
}
