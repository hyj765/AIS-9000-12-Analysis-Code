package swingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;


public class proccesssys extends SwingWorker<Boolean, Void> {
	  	String buffer;
	  	String bff[] = new String[3000];
	  	String Analsisbuffer[] = new String[2000];
		boolean endcheck = false;
		int funtionN;
		String folder = "";
		String Track = "";
		String Mark = "";
		String Way = "";
		String Rcv = "";
		String Send = "";
		public proccesssys(int fuN,String Folp)
		{
			this.funtionN = fuN;
			this.folder = Folp;
		}
		public proccesssys(int fuN,String Folp,String TrackP,String MarkP,String WayP)
		{
			this.funtionN = fuN;
			this.folder = Folp;
			this.Track = TrackP;
			this.Mark = MarkP;
			this.Way = WayP;
		}
		public proccesssys(int fuN,String RMessage,String SMessage)
		{	
			this.funtionN = fuN;
			this.Rcv = RMessage;
			this.Send = SMessage;
		}
		/*public proccesssys(int fuN,String Folp
			{
			this.funtionN = fuN; this.folder = Folp;
		}*/
		void pro_start() throws IOException
		{
			ProcessBuilder star = new ProcessBuilder("cmd","/c","python",".\\parser.py",folder,"3"); 
			Process proc = star.start();
			BufferedReader Reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String line;
			while((line = Reader.readLine())!= null)
			{
				System.out.print(line);
			}
		}
	
		void pro_start_track(String trackpath,String programpath) throws IOException
		{
			String argument = "";
			String[] command = new String[4];
		
			ProcessBuilder trst = new ProcessBuilder(command);
			trst.start();
		}
		
		@Override
		protected Boolean doInBackground() throws Exception {
			String argument = "";
			String[] command = new String[4];
			/*
			ProcessBuilder te= new ProcessBuilder("cmd","/c","");
			te.start();
			*/
			if(this.funtionN == 1)
			{
				int i = 0;
				ProcessBuilder star = new ProcessBuilder("python",".\\parser.py",Track,"1",Mark,Way); 
				Process prot= star.start();
			
			try {
				BufferedReader Reader = new BufferedReader(new InputStreamReader(prot.getInputStream()));
				while((buffer = Reader.readLine())!= null)
				{
								Analsisbuffer[i]=buffer;
								System.out.println(Analsisbuffer[i]);
								i++;
				}
				prot.waitFor();
				return true;
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        } 

				System.out.print("항적 데이터 분석 중");
			}
			else if(this.funtionN == 3)
			{	int i=0;
				ProcessBuilder star = new ProcessBuilder("python",".\\parser.py",Rcv,"3",Send); 
				Process proc = star.start();
				BufferedReader Reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
				while((buffer = Reader.readLine())!= null)
				{
								bff[i]=buffer;
								System.out.println(bff[i]);
								i++;
				}
				proc.waitFor();
				this.endcheck = true;
			
			}
			return true;
		}
		@Override
		public void done() {
			
			if(this.funtionN == 1) {
				try {
				
					Boolean state = get();
					if(state == true)
					{
					JOptionPane.showMessageDialog(null, "항적데이터 분석 완료");
					endcheck = true;
					Runtime res = Runtime.getRuntime();
					String file ="cmd /c .\\AIS9000.html";
					Process pro;
					try {
						pro = res.exec(file);
						pro.waitFor();
					}catch(Exception e) {
						e.printStackTrace();
					}
					}
					else{
					JOptionPane.showMessageDialog(null, "항적데이터 분석 실패");
					endcheck = false;
					}
				}catch (InterruptedException | ExecutionException e){
				}
			
			}
			synchronized(this) {
				if(this.funtionN == 3)
				{
					notify();
				}
			}
		}
}

