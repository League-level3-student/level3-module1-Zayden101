package _00_Intro_To_ArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
    public static void main(String[] args) {
        // 1. Create an array list of Strings
        //    Don't forget to import the ArrayList class
        ArrayList<String> stringes = new ArrayList<String>();

        // 2. Add five Strings to your list
        stringes.add("one thing");
        stringes.add("second thing");
        stringes.add("third thing");
        stringes.add("fourth thing");
        stringes.add("fifth thing");
        // 3. Print all the Strings using a standard for-loop
        for (int i = 0; i < stringes.size(); i++) {
			String a = stringes.get(i);
			//System.out.println(a);
		}
        // 4. Print all the Strings using a for-each loop
        for (String a : stringes) {
			//System.out.println(a);
        }
        // 5. Print only the even numbered elements in the list.

        for (int i = 0; i < stringes.size(); i++) {
        	String a= stringes.get(i);
        	if (i % 2 == 0) {
        		//System.out.println(a);
        	}
        }
        // 6. Print all the Strings in reverse order.
        for (int i = stringes.size(); i < 0; i--) {
        	String a = stringes.get(i);
        	System.out.println(a);
        }
        // 7. Print only the Strings that have the letter 'e' in them.
        
    }
}
