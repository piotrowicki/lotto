package pl.piotrowicki.lotto.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.apache.log4j.Logger;
import pl.piotrowicki.lotto.dao.DrawDao;
import pl.piotrowicki.lotto.entity.DrawEntity;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Stateless
public class DrawService {

    private static final Logger LOGGER = Logger.getLogger(DrawService.class);

    @Inject
    private DrawDao drawDao;
    
    public List<DrawEntity> findAll() {
        return drawDao.findAll();
    }

    public void save(DrawEntity entity) {
        drawDao.save(entity);
    }

    public Optional<DrawEntity> findByDrawAndDrawDate(String numbers, LocalDate drawDate) {
        return drawDao.findByDrawAndDrawDate(numbers, drawDate);
    }
 }
