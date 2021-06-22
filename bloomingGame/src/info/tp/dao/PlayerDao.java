package info.tp.dao;

import java.util.List;

import info.tp.model.Asset;
import info.tp.model.Bank;
import info.tp.model.Card;
import info.tp.model.Party;
import info.tp.model.PlaySpace;
import info.tp.model.Player;
import info.tp.model.Profession;

public interface PlayerDao {
	
	Player findPlayerById(String name);
	void createPlayer(Player player);

	Profession ProfessionPlayer();
	Bank bankPlayer();
	PlaySpace playSpacePlayer();
	
	void sellAsset(Player seller,Asset asset,Player buyer);
	void buyAsset(Player seller,Asset asset,Player buyer);
	
	
/*	void startParty(Party party);
	void reStartParty(Party party);
	void saveParty(Party party);
	void cancelParty(Party party);
	
	void addPlayerToParty(Player player , Party party);
	void deletePlayerToParty(Player player , Party party);
	
	void addPlayerToPlaySpace(Player player , PlaySpace playSpace);
	void deletePlayerToPlaySpace(Player player , PlaySpace playSpace);
	

	List <Card> findAllCard(int id);
	List <Party> findAllParty(int id);
	List <Asset> findAllAsset(int id);*/

}
