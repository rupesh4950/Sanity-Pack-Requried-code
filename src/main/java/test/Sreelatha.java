package test;

public class Sreelatha {
	public static void main(String[] args) {
		System.out.println(check("0600",5,10));
	}
	public static String check(String timeSetAt, int secondsGainedEveryFiveMinutes,int minutsEaryly) {
		String time =timeSetAt;
		int sG=secondsGainedEveryFiveMinutes;
		int mE=minutsEaryly;
		
		if(time.length()<4 || time.length()>4) {
			return "Invalid input";
		}
		int sec=mE*60;
		int ti=sec/sG;
		
		int h=(ti/12);
		int m=(ti%12);
		
		
		int hours=Integer.parseInt((String) time.substring(0, 2));
		int minuts=Integer.parseInt((String) time.substring(2));
		
		int returnH=hours+h;
		int returnM=minuts+m;
		
		String ret="";
		if((returnH+"").length()==1) {
			ret="0"+returnH;
		}
		else {
			ret=returnH+"";
		}
		if((returnM+"").length()==1) {
			ret+=("0"+returnM);
		}
		else {
			ret+=(returnM+"");
		}
		
		return ret;
	}
}
