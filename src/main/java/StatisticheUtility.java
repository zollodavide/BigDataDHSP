public class StatisticheUtility {

	public static boolean dataMaggiore(String[] data1, String[] data2) {
		int mese1 = Integer.parseInt(data1[1]);
		int mese2 = Integer.parseInt(data2[1]);
		if(mese1 > mese2)
			return true;
		else if(mese1 == mese2)
			if(Integer.parseInt(data1[2]) > Integer.parseInt(data2[2]))
				return true;
			else 
				return false;		
		else 
			return false;
	}
}
