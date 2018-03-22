package pl.piotrowicki.lotto.service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.apache.log4j.Logger;
import pl.piotrowicki.lotto.dao.DrawDao;
import pl.piotrowicki.lotto.entity.Draw;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Stateless
public class DrawService implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(DrawService.class);

    @Inject
    private DrawDao drawDao;
    
    public List<Draw> findAll() {
        return drawDao.findAll();
    }

    public void save(Draw entity) {
        drawDao.save(entity);
    }

    public Optional<Draw> findByDrawAndDrawDate(String numbers, LocalDate drawDate) {
        return drawDao.findByDrawAndDrawDate(numbers, drawDate);
    }
 }
