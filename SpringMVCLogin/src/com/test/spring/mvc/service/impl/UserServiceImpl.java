package com.test.spring.mvc.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.spring.mvc.dao.EmployeeDO;
import com.test.spring.mvc.dao.UserDao;
import com.test.spring.mvc.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
		@Autowired
		private UserDao userDao;
		

		@Override
		public boolean isValidUser(String employeeId, String firstName) throws SQLException
		{
				return userDao.isValidUser(employeeId, firstName);
		}

		@Override
		public List<EmployeeDO> retrieveUserDetails(String employeeId,String firstName) throws SQLException {
			return userDao.retrieveUserDetails(employeeId,firstName);
		}
		

}
