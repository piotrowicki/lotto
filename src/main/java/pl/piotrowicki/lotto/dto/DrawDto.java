package pl.piotrowicki.lotto.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public class DrawDto {
    private Long id;
    private String numbers;
    private LocalDate drawDate;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public DrawDto(Long id, String numbers, LocalDate drawDate) {
        this.id = id;
        this.numbers = numbers;
        this.drawDate = drawDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public LocalDate getDrawDate() {
        return drawDate;
    }

    public void setDrawDate(LocalDate drawDate) {
        this.drawDate = drawDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numbers, createDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DrawDto other = (DrawDto) obj;
        return Objects.equals(id, other.id)
                && Objects.equals(numbers, other.numbers)
                &&Objects.equals(drawDate, other.drawDate);
    }
}
