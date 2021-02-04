package swingtest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Timemgsys {
	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
		String timelog()
		{	
			Date time =new Date();
			String time1 = format1.format(time);
			System.out.print(time1+" ");
			return time1;
		}
		
		void logap(){
			
			
		}
		
}
