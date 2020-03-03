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

		SingleLinkList result = addTwoNumbers(firstNumberString, secondNumberString);
		System.out.println("Summation of two given number is");
		result.printElements();

	}

	private static SingleLinkList addTwoNumbers(String firstNumberString, String secondNumberString) {

		SingleLinkList firstNumber = convertStringToNumber(firstNumberString); 
		SingleLinkList secondNumber = convertStringToNumber(secondNumberString); 

		SingleLinkList addResult = new SingleLinkList();

		firstNumber = reverseList(firstNumber);
		secondNumber = reverseList(secondNumber);

		Node head1 = firstNumber.getHead();
		Node head2 = secondNumber.getHead();

		int carry = 0;
		int result = 0;

		while ((head1 != null || head2 != null) || carry!=0) {
			if (head1 != null && head2 != null) {
				result = Integer.parseInt(head1.getData()) + Integer.parseInt(head2.getData()) + carry;
				carry = result / 10;
				result = result % 10;
				addResult.addNode(String.valueOf(result));
				head1 = head1.getLink();
				head2 = head2.getLink();
			} else if (head1 == null && head2 != null) {
				result = Integer.parseInt(head2.getData()) + carry;
				carry = result / 10;
				result = result % 10;
				addResult.addNode(String.valueOf(result));
				head2 = head2.getLink();
			} else if (head1 != null && head2 == null) {
				result = Integer.parseInt(head1.getData()) + carry;
				carry = result / 10;
				result = result % 10;
				addResult.addNode(String.valueOf(result));
				head1 = head1.getLink();
			} else if (head1 == null && head2 == null && carry != 0) {
				addResult.addNode(String.valueOf(carry));
				carry = 0;
			}
		}

		return reverseList(addResult);
	}
    
	/***
	 * Algorithm for reversing the list
	 * current = head , previous = null , next = null
	 * while(current!=null) do
	 *   next = current.next
	 *   current.next = previous
	 *   previous = current
	 *   current = next;
	 * End While  
	 */
	private static SingleLinkList reverseList(SingleLinkList list) {
		Node current = list.getHead();
		Node previous = null, next = null;
		while(current!=null) {
			next = current.getLink();
			current.setLink(previous);
			previous = current;
			current = next;
		}
		
		return new SingleLinkList(previous);
	}

	private static SingleLinkList convertStringToNumber(String number) {

		SingleLinkList list = new SingleLinkList();
		for (int index = 0; index < number.length(); index++) {
			list.addNode(number.substring(index, index + 1));
		}
		return list;
	}

}
