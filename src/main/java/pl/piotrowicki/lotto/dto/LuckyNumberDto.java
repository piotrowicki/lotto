package pl.piotrowicki.lotto.dto;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public class LuckyNumberDto {

    private final LocalDate drawDate;
    private final Set<Integer> draw;

    public LuckyNumberDto(LocalDate drawDate, Set<Integer> draw) {
        this.drawDate = drawDate;
        this.draw = draw;
    }

    public LocalDate getDrawDate() {
        return drawDate;
    }

    public Set<Integer> getDraw() {
        return draw;
    }

    public String getDrawAsString() {
        return StringUtils.join(draw, " ");
    }

    @Override
    public int hashCode() {
        return Objects.hash(draw, drawDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof LuckyNumberDto)) {
            return false;
        }
        LuckyNumberDto o = (LuckyNumberDto) obj;
        return Objects.equals(draw, o.draw)
                && Objects.equals(drawDate, o.drawDate);
    }
}
