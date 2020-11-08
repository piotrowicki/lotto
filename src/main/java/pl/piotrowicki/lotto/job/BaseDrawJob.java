package pl.piotrowicki.lotto.job;

import java.time.LocalDate;
import pl.piotrowicki.lotto.entity.draw.BaseDrawEntity;

/**
 *
 * @author nowik
 */
public class BaseDrawJob<T extends BaseDrawEntity> {
     public <T extends BaseDrawEntity> T convertToEntity(Class<T> clazz, String input) throws InstantiationException, IllegalAccessException {
        String[] splittedDraw = input.split(" ");

        int firstSpace = input.indexOf(" ") + 1;

        T entity = clazz.newInstance();
        entity.setDrawDate(LocalDate.parse(splittedDraw[0]));
        entity.setNumbers(input.substring(firstSpace));
        return entity;
    }   
}
