package org.travelplan.dao.impl;

import org.travelplan.dao.EmployeeDAO;
import org.travelplan.entity.Employee;

public class EmployeeDAOImpl extends CommonDAOImpl<Employee> implements EmployeeDAO {

	public EmployeeDAOImpl() {
		super(Employee.class);
	}

}
