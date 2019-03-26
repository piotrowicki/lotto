package pl.piotrowicki.lotto.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public class StatisticUtil {
     public static long calculateAxisYSize(Map<Integer, Long> numbersMode) {
        return Collections.max(numbersMode.entrySet(), Comparator.comparingLong(Map.Entry::getValue)).getValue();
    }
     
     public static long calculateAxisYSizeWithAdditionalSpace(Map<Integer, Long> numbersMode, int space) {
         return calculateAxisYSize(numbersMode) + space;
     }

    public static long calculateAxisYTickInterval(Map<Integer, Long> numbersMode) {
        return calculateAxisYSizeWithAdditionalSpace(numbersMode, 0) / 10;
    }
}
