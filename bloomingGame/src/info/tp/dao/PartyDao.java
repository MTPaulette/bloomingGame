package info.tp.dao;

import java.util.List;

import info.tp.model.Player;
import info.tp.model.Party;

public interface PartyDao {
	
	Party findPartyById(int id);
	void createParty(Party party);
	
	/*
	void startParty(Party party);
	void reStartParty(Party party);
	void saveParty(Party party);
	void cancelParty(Party party);
	*/

}
