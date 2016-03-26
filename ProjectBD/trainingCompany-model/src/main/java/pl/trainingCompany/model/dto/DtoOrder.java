package pl.trainingCompany.model.dto;

/**
 * Created by Sebastian on 2016-03-25.
 */
public class DtoOrder {

    private long id;

    private Long basketId;

    private Long offerId;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getBasketId() {
        return basketId;
    }

    public void setBasketId(Long basketId) {
        this.basketId = basketId;
    }

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }
}
