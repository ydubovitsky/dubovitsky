package start;

import models.*;

public class Tracker {
	
	Item[] item = new Item[3];
	
	public static void main(String[] args) {
		Tracker tracker = new Tracker();
		tracker.item[0] = new Item("name", "description", 0l);
		tracker.item[1] = new Task("name", "description");
		tracker.item[2] = new Bug();
		Item item = new Item("name", "description", 0l);
		System.out.println(item.getName() + " " + item.getDescription() + " ");
		Task task = new Task("name", "description");
		System.out.println(item.getName() + " " + item.getDescription() + " ");
		for(Item show : tracker.item) {
			if(show instanceof Task) {
				System.out.println(((Task) show).showMustGoOn());
			}
			System.out.println(show.getName());
		}
	}
}