package pl.piotrowicki.lotto.service.calculation.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import pl.piotrowicki.lotto.entity.Draw;
import pl.piotrowicki.lotto.service.calculation.CalculationStrategy;
import pl.piotrowicki.lotto.util.DrawConverterUtil;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public class PercentageStrategyCalculation implements CalculationStrategy {

    @Override
    public Map<Integer, Long> calculate(List<Draw> draws) {
        List<Integer> allNumbers = DrawConverterUtil.convertToIntegers(draws);

        Map<Integer, Long> collect = allNumbers.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        TreeMap::new,
                        Collectors.counting())
                );

        for (Map.Entry<Integer, Long> entry : collect.entrySet()) {

            BigDecimal currentNumberQuntity = BigDecimal.valueOf(entry.getValue());
            BigDecimal howMAnyNumbers = BigDecimal.valueOf(allNumbers.size());

            long result = currentNumberQuntity
                    .multiply(BigDecimal.valueOf(100))
                    .divide(howMAnyNumbers, RoundingMode.HALF_EVEN)
                    .longValue();

            entry.setValue(result);
        }

        return collect;
    }
}
