// Quinn Keenan, 301504914, 05/10/2025

package com.github.kqfall1.QuinnKeenan_301504914_COMP228Lab3.exercise1;

abstract class Insurance
{
	private final int id;
	private double monthlyPayment;
	private static int nextIdValue;
	private final InsuranceType type;

	protected Insurance(double monthlyPayment, InsuranceType type)
	{
		id = ++nextIdValue;
		this.monthlyPayment = monthlyPayment;
		this.type = type;
	}

	public int getId()
	{
		return id;
	}

	public double getMonthlyPayment()
	{
		return monthlyPayment;
	}

	public InsuranceType getType()
	{
		return type;
	}

	protected void setMonthlyPayment(double monthlyPayment)
	{
		if (monthlyPayment <= 0)
		{
			throw new IllegalArgumentException(String.format("Insurance #%d: monthly payment must be positive.", getId()));
		}

		this.monthlyPayment = monthlyPayment;
	}

	@Override
	public String toString()
	{
		return String.format("ID: %d, Monthly Payment: %.2f, Type: %s", id, monthlyPayment, type);
	}
}