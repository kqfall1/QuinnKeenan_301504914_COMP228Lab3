// Quinn Keenan, 301504914, 07/10/2025

package com.github.kqfall1.QuinnKeenan_301504914_COMP228Lab3.exercise3;

import com.github.kqfall1.kqfall1JavaUtils.CollectionConverter;
import com.github.kqfall1.kqfall1JavaUtils.CollectionPrinter;
import com.github.kqfall1.kqfall1JavaUtils.JOptionPaneHandler;
import com.github.kqfall1.kqfall1JavaUtils.StringUtils;
import javax.swing.JOptionPane;
import java.util.Arrays;

class MortgageController
{
	public static void main(String[] args)
	{
		final int MORTGAGE_INSTANTIATION_COUNT = 3;
		int mortgageIndex;
		Mortgage[] mortgages = new Mortgage[MORTGAGE_INSTANTIATION_COUNT];

		for (mortgageIndex = 0; mortgageIndex < mortgages.length; mortgageIndex++)
		{
			mortgages[mortgageIndex] = promptForMortgageInfo();

			JOptionPane.showMessageDialog(
				null,
				String.format("Mortgage %d created.", mortgages[mortgageIndex].getId()),
				"Success",
				JOptionPane.INFORMATION_MESSAGE
			);
		}

		Arrays.sort(mortgages);
		CollectionPrinter.print(mortgages, "Mortgage array");
	}

	private static Mortgage promptForMortgageInfo()
	{
		String input = null;
		double insuranceRate = 0;
		double monthlyPayment = 0;
		Mortgage mortgage;
		double principal = 0;
		double termYears = 0;

		insuranceRate = JOptionPaneHandler.promptForValidDouble(
			"What interest rate would you like for your new mortgage?",
			0.1, 100
		);

		monthlyPayment = JOptionPaneHandler.promptForValidDouble(
			"What is the monthly payment?",
			1, Double.MAX_VALUE
		);

		principal = JOptionPaneHandler.promptForValidDouble(
			"What is the principal?",
			1, Double.MAX_VALUE
		);

		termYears = JOptionPaneHandler.promptForValidDouble(
			"How long is the term in years?",
			1, Mortgage.MAX_TERM_YEARS
		);

		input = JOptionPaneHandler.promptForValidString(
			"What is the type of this mortgage?",
			CollectionConverter.toStringArr(MortgageType.values())
		);

		if (StringUtils.normalizeUpper(input).equals(MortgageType.BUSINESS.toString()))
		{
			mortgage = new BusinessMortgage(insuranceRate, monthlyPayment, principal, termYears);
		}
		else
		{
			mortgage = new PersonalMortgage(insuranceRate, monthlyPayment, principal, termYears);
		}

		return mortgage;
	}
}