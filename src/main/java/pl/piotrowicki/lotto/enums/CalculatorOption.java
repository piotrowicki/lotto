package pl.piotrowicki.lotto.enums;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
public enum CalculatorOption {
    
    MODE("Most often value"),
    AVG("Average value");
    
    private final String description;

    private CalculatorOption(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
