package pl.piotrowicki.lotto.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SqlResultSetMapping;
import pl.piotrowicki.lotto.dto.DrawDto;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@MappedSuperclass
@SqlResultSetMapping(
        name = "DrawDTOMapping",
        classes = @ConstructorResult(
                targetClass = DrawDto.class,
                columns = {
                    @ColumnResult(name = "id", type = Long.class),
                    @ColumnResult(name = "numbers", type = String.class),
                    @ColumnResult(name = "drawDate", type = LocalDate.class)
                }
        )
)
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -622813870278192134L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "CREATE_DATE", columnDefinition = "DATETIME")
    private LocalDateTime createDate;

    @Column(name = "UPDATE_DATE", columnDefinition = "DATETIME")
    private LocalDateTime updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    @PrePersist
    public void prePersist() {
        createDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updateDate = LocalDateTime.now();
    }
}
