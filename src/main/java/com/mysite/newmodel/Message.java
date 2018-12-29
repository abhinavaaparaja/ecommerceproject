package com.mysite.newmodel;

public class Message {
	private String messageType,messageBody;
	public Message() {
		messageType="INF";
		messageBody="NA";
		
	}
	public Message(String mt,String mb) {
		messageType=mt;
		messageBody=mb;
	}
	public String getMessageType() {
		return messageType;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	
}
