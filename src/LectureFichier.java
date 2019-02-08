import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.text.*;

public class LectureFichier {

	public LectureFichier() throws IOException {
		
		Path chemin = Paths.get("Liste.txt");
		Path cheminEcriture = Paths.get("Facture.txt");
		BufferedReader ficLecture = Files.newBufferedReader(chemin, Charset.forName("UTF-8"));
		BufferedWriter ficEcriture = Files.newBufferedWriter(cheminEcriture, Charset.forName("UTF-8"));
		
		ArrayList<Client> listeClients = new ArrayList<>();
		ArrayList<Plat> listePlats = new ArrayList<>();
		ArrayList<Commande> listeCommandes = new ArrayList<>();
		
		double totalFacture;
		
		String ligne = "";
		
		if((ligne = ficLecture.readLine()).equals("Clients :")) {
			
			while(!(ligne = ficLecture.readLine()).equals("Plats :")) {
				
				listeClients.add(new Client(ligne));
				
			}
			
			while(!(ligne = ficLecture.readLine()).equals("Commandes :")) {
				
				String[] infoPlat = ligne.split(" ");
				
				listePlats.add(new Plat(infoPlat[0], Double.parseDouble(infoPlat[1])));
				
			}
			while(!(ligne = ficLecture.readLine()).equals("Fin")) {

				String[] infoCommande = ligne.split(" ");
				Boolean platTrouve = false;
				
				for(Plat plat : listePlats) {
					
					if(infoCommande[1].equals(plat.getNom())) {
						
						listeCommandes.add(new Commande(infoCommande[0], plat, Integer.parseInt(infoCommande[2])));
						platTrouve = true;
						break;
					}
				}
				
				if(!platTrouve) {
					
					System.out.println("Erreur, le fichier ne respecte pas le bon format.");
				}
				
				
			}
			
			for(Client client : listeClients) {
				
				for(Commande commande : listeCommandes) {
					
					if(client.getNom().equals(commande.getNomClient())){
						
						client.getListeCommande().add(commande);
					}
				}
			}
		
			ficEcriture.write("Bienvenue chez Barette!");
			ficEcriture.newLine();
			ficEcriture.write("\nFactures:");
			ficEcriture.newLine();
			
			NumberFormat formatArgent = NumberFormat.getCurrencyInstance();
			
			
			
			for(Client client : listeClients) {
				
				totalFacture =0;
				
				for(Commande commande : client.getListeCommande()) {
					
					totalFacture+= commande.calculerPrix();
				}
				ficEcriture.write(client.getNom() + " " + formatArgent.format(totalFacture));
				ficEcriture.newLine();
			}
			
			
		}else {
			System.out.println("Erreur, le fichier ne respecte pas le bon format.");
		}
		
		ficLecture.close();
		ficEcriture.close();
		
	}
}
