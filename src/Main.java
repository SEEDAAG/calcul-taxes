import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author sagbodjo
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Path path = Paths.get("Output1.txt");
	    //Montant taxes et Total facture 
	    Double montantTaxe = 0.0;
	    Double total=0.0;
	    
	    File file = new File("Output1.txt");
	    
	   
	    
	    
	    try {
			
	          	
	        //Nous allons écrire chaque Panier dans le fichier
	        Panier premierPanier = new Panier(2, "livres", 12.49, TypeArticle.livre);
	        Panier deuxiemePanier = new Panier(1, "CD musical", 14.99, TypeArticle.autre);
	        Panier troisiemePanier = new Panier(3, "Barres de chocolat", 0.85, TypeArticle.nourriture);
	        
	        montantTaxe= premierPanier.calculTaxe() + deuxiemePanier.calculTaxe() + troisiemePanier.calculTaxe();
	        total = premierPanier.calculTtc() + deuxiemePanier.calculTtc() + troisiemePanier.calculTtc();
	        
	        String Facture = premierPanier.toString()+"\n"+deuxiemePanier.toString()+"\n"+troisiemePanier.toString()+"\n Montant des taxes :" +montantTaxe+ "€\n Total : " +total+ "€\n";
	       
	        Files.write(path, Facture.getBytes());
	
	        System.out.println("Fin d'écriture");
	    
	        
	        
	        Scanner in = new Scanner(file);
	        
	        while(in.hasNextLine()) {
	        	System.out.println(in.nextLine());
	        }
	      //On ferme 
	        in.close();
	        
	    } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
	        e.printStackTrace();
	      } 
	   
		
	}

}
