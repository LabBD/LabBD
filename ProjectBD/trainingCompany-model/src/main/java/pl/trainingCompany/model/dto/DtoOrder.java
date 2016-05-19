package pl.trainingCompany.model.dto;

import java.util.Date;

/**
 * Created by Sebastian on 2016-03-25.
 */
public class DtoOrder {

    private long id;

    private Long accountId;

    private Long offerId;

    private String offerName;

    private Double offerPrice;

    private Long offerQuantity;

    private Long amount;

    private Date datePayment;

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

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public Date getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }

    public boolean isValid() {
        return offerId != null && offerName != null && offerPrice != null && offerQuantity != null;
    }}
