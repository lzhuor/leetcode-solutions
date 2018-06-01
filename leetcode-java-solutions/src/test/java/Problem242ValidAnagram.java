import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Problem242ValidAnagram {
    @Test
    public void test() {
        assertTrue(checkAnagram("test", "estt"));
        assertTrue(checkAnagram("team", "eamt"));
        assertFalse(checkAnagram("test", "est"));
    }

    private boolean checkAnagram(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        int[] dic = new int[256];
        Arrays.fill(dic, 0);

        for (char c : chars1) {
            dic[c]++;
        }

        for (char c : chars2) {
            dic[c]--;
        }

        for (int i : dic) {
            if (i != 0) return false;
        }

        return true;
    }
}
