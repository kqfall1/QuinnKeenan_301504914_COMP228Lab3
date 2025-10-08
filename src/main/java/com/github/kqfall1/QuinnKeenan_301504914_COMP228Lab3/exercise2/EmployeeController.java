// Quinn Keenan, 301504914, 07/10/2025

package com.github.kqfall1.QuinnKeenan_301504914_COMP228Lab3.exercise2;

import com.github.kqfall1.kqfall1JavaUtils.CollectionConverter;
import com.github.kqfall1.kqfall1JavaUtils.JOptionPaneHandler;
import com.github.kqfall1.kqfall1JavaUtils.StringUtils;
import java.util.Arrays;

public class EmployeeController
{
	public static void main(String[] args)
	{
		final String ADDRESS = "12 Pine Lane";
		final Employee employee;
		final String NAME = "Billy Joe Buck";
		final String PHONE = "437-890-7619";

		String input = JOptionPaneHandler.promptForValidString(
			"Would you like to create an hourly employee or a salary employee?",
			Arrays.asList(CollectionConverter.toStringArr(PayClassification.values()))
		);

		if (PayClassification.valueOf(StringUtils.normalizeUpper(input)) == PayClassification.HOURLY)
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