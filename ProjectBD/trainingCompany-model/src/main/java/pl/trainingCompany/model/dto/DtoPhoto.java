package pl.trainingCompany.model.dto;

import pl.trainingCompany.model.dbo.Offer;


/**
 * Created by Kamil S on 2016-03-20.
 */
public class DtoPhoto {

    private long id;

    private String name;

    private String offerName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }
}
