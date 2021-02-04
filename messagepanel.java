package swingtest;

import java.awt.font.*;
import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.Font;
import java.awt.Window;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import javax.swing.border.Border;

public class messagepanel extends JDialog{
	String[] rcvdata ={""};
	String[] senddata= {""};
	public messagepanel(Window parent,String[] data)
	{
		
		super(parent, "AIS MESSAGE Alarm", ModalityType.APPLICATION_MODAL);
		setSize(800,660);
		setLayout(null);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		JLabel rcvm = new JLabel("받은 메세지");
		rcvm.setFont(new Font("굴림",Font.BOLD,15));
		rcvm.setBounds(60,20,200,60);
		add(rcvm);
		JLabel sedm = new JLabel("보낸 메세지");
		sedm.setFont(new Font("굴림",Font.BOLD,15));
		sedm.setBounds(410,20,200,60);
		add(sedm);
		JTextArea rcv = new JTextArea("");
		JScrollPane RscrollPane = new JScrollPane(rcv);
		RscrollPane.setBounds(60, 70, 320, 500);
		rcv.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		add(RscrollPane);
		JTextArea sed = new JTextArea("");
		JScrollPane SscrollPane = new JScrollPane(sed);
		SscrollPane.setBounds(410, 70, 320, 500);
		sed.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		add(SscrollPane);
		msset(data,rcv,sed);
	}
	
	
	public void msset(String[] data,JTextArea lt,JTextArea to)
	{
		int i = 1;
		
			while(!data[i].trim().startsWith("ep"))
			{	
				if(i == 1){
					lt.setText(data[i]+"\n");
				}
				else {
					lt.append(data[i]+"\n");
				}
				if(i % 5 == 0)
				{
					lt.append("\n");
				}
				i++;
			}
			while(!data[i].trim().startsWith("ed"))
			{	
				if(data[i].trim().startsWith("Send Message - 1"))
				{
					to.setText(data[i]+"\n");
				}
				else {
					to.append(data[i]+"\n");
				}
				if(i %4 == 0)
				{
					to.append("\n");
				}
				i++;
			}
			
		}
		
	}

	/*@Override
	protected Boolean doInBackground() throws Exception {
		/* ProcessBuilder te= new ProcessBuilder("cmd","/c",path,"message.exe");
		
		 (3/i)*i + i*2 + i*3        123 456 789 101112 3/3     3(i) 
		 for (
			 			123 456 789 101112               i+3         while(readline == 'ep'){  f[j]= i + (i+1)+ (i+2)  i+=3 j++ }
			 																	
			 		
		te.start();
		try{
		te.excute();
		te.waitfor();
		
		}
		catch
		{
		
		}
		
		return true;
	}
	public void done()
	{
		
		
	}
	*/

	
