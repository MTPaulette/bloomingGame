package info.tp.model;

import java.util.List;

public class Party {
	private String name;
	private int time; //en minutes
	
	//public List <Player> player;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getTime() {
		return this.time;	
	}
	
	public void setTime(int time) {
		if (time > 120 || time < 0) {
			System.out.println("une party ne doit pas depasser 2heures");
		}
		else {
			this.time = time;		
		}	
	}

}
