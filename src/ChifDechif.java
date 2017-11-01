import java.math.*;
import java.util.*;


public class ChifDechif {

	/**
	 * @param args
	 */
	
	public boolean premier_deux() {
		return false ;
	}
	
	public boolean calc_pgcd() {
		return false ;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		BigInteger e = new BigInteger("0") ;
		BigInteger d = new BigInteger("0") ;
		int k = 50;
		boolean bool = false;
		
		System.out.print("Saisir un nombre: ");
		long mes = sc.nextLong();
		System.out.println("Le nombre a calculer: " + mes);
		
		//Declarer et initialiser deux entiers grand
		BigInteger prem_1 ;
		BigInteger prem_2 ;
		
		//Instation de Implement_RSA et Verif_Prem
		Verif_Prmier verif = new Verif_Prmier();
		Cypt_Decrypt calcul = new Cypt_Decrypt();
		
		//Vérification de la primalité de prem_1 et prem_2
		do {
			prem_1 = new BigInteger(50 , rand);
			bool = verif.isProbablePrime(prem_1, k);
		} while(bool == false);
				
		do {
			prem_2 = new BigInteger(50 , rand);
			bool = verif.isProbablePrime(prem_2, k);
		} while(bool == false);
		
		Implement_RSA impl = new Implement_RSA(prem_1 , prem_2);
		
		//Calcule des clès publiques et privées
		BigInteger n = impl.n ;
		e = impl.e ;
		d = impl.d ;
		//impl.affiche();
		
		//Chiffrer et Déchiffrer un nombre
		BigInteger res = calcul.chif_dechif(BigInteger.valueOf(mes), n, e) ;
		
		System.out.println("Résultat après chiffrement  : " + res);
		System.out.println("Résultat après déchiffrement: " + calcul.chif_dechif(res, n, d));
	}

}
