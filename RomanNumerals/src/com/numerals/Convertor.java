package com.numerals;

import java.util.List;

import static com.numerals.Numeral.*;

public class Convertor {
	
	int total = 0;
	int count = 0;
	
	public int convert(String numerals) {
		List<Numeral> validNumerals = convertStringToNumerals(numerals);
		return convertNumeralsToInteger(validNumerals);
	}
	
	private int convertNumeralsToInteger(List<Numeral> validNumerals) {
		while (count < validNumerals.size()) {
			if (isLastNumeralInSequence(validNumerals, count+1)) {
				return total += validNumerals.get(count).getValue();
			} else {
				evaluteCurrentAndSucceeding(validNumerals);
			}
			count++;
		}
		return total;
	}

	private void evaluteCurrentAndSucceeding(List<Numeral> validNumerals) {
		int value1 = validNumerals.get(count).getValue();
		int value2 = validNumerals.get(count+1).getValue();
		if (value1 < value2) {
			total += (value2 - value1);
			count++;
		} else if (value1 >= value2) {
			total += value1;
		}
	}
	
	private boolean isLastNumeralInSequence(final List<Numeral> list, int index) {
	     return index >= list.size();
	}
}