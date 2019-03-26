package pl.piotrowicki.lotto.dto;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public class LuckyNumbersResultDto {

    private final Set<LuckyNumberDto> threeHit = new HashSet<>();
    private final Set<LuckyNumberDto> fourHit = new HashSet<>();
    private final Set<LuckyNumberDto> fiveHit = new HashSet<>();
    private final Set<LuckyNumberDto> sixHit = new HashSet<>();

    public void addEntry(Set<Integer> set, LuckyNumberDto luckyNumberDto) {
        switch (set.size()) {
            case 3:
                threeHit.add(luckyNumberDto);
                break;
            case 4:
                fourHit.add(luckyNumberDto);
                break;
            case 5:
                fiveHit.add(luckyNumberDto);
                break;
            case 6:
                sixHit.add(luckyNumberDto);
                break;
            default:
                break;
        }
    }

    public Set<LuckyNumberDto> getThreeHit() {
        return threeHit;
    }

    public Set<LuckyNumberDto> getFourHit() {
        return fourHit;
    }

    public Set<LuckyNumberDto> getFiveHit() {
        return fiveHit;
    }

    public Set<LuckyNumberDto> getSixHit() {
        return sixHit;
    }
}
