package info.tp.dao.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import info.tp.dao.PlaySpaceDao;

public class PlaySpaceDaoImpl implements PlaySpaceDao{
	
	private Connection getConnexion() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/bloomingGame";
		Connection connection = DriverManager.getConnection(url, "root", "");
		return connection;
	}

	@Override
	public void createPlaySpace() {
		String insertionPlaySpace = "INSERT INTO playSpace(name) VALUES ('fast Track'),('rat race');"; //VALUES (?,?);";
		Connection cx = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			cx = getConnexion();
			st =cx.prepareStatement(insertionPlaySpace);
			//st.setString(1, name);
			int inserer  = st.executeUpdate();	
			if (inserer != 0)
				System.out.println("insertionPlaySpace réussie");
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			try { if(rs != null) rs.close(); }catch( SQLException sql) {}
			try { if(st != null) st.close(); }catch( SQLException sql) {}
			try { if(cx != null) cx.close(); }catch( SQLException sql) {}
		}
	}

}
