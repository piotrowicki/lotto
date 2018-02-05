package pl.piotrowicki.lotto.service;

import java.util.List;
import java.util.Map;
import pl.piotrowicki.lotto.entity.Draw;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public interface CalculationStrategy {
    Map<Integer, Long> calculate(List<Draw> draws);
}
