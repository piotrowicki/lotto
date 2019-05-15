package pl.piotrowicki.lotto.service;

import java.time.LocalDate;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import pl.piotrowicki.lotto.dao.user.DrawEPDao;
import pl.piotrowicki.lotto.entity.DrawEPEntity;

/**
 *
 * @author nowik
 */
@Stateless
public class DrawEPService {
    
    @Inject
    private DrawEPDao dao;
    
    public List<DrawEPEntity> findAll() {
        return dao.findAll();
    }

    public void save(DrawEPEntity entity) {
        dao.save(entity);
    }

    public DrawEPEntity findByDrawAndDrawDate(String numbers, LocalDate drawDate) {
        return dao.findByDrawAndDrawDate(numbers, drawDate);
    }   
}
