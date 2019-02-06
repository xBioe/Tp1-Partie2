
public class Commande {
	
	private Plat plat;
	private int quantite;
	private String nomClient;
	
	public Commande(Plat plat, int quantite, String nomClient) {
		this.plat=plat;
		this.quantite=quantite;
		this.nomClient=nomClient;
	}
	
	public Plat getPlat() {
		return plat;
	}
	
	public void setPlat(Plat plat) {
		this.plat=plat;
	}
	
	public int getQuantite() {
		return quantite;
	}
	
	public void setQuantite(int quantite) {
		this.quantite=quantite;
	}
	
	public String getNomClient() {
		return nomClient;
	}
	
	public void setNomClient(String nomClient) {
		this.nomClient=nomClient;
	}

}
