package info.tp.model;

import java.util.List;

public class PlaySpace {
	private String name;
	public List <Player> player;
	public List <Card> card;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
