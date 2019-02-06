import java.util.ArrayList;

public class Client {
	private String nom;
	private ArrayList<Commande> listeCommande;
	
	public Client(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom=nom;
	}
	
	public ArrayList<Commande> getListeCommande(){
		return listeCommande;
	}

}
