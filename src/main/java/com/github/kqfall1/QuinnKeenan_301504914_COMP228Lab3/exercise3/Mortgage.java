// Quinn Keenan, 301504914, 07/10/2025

package com.github.kqfall1.QuinnKeenan_301504914_COMP228Lab3.exercise3;

import com.github.kqfall1.kqfall1JavaUtils.ObjectUtils;
import com.github.kqfall1.kqfall1JavaUtils.StringUtils;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

abstract class Mortgage implements Comparable<Mortgage>
{
	private final LocalDate creationDate;
	private final int id;
	private static int nextId;
	private final double interestRate;
	private BigDecimal monthlyPayment;
	private BigDecimal principal;
	private BigDecimal termYears;
	public static final int MAX_TERM_YEARS = 150;
	private BigDecimal totalPaid;
	private final MortgageType type;

	Mortgage(double interestRate, double monthlyPayment, double principal, double termYears, MortgageType type)
	{
		creationDate = LocalDate.now();
		id = ++nextId;
		ObjectUtils.validateNumber(interestRate, "Interest rate", 0.1, 100);
		this.interestRate = interestRate / 100;
		setMonthlyPayment(monthlyPayment);
		setPrincipal(principal);
		setTermYears(termYears);
		totalPaid = BigDecimal.ZERO;
		this.type = type;
	}

	@Override
	public int compareTo(Mortgage other)
	{
		return getId() - other.getId();
	}

	public final LocalDate getCreationDate()
	{
		return creationDate;
	}

	public final int getId()
	{
		return id;
	}

	public final double getInterestRate()
	{
		return interestRate * 100;
	}

	public final double getMonthlyPayment()
	{
		return monthlyPayment.doubleValue();
	}

	public final double getPrincipal()
	{
		return principal.doubleValue();
	}

	public final double getTermYears()
	{
		return termYears.doubleValue();
	}

	public final double getTotalInterest()
	{
		return getTotalOwed() - getPrincipal();
	}

	public final double getTotalPaid()
	{
		return totalPaid.doubleValue();
	}

	public final double getTotalOwed()
	{
		int monthIndex;
		BigDecimal monthlyRate;
		BigDecimal monthsActive = BigDecimal.valueOf(Period.between(creationDate, LocalDate.now()).toTotalMonths());
		BigDecimal totalOwed = principal;

		monthlyRate = BigDecimal.valueOf(interestRate / 12);

		for (monthIndex = 0; monthIndex < monthsActive.intValue(); monthIndex++)
		{
			totalOwed = totalOwed.add(totalOwed.multiply(monthlyRate));
		}

		return totalOwed.doubleValue();
	}

	public final MortgageType getType()
	{
		return type;
	}

	final void setMonthlyPayment(double monthlyPayment)
	{
		final int LOWER_BOUND = 1;
		final double UPPER_BOUND = Float.MAX_VALUE;

		ObjectUtils.validateNumber(monthlyPayment, "Monthly payment", LOWER_BOUND, UPPER_BOUND);
		this.monthlyPayment = new BigDecimal(monthlyPayment);
	}

	private void setPrincipal(double principal)
	{
		int LOWER_BOUND = 1;
		double UPPER_BOUND = Float.MAX_VALUE;

		ObjectUtils.validateNumber(principal, "Principal", LOWER_BOUND, UPPER_BOUND);
		this.principal = new BigDecimal(principal);
	}

	final void setTermYears(double termYears)
	{
		int LOWER_BOUND = 1;

		ObjectUtils.validateNumber(termYears, "Term years", LOWER_BOUND, MAX_TERM_YEARS);
		this.termYears = new BigDecimal(termYears);
	}

	final void setTotalPaid(double totalPaid)
	{
		int LOWER_BOUND = 0;
		double UPPER_BOUND = Float.MAX_VALUE;

		ObjectUtils.validateNumber(totalPaid, "Total paid", LOWER_BOUND, UPPER_BOUND);
		this.totalPaid = new BigDecimal(totalPaid);
	}

	@Override
	public String toString()
	{
		return String.format(
			"ID: %d, creation date: %s, interest rate: %.2f%%, monthly payment: $%.2f, principal: $%.2f, term years: %.2f, total interest: $%.2f, total paid: $%.2f, type: %s",
			getId(), getCreationDate(), getInterestRate(), getMonthlyPayment(), getPrincipal(), getTermYears(), getTotalInterest(), getTotalPaid(), StringUtils.normalizeLower(type.toString())
		);
	}
}