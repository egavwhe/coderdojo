package com.numerals;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.Before;

import com.numerals.Convertor;

public class ConvertorTest {
	
	Map<String, Integer> numeralToInt = new HashMap<String, Integer>();
	
	@Before
	public void setup() {
		numeralToInt.put("I", 1);
		numeralToInt.put("II", 2);
		numeralToInt.put("III", 3);
		numeralToInt.put("IV", 4);
		numeralToInt.put("V", 5);
		numeralToInt.put("VI", 6);
		numeralToInt.put("VII", 7);
		numeralToInt.put("VIII", 8);
		numeralToInt.put("IX", 9);
		numeralToInt.put("X",10);
		numeralToInt.put("XI",11);
		numeralToInt.put("XII",12);
		numeralToInt.put("XIII", 13);
		numeralToInt.put("XIV", 14);
		numeralToInt.put("XX", 20);
		numeralToInt.put("XLIV", 44);
		numeralToInt.put("LXXXIX", 89);
		numeralToInt.put("CDXLVII", 447);
		numeralToInt.put("CMXCIX", 999);
	}
	
	@Test
	public void numeralsShouldConvertToCorrectIntegers() {
		for (Map.Entry<String, Integer> entry : numeralToInt.entrySet()) {
			Convertor convertor = new Convertor();
			Integer actualValue = convertor.convert(entry.getKey());
			assertEquals(actualValue, entry.getValue());
		}
	}
	
	@Test
	public void superbowl() {
		final int expected = 49;
		Convertor convertor = new Convertor();
		int actual = convertor.convert("XLIX");
		assertEquals("Characters 'XLIX' should convert to '49'.", expected, actual);
	}
}