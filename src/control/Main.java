package control;

import java.util.ResourceBundle;

import javax.swing.*;

import model.ConexaoMYSQL;
import view.LoginGUI;

public class Main {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
			JFrame frame = new LoginGUI();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			frame.setSize(600,350);
			frame.setLocation(400,150);
			frame.setResizable(false);
			
		      LerTxt application = new LerTxt();
		      application.openFile();
		      application.readRecords();
		      application.closeFile();
		

	}

}
