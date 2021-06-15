package com.elantsev.netology.moneytf.repository;

import com.elantsev.netology.moneytf.model.Amount;
import com.elantsev.netology.moneytf.model.Operation;
import com.elantsev.netology.moneytf.model.Transaction;
import com.elantsev.netology.moneytf.model.Verificator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RepoTest {
    private Amount amount = new Amount(1000,"RUR");
    private Transaction transaction = new Transaction("1234123412341243","12/21","123","4321432143214321",amount);
    private Verificator verificator = new Verificator("12341234231D32244","0000");
    private Operation operation = new Operation(verificator.getOperationId());
    private TransferRepository trRepository = new TransferRepository();
    @Test
    public void saveTransactionTest(){
        long unixTime = System.currentTimeMillis() / 1000L;
        String time = Long.toString(unixTime);
        String result = trRepository.saveTransaction(transaction);
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(time)
                .append("D")
                .append(transaction.hashCode());
        assertTrue(result.equals(sBuilder.toString()));
    }

    @Test
    public void confirmOperationTest(){
        Operation testOperation = trRepository.confirmOperation(verificator);
        assertSame(operation.getOperationId(),testOperation.getOperationId());
    }

    @Test
    public void confirmOperationTestWithMock(){
        Operation mockOperation = mock(Operation.class);
        when(mockOperation.getOperationId()).thenReturn("12341234231D32244");
        String result = mockOperation.getOperationId();
        assertEquals(result,trRepository.confirmOperation(verificator).getOperationId());
    }
}
