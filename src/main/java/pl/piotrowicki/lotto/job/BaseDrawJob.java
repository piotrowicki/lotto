package pl.piotrowicki.lotto.job;

import java.time.LocalDate;

import pl.piotrowicki.lotto.entity.draw.BaseDrawEntity;

/**
 * @author nowik
 */
public class BaseDrawJob<T extends BaseDrawEntity> {

    private static final String DATE_AND_DRAW_REGEXP = "^\\d{1,4}-\\d{1,2}-\\d{1,2}(\\s\\d{1,2})+$";

    public <T extends BaseDrawEntity> T convertToEntity(Class<T> clazz, String input) throws InstantiationException, IllegalAccessException {
        if (!input.matches(DATE_AND_DRAW_REGEXP)) {
            return null;
        }

        String[] splittedDraw = input.split(" ");

        int firstSpace = input.indexOf(" ") + 1;

        T entity = clazz.newInstance();
        entity.setDrawDate(LocalDate.parse(splittedDraw[0]));
        entity.setNumbers(input.substring(firstSpace));
        return entity;
    }
}
