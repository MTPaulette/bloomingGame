package info.tp.model;

import info.tp.dao.implementation.BankDaoImpl;
import info.tp.dao.implementation.PartyDaoImpl;
import info.tp.dao.implementation.PartyPlayerDaoImpl;
import info.tp.dao.implementation.PlaySpaceDaoImpl;
import info.tp.dao.implementation.PlayerDaoImpl;
import info.tp.dao.implementation.ProfessionDaoImpl;

public class MainClass {

	public static void main(String[] args) {
		int id = 2;
		/*
		ProfessionDaoImpl profession = new ProfessionDaoImpl();
		profession.createProfession();
		

		BankDaoImpl bank = new BankDaoImpl();
		bank.createBank();

		PlaySpaceDaoImpl place = new PlaySpaceDaoImpl();
		place.createPlaySpace();*/
		
		Player p = new Player();
		p.setName("bombo00");
		p.setNbChildren(15);
		
		PlayerDaoImpl pi = new PlayerDaoImpl();
		pi.createPlayer(p);
		
		Party party = new Party();
		party.setName("part400");
		party.setTime(50);
		
		PartyDaoImpl partyImp = new PartyDaoImpl();
		partyImp.createParty(party);
		
		PartyPlayerDaoImpl partyPlayerDaoImpl = new PartyPlayerDaoImpl();
		partyPlayerDaoImpl.createPartyPlayer(id, party, p);
		
		id++;
		
	/*	
		System.out.println("");
		System.out.println(p.getName());
		System.out.println(p.getNbChildren());
		System.out.println(p.getPlaySpace().getName());
		System.out.println(p.getBank().getName());
		System.out.println(p.getProfession().getName());
		*/
	}

}
