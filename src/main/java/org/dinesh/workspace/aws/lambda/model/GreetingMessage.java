package org.dinesh.workspace.aws.lambda.model;

public class GreetingMessage {

	private String message;

	public GreetingMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
