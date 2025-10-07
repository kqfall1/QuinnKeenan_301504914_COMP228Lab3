// Quinn Keenan, 301504914, 05/10/2025

package com.github.kqfall1.QuinnKeenan_301504914_COMP228Lab3.exercise1;

import com.github.kqfall1.kqfall1JavaUtils.CollectionPrinter;
import com.github.kqfall1.kqfall1JavaUtils.JOptionPaneHandler;
import java.util.Arrays;

class InsuranceController
{
	private static final int INSURANCE_ARR_COUNT = 10;
	private static final double ALTERED_MONTHLY_PAYMENT = 1675;

	public static void main(String[] args)
	{
		final Insurance[] insuranceArr = new  Insurance[INSURANCE_ARR_COUNT];
		int insuranceIndex;
		final InsuranceType type;
		final double monthlyPayment;
		String userInput;

		userInput = JOptionPaneHandler.promptForValidString("Enter \"health\" or \"life.\"", Arrays.asList("health", "life"));

		if (userInput.toUpperCase().equals(InsuranceType.HEALTH.toString()))
		{
			type =  InsuranceType.HEALTH;
		}
		else
		{
			type = InsuranceType.LIFE;
		}

		for (insuranceIndex = 0; insuranceIndex < insuranceArr.length; insuranceIndex++)
		{
			switch (type)
			{
				case HEALTH -> insuranceArr[insuranceIndex] = new HealthInsurance(2000);
				case LIFE -> insuranceArr[insuranceIndex] = new LifeInsurance(1500);
			};
		}

		CollectionPrinter.print(insuranceArr, "\nInsurance array");

		for (Insurance insurance : insuranceArr)
		{
			insurance.setMonthlyPayment(ALTERED_MONTHLY_PAYMENT);
		}

		CollectionPrinter.print(insuranceArr, "\nInsurance array after altering all monthly payment amounts");
	}
}