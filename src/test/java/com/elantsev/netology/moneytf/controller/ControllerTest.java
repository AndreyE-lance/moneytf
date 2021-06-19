package com.elantsev.netology.moneytf.controller;

import com.elantsev.netology.moneytf.model.Amount;
import com.elantsev.netology.moneytf.model.Transaction;
import com.elantsev.netology.moneytf.service.TransferService;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;

/*В тесте на контроллер можно также добавить verify на мок сервиса,
        что у него был вызван нужный метод с правильными аргументами*/
@RunWith(SpringRunner.class)
@WebMvcTest(TransferController.class)
class ControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    TransferService transferService;

    @Test
    public void transferTest() throws Exception {
        Amount amountTest = new Amount(10000, "RUR");
        Transaction transactionTest = new Transaction("1234123412341234", "12/21", "111", "4321432143214321", amountTest);
        mockMvc.perform(post("/transfer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(transactionTest.toJSON()))
                .andExpect(status().isOk());
                //.andExpect(jsonPath("$.operationID", is(getUC(transactionTest))));
        ArgumentCaptor<Transaction> argumentCaptor = ArgumentCaptor.forClass(Transaction.class);
        verify(transferService).transfer(argumentCaptor.capture());//<- с каптором заработало!
    }

    public String getUC(Transaction tTest) {
        long unixTime = System.currentTimeMillis() / 1000L;
        String time = Long.toString(unixTime);
        StringBuilder stringBuilder = new StringBuilder(time)
                .append("D")
                .append(tTest.hashCode());
        return stringBuilder.toString();
    }

    public Transaction fromJson(String jsonObj){
        Gson gson = new Gson();
        Transaction transaction = gson.fromJson(jsonObj, Transaction.class);
        return transaction;
    }
}
