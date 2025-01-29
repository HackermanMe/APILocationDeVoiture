package com.kb.location.utils;

import java.util.Date;

public class GlobalResponse<T> {
    private Date timestamp;
    private boolean isError;
    private String message;
    private T details;

    public GlobalResponse(Date timestamp, boolean isError, String message, T details) {
        this.timestamp = timestamp;
        this.isError = isError;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean error) {
        isError = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDetails() {
        return details;
    }

    public void setDetails(T details) {
        this.details = details;
    }
}