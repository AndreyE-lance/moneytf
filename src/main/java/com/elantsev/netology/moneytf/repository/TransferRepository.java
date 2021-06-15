package com.elantsev.netology.moneytf.repository;

import com.elantsev.netology.moneytf.model.Card;
import com.elantsev.netology.moneytf.model.Operation;
import com.elantsev.netology.moneytf.model.Transaction;
import com.elantsev.netology.moneytf.model.Verificator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TransferRepository {

    private final Map<String,Transaction> transactions = new HashMap<>();
    private static final Logger logger = LogManager.getLogger("transferLog");

    public String saveTransaction(Transaction transaction){
        long unixTime = System.currentTimeMillis() / 1000L;
        String time = Long.toString(unixTime);
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(time)
                .append("D")
                .append(transaction.hashCode());
        transactions.put(sBuilder.toString(),transaction);
        logger.info("ЗАПРОС НА ПЕРЕВОД "+sBuilder.toString()+" "+transaction);
        return sBuilder.toString();//тут сохраняем транзакцию и возвращаем уникальный номер
    }

    public Operation confirmOperation(Verificator verificator){
        logger.info("Перевод подтвержден " + verificator.toString());
        return new Operation(verificator.getOperationId());
    }
}
