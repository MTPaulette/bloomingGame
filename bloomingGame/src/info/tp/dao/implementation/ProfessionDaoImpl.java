package info.tp.dao.implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import info.tp.dao.ProfessionDao;
import info.tp.model.Player;
import info.tp.model.Profession;

public class ProfessionDaoImpl implements ProfessionDao{
	
	private Connection getConnexion() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost/bloomingGame";
		Connection connection = DriverManager.getConnection(url, "root", "");
		return connection;
	}


	@Override
	public void createProfession() {	
		String insertion = "INSERT INTO profession(id , name , salary) VALUES (1,'enseignant',100000),(2,'medecin',155000),(3,'architecte',200000),(4,'caissiere',50000);"; //VALUES (?,?);";
		Connection cx = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			cx = getConnexion();
			st =cx.prepareStatement(insertion);
			//st.setString(1, name);
			int inserer  = st.executeUpdate();	
			if (inserer != 0)
				System.out.println("insertion réussie");
		}catch(Exception e) {
			throw new RuntimeException(e);
		}finally {
			try { if(rs != null) rs.close(); }catch( SQLException sql) {}
			try { if(st != null) st.close(); }catch( SQLException sql) {}
			try { if(cx != null) cx.close(); }catch( SQLException sql) {}
		}
	}
	
/*
	@Override
	public Profession findById(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> findAllPlayer(String name) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
