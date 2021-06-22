package info.tp.dao.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import info.tp.dao.PartyDao;
import info.tp.model.Party;
import info.tp.model.Player;

public class PartyDaoImpl implements PartyDao{
	
	private Connection getConnexion() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/bloomingGame";
			Connection connection = DriverManager.getConnection(url, "root", "");
			return connection;
	}

	@Override
	public Party findPartyById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createParty(Party party) {
		Connection cx = null;
		PreparedStatement st = null;
		try {
			cx = getConnexion();
			st = cx.prepareStatement("INSERT INTO party(name,time) VALUES(?,?)");
			st.setString(1, party.getName());
			if (party.getTime() <= 0)
				System.out.println("Definir la durée d'une party. Elle ne doit pas depasser 2heures");
			else {
				st.setInt(2, party.getTime());
				st.executeUpdate();
				System.out.println("creation partie reussie");
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			try { if(st != null) st.close(); }catch( SQLException sql) {}
			try { if(cx != null) cx.close(); }catch( SQLException sql) {}
		}
	}

}
