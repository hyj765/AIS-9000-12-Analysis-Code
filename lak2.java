package swingtest;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.filechooser.*;
import java.awt.*;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.JMenu;
import javax.swing.JPanel;
public class lak2 {

	void logmake(JTextArea areat, String doneit)
	{
		Timemgsys to = new Timemgsys();
		areat.append(to.timelog()+": "+doneit+"\n");
	}
	
	
	
	private JFrame frmPrototype;
	public int mid = 0;

	String FolderPath = "";
	String TrackPath = "";
	String MarkPath = "";
	String WayPath = "";
	String RMessagePath ="";
	String SMessagePath = "";
	/**
	 * Launch the application.
	 */
	void datapathpacing(String tp,String eip,String WP,String RMp,String SMp)
	{
		TrackPath = tp;
		MarkPath = eip;
		WayPath =WP;
		RMessagePath =RMp;
		SMessagePath = SMp;
		
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lak2 window = new lak2();
					window.frmPrototype.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public lak2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrototype = new JFrame();
		frmPrototype.getContentPane().setForeground(Color.BLACK);
		frmPrototype.getContentPane().setBackground(UIManager.getColor("Button.background"));
		frmPrototype.setTitle("DOMAT[Prototype]");
		frmPrototype.setBounds(100, 100, 850, 600);
		frmPrototype.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrototype.getContentPane().setLayout(null);
		String[] Modellist = {"Plz Select Model","AIS9000-12","FT8700"};
		JFormattedTextField Pathtext = new JFormattedTextField();
		Pathtext.setForeground(Color.BLACK);
		Pathtext.setBackground(Color.WHITE);
		Pathtext.setFont(new Font("Arial", Font.PLAIN, 12));
		Pathtext.setEnabled(false);
		Pathtext.setBounds(66, 62, 429, 21);
		frmPrototype.getContentPane().add(Pathtext);
		JComboBox comboBox = new JComboBox(Modellist);
		comboBox.setToolTipText("");
		comboBox.setBounds(87, 29, 163, 23);
		comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
				JComboBox cp =(JComboBox) e.getSource();
				int index = cp.getSelectedIndex();
					mid = index;
				}
			});
		
		
		
		frmPrototype.getContentPane().add(comboBox);
		
		
		JLabel lblNewLabel = new JLabel("Model type");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel.setBounds(12, 31, 63, 19);
		frmPrototype.getContentPane().add(lblNewLabel);
		
		JLabel lblFilePath = new JLabel("File Path");
		lblFilePath.setFont(new Font("굴림", Font.BOLD, 12));
		lblFilePath.setBounds(12, 63, 63, 19);
		frmPrototype.getContentPane().add(lblFilePath);
		
		JLabel lblNewLabel_1 = new JLabel("Track Data");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1.setBounds(12, 93, 174, 15);
		frmPrototype.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mark Point");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(12, 142, 174, 15);
		frmPrototype.getContentPane().add(lblNewLabel_1_1);
		
		JTextArea logPane = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(logPane);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		logPane.setForeground(Color.RED);
		scrollPane.setBounds(12, 350, 700, 200);
		//logPane.setBounds(12, 313, 748, 238);
		logPane.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		frmPrototype.getContentPane().add(scrollPane);
		
		JLabel lblFilePath_1 = new JLabel("File Path");
		lblFilePath_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblFilePath_1.setBounds(12, 163, 63, 19);
		frmPrototype.getContentPane().add(lblFilePath_1);
		
		JFormattedTextField TrackP = new JFormattedTextField();
		TrackP.setForeground(Color.BLACK);
		TrackP.setEnabled(false);
		TrackP.setBounds(66, 111, 429, 21);
		frmPrototype.getContentPane().add(TrackP);
		
		JLabel lblFilePath_1_1 = new JLabel("File Path");
		lblFilePath_1_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblFilePath_1_1.setBounds(12, 112, 63, 19);
		frmPrototype.getContentPane().add(lblFilePath_1_1);
		
		JFormattedTextField MarkP = new JFormattedTextField();
		MarkP.setForeground(Color.BLACK);
		MarkP.setEnabled(false);
		MarkP.setBounds(66, 161, 429, 21);
		frmPrototype.getContentPane().add(MarkP);
		
		JLabel lblNewLabel_2 = new JLabel("Partition Parcing");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(496, 93, 122, 15);
		frmPrototype.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Recive AIS Message");
		lblNewLabel_1_1_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(12, 237, 174, 15);
		frmPrototype.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblFilePath_1_2 = new JLabel("File Path");
		lblFilePath_1_2.setFont(new Font("굴림", Font.BOLD, 12));
		lblFilePath_1_2.setBounds(12, 262, 63, 19);
		frmPrototype.getContentPane().add(lblFilePath_1_2);
		
		JFormattedTextField MessageP = new JFormattedTextField();
		MessageP.setEnabled(false);
		MessageP.setBounds(66, 262, 429, 21);
		frmPrototype.getContentPane().add(MessageP);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Send AIS Message");
		lblNewLabel_1_1_1_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(12, 293, 174, 15);
		frmPrototype.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblFilePath_1_2_1 = new JLabel("File Path");
		lblFilePath_1_2_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblFilePath_1_2_1.setBounds(12, 318, 63, 19);
		frmPrototype.getContentPane().add(lblFilePath_1_2_1);
		
		JFormattedTextField SMessageP = new JFormattedTextField();
		SMessageP.setEnabled(false);
		SMessageP.setBounds(66, 318, 429, 21);
		frmPrototype.getContentPane().add(SMessageP);
		
		JFormattedTextField WayP = new JFormattedTextField();
		WayP.setForeground(Color.BLACK);
		WayP.setEnabled(false);
		WayP.setBounds(66, 211, 429, 21);
		frmPrototype.getContentPane().add(WayP);

		
		JButton btnNewButton = new JButton("Find Path");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Openfilesys a = new Openfilesys();
				FolderPath=a.selecting(mid);
				Pathtext.setText(FolderPath);
				checkersys at = new checkersys(FolderPath);
				if(at.checker(mid) == true)
					{
						datapathpacing(at.TrackPath,at.MarkPath,at.WayPath,at.RMessagePath,at.SMessagePath);
						TrackP.setText(TrackPath);
						MarkP.setText(MarkPath);
						MessageP.setText(RMessagePath);
						SMessageP.setText(SMessagePath);
						WayP.setText(WayPath);
						logmake(logPane,"디렉토리 매칭 완료");
						JOptionPane.showMessageDialog(null,"Directory Maching Succeed");
					}else if(mid != 0 && at.checker(mid) != true){
						logmake(logPane,"디렉토리 매칭 실패");
						datapathpacing("","","","","");
						TrackP.setText(TrackPath);
						MarkP.setText(MarkPath);
						MessageP.setText(RMessagePath);
						JOptionPane.showMessageDialog(null,"Directory Maching Fail");
					}
				}
			}
		);
		btnNewButton.setBounds(507, 61, 97, 23);
		frmPrototype.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("항적데이터 보기");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(TrackPath == "" || MarkPath == "" || WayPath =="")
				{
					JOptionPane.showMessageDialog(null, "항적 데이터 경로를 지정해주세요.");
				}else {
						
						proccesssys et = new proccesssys(1,FolderPath,TrackPath,MarkPath,WayPath);
						et.execute();
						Progress hitim = new Progress(frmPrototype,100,0);
							logmake(logPane,"항적데이터 확인");
							for (String Analsisbuffer :et.Analsisbuffer) {
								if(Analsisbuffer == null)
								{
									break;
								}
								logmake(logPane,Analsisbuffer);
							
					}
				}
			}
		});
		btnNewButton_1.setBounds(625, 180, 135, 32);
		frmPrototype.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("\uC2DC\uAC04\uC815\uBCF4");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logmake(logPane,"타임메세지 확인");
			}
		});
		btnNewButton_1_1.setBounds(625, 226, 135, 32);
		frmPrototype.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("\uBA54\uC138\uC9C0 \uD655\uC778");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(RMessagePath == "" || SMessagePath == "")
				{
					JOptionPane.showMessageDialog(null, "메시지 데이터 경로를 지정해주세요.");
				}else {
					proccesssys me = new proccesssys(3,RMessagePath,SMessagePath);
					me.execute();
					logmake(logPane,"AIS 메세지 분석 중");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		
					logmake(logPane,"AIS 메세지 분석 완료");
							messagepanel m = new messagepanel(frmPrototype,me.bff);
							m.setVisible(true);
				}	
			}
		});
		btnNewButton_1_1_1.setBounds(625, 271, 135, 32);
		frmPrototype.getContentPane().add(btnNewButton_1_1_1);
		
		JLabel lblAutoParcing = new JLabel("Integration Pacing");
		lblAutoParcing.setFont(new Font("굴림", Font.BOLD, 12));
		lblAutoParcing.setBounds(499, 33, 105, 19);
		frmPrototype.getContentPane().add(lblAutoParcing);
		
		JButton TrackPB = new JButton("Find Path");
		TrackPB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Openfilesys a = new Openfilesys();
				FolderPath=a.fileSel(mid);
				TrackP.setText(FolderPath);
				TrackPath=TrackP.getText();
				if(TrackP.getText().isEmpty() != true)
				{
					logmake(logPane,"항적데이터 파일 매칭 완료");
				}
			}
		});
		TrackPB.setBounds(507, 110, 97, 23);
		frmPrototype.getContentPane().add(TrackPB);
		
		JButton TimePB = new JButton("Find Path");
		TimePB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Openfilesys a = new Openfilesys();
				FolderPath=a.fileSel(mid);
				MarkP.setText(FolderPath);
				MarkPath=MarkP.getText();
				if(MarkP.getText().isEmpty() != true) {
					logmake(logPane,"마크포인트 파일 매칭 완료");
				}
			}
		});
		TimePB.setBounds(507, 161, 97, 23);
		frmPrototype.getContentPane().add(TimePB);
		
		JButton MessagePB = new JButton("Find Path");
		MessagePB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Openfilesys a = new Openfilesys();
				FolderPath=a.fileSel(mid);
				MessageP.setText(FolderPath);
				RMessagePath=MessageP.getText();
				if(MessageP.getText().isEmpty() != true) {
					logmake(logPane,"AIS Recieve 메세지 파일 매칭 완료");
				}
			}
		});
		MessagePB.setBounds(507, 260, 97, 23);
		frmPrototype.getContentPane().add(MessagePB);
		
		JButton RoutePB = new JButton("Find Path");
		RoutePB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Openfilesys a = new Openfilesys();
				FolderPath=a.fileSel(mid);
				SMessageP.setText(FolderPath);
				SMessagePath=SMessageP.getText();
				if(SMessageP.getText().isEmpty() != true)
				{
					logmake(logPane,"AIS SEND 메세지 파일 매칭 완료");
				}
			}
		});
		RoutePB.setBounds(507, 317, 97, 23);
		frmPrototype.getContentPane().add(RoutePB);
		
		JLabel iL = new JLabel("");
		iL.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\bob_bi\\bob_bi_basic.jpg"));
		iL.setBounds(617, 29, 174, 141);
		frmPrototype.getContentPane().add(iL);
		
	
		
		JButton WayPoint_B = new JButton("Find Path");
		WayPoint_B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Openfilesys a = new Openfilesys();
				FolderPath=a.fileSel(mid);
				WayP.setText(FolderPath);
				WayPath=MarkP.getText();
				if(TrackP.getText().isEmpty() != true) {
					logmake(logPane,"웨이포인트 파일 매칭 완료");
				}
			}
		});
		WayPoint_B.setBounds(507, 211, 97, 23);
		frmPrototype.getContentPane().add(WayPoint_B);
		
		JLabel lblFilePath_1_3 = new JLabel("File Path");
		lblFilePath_1_3.setFont(new Font("굴림", Font.BOLD, 12));
		lblFilePath_1_3.setBounds(12, 213, 63, 19);
		frmPrototype.getContentPane().add(lblFilePath_1_3);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Way Point");
		lblNewLabel_1_1_2.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1_1_2.setBounds(12, 192, 174, 15);
		frmPrototype.getContentPane().add(lblNewLabel_1_1_2);
		
		
		
	}
}
