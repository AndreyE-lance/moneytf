package com.elantsev.netology.moneytf.model;

public class Verificator {
    private final String operationId;
    private final String code;

    public Verificator(String operationId, String code) {
        this.operationId = operationId;
        this.code = code;
    }

    public String getOperationId() {
        return operationId;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Verificator{" +
                "operationId='" + operationId + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
