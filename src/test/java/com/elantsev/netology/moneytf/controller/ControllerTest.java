package com.elantsev.netology.moneytf.controller;

import com.elantsev.netology.moneytf.model.Amount;
import com.elantsev.netology.moneytf.model.Transaction;
import com.elantsev.netology.moneytf.service.TransferService;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TransferController.class)
public class ControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    TransferService transferService;

    @Test
    public void transferTest() throws Exception {
        Amount amountTest = new Amount(10000, "RUR");
        Transaction transactionTest = new Transaction("1234123412341234", "12/21","111","4321432143214321",amountTest);
        mockMvc.perform(post("/transfer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(transactionTest.toJSON()))
                .andExpect(status().isOk());
    }
}
