package pl.piotrowicki.lotto.service;

import java.time.LocalDate;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.apache.log4j.Logger;
import pl.piotrowicki.lotto.dao.DrawDao;
import pl.piotrowicki.lotto.entity.BaseDrawEntity;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Stateless
public class DrawService {

    private static final Logger LOGGER = Logger.getLogger(DrawService.class);

    @Inject
    private DrawDao drawDao;
    
    public <T extends BaseDrawEntity> List<T> findAll(Class<T> aClass) {
        return drawDao.findAll(aClass);
    }

    public <T extends BaseDrawEntity> void save(T entity) {
        drawDao.save(entity);
    }

    public <T extends BaseDrawEntity> T findByDrawAndDrawDate(Class<T> aClass, String numbers, LocalDate drawDate) {
        return drawDao.findByDrawAndDrawDate(aClass, numbers, drawDate);
    }
 }
