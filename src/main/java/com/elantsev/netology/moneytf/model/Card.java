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
}
