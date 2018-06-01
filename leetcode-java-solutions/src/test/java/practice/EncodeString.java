package practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EncodeString {
    @Test
    public void test() {
        assertEquals("a5b2c1", encodeString("aaaaabbc"));
        assertEquals("a1", encodeString("a"));
        assertEquals("a6", encodeString("aaaaaa"));
    }

    private String encodeString(String string) {
        String[] arr = string.split("");
        String current = arr[0];
        int counter = 0;

        StringBuilder builder = new StringBuilder();

        for (String s : arr) {
            if (current.equals(s)) {
                counter++;
            } else {
                builder.append(current);
                builder.append(counter);
                current = s;
                counter = 1;
            }
        }

        builder.append(current);
        builder.append(counter);

        return builder.toString();
    }
}
