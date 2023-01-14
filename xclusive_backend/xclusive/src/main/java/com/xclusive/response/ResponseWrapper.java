package com.xclusive.response;

public class ResponseWrapper<T> {
	
	private T output;
	private String status;
	private String description;
	
	public ResponseWrapper() {
	
	}

	public ResponseWrapper(T output, String status, String description) {
		this.output = output;
		this.status = status;
		this.description = description;
	}

	public T getOutput() {
		return output;
	}

	public void setOutput(T output) {
		this.output = output;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
