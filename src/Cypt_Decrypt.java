import java.math.BigInteger;

public class Cypt_Decrypt {
	
	BigInteger mes_ap_trt ;
	
	//Fonction de chifferement et déchiffrement
	public BigInteger chif_dechif(BigInteger mes, BigInteger n , BigInteger b) {
		mes_ap_trt = mes.multiply(b).mod(n);
		return mes_ap_trt ;
	}
}
