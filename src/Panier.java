import java.io.Serializable;

/**
 * 
 */

/**
 * @author sagbodjo
 *
 */
public class Panier implements Serializable {
	
	int nombre ;
	String libelle;
	Double prixHt;
	transient TypeArticle type;
	transient boolean isImporte ;
	
	
	
	/**
	 * @param nombre
	 * @param nom
	 * @param prixHt
	 * @param type 
	 
	 */
	public Panier(int nombre, String libelle, Double prixHt, TypeArticle type) {
		super();
		this.nombre = nombre;
		this.libelle = libelle;
		this.prixHt = prixHt;
		this.type = type;
		isImporte = false ;
	}
	
	public Panier(int nombre, String libelle, Double prixHt, TypeArticle type, boolean isImporte ) {
		super();
		this.nombre = nombre;
		this.libelle = libelle;
		this.prixHt = prixHt;
		this.type = type;
		this.isImporte = isImporte ;
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "*" + nombre +" "+ libelle + " à " + prixHt + "€ : " + this.calculTtc() + "€ TTC\n";
	}
	
	/**
	 * 
	 * @return taxe
	 */
	public Double calculTaxe() {
		Double taxeLivre = 0.0 ;
		Double taxeAutre = 0.0 ;
		Double taxeAdditionnelle = 0.0 ;
	
		//Double tmp = (double) Math.round(valeur , 1);	
		
		// quel est le type
		if (type == TypeArticle.livre) {
			taxeLivre = 0.1 ;
		}
		else if (type == TypeArticle.autre) {
			taxeAutre = 0.2 ; 
		} else {
			if (type == TypeArticle.nourriture || 
					type == TypeArticle.medicament ) {
			}
			else {
				System.out.println("Type inconnu");
			} 
		}
		// si importe 
		if (isImporte) {
			taxeAdditionnelle = 0.05;
		}
		
		Double coutTVA = nombre*(prixHt*(taxeLivre +taxeAutre +taxeAdditionnelle));
		
		return coutTVA;
	}

	/**
	 * 
	 * @return total 
	 */
	public Double calculTtc() {
		//calcul du prix TTC
		return nombre*(prixHt) + this.calculTaxe();
	}
	/**
	 * 
	 * @param maValeur
	 * @return
	 */
	public Double calculArrondi(Double maValeur) {

		return (double) Math.round(maValeur * 0.5) / 0.5;

	}


	/**
	 * @return the nombre
	 */
	public int getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(int nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return libelle;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.libelle = nom;
	}
	/**
	 * @return the prixHt
	 */
	public Double getPrixHt() {
		return prixHt;
	}
	/**
	 * @param prixHt the prixHt to set
	 */
	public void setPrixHt(Double prixHt) {
		this.prixHt = prixHt;
	}
	/**
	 * @return the type
	 */
	public TypeArticle getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TypeArticle type) {
		this.type = type;
	}


}
