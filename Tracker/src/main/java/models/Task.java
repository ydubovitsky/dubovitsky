package models;

public class Task extends Item {
	public Task(String name, String description) {
		this.name = name;
		this.description = description;
	}
	public String showMustGoOn() {
		return "showMustGoOn!!!";
	}
}