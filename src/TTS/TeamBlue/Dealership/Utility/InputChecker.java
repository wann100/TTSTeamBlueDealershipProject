package TTS.TeamBlue.Dealership.Utility;

import java.util.Scanner;

public class InputChecker {
	
	public static String checkInputText(Scanner scanner) {
		String input = "";
		boolean flag = false;
		while (flag == false) {
			if (scanner.hasNext()) {
				input = scanner.next();
				if (input.isEmpty()) {
					flag = false;
				} else {
					flag = true;
				}
			}
		}
		return input;
	}
	
	public static int checkInputNum(Scanner scanner) {
		String input = "";
		int num = 0;
		boolean flag = false;
		while (flag == false) {
			input = scanner.next();
			if (numberOrNot(input)) {
				num = Integer.parseInt(input);
				if (num < 0 || num > Integer.MAX_VALUE) {
					System.out.println("Something's wrong with you input. Try again...");
					flag = false;
				} else {
					flag = true;
				}
			} else {
				System.out.println("Something's wrong with you input. Try again...");
				flag = false;
			}
		}
		return num;
	}
	
	public static boolean numberOrNot(String input) {
	    try {
	        Integer.parseInt(input);
	    }
	    catch(NumberFormatException ex) {
	        return false;
	    }
	    return true;
	}

}
