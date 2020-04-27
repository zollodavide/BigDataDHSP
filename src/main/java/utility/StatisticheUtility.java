package utility;
public class StatisticheUtility {

	public static boolean dataMaggiore(int anno1, int mese1, int giorno1, int anno2, int mese2, int giorno2) {
		
		if(mese1 > mese2)
			return true;
		else if(mese1 == mese2) {
			if(giorno1 > giorno2)
				return true;
			else 
				return false;	
		}
		else 
			return false;
	}
}
