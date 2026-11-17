package pkg; //1stLabExam

import java.util.*;

public class PermutationNiBajala {//bajala was here

	//constructor
	// Prints every arrangement of the letters
	static void permute(String str, String answer) {

		if (str.length() == 0) {
			System.out.println(answer);
			return;
		}

		// try every letter in the remaining strings
		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i); // pick one letters

			// remove the picked letter from the remaining string
			String rest = str.substring(0, i) + str.substring(i + 1);

			// add the picked letter and repeat with the resttt
			permute(rest, answer + ch);
		}
	}

	public static void main(String[] args) {   ///main start
		Scanner sc = new Scanner(System.in);
		
		System.out.println("======================= vvvvv");
		System.out.print("Enter any 5 characters: ");
		String input = sc.nextLine();
		
		permute(input, "");
		System.out.println("=============================");
		sc.close();

	}// main end

}

/*javadoc
 * String input = "1 fish 2 fish red fish blue fish"; Scanner s = new
 * Scanner(input); s.findInLine("(\\d+) fish (\\d+) fish (\\w+) fish (\\w+)");
 * MatchResult result = s.match(); for (int i=1; i<=result.groupCount(); i++)
 * System.out.println(result.group(i)); s.close();
 */
