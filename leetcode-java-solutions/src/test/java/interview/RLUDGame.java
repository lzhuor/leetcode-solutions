package interviews;

import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.factory.Maps;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RLUDGame {
    @Test
    public void testRLUDGame() {
        // Given
        MutableMap<String, Integer[]> testCases =
                Maps.mutable.with(
                        // case 1
                        "R", new Integer[]{1, 0},
                        // case 2
                        "RLLLLDDDU", new Integer[]{-3, -2},
                        // case 3
                        "RLUD", new Integer[]{0, 0}
                );

        // Then
        testCases.forEachKeyValue((key, val) -> assertThat(go(key)).isEqualTo(val));
    }

    private Integer[] go(String path) {
        List<Character> collect = path.chars()
                .mapToObj(each -> (char) each)
                .collect(Collectors.toList());

        int x = collect.stream().mapToInt(each -> {
            if (String.valueOf(each).equals("R")) return 1;
            if (String.valueOf(each).equals("L")) return -1;
            return 0;
        }).sum();

        int y = collect.stream().mapToInt(each -> {
            if (String.valueOf(each).equals("U")) return 1;
            if (String.valueOf(each).equals("D")) return -1;
            return 0;
        }).sum();

        return new Integer[]{x, y};
    }
}
