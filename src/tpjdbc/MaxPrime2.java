package tpjdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MaxPrime2 {
	static String server = "localhost";
	static String port = "3306";
	static String database = "tennis";
	static String user = "root";
	static String password = "";

	static Connection connexion = null;

	/** La méthode traiteRequete */
	//public void traiteRequete() {
	public static void main(String[] args) {
		try {
				Class c = Class.forName("com.mysql.jdbc.Driver");
				Driver pilote = (Driver) c.newInstance();
				DriverManager.registerDriver(pilote);
                                Scanner annee= new Scanner(System.in);
                                
                                
                                
				String url = "jdbc:mysql://" +server + ":" +port + "/"+database;
				connexion = DriverManager.getConnection(url, user, password);
				Statement lecture = connexion.createStatement();
	                        
                                do{
                                    
                                System.out.println("Entrez l'annee"); 
                                int an= annee.nextLine();
                                String requete = "select max(PRIME) from gain where ANNEE="+an;
                                ResultSet resultat = lecture.executeQuery(requete);		
				                               
                                while (resultat.next()) {
	
                                    String tuple = "maxPrime="+ resultat.getString("max(PRIME)");
					System.out.println(tuple);
				
                                }
                                }while(an=);
                                resultat.close();
				lecture.close();
				connexion.close();
		  }
		 catch(Exception e){e.printStackTrace(); }
	}


}
