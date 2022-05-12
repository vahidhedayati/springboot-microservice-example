package com.vh.test.microservice.util;

import java.util.Map;

public class ResponseTransfer {
    private String text;
    Map<String, Object> response;

    public ResponseTransfer() {

    }
    public ResponseTransfer(String text) {
        this.text = text;

    }
    public ResponseTransfer(String text, Map<String, Object> response) {
        this.text = text;
        this.response=response;
    }
    public ResponseTransfer(Map<String, Object> response) {
        this.response=response;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<String, Object> getResponse() {
        return response;
    }

    public void setResponse(Map<String, Object> response) {
        this.response = response;
    }
}
