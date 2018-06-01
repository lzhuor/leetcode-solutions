package practice;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FirstNonDuplicateElement {
    @Test
    public void test() {
        assertEquals(0, firstUniqChar("leetcode"));
        assertEquals(2, firstUniqChar("loveleetcode"));
    }

    private int firstUniqChar(String s) {
        if (s.equals("")) return -1;

        Map<String, Integer> map = new HashMap<>();
        String[] list = s.split("");

        for (String each : list) {
            int count = map.getOrDefault(each, 0);
            count += 1;
            map.put(each, count);
        }

        for (int i = 0; i < list.length; i++) {
            if (map.get(list[i]) == 1) return i;
        }

        return -1;
    }
}
