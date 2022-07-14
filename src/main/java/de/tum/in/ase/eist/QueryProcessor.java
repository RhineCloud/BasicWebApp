package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "Yin";
        } else if (query.contains("plus")) {
            String[] words = query.split(" ");
            int first = Integer.parseInt(words[3]);
            int second = Integer.parseInt(words[5]);
            return String.valueOf(first + second);
        } else if (query.contains("largest")) {
            String[] numberStrings = query.substring(query.lastIndexOf(":") + 2).split(", ");
            int[] numbers = new int[numberStrings.length];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(numberStrings[i]);
            }
            int largest = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] > largest) {
                    largest = numbers[i];
                }
            }
            return String.valueOf(largest);
        } else {
            return "";
        }
    }
}
