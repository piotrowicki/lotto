package pl.piotrowicki.lotto.enums;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public enum StatisticOption {
    
    MODE("Most often value"),
    PERCENTAGE("Percentage value"),
    AVG("Average value");
    
    private final String description;

    private StatisticOption(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
