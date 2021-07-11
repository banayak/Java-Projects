package com.user.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.user.bean.EmployeeBean;
import com.user.model.Employee;
import com.user.service.EmployeeService;

/**
 * @author basanta
 *
 */
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("command") EmployeeBean employeeBean, BindingResult result)
			throws ParseException {
		Employee employee = prepareModel(employeeBean);
		employeeService.addEmployee(employee);
		return new ModelAndView("redirect:/add.html");
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ModelAndView listEmployees() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees", prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("employeesList", model);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("command") EmployeeBean employeeBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employees", prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("addEmployee", model);
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@ModelAttribute("command") EmployeeBean employeeBean, BindingResult result)
			throws ParseException {
		employeeService.deleteEmployee(prepareModel(employeeBean));
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", null);
		model.put("employees", prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("addEmployee", model);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editEmployee(@ModelAttribute("command") EmployeeBean employeeBean, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("employee", prepareEmployeeBean(employeeService.getEmployee(employeeBean.getEmpId())));
		model.put("employees", prepareListofBean(employeeService.listEmployeess()));
		return new ModelAndView("addEmployee", model);
	}

	private Employee prepareModel(EmployeeBean employeeBean) throws ParseException {
		Employee employee = new Employee();

		employee.setEmpId(employeeBean.getEmpId());
		employee.setFirstName((employeeBean.getFirstName()));
		employee.setLastName((employeeBean.getLastName()));
		employee.setEmail((employeeBean.getEmail()));
		employee.setPhoneNumber((employeeBean.getPhoneNumber()));
		employee.setHireDate(convertInputDateToSQLDate(employeeBean.getHireDate()));
		employee.setJobId(employeeBean.getJobId());
		employee.setSalary(employeeBean.getSalary());
		employee.setCommisionPct(employeeBean.getCommisionPct());
		employee.setManagerId(employeeBean.getManagerId());
		employee.setDeptId(employeeBean.getDeptId());
		return employee;
	}

	private List<EmployeeBean> prepareListofBean(List<Employee> employees) {
		List<EmployeeBean> beans = null;
		if (employees != null && !employees.isEmpty()) {
			beans = new ArrayList<EmployeeBean>();
			EmployeeBean bean = null;
			for (Employee employee : employees) {
				bean = new EmployeeBean();
				bean.setEmpId(employee.getEmpId());
				bean.setFirstName((employee.getFirstName()));
				bean.setLastName((employee.getLastName()));
				bean.setEmail((employee.getEmail()));
				bean.setPhoneNumber((employee.getPhoneNumber()));
				bean.setHireDate(convertSQLDate(employee.getHireDate()));
				bean.setJobId(employee.getJobId());
				bean.setSalary(employee.getSalary());
				bean.setCommisionPct(employee.getCommisionPct());
				bean.setManagerId(employee.getManagerId());
				bean.setDeptId(employee.getDeptId());
				beans.add(bean);
			}
		}
		return beans;
	}

	private EmployeeBean prepareEmployeeBean(Employee employee) {
		EmployeeBean bean = new EmployeeBean();
		bean.setEmpId(employee.getEmpId());
		bean.setFirstName((employee.getFirstName()));
		bean.setLastName((employee.getLastName()));
		bean.setEmail((employee.getEmail()));
		bean.setPhoneNumber((employee.getPhoneNumber()));
		bean.setHireDate(convertSQLDate(employee.getHireDate()));
		bean.setJobId(employee.getJobId());
		bean.setSalary(employee.getSalary());
		bean.setCommisionPct(employee.getCommisionPct());
		bean.setManagerId(employee.getManagerId());
		bean.setDeptId(employee.getDeptId());
		return bean;
	}

	public String convertSQLDate(java.sql.Date hireDate) {
		if (hireDate != null) {
			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
			String date = DATE_FORMAT.format(hireDate);
			return date;
		}
		return null;
	}

	public java.sql.Date convertInputDateToSQLDate(String hireDate) throws ParseException {
		if (hireDate != null) {
			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
			Date date = DATE_FORMAT.parse(hireDate);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			System.out.println("Converted SQL Date : " + sqlDate);
			return sqlDate;
		}
		return null;
	}
}
