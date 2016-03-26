package pl.trainingCompany.model.dbo;



import javax.persistence.*;
import java.util.List;

/**
 * Created by Sebastian on 2016-03-25.
 */
@Entity
public class Basket {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "basket")
    private List<Order> orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
