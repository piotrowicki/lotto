package pl.piotrowicki.lotto.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import pl.piotrowicki.lotto.dao.DrawDao;
import pl.piotrowicki.lotto.entity.Draw;
import pl.piotrowicki.lotto.util.DrawConverterUtil;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Stateless
public class DrawService implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(DrawService.class.getName());

    @Inject
    private DrawDao drawDao;
    
    public List<Draw> findAll() {
        return drawDao.findAll();
    }

    public Draw convertToEntity(String input) {
        return DrawConverterUtil.convertToEntity(input);
    }

    public void save(Draw entity) {
        drawDao.save(entity);
    }

    public Optional<Draw> findByDrawAndDrawDate(String numbers, Date drawDate) {
        return drawDao.findByDrawAndDrawDate(numbers, drawDate);
    }
 }
