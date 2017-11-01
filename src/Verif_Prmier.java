import java.math.BigInteger;
import java.util.Random;

public class Verif_Prmier {

	private static final BigInteger ZERO = BigInteger.ZERO;
	private static final BigInteger ONE = BigInteger.ONE;
	private static final BigInteger TWO = new BigInteger("2");
	private static final BigInteger THREE = new BigInteger("3");

	public static boolean isProbablePrime(BigInteger nombre, int k) {
		if (nombre.compareTo(ONE) == 0)
			return false;
		if (nombre.compareTo(THREE) < 0)
			return true;
		int s = 0;
		BigInteger nbr_Subst_Un = nombre.subtract(ONE);
		while (nbr_Subst_Un.mod(TWO).equals(ZERO)) {
			s++;
			nbr_Subst_Un = nbr_Subst_Un.divide(TWO);
		}
		for (int i = 0; i < k; i++) {
			BigInteger a = uniformRandom(TWO, nombre.subtract(ONE));
			BigInteger x = a.modPow(nbr_Subst_Un, nombre);
			if (x.equals(ONE) || x.equals(nombre.subtract(ONE)))
				continue;
			int r = 0;
			for (; r < s; r++) {
				x = x.modPow(TWO, nombre);
				if (x.equals(ONE))
					return false;
				if (x.equals(nombre.subtract(ONE)))
					break;
			}
			if (r == s)
				return false;
		}
		return true;
	}

	private static BigInteger uniformRandom(BigInteger min, BigInteger max) {
		Random rnd = new Random();
		BigInteger res;
		do {
			res = new BigInteger(max.bitLength(), rnd);
		} while (res.compareTo(min) < 0 || res.compareTo(max) > 0);
		return res;
	}
}
