import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Problem344ReverseString {
    @Test
    public void test() {
        assertEquals("cba", reverseString("abc"));
        assertEquals("olleh", reverseString("hello"));
    }

    private String reverseString(String s) {
        String[] origin = s.split("");
        StringBuilder builder = new StringBuilder();

        for (int i = origin.length - 1; i >= 0; i--) {
            builder.append(origin[i]);
        }

        return builder.toString();
    }
}
