package com.mdo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transaction_id")
    private int transactionId;

    @Column(name = "from_id_account")
    private int fromIdAccount;

    @Column(name = "to_id_account")
    private int toIdAccount;

    @Column(name = "amount")
    private int amount;

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getFromIdAccount() {
        return fromIdAccount;
    }

    public void setFromIdAccount(int fromIdAccount) {
        this.fromIdAccount = fromIdAccount;
    }

    public int getToIdAccount() {
        return toIdAccount;
    }

    public void setToIdAccount(int toIdAccount) {
        this.toIdAccount = toIdAccount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return transactionId == that.transactionId &&
                fromIdAccount == that.fromIdAccount &&
                toIdAccount == that.toIdAccount &&
                amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, fromIdAccount, toIdAccount, amount);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", fromIdAccount=" + fromIdAccount +
                ", toIdAccount=" + toIdAccount +
                ", amount=" + amount +
                '}';
    }
}
