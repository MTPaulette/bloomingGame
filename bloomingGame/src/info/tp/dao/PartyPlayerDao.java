package info.tp.dao;

import java.util.List;

import info.tp.model.Party;
import info.tp.model.Player;

public interface PartyPlayerDao {
	
	List <String> findPlayerOfParty(String party);
	void createPartyPlayer(int id, Party party, Player player);

}
