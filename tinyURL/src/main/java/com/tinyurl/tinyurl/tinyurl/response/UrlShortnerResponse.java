package com.tinyurl.tinyurl.tinyurl.response;

public class UrlShortnerResponse {

    public String encodedResult;
    public boolean isSuccess = false;

    public String getEncodedResult() {
        return encodedResult;
    }

    public void setEncodedResult(String encodedResult) {
        this.encodedResult = encodedResult;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

}
