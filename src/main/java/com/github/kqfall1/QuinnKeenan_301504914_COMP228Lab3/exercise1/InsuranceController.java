// Quinn Keenan, 301504914, 05/10/2025

package com.github.kqfall1.QuinnKeenan_301504914_COMP228Lab3.exercise1;

import com.github.kqfall1.kqfall1JavaUtils.CollectionConverter;
import com.github.kqfall1.kqfall1JavaUtils.CollectionPrinter;
import com.github.kqfall1.kqfall1JavaUtils.JOptionPaneHandler;
import com.github.kqfall1.kqfall1JavaUtils.StringUtils;

import java.util.Arrays;

class InsuranceController
{
	public static void main(String[] args)
	{
		final double ALTERED_MONTHLY_PAYMENT = 1675;
		final int INSURANCE_ARR_COUNT = 10;
		final Insurance[] insuranceArr = new  Insurance[INSURANCE_ARR_COUNT];
		int insuranceIndex;
		final double monthlyPayment;
		String input;

		input = JOptionPaneHandler.promptForValidString(
			"Would you like to create a health insurance or life insurance plan?",
			Arrays.asList(CollectionConverter.toStringArr(InsuranceType.values()))
		);

		monthlyPayment = JOptionPaneHandler.promptForValidDouble(
			"What is the monthly payment?",
			1, Float.MAX_VALUE
		);

		if (InsuranceType.valueOf(StringUtils.normalizeUpper(input)) == InsuranceType.HEALTH)
		{
			for (insuranceIndex = 0; insuranceIndex < insuranceArr.length; insuranceIndex++)
			{
				insuranceArr[insuranceIndex] = new HealthInsurance(monthlyPayment);
			}
		}
		else
		{
			for (insuranceIndex = 0; insuranceIndex < insuranceArr.length; insuranceIndex++)
			{
				insuranceArr[insuranceIndex] = new LifeInsurance(monthlyPayment);
			}
		}

		CollectionPrinter.print(insuranceArr, "\nInsurance array");

		for (Insurance insurance : insuranceArr)
		{
			insurance.setMonthlyPayment(ALTERED_MONTHLY_PAYMENT);
		}

		CollectionPrinter.print(insuranceArr, "\nInsurance array after altering all monthly payment amounts");
	}
}