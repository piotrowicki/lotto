package pl.piotrowicki.lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import pl.piotrowicki.lotto.dto.LuckyNumberDto;
import pl.piotrowicki.lotto.entity.draw.BaseDrawEntity;
import pl.piotrowicki.lotto.entity.draw.DrawEntity;
import pl.piotrowicki.lotto.service.DrawService;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public class DrawConverterUtil {

    private static final Logger LOGGER = Logger.getLogger(DrawService.class.getName());

    public static <T extends BaseDrawEntity> List<Integer> convertToIntegers(List<T> draws) {
        return draws.stream()
                .map(s -> s.getNumbers().split(" "))
                .flatMap(Arrays::stream)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<LuckyNumberDto> convertToLuckyNumberDto(List<DrawEntity> draws) {
        return draws.stream()
                .map(f -> new LuckyNumberDto(f.getDrawDate(), convertToIntegerSet(f.getNumbers())))
                .collect(Collectors.toList());
    }

    public static Set<Integer> convertToIntegerSet(String numbers) {
        return Stream.of(numbers.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }
}
