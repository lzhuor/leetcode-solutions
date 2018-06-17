package interviews.google;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;

public class Google {
    @Test
    public void test() {
//        assertEquals("11:00", solution("12:34"));
        assertEquals("11:00", solution("11:01"));
        assertEquals("11:55", solution("11:59"));
        assertEquals("11:11", solution("11:13"));
        assertEquals("22:22", solution("22:22"));
    }

    private String solution(String S) {
        String hours = S.split(":")[0];
        String mins = S.split(":")[1];

        int hr1 = Integer.parseInt(hours.substring(0, 1));
        int hr2 = Integer.parseInt(hours.substring(1));
        int min1 = Integer.parseInt(mins.substring(0, 1));
        int min2 = Integer.parseInt(mins.substring(1));

        HashSet<Integer> set = new HashSet<>();
        set.add(hr1);
        set.add(hr2);
        set.add(min1);
        set.add(min2);

        ArrayList<String> times = new ArrayList<>();

        StringBuilder time = new StringBuilder();

        for (Integer h1 : set) {
            if (h1 > 2) continue;
            time.append(h1);
            for (Integer h2 : set) {
                time.append(h2);
                time.append(":");
                for (Integer m1 : set) {
                    if (m1 > 5) continue;
                    time.append(m1);
                    for (Integer m2 : set) {
                        time.append(m2);
                        String maybeTime = time.toString();
                        if (isValidTime(maybeTime)) {
                            times.add(maybeTime);
                        }
                        time.deleteCharAt(4);
                    }
                    time.deleteCharAt(3);
                }
                time.deleteCharAt(2);
                time.deleteCharAt(1);
            }
            time.deleteCharAt(0);
        }

        long minDiff = Integer.MAX_VALUE;
        String timeString = "";

        for (String aTime: times) {
            Date givenDate = parseDate(S);
            Date ourDate = parseDate(aTime);
            long diff = givenDate.getTime() - ourDate.getTime();

            if (diff > 0 && diff < minDiff) {
                minDiff = diff;
                timeString = aTime;
            }
        }

        if (minDiff == Integer.MAX_VALUE) {
            return S;
        } else {
            return timeString;
        }

    }

    public boolean isValidTime(String time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(time);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public Date parseDate(String time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        dateFormat.setLenient(false);
        try {
            return dateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
