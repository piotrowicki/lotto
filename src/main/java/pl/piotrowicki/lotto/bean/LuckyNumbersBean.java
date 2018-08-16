package pl.piotrowicki.lotto.bean;

import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pl.piotrowicki.lotto.dao.DrawDao;
import pl.piotrowicki.lotto.dto.LuckyNumberDto;
import pl.piotrowicki.lotto.dto.LuckyNumbersResultDto;
import pl.piotrowicki.lotto.entity.DrawEntity;
import pl.piotrowicki.lotto.util.DrawConverterUtil;

/**
 *
 * @author Nowik
 */
@Named
@RequestScoped
public class LuckyNumbersBean implements Serializable {

    private List<Integer> luckyNumbers;
    private LuckyNumbersResultDto result;

    @Inject
    private DrawDao drawDao;

    public void calculateStatistic() {
        List<DrawEntity> entites = drawDao.findAll();

        List<LuckyNumberDto> luckyNumbersDto = DrawConverterUtil.convertToLuckyNumberDto(entites);
        Set<Set<Integer>> userPowerSet = Sets.powerSet(Sets.newHashSet(luckyNumbers)).stream().filter(p -> p.size() > 2).collect(Collectors.toSet());

        result = new LuckyNumbersResultDto();
        for (LuckyNumberDto luckyNumberDto : luckyNumbersDto) {
            for (Set<Integer> set : userPowerSet) {
                if (luckyNumberDto.getDraw().containsAll(set)) {
                    result.addEntry(set, luckyNumberDto);
                }
            }
        }
    }

    public List<Integer> getLuckyNumbers() {
        return luckyNumbers;
    }

    public void setLuckyNumbers(List<Integer> luckyNumbers) {
        this.luckyNumbers = luckyNumbers;
    }

    public LuckyNumbersResultDto getResult() {
        return result;
    }

    public void setResult(LuckyNumbersResultDto result) {
        this.result = result;
    }
}
