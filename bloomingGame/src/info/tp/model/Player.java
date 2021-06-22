package info.tp.model;

import java.util.List;

public class Player {
	private String name;
	private int nbChildren;
	private Profession profession;
	private PlaySpace playSpace;
	private Bank bank;
	
	//private List <Party> party;
	private List <Card> card;
	private List <Asset> asset;
	/*
	public List <Party> getParty() {
		return party;
	}
	public void setParty(List <Party> party) {
		this.party = party;
	}*/
	public List <Card> getCard() {
		return card;
	}
	public void setCard(List <Card> card) {
		this.card = card;
	}
	public List <Asset> getAsset() {
		return asset;
	}
	public void setAsset(List <Asset> asset) {
		this.asset = asset;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNbChildren() {
		return nbChildren;
	}
	public void setNbChildren(int nbChildren) {
		this.nbChildren = nbChildren;
	}
	public Profession getProfession() {
		return profession;
	}
	public void setProfession(Profession profession) {
		this.profession = profession;
	}
	public PlaySpace getPlaySpace() {
		return playSpace;
	}
	public void setPlaySpace(PlaySpace playSpace) {
		this.playSpace = playSpace;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}

}
