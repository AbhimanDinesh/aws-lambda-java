package org.dinesh.workspace.aws.lambda.model;

public class User {

	private String name;
	private String title;
	private String department;

	public User() {
	}

	public User(String name, String title, String department) {
		this.name = name;
		this.title = title;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", title=" + title + ", department=" + department + "]";
	}

}
