import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.factory.Maps;
import org.junit.Test;

import java.util.HashMap;

public class Problem7ReverseInteger {
    @Test
    public void test() {
        MutableMap<Integer, Integer> testCases = Maps.mutable.with(
                // case 1
                100, 1,
                // case 2
                123, 321,
                // case 3
                -123, -321,
                // case 4
                120, 21
        );
    }

    public int reverInteger(int number) {
        HashMap<String, String> map = new HashMap<>();

        return 0;
    }
}
