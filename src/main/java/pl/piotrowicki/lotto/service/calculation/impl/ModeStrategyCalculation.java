package pl.piotrowicki.lotto.service.calculation.impl;

import pl.piotrowicki.lotto.service.calculation.CalculationStrategy;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import pl.piotrowicki.lotto.entity.Draw;
import pl.piotrowicki.lotto.util.DrawConverterUtil;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public class ModeStrategyCalculation implements CalculationStrategy {

    @Override
    public Map<Integer, Long> calculate(List<Draw> draws) {
        List<Integer> allNumbers = DrawConverterUtil.convertToIntegers(draws);

        return allNumbers.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        TreeMap::new,
                        Collectors.counting())
                );
    }
}
