// Quinn Keenan, 301504914, 07/10/2025

package com.github.kqfall1.QuinnKeenan_301504914_COMP228Lab3.exercise2;

import com.github.kqfall1.kqfall1JavaUtils.JOptionPaneHandler;
import java.util.Arrays;

public class EmployeeController
{
	private static final String ADDRESS = "12 Pine Lane";
	private static final String NAME = "Billy Don Bob";
	private static final String PHONE = "437-890-7619";

	public static void main(String[] args)
	{
		Employee employee;

		String userInput = JOptionPaneHandler.promptForValidString(
			"Would you like to create an hourly employee or a salary employee?",
			Arrays.asList("SALARY", "HOURLY")
		);

		if (PayClassification.valueOf(userInput.toUpperCase()) == PayClassification.HOURLY)
		{
			employee = new HourlyEmployee(ADDRESS, 30, NAME, PHONE, EmployeeType.PART_TIME);
		}
		else
		{
			employee = new SalaryEmployee(ADDRESS, NAME, PHONE, EmployeeType.FULL_TIME);
		}

		System.out.println(employee);
	}
}