package org.upec.andric.test;
import java.util.ArrayList;

public class Personne
{
	 String firstName;
	 String lastName;
	 String dateNaissance;
	 ArrayList<Compte> listCompte;
	 String res;
	
	public Personne(String dateN,String Prenom,String Nom)
	{
		this.dateNaissance=dateN;
		this.firstName=Prenom;
		this.lastName=Nom;
		this.listCompte = new ArrayList<Compte>();
		System.out.println("Date de naissance: "+ dateN +" " +" Prenom : "+ Prenom + " " +" Nom :"+" " +Nom);	
	}

	
	public Personne getPersonne(Personne p)
	{
		Personne p1 = new Personne(p.dateNaissance,p.firstName, p.lastName);
		
		return p1;
			
	}
	
	public void addCompte(Compte c)
	{
		listCompte.add(c);
		System.out.printf("Le compte %s � �t� ajout�\n", c.compteNumero);
	}
	
	
	public void removeCompte(int num)
	{
		int j = 0;
		
		while (listCompte.size() > j) 
		{
			System.out.println(listCompte.get(j));
			
			if(listCompte.get(j).compteNumero == num)
			{
				listCompte.remove(j);
				System.out.printf("Le compte Numero %s � �t� supprim�\n",num);
				break;	
			}
			j++;
		}
	}
	
	
//	public String getNom() {
//		return lastName;
//	}
//
//	public void setNom(String nom) {
//		this.lastName = lastName;
//	}
//	public String getPrenom() {
//		return firstName;
//	}
//
//	public void setPrenom(String prenom) {
//		this.firstName = firstName;
//	}
//
//	public String getDateNaissance() {
//		return dateNaissance;
//	}
//
//	public void setDateNaissance(String dateNaissance) {
//		this.dateNaissance = dateNaissance;
//	}
//
//	public ArrayList<Compte> getListCompte() {
//		return listCompte;
//	}
//
//	public void setListCompte(ArrayList<Compte> listCompte) {
//		this.listCompte = listCompte;
//	}	
	
}

