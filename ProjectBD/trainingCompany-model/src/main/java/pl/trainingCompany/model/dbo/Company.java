package pl.trainingCompany.model.dbo;

import javax.persistence.*;

/**
 * Created by Mateusz on 2016-03-24.
 */
@Entity
public class Company {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    private String companyName;
    private String description;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
