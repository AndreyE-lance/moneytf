package com.elantsev.netology.moneytf.controller;

import com.elantsev.netology.moneytf.exceptions.ErrorInputData;
import com.elantsev.netology.moneytf.exceptions.ErrorTransfer;
import com.elantsev.netology.moneytf.model.Operation;
import com.elantsev.netology.moneytf.model.Transaction;
import com.elantsev.netology.moneytf.model.Verificator;
import com.elantsev.netology.moneytf.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransferController {

    private final TransferService trService;

    @Autowired
    public TransferController(TransferService trService) {
        this.trService = trService;
    }

    @PostMapping("/transfer")
    public Operation transfer(@RequestBody Transaction transaction) {
        return trService.transfer(transaction);
    }

    @PostMapping("/confirmOperation")
    public Operation confirm(@RequestBody Verificator verificator) {
        return trService.confirmOperation(verificator);
    }

    @ExceptionHandler(ErrorTransfer.class)
    public ResponseEntity<String> errorTransferHndl(ErrorTransfer ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ErrorInputData.class)
    public ResponseEntity<String> errorInputDataHndl(ErrorInputData ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
