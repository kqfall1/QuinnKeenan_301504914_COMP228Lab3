// Quinn Keenan, 301504914, 06/10/2025

package com.github.kqfall1.QuinnKeenan_301504914_COMP228Lab3.exercise2;

import com.github.kqfall1.kqfall1JavaUtils.ObjectUtils;

public class HourlyEmployee extends Employee
{
	private double avgWeeklyHours;
	private static final double AVG_WEEKS_PER_MONTH = 4.345;
	private static final double BASE_HOURLY_RATE = 21.5;
	private double hourlyRate;

	HourlyEmployee(String address, double avgWeeklyHours, String name, String phone, EmployeeType type)
	{
		super(address, name, PayClassification.HOURLY, phone, type);
		setAvgWeeklyHours(avgWeeklyHours);
		setHourlyRate(BASE_HOURLY_RATE);
	}

	HourlyEmployee(String address, double avgWeeklyHours, double hourlyRate, String name,
				   String phone, EmployeeType type)
	{
		super(address, name, PayClassification.HOURLY, phone, type);
		setAvgWeeklyHours(avgWeeklyHours);
		setHourlyRate(hourlyRate);
	}

	public final double getAvgWeeklyHours()
	{
		return avgWeeklyHours;
	}

	public final double getHourlyRate()
	{
		return hourlyRate;
	}

	@Override
	final double getMonthlyPay()
	{
		return getAvgWeeklyHours() * getHourlyRate() * AVG_WEEKS_PER_MONTH;
	}

	final void setAvgWeeklyHours(double avgWeeklyHours)
	{
		final int LOWER_BOUND = 1;
		final int UPPER_BOUND = 125;

		ObjectUtils.validateNumber(avgWeeklyHours, "Average weekly hours", LOWER_BOUND, UPPER_BOUND);
		this.avgWeeklyHours = avgWeeklyHours;
	}

	final void setHourlyRate(double hourlyRate)
	{
		final int LOWER_BOUND = 1;
		final int UPPER_BOUND = 10000;

		ObjectUtils.validateNumber(hourlyRate, "Hourly rate", LOWER_BOUND, UPPER_BOUND);
		this.hourlyRate = hourlyRate;
	}

	@Override
	public String toString()
	{
		return String.format(
			"Hourly employee %s, average weekly hours: %.2f, hourly rate: $%.2f.",
			super.toString(), getAvgWeeklyHours(), getHourlyRate()
		);
	}
}