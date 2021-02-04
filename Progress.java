package swingtest;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Window;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;


public class Progress{
		JProgressBar progress;
	public Progress(Window parent,int maxsimum,int minimum)
	{	
		JFrame f = new JFrame("Analsis Processing now wait for a seconds..");
		f.setVisible(true);
		f.setLayout(new FlowLayout());
		progress = new JProgressBar(minimum,maxsimum);
		progress.setStringPainted(true);
		f.add(progress);
		f.setSize(300,1);
		progress_timer(progress,f);
	}
	public void progress_timer(JProgressBar hi,JFrame m)
	{
		int i = 0;
		
				while(i != 101)
				{
					hi.setValue(i);
					try {	
						Thread.sleep(680);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
					i += 1;
				}
				m.setVisible(false);
	}
		
}

