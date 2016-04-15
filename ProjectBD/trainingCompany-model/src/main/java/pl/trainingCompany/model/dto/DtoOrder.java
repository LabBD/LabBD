package pl.trainingCompany.model.dto;

/**
 * Created by Sebastian on 2016-03-25.
 */
public class DtoOrder {

    private long id;

    private Long basketId;

    private Long offerId;

    private String offerDescription;

    private Double offerPrice;

    private Long offerQuantity;

    private Long amount;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getOfferQuantity() {
        return offerQuantity;
    }

    public void setOfferQuantity(Long offerQuantity) {
        this.offerQuantity = offerQuantity;
    }

    public Double getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(Double offerPrice) {
        this.offerPrice = offerPrice;
    }

    public String getOfferDescription() {
        return offerDescription;
    }

    public void setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
    }

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
