package com.wemakeprice.dto.printstatus;

public enum PrintStatus {
    TEXT("TEXT"), REMOVE("REMOVE");

    private final String status;

    PrintStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }


}
