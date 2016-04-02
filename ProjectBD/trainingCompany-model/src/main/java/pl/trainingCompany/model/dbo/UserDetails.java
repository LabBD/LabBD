package pl.trainingCompany.model.dbo;

import javax.persistence.*;

/**
 * Created by Daniel Palonek on 2016-04-02.
 */
@Entity
public class UserDetails {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String surname;
    private String city;
    private String address;
    private String phone;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Account getAccount() {
        return account;
    }
}
