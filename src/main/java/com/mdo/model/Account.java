package com.mdo.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int accountId;

    @Column(name = "client_id")
    private int clientId;

    @Column(name = "money_amount")
    private String moneyAmount;

    @JoinColumn(name = "client_id", referencedColumnName = "client_id", insertable = false, updatable = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Client client;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accuntId) {
        this.accountId = accuntId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(String moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return accountId == account.accountId &&
                clientId == account.clientId &&
                moneyAmount.equals(account.moneyAmount) &&
                client.equals(account.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, clientId, moneyAmount, client);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accuntId=" + accountId +
                ", clientId=" + clientId +
                ", moneyAmount='" + moneyAmount + '\'' +
                ", client=" + client +
                '}';
    }
}
