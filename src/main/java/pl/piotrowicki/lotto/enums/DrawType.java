package pl.piotrowicki.lotto.enums;

/**
 *
 * @author nowik
 */
public enum DrawType {
    DUZY_LOTEK("DUŻY LOTEK"),
    MINI_LOTTO("MINI LOTTO"), 
    EKSTRA_PENSJA("EKSTRA PENSJA"), 
    KASKADA("KASKADA"), 
    MULTI_MULTI  ("MULTI MULTI");
    
    private final String description;
    
    private DrawType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
