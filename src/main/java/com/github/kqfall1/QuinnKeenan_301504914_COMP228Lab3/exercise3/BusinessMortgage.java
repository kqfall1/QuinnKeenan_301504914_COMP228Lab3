// Quinn Keenan, 301504914, 07/10/2025

package com.github.kqfall1.QuinnKeenan_301504914_COMP228Lab3.exercise3;

class BusinessMortgage extends Mortgage
{
	BusinessMortgage(double interestRate, double monthlyPayment, double principal, double termYears)
	{
		super(interestRate, monthlyPayment, principal, termYears, MortgageType.BUSINESS);
	}
}