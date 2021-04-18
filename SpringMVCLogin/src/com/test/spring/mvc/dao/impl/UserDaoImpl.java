package com.test.spring.mvc.dao.impl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.test.spring.mvc.dao.EmployeeDO;
import com.test.spring.mvc.dao.UserDao;


/**
 * @author CENTAUR
 */
@Repository
public class UserDaoImpl implements UserDao
{
		@Autowired
		DataSource dataSource;
		

		@Override
		public boolean isValidUser(String employeeId, String firstName) throws SQLException
		{
				String query = "Select count(1) from EMPLOYEES where EMPLOYEE_ID = ? ";
				PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);
				pstmt.setString(1, employeeId);
				//pstmt.setString(2, password);
				ResultSet resultSet = pstmt.executeQuery();
				if (resultSet.next())
						return (resultSet.getInt(1) > 0);
				else
						return false;
		}

		@Override
		public List<EmployeeDO> retrieveUserDetails(String employeeId,String firstName) throws SQLException {
			StringBuilder sqlQuery = new StringBuilder("Select * from EMPLOYEES ");
			if(!StringUtils.isEmpty(employeeId) && ! StringUtils.isEmpty(firstName)) {
				sqlQuery.append( "where EMPLOYEE_ID = ? AND FIRST_NAME LIKE ? ESCAPE '!' ");
			}
			else if(!StringUtils.isEmpty(employeeId)) {
				sqlQuery.append( "where EMPLOYEE_ID = ? ");
			}
			else if(!StringUtils.isEmpty(firstName)) {
				sqlQuery.append( "where FIRST_NAME LIKE ? ESCAPE '!' ");
			}
			PreparedStatement pstmt = dataSource.getConnection().prepareStatement(sqlQuery.toString());
			
			if(!StringUtils.isEmpty(employeeId) && ! StringUtils.isEmpty(firstName)) {
				pstmt.setString(1, employeeId);
				pstmt.setString(2, firstName);	
			}
			else if(!StringUtils.isEmpty(employeeId)) {
				pstmt.setString(1, employeeId);	
			}
			else if(!StringUtils.isEmpty(firstName)) {
				pstmt.setString(1, "%" + firstName + "%");
			}
			
			 
			ResultSet resultSet = pstmt.executeQuery();
			EmployeeDO employeeDO = null;
			List<EmployeeDO> employeeDOs = new ArrayList<EmployeeDO>();
			while(resultSet.next()) {
				employeeDO = new EmployeeDO(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), 
						resultSet.getString(7), resultSet.getString(8));
				employeeDOs.add(employeeDO);
			}
			return employeeDOs;
		}

}