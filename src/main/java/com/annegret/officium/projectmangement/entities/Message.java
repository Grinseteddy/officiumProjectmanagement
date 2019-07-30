package com.annegret.officium.projectmangement.entities;


public class Message {

    public enum severity {
        SUCCESS,
        WARNING,
        ERROR,
        CRITICALERROR
    }

    private String code;

    private severity severity;

    private String message;

    private String trackingId;

    public Message() {

    }

    public Message(String code, Message.severity severity, String message, String trackingId) {
        this.code=code;
        this.severity=severity;
        this.message=message;
        this.trackingId=trackingId;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code=code;
    }

    public Message.severity getSeverity() {
        return severity;
    }

    public void setSeverity(Message.severity severity) {
        this.severity = severity;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }
}
