package com.elantsev.netology.moneytf.model;

import java.util.Objects;

public class Card {
    private String cardNumber;
    private String expirDate;
    private String cardCvv;
    private Amount amount;


    public Card(String cardNumber, String expirDate, String cardCvv, Amount amount) {
        this.cardNumber = cardNumber;
        this.expirDate = expirDate;
        this.cardCvv = cardCvv;
        this.amount = amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExpirDate(String expirDate) {
        this.expirDate = expirDate;
    }

    public void setCardCvv(String cardCvv) {
        this.cardCvv = cardCvv;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + cardNumber + '\'' +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return Objects.equals(cardNumber, card.cardNumber) &&
                Objects.equals(expirDate, card.expirDate) &&
                Objects.equals(cardCvv, card.cardCvv) &&
                Objects.equals(amount, card.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, expirDate, cardCvv, amount);
    }
}
