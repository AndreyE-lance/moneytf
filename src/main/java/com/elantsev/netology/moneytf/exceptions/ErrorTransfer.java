package com.elantsev.netology.moneytf.exceptions;

public class ErrorTransfer extends RuntimeException{
    public ErrorTransfer(){
        super("Transfer error.");
    }
}
