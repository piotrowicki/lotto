package pl.piotrowicki.lotto.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.apache.log4j.Logger;
import pl.piotrowicki.lotto.dao.DrawDao;
import pl.piotrowicki.lotto.entity.draw.BaseDrawEntity;
import pl.piotrowicki.lotto.entity.draw.DrawELEntity;
import pl.piotrowicki.lotto.entity.draw.DrawEPEntity;
import pl.piotrowicki.lotto.entity.draw.DrawEntity;
import pl.piotrowicki.lotto.entity.draw.DrawKAEntity;
import pl.piotrowicki.lotto.entity.draw.DrawMMEntity;
import pl.piotrowicki.lotto.enums.DrawType;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Stateless
public class DrawService {

    private static final Logger LOGGER = Logger.getLogger(DrawService.class);

    @Inject
    private DrawDao drawDao;
    
    private final Map<DrawType, Class<?>> mapper = new HashMap<>();

    @PostConstruct
    private void init() {
        mapper.put(DrawType.KASKADA, DrawKAEntity.class);
        mapper.put(DrawType.MULTI_MULTI, DrawMMEntity.class);
        mapper.put(DrawType.DUZY_LOTEK, DrawEntity.class);
        mapper.put(DrawType.EKSTRA_PENSJA, DrawEPEntity.class);
        mapper.put(DrawType.MINI_LOTTO, DrawELEntity.class);
    }
    
    public <T extends BaseDrawEntity> List<T> findAll(Class<T> aClass) {
        return drawDao.findAll(aClass);
    }

    public <T extends BaseDrawEntity> void save(T entity) {
        drawDao.save(entity);
    }

    public <T extends BaseDrawEntity> T findByDrawAndDrawDate(Class<T> aClass, String numbers, LocalDate drawDate) {
        return drawDao.findByDrawAndDrawDate(aClass, numbers, drawDate);
    }
    
    public <T extends BaseDrawEntity> Class<T> getClass(DrawType type) {
        return (Class<T>) mapper.get(type);
    }
 }
