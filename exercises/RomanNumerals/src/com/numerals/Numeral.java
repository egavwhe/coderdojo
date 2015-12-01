package com.numerals;

import java.util.ArrayList;
import java.util.List;

public enum Numeral {
	
	I(1), 
	V(5), 
	X(10), 
	L(50), 
	C(100), 
	D(500), 
	M(1000);
	
	private int value;
	
	Numeral(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public static List<Numeral> convertStringToNumerals(String numerals) {
		List<Numeral> validNumerals = new ArrayList<Numeral>();
		for (int i = 0; i < numerals.length(); i++) {
			validNumerals = convertCharToNumeral(numerals.charAt(i), validNumerals);
		}
		return validNumerals;
	}
	
	private static List<Numeral> convertCharToNumeral(char numeral, List<Numeral> validNumerals) {
		if (numeral == 'I') {
			validNumerals.add(I);
		} else if (numeral == 'V') {
			validNumerals.add(V);
		} else if (numeral == 'X') {
			validNumerals.add(X);
		} else if (numeral == 'L') {
			validNumerals.add(L);
		} else if (numeral == 'C') {
			validNumerals.add(C);
		} else if (numeral == 'D') {
			validNumerals.add(D);
		} else if (numeral == 'M') {
			validNumerals.add(M);
		} else {
			System.out.println("Invalid character used.");
		}
		return validNumerals;
	}

}
