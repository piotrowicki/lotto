package pl.piotrowicki.lotto.service.calculation;

import java.util.List;
import java.util.Map;
import pl.piotrowicki.lotto.entity.DrawEntity;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public interface CalculationStrategy {
    Map<Integer, Long> calculate(List<DrawEntity> draws);
}
