package com.elantsev.netology.moneytf.service;

import com.elantsev.netology.moneytf.model.Operation;
import com.elantsev.netology.moneytf.model.Transaction;
import com.elantsev.netology.moneytf.model.Verificator;
import com.elantsev.netology.moneytf.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransferService {
    @Autowired
    TransferRepository trRepository;

    public Operation transfer(Transaction transaction){
        return new Operation(trRepository.saveTransaction(transaction));
    }

    public Operation confirmOperation(Verificator verificator){
        return trRepository.confirmOperation(verificator);
    }
}
