package info.tp.dao;

import java.util.List;

import info.tp.model.Asset;
import info.tp.model.Card;

public interface CardDao {
	
	Card findCardById(int id);
	void createCard(Card Card);

	List <Card> findAll();
}
