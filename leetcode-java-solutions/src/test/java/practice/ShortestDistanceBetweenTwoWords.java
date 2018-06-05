package practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ShortestDistanceBetweenTwoWords {
    @Test
    public void test() {
        String book = "Java String array FAQ Can you share some Java array examples" +
                " specifically some String array examples as well as the Java 5 for loop syntax";
        String[] text = book.split("\\s+");

        // without pre process
        assertEquals(1, shortestDistance(text, "Java", "examples"));
        assertEquals(0, shortestDistance(text, "FAQ", "Can"));
        assertEquals(9, shortestDistance(text, "as", "share"));

        // without pre process - John's own solution
        assertEquals(1, shortestDistance3(text, "Java", "examples"));
        assertEquals(0, shortestDistance3(text, "FAQ", "Can"));
        assertEquals(9, shortestDistance3(text, "as", "share"));

        // with pre process
        assertEquals(1, shortestDistance2(text, "Java", "examples"));
        assertEquals(0, shortestDistance2(text, "FAQ", "Can"));
        assertEquals(9, shortestDistance2(text, "as", "share"));
    }

    private int shortestDistance(String[] text, String word1, String word2) {
        if (text == null || word1 == null || word2 == null || word1.isEmpty() || word2.isEmpty()) return -1;

        int p1 = -1, p2 = -1, minDistance = text.length;
        for (int i = 0; i < text.length; ++i) {
            if (text[i].equals(word1)) p1 = i;
            else if ((text[i].equals(word2))) p2 = i;
            if (p1 != -1 && p2 != -1) minDistance = Math.min(minDistance, Math.abs(p1 - p2));
        }
        return minDistance - 1;
    }

    private int shortestDistance3(String[] text, String word1, String word2) {
        int p1 = -1;
        int p2 = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < text.length; i++) {
            if (text[i].equals(word1)) p1 = i;
            if (text[i].equals(word2)) p2 = i;
            if (p1 != -1 && p2 != -1) minDistance = Math.min(minDistance, Math.abs(p1 - p2));
        }

        return minDistance - 1;
    }

    private int shortestDistance2(String[] text, String word1, String word2) {
        Map<String, ArrayList<Integer>> dict = preProcess(text);

        ArrayList<Integer> word1List = dict.get(word1);
        ArrayList<Integer> word2List = dict.get(word2);

        int p1 = 0;
        int p2 = 0;
        int minDistance = Integer.MAX_VALUE;

        while (p1 < word1List.size() && p2 < word2List.size()) {
            int index1 = word1List.get(p1);
            int index2 = word2List.get(p2);
            minDistance = Math.min(minDistance, Math.abs(index1 - index2));

            if (index1 < index2) {
                p1++;
            } else {
                p2++;
            }
        }

        return minDistance - 1;
    }

    private Map<String, ArrayList<Integer>> preProcess(String[] text) {
        Map<String, ArrayList<Integer>> dict = new HashMap<>();

        for (int i = 0; i < text.length; i++) {
            String word = text[i];
            ArrayList<Integer> positionList = dict.getOrDefault(word, new ArrayList<>());
            positionList.add(i);
            dict.put(word, positionList);
        }

        return dict;
    }
}
