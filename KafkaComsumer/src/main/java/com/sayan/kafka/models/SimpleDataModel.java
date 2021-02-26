package com.sayan.kafka.models;

public class SimpleDataModel {

	String source;
	String userName;
	String data;
	String remarks;
	public SimpleDataModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SimpleDataModel(String source, String userName, String data, String remarks) {
		super();
		this.source = source;
		this.userName = userName;
		this.data = data;
		this.remarks = remarks;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "SimpleDataModel [source=" + source + ", userName=" + userName + ", data=" + data + ", remarks="
				+ remarks + "]";
	}
}
