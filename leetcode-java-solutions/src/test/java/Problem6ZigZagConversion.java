import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem6ZigZagConversion {
    @Test
    public void ZigZagConversion() {
        MutableMap<Pair<String, Integer>, String> testCases = Maps.mutable.with(
                // case 1
                Tuples.pair("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR",
                // case 2
                Tuples.pair("PAYPALISHIRING", 4), "PINALSIGYAHRPI",
                // case 3
                Tuples.pair("AB", 1), "AB"
        );

        testCases.forEachKeyValue((pair, result) -> assertThat(convert(pair.getOne(), pair.getTwo())).isEqualTo(result));
    }

    private String convert(String s, Integer rows) {
        if (rows == 1) return s;

        String[] arr = s.split("");
        List<List<String>> list = new ArrayList<>();

        int counter = 0;
        while (counter < rows) {
            list.add(new ArrayList<>());
            counter++;
        }

        int row = 0;
        boolean isForward = true;

        for (String c : arr) {
            if (isForward) {
                list.get(row).add(c);
                row++;
            } else {
                list.get(row).add(c);
                row--;
            }

            if (row == rows) {
                isForward = false;
                row-=2;
            }
            if (row == 0) {
                isForward = true;
            }
        }

        StringBuilder sb = new StringBuilder(s.length());

        list.forEach(each -> each.forEach(sb::append));

        return sb.toString();
    }
}
