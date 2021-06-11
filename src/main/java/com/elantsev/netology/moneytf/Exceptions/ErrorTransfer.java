package com.elantsev.netology.moneytf.Exceptions;

public class ErrorTransfer extends RuntimeException{
    public ErrorTransfer(){
        super("Transfer error.");
    }
}
