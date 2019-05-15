package pl.piotrowicki.lotto.job;

import java.time.LocalDate;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import pl.piotrowicki.lotto.entity.DrawEPEntity;
import pl.piotrowicki.lotto.service.DrawEPService;
import pl.piotrowicki.lotto.service.JsoupReaderService;

/**
 *
 * @author nowik
 */
@Singleton
public class ReadDrawEPJob {
    
    private static final String EKSTRA_PENSJA = "http://app.lotto.pl/wyniki/?type=ep";

    @Inject
    private JsoupReaderService jsoupReaderService;

    @Inject
    private DrawEPService service;

    @Schedule(hour = "*/7", persistent = false)
    public void run() {
        String input = jsoupReaderService.read(EKSTRA_PENSJA);

        DrawEPEntity entity = convertToEntity(input);
        
         DrawEPEntity result = service.findByDrawAndDrawDate(entity.getNumbers(), entity.getDrawDate());

        if (result != null) {
            service.save(entity);
        }    
    }
    
    public DrawEPEntity convertToEntity(String input) {
        String[] splittedDraw = input.split(" ");

        int firstSpace = input.indexOf(" ") + 1;

        DrawEPEntity entity = new DrawEPEntity();
        entity.setDrawDate(LocalDate.parse(splittedDraw[0]));
        entity.setNumbers(input.substring(firstSpace));
        return entity;
    }
}
