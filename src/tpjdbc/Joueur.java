package tpjdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Joueur {
	static String server = "localhost";
	static String port = "3306";
	static String database = "tennis";
	static String user = "root";
	static String password = "";
	static String requete = "select nom, prenom from Joueur";
	static Connection connexion = null;

	/** La méthode traiteRequete */
	//public void traiteRequete() {
	public static void main(String[] args) {
		try {
				Class c = Class.forName("com.mysql.jdbc.Driver");
				Driver pilote = (Driver) c.newInstance();
				DriverManager.registerDriver(pilote);

				String url = "jdbc:mysql://" +server + ":" +port + "/"+database;
				connexion = DriverManager.getConnection(url, user, password);
				Statement lecture = connexion.createStatement();
				ResultSet resultat = lecture.executeQuery(requete);
				while (resultat.next()) {
					String tuple = resultat.getString(1) + " " +resultat.getString(2);
					System.out.println(tuple);
				}
				resultat.close();
				lecture.close();
				connexion.close();
		  }
		 catch(Exception e){e.printStackTrace(); }
	}


}
