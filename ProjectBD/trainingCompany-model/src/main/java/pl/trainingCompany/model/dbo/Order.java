package pl.trainingCompany.model.dbo;

import javax.persistence.*;

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
}
