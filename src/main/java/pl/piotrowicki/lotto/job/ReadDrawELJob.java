/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.piotrowicki.lotto.job;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import org.apache.log4j.Logger;
import pl.piotrowicki.lotto.entity.DrawELEntity;
import pl.piotrowicki.lotto.service.DrawService;
import pl.piotrowicki.lotto.service.JsoupReaderService;

/**
 *
 * @author nowik
 */
@Singleton
public class ReadDrawELJob extends BaseDrawJob<DrawELEntity> {
    
    private static final Logger LOGGER = Logger.getLogger(ReadDrawELJob.class);

    private static final String MINI_LOTTO = "http://app.lotto.pl/wyniki/?type=el";

    @Inject
    private JsoupReaderService jsoupReaderService;

    @Inject
    private DrawService service;

    @Schedule(hour = "*/7", persistent = false)
    public void run() {
        String input = jsoupReaderService.read(MINI_LOTTO);
        
        DrawELEntity entity = null;
        try {
            entity = convertToEntity(DrawELEntity.class, input);
        } catch (InstantiationException | IllegalAccessException ex) {
            LOGGER.error("Unable to convert String of MINI LOTTO into Entity: " + ex);
        }
        
        DrawELEntity result = service.findByDrawAndDrawDate(DrawELEntity.class, entity.getNumbers(), entity.getDrawDate());

        if (result != null) {
            service.save(entity);
        }
    }
}
