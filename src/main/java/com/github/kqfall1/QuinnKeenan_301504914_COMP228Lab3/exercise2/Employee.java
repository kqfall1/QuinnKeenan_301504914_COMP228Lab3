// Quinn Keenan, 301504914, 06/10/2025

package com.github.kqfall1.QuinnKeenan_301504914_COMP228Lab3.exercise2;

abstract class Employee
{
	private String address;
	private final int id;
	private static int nextId;
	private final String name;
	private PayClassification payClassification;
	private String phone;
	private EmployeeType type;

	Employee(String address, String name, PayClassification payClassification,
			 String phone, EmployeeType type)
	{
		setAddress(address);
		id = ++nextId;
		this.name = name;
		setPayClassification(payClassification);
		setPhone(phone);
		setType(type);
	}

	final String getAddress()
	{
		return address;
	}

	final int getId()
	{
		return id;
	}

	abstract double getMonthlyPay();

	final String getName()
	{
		return name;
	}

	final PayClassification getPayClassification()
	{
		return payClassification;
	}

	final String getPhone()
	{
		return phone;
	}

	final EmployeeType getType()
	{
		return type;
	}

	final void setAddress(String address)
	{
		this.address = address;
	}

	final void setPayClassification(PayClassification payClassification)
	{
		this.payClassification = payClassification;
	}

	final void setPhone(String phone)
	{
		this.phone = phone;
	}

	final void setType(EmployeeType type)
	{
		this.type = type;
	}

	@Override
	public String toString()
	{
		return String.format(
			"%s, ID: %d, address: %s, pay classification: %s, phone: %s, type: %s, monthly pay: $%.2f",
			getName(), getId(), getAddress(), getPayClassification(), getPhone(), getType(), getMonthlyPay()
		);
	}
}