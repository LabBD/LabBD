package pl.trainingCompany.model.dto;


import pl.trainingCompany.model.dbo.OfferCategory;

import java.util.Date;
import java.util.List;

/**
 * Created by Kamil S on 2016-03-20.
 */
public class DtoOffer {

    private long id;

    private String name;

    private String description;

    private Double price;

    private Long quantity;

    private Date endDate;

    private String offerCategoryName;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getOfferCategoryName() {
        return offerCategoryName;
    }

    public void setOfferCategoryName(String offerCategoryName) {
        this.offerCategoryName = offerCategoryName;
    }
}
