// Quinn Keenan, 301504914, 05/10/2025

package com.github.kqfall1.QuinnKeenan_301504914_COMP228Lab3.exercise1;

import com.github.kqfall1.kqfall1JavaUtils.ObjectUtils;

abstract class Insurance
{
	private final int id;
	private double monthlyPayment;
	private static int nextIdValue;
	private final InsuranceType type;

	Insurance(double monthlyPayment, InsuranceType type)
	{
		id = ++nextIdValue;
		setMonthlyPayment(monthlyPayment);
		this.type = type;
	}

	public final int getId()
	{
		return id;
	}

	public final double getMonthlyPayment()
	{
		return monthlyPayment;
	}

	public final InsuranceType getType()
	{
		return type;
	}

	protected final void setMonthlyPayment(double monthlyPayment)
	{
		final int LOWER_BOUND = 1;
		final double UPPER_BOUND = Float.MAX_VALUE;

		ObjectUtils.validateNumber(monthlyPayment, "Monthly payment", LOWER_BOUND, UPPER_BOUND);
		this.monthlyPayment = monthlyPayment;
	}

	@Override
	public String toString()
	{
		return String.format("ID: %d, Monthly Payment: %.2f, Type: %s", id, monthlyPayment, type);
	}
}