package com.genesisresources.GenesisResourcesRegistry.dto;

public class ErrorResponse {

    private String description;
    private int httpCode;

    public ErrorResponse(String description, int httpCode)  {
        this.description = description;
        this.httpCode = httpCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }
}
