package pl.piotrowicki.lotto.util;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import pl.piotrowicki.lotto.entity.DrawEntity;
import pl.piotrowicki.lotto.service.DrawService;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public class DrawConverterUtil {

    private static final Logger LOGGER = Logger.getLogger(DrawService.class.getName());

    public static DrawEntity convertToEntity(String input) {
        String[] splittedDraw = input.split(" ");

        int firstSpace = input.indexOf(" ") + 1;

        DrawEntity entity = new DrawEntity();
        entity.setDrawDate(LocalDate.parse(splittedDraw[0]));
        entity.setNumbers(input.substring(firstSpace));
        return entity;
    }

    public static List<Integer> convertToIntegers(List<DrawEntity> draws) {
        return draws.stream()
                .map(s -> s.getNumbers().split(" "))
                .flatMap(Arrays::stream)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
