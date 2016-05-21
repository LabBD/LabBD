package pl.trainingCompany.model.dbo;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Kamil S on 2016-03-20.
 */
@Entity
public class Offer {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToOne
    private Company company;

    @Column(length = 1500)
    private String description;

    private Double price;

    private Long quantity;

    private Date endDate;

    @OneToMany(mappedBy = "offer")
    private List<Attachment> attachments;

    @OneToMany(mappedBy = "offer")
    private List<Order> orders;

    @OneToMany(mappedBy = "offer")
    private List<Guest> guests;

    @OneToMany(mappedBy = "offer")
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "offer_category_id")
    private OfferCategory offerCategory;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

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

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
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

    public OfferCategory getOfferCategory() {
        return offerCategory;
    }

    public void setOfferCategory(OfferCategory offerCategory) {
        this.offerCategory = offerCategory;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
