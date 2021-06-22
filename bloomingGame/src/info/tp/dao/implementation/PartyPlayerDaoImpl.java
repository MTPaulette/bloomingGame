package info.tp.dao.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import info.tp.dao.PartyPlayerDao;
import info.tp.model.Party;
import info.tp.model.Player;

public class PartyPlayerDaoImpl implements PartyPlayerDao{

	private Connection getConnexion() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/bloomingGame";
			Connection connection = DriverManager.getConnection(url, "root", "");
			return connection;
	}
	
	@Override
	public List <String> findPlayerOfParty(String party) {
		Connection cx = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List <String> players = new ArrayList<String>();
		try {
			cx = getConnexion();
			st =cx.prepareStatement("SELECT name FROM party , party_player WHERE name = ?" );
			st.setString(1, party);
			rs = st.executeQuery();
			if(rs.next()) {
				String namePlayer = rs.getString(1);
				players.add(namePlayer);
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			try { if(rs != null) rs.close(); }catch( SQLException sql) {}
			try { if(st != null) st.close(); }catch( SQLException sql) {}
			try { if(cx != null) cx.close(); }catch( SQLException sql) {}
		}
		return players;
	}

	@Override
	public void createPartyPlayer(int id, Party party, Player player) {
		Connection cx = null;
		PreparedStatement st = null;
		try {
			cx = getConnexion();
			st = cx.prepareStatement("INSERT INTO party_player(id,party,player) VALUES(?,?,?)");
			st.setInt(1, id);
			st.setString(2, party.getName());
			st.setString(3, player.getName());
			
			st.executeUpdate();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			try { if(st != null) st.close(); }catch( SQLException sql) {}
			try { if(cx != null) cx.close(); }catch( SQLException sql) {}
		}
	}
	
	
}
