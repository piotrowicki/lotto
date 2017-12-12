package pl.piotrowicki.lotto.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import pl.piotrowicki.lotto.entity.Draw;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Stateless
public class DrawDao implements Serializable {
    
    public List<Draw> findAll() {
        return new ArrayList<>();
    }
}
