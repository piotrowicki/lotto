package pl.piotrowicki.lotto.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public class StatisticUtil {
     public static Long calculateAxisYSize(Map<Integer, Long> numbersMode) {
        return Collections.max(numbersMode.entrySet(), Comparator.comparingLong(Map.Entry::getValue)).getValue();
    }
     
     public static Long calculateAxisYSizeWithAdditionalSpace(Map<Integer, Long> numbersMode, int space) {
         return calculateAxisYSize(numbersMode) + space;
     }
}
