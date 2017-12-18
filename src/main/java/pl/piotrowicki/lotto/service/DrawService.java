package pl.piotrowicki.lotto.service;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import pl.piotrowicki.lotto.dao.DrawDao;
import pl.piotrowicki.lotto.entity.Draw;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Stateless
public class DrawService implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(DrawService.class.getName());

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Inject
    private DrawDao drawDao;
    
    public List<Draw> findAll() {
        return drawDao.findAll();
    }

    public Draw convertToEntity(String input) {
        String[] splittedDraw = input.split(" ");

        int firstSpace = input.indexOf(" ") + 1;

        Draw entity = new Draw();
        try {
            entity.setDrawDate(DATE_FORMAT.parse(splittedDraw[0]));
            entity.setNumbers(input.substring(firstSpace));
        } catch (ParseException ex) {
            LOGGER.log(Level.WARNING, "Date parsing FAIL " + ex);
        }
        return entity;
    }

    public void save(Draw entity) {
        drawDao.save(entity);
    }

    public Optional<Draw> findByDrawAndDrawDate(String numbers, Date drawDate) {
        return drawDao.findByDrawAndDrawDate(numbers, drawDate);
    }
 }
