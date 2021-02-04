package swingtest;

import java.io.File;

public class checkersys {

	
	String s1="";
	int s2 = 0;
	String TrackPath="";
	String MarkPath="";
	String RMessagePath="";
	String SMessagePath="";
	String WayPath="";
	public checkersys(String path){
		this.s1 = path;
	}
	boolean checker(int index)
	{
		switch(index) {
		
		case 1 : {	if(ais9000check(s1) == true) {
				  
					return true; 
					}
		
			break;
			}
		case 2 : {
				
			}
		}
		return false;
	}
	boolean fileex(String path){
		try {	
			File filet = new File(path);
		
			if(filet.exists()!=true){
				System.out.print("files not find");
				return false;
			}
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.print("file error");
			return false;
		}
	}

	boolean ais9000check(String path)
	{
		String track = "\\track.dat";
		String Rmessage = "\\rcvmsg.txt";
		String mark = "\\markpoint.dat";
		String Smessage = "\\sendmsg.txt";
		String way = "\\waypoint.dat";
		if(fileex(path+track)!= true){
				return false;
			}
		if(fileex(path+Rmessage)!= true){
				return false;
		}
		
		if(fileex(path+mark)!= true) {
				return false;
		}
		if(fileex(path+way) != true)
		{
			return false;
		}
		if(fileex(path+Smessage) != true)
		{
			return false;
		}
		this.TrackPath = path;
		this.MarkPath = path;
		this.WayPath = path;
		this.RMessagePath = path;
		this.SMessagePath= path;
		return true; 
	}
	boolean FT8700check()
	{
		return true;
	}

}
