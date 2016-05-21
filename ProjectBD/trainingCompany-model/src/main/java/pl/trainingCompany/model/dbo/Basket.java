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
    @JoinColumn(name = "account_id")
    private Account account;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
