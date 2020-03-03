package com.me.datastructure.linklist.single;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class BasicNumericalOperations {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String firstNumberString = null, secondNumberString = null;
		boolean first = true, second = true;
		Pattern pattern = Pattern.compile("\\d+");

		while (first) {
			System.out.println("Enter first Number");
			firstNumberString = reader.readLine();
			if (pattern.matcher(firstNumberString).matches()) {
				first = false;
			} else {
				System.out.println("Entered first Number contains non numeric digits");
			}
		}

		while (second) {
			System.out.println("Enter second Number");
			secondNumberString = reader.readLine();
			if (pattern.matcher(secondNumberString).matches()) {
				second = false;
			} else {
				System.out.println("Entered second Number contains non numeric digits");
			}
		}

		SingleLinkList firstNumber =  convertStringToNumber(firstNumberString);
		SingleLinkList secondNumber =  convertStringToNumber(secondNumberString);
		System.out.println("After converting into list first number:");
		firstNumber.printElements();
		System.out.println("After converting into list second number:");
		secondNumber.printElements();

	}
	
	public static SingleLinkList convertStringToNumber(String number) {
		
		SingleLinkList list = new SingleLinkList();
		for(int index=0; index<number.length() ; index++ ) {
			list.addNode(number.substring(index, index+1));
		}
		return list;
	}

}
