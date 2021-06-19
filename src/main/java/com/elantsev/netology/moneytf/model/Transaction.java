package com.elantsev.netology.moneytf.model;

import com.google.gson.Gson;

import java.util.Objects;

public class Transaction {
    private final Card cardFrom;
    private  String cardToNumber;
    private final Amount amount;

    public Transaction(String cardFromNumber,
                       String cardFromValidTill,
                       String cardFromCVV,
                       String cardToNumber,
                       Amount amount) {
        this.cardFrom = new Card(cardFromNumber,cardFromValidTill,cardFromCVV,amount);
        this.cardToNumber = cardToNumber;
        this.amount = amount;
    }

    public Card getCardFrom(){
        return this.cardFrom;
    }

    public String getCardToNumber() {
        return cardToNumber;
    }

    public Amount getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{ " +
                cardFrom.toString()+" "+
                ", cardToNumber='" + cardToNumber + '\'' +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return cardFrom.equals(that.cardFrom) &&
                cardToNumber.equals(that.cardToNumber) &&
                amount.equals(that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardFrom, cardToNumber, amount);
    }

    public String toJSON(){
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }
}
