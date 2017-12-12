package pl.piotrowicki.lotto.service;

import java.io.Serializable;
import java.util.List;
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
    
    @Inject
    private DrawDao drawDao;
    
    public List<Draw> findAll() {
        return drawDao.findAll();
    }
}
