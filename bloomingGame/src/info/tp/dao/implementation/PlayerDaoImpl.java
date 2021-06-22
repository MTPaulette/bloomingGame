package info.tp.dao.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import info.tp.dao.PlayerDao;
import info.tp.model.Asset;
import info.tp.model.Bank;
import info.tp.model.Card;
import info.tp.model.Party;
import info.tp.model.PlaySpace;
import info.tp.model.Player;
import info.tp.model.Profession;

public class PlayerDaoImpl implements PlayerDao{
	
	private Connection getConnexion() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/bloomingGame";
			Connection connection = DriverManager.getConnection(url, "root", "");
			return connection;
	}

	public Player findPlayerById(String name) {
		Connection cx = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Player player = null;
		try {
			cx = getConnexion();
			st =cx.prepareStatement("SELECT name FROM player WHERE name=?" );
			st.setString(1, name);
			rs = st.executeQuery();
			if(rs.next()) {
				String namePlayer = rs.getString(1);
				
				player = new Player();
				player.setName(namePlayer);
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			try { if(rs != null) rs.close(); }catch( SQLException sql) {}
			try { if(st != null) st.close(); }catch( SQLException sql) {}
			try { if(cx != null) cx.close(); }catch( SQLException sql) {}
		}
		return player;
	}

	@Override
	public void createPlayer(Player player) {
		Connection cx = null;
		PreparedStatement st = null;/*
		player.setProfession(ProfessionPlayer());
		player.setBank(bankPlayer());
		player.setPlaySpace(playSpacePlayer());*/
		try {
			cx = getConnexion();
			st = cx.prepareStatement("INSERT INTO player(name,nbChildren,profession,playSpace,bank) VALUES(?,?,?,?,?)");
			st.setString(1, player.getName());
			st.setInt(2, player.getNbChildren());
			st.setInt(3, ProfessionPlayer().getId());
			player.setProfession(ProfessionPlayer());
		
			st.setString(4, playSpacePlayer().getName());
			st.setString(5, bankPlayer().getName());
			player.setBank(bankPlayer());
			player.setPlaySpace(playSpacePlayer());
			
			st.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			//throw new RuntimeException(e);
		}finally {
			try { if(st != null) st.close(); }catch( SQLException sql) {}
			try { if(cx != null) cx.close(); }catch( SQLException sql) {}
		}
		
	}

	@Override
	public Profession ProfessionPlayer() {
		int idp = 1+(int)(Math.random()*((4-1)+1));
		Connection cx = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Profession profession = null;
		Player player = null;
		try {
			cx = getConnexion();
			st =cx.prepareStatement("SELECT * FROM profession WHERE id=?" );
			st.setInt(1, idp);
			rs = st.executeQuery();
			if(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int salary = rs.getInt(3);
				
				profession = new Profession();
				profession.setId(id);
				profession.setName(name);
				profession.setSalary(salary);
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			try { if(rs != null) rs.close(); }catch( SQLException sql) {}
			try { if(st != null) st.close(); }catch( SQLException sql) {}
			try { if(cx != null) cx.close(); }catch( SQLException sql) {}
		}

		//player.setProfession() = profession;
		return profession;	
	}

	@Override
	public Bank bankPlayer() {	
		String bankName = "bank1";
		Connection cx = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Bank bank = null;
		try {
			cx = getConnexion();
			st =cx.prepareStatement("SELECT * FROM bank WHERE name=?" );
			st.setString(1, bankName);
			rs = st.executeQuery();
			if(rs.next()) {
				String name = rs.getString(1);
				
				bank = new Bank();
				bank.setName(name);
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			try { if(rs != null) rs.close(); }catch( SQLException sql) {}
			try { if(st != null) st.close(); }catch( SQLException sql) {}
			try { if(cx != null) cx.close(); }catch( SQLException sql) {}
		}
		/*
		Bank bank = new Bank();
		bank.setName("bank1");*/
		return bank;
	}

	@Override
	public PlaySpace playSpacePlayer() {
		String space = "rat race";
		Connection cx = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		PlaySpace playSpace = null;
		try {
			cx = getConnexion();
			st =cx.prepareStatement("SELECT * FROM playSpace WHERE name=?" );
			st.setString(1, space);
			rs = st.executeQuery();
			if(rs.next()) {
				String name = rs.getString(1);
				
				playSpace = new PlaySpace();
				playSpace.setName(name);
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			try { if(rs != null) rs.close(); }catch( SQLException sql) {}
			try { if(st != null) st.close(); }catch( SQLException sql) {}
			try { if(cx != null) cx.close(); }catch( SQLException sql) {}
		}
		/*
		Bank bank = new Bank();
		bank.setName("bank1");*/
		return playSpace;
		
		/*
		PlaySpace playSpace = new PlaySpace();
		playSpace.setName("rat race");
		return playSpace;	*/
	}

	@Override
	public void sellAsset(Player seller, Asset asset, Player buyer) {
	}

	@Override
	public void buyAsset(Player seller, Asset asset, Player buyer) {
		// TODO Auto-generated method stub
		
	}

/*	@Override
	public void startParty(Party party) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reStartParty(Party party) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveParty(Party party) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelParty(Party party) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPlayerToParty(Player player, Party party) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePlayerToParty(Player player, Party party) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPlayerToPlaySpace(Player player, PlaySpace playSpace) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePlayerToPlaySpace(Player player, PlaySpace playSpace) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sellAsset(Player seller, Asset asset, Player buyer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buyAsset(Player seller, Asset asset, Player buyer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Card> findAllCard(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Party> findAllParty(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Asset> findAllAsset(int id) {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
