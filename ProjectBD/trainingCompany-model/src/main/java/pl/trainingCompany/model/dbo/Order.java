package pl.trainingCompany.model.dbo;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Sebastian on 2016-03-25.
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    private Long amount;

    private Date datePayment;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Date getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }
}
