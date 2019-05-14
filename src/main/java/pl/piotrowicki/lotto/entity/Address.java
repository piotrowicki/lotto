package pl.piotrowicki.lotto.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author piotrowicki <piotrowicki at gmail.com>
 */
@Embeddable
public class Address implements Serializable {

    private static final long serialVersionUID = 7375782521706939386L;
    
    @Column(name = "STREET")
    private String street;
    
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    
    @Column(name = "CITY")
    private String city;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
