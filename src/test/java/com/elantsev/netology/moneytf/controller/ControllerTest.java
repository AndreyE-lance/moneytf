package com.elantsev.netology.moneytf.controller;

import com.elantsev.netology.moneytf.model.Amount;
import com.elantsev.netology.moneytf.model.Operation;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
        when(transferService.transfer(any())).thenReturn(new Operation("123"));//<- с any() заработало! Нельзя просто так взять и подсунуть transactionTest
        mockMvc.perform(post("/transfer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(transactionTest.toJSON()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.operationId", is("123")));
        ArgumentCaptor<Transaction> argumentCaptor = ArgumentCaptor.forClass(Transaction.class);
        verify(transferService).transfer(argumentCaptor.capture());//<- с каптором заработало! Нельзя просто так взять и подсунуть transactionTest
        //Почему никто не любит transactionTest?
    }

}
