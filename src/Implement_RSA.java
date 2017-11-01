import java.math.BigInteger;
import java.util.Random;


public class Implement_RSA {
	
	Random rand = new Random();
	BigInteger prem1 = new BigInteger("0");
	BigInteger prem2 = new BigInteger("0");
	BigInteger n , e , φ , d ;
	
	public Implement_RSA(BigInteger p , BigInteger q){
		this.prem1 = p ;
		this.prem2 = q ;
		this.n = this.calcul_n() ;
		this.φ = this.calcul_φ() ;
		this.e = this.calc_e() ;
		this.d = this.calc_d() ;
		
	}
	
	public void affiche() {
		System.out.println("φ = " + φ);
		System.out.println("n = " + n);
		System.out.println("e= "+ e);
		System.out.println("d= " + d);
	}
	
	public BigInteger calcul_n() {
		return prem1.multiply(prem2);
	}
	
	public BigInteger calcul_φ() {
		return prem1.subtract(BigInteger.valueOf(1)).multiply(prem2.subtract(BigInteger.valueOf(1))) ;
	}
	
	//!!!!!!!!!!generation de e !!!!!!!!
	public BigInteger calc_e() {
		BigInteger E , pgcd;
		
		do {
			do {
				E = new BigInteger(prem2.max(prem1).bitLength(), rand);
			} while (E.compareTo(prem2.max(prem1)) < 0 || E.compareTo(this.φ) > 0);
			
		pgcd = this.n.gcd(E);
		} while (pgcd.compareTo(BigInteger.valueOf(1)) != 0);
		return E;
	}
	
	//!!!!!!!!!!generation de d !!!!!!!!
	public BigInteger calc_d() {
		BigInteger D ;
		
		D = e.modInverse(n);
		return D;
	}
}
