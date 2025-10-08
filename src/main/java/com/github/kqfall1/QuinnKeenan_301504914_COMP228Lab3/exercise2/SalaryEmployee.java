// Quinn Keenan, 301504914, 06/10/2025

package com.github.kqfall1.QuinnKeenan_301504914_COMP228Lab3.exercise2;

import com.github.kqfall1.kqfall1JavaUtils.ObjectUtils;

public class SalaryEmployee extends Employee
{
	private static final double BASE_SALARY = 65000;
	private double salary;

	SalaryEmployee(String address, String name, String phone, EmployeeType type)
	{
		super(address, name, PayClassification.SALARY, phone, type);
		setSalary(BASE_SALARY);
	}

	SalaryEmployee(String address, String name, String phone, double salary, EmployeeType type)
	{
		super(address, name, PayClassification.SALARY, phone, type);
		setSalary(salary);
	}

	@Override
	final double getMonthlyPay()
	{
		return salary / 12;
	}

	public final double getSalary()
	{
		return salary;
	}

	final void setSalary(double salary)
	{
		final int LOWER_BOUND = 1;
		final double UPPER_BOUND = Float.MAX_VALUE;

		ObjectUtils.validateNumber(salary, "Salary", LOWER_BOUND, UPPER_BOUND);
		this.salary = salary;
	}

	@Override
	public final String toString()
	{
		return String.format("Salary employee %s, salary: $%.2f.", super.toString(), getSalary());
	}
}