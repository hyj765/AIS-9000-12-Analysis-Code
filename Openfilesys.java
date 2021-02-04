package swingtest;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

public class Openfilesys {
	
	String FolderP = "";
	
	public String fileSel(int index){
		JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		chooser.setCurrentDirectory(new File("/"));
		chooser.setAcceptAllFileFilterUsed(true);
		chooser.setDialogTitle("AIS 백업 파일 경로지정");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		 int returnVal = chooser.showOpenDialog(null);
		 if(returnVal == JFileChooser.APPROVE_OPTION) {
			 if(index > 0)
			 {
			 FolderP = chooser.getSelectedFile().toString();
			 return FolderP;
			 }
			 else {
				 JOptionPane.showMessageDialog(null,"AIS의 모델이 지정되지 않았습니다.");
				 return "";
			 }
		 }else if(returnVal == JFileChooser.CANCEL_OPTION){
			 System.out.print("Cancel");
			 return FolderP;
		 }
		return FolderP;
		}
	
	public String selecting(int index)
	{
		JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		chooser.setCurrentDirectory(new File("/"));
		chooser.setAcceptAllFileFilterUsed(true);
		chooser.setDialogTitle("AIS 백업 폴더 경로지정");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		 int returnVal = chooser.showOpenDialog(null);
		 if(returnVal == JFileChooser.APPROVE_OPTION) {
			 if(index > 0)
			 {
			 FolderP = chooser.getSelectedFile().toString();
			 return FolderP;
			 }
			 else {
				 JOptionPane.showMessageDialog(null,"AIS의 모델이 지정되지 않았습니다.");
				 return "";
			 }
		 }else if(returnVal == JFileChooser.CANCEL_OPTION){
			 System.out.print("Cancel");
			 return FolderP;
		 }
		return FolderP;
	}
	
	
}
