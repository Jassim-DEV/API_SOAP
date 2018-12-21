package org.upec.andric.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/all")
public class ManagementdB 
{
	String url = "jdbc:mysql://localhost:3306/bank";
    String user = "root";
    String passwd = "mysql";
    

    // Methode permettant de récuperer la liste de toutes les personnes
    // dans la base de donnée à traver la methode GET
    
    @GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getRandom() {

		String s = "salut andric, voici la liste des personne ayant un compte.";
		return s;
	}
    
   
    
    // Insertion dans la base de donnée
    
	public int ajouterPersonne(int numID, String prenom, String nom, String datenaissance, int numeroCompte)
	{
		String requete = "insert into personne(numID, Prenom, Nom, dateNaissance) VALUES('"+numID+"','"+prenom+"','"+nom+"','"+datenaissance+"','"+numeroCompte+"');";
		if (update(requete)==-1)
			return -1;
		else 
			return 0;
	}

	public int ajouterCompteCheque(int ColonnenNumero,int ColonnenProprietaire,float ColonnenSold, float decouvertAuth, int ColonnenumCarte, float taux)
	{
		String requete = "insert into compte (nNumero, nProprietaire, nSold, taux, decouvertAuth, numCarte ) VALUES("+ColonnenNumero+","+ColonnenProprietaire+"',"+ColonnenSold+","+taux+","+decouvertAuth+","+ColonnenumCarte+");";
		if (update(requete)==-1)
			return -1;
		else 
//		{
//			//requete = "update personne set nbcompte = nbcompte + 1 where id ="+ColonnenProprietaire+";";
//			update(requete);
			return 0;
//		}
	}
	
	public int ajouterCompteEpargne(int numero,
									int proprietaire_id,
									float solde, 
									float taux)
	{
		String requete = "insert into compte VALUES("+numero+","+proprietaire_id+",'Compte Epargne',"+solde+","+taux+",NULL,NULL);";
		envoieRequete(requete);
		requete = "update personne set nbcompte = nbcompte + 1  where id ="+proprietaire_id+";";
		envoieRequete(requete);
		return 0;
	}
	
	public int ajouterCredit(int anumCredit,int numCompte, double mensualite,double asommes,double ataux, int adureeEnMois, double sommesRestante)
	{
		String req = "INSERT INTO credit values ("
			  + ""+anumCredit        +","
				  +numCompte        +","
				  +asommes           +","
				  +ataux             +","
				  +adureeEnMois      +","
				  +mensualite+","   +sommesRestante+")  ;";
		System.out.println(req);
		update(req);
		return 0;
	}        

	
	
	// Extraction des information de la base de données.

	int comptePersonne(int id_p)
	{
		String requete = "SELECT compte.* FROM personne, compte WHERE compte.persoid=personne.id AND personne.id="+id_p+";";
		envoieRequete(requete);
		return 0;
	}

	int creditCompte(int id_c)
	{
		String requete = "SELECT credit.* FROM credit, compte WHERE credit.comptenum=compte.num AND credit.comptenum="+id_c+";";
		envoieRequete(requete);
		return 0;
	}
	
	int envoieRequete(String r)
	{
	    try 
	    {
		      Class.forName("com.mysql.jdbc.Driver");
		      Connection conn = DriverManager.getConnection(this.url, this.user, this.passwd);
		      System.out.println("Driver O.K.");
		      Statement state = conn.createStatement();
		      //L'objet ResultSet contient le résultat de la requête SQL
		      int res = state.executeUpdate(r);
		      //ResultSetMetaData data = res.getMetaData();
		      
		      
		      /*System.out.println("\n");
		      //On affiche le nom des colonnes
		      for(int i = 1; i <= data.getColumnCount(); i++)
		        System.out.print("\t\t" + data.getColumnName(i).toUpperCase() + "\t\t*");
		         
		      System.out.println("\n");
		         
	          while(res.next())
	          {         
	              for(int i = 1; i <= data.getColumnCount(); i++)
	              {
	            	  if (res.getObject(i)==null)
	            	  {
	            		  System.out.println("\t\tnull\t\t|");
	            		  continue;
	            	  }
	            	  System.out.print("\t\t" + res.getObject(i).toString() + "\t\t |");
	              }
	                
	                  
	              System.out.println("\n");
	          }*/
		      return 0;
	    }
	    catch (Exception e) 
	   	{
	    	e.printStackTrace();
	    	return -1;
    	} 
	}
	
	int update(String r)
	{
	    try 
	    {
		      Class.forName("com.mysql.jdbc.Driver"); 
		      Connection conn = DriverManager.getConnection(this.url, this.user, this.passwd);
		      System.out.println("Driver O.K.");
		      Statement state = conn.createStatement();
		      int res = state.executeUpdate(r);
		      return 0;
	    }
	    catch (Exception e) 
	   	{
	    	e.printStackTrace();
	    	return -1;
    	} 
}
}

	
