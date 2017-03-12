package view;

import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import java.awt.*;


public class HomeEmpresa extends JFrame implements ActionListener{
	 
	private JButton cadastrar, consultar;
	private Container container;
	public ResourceBundle bn= null;
	
	
	public HomeEmpresa(ResourceBundle bn)
	{
		super("Inicio Empresa");
		this.bn=bn;
		container = getContentPane();
		setLayout(new GridBagLayout());
		
		GridBagConstraints local = new GridBagConstraints();
		
		//criar botoes
		local.gridx = 0;
		local.gridy = 0;
		cadastrar = new JButton(bn.getString("telaInEmpre.botao.cadastrar"));
		container.add(cadastrar, local);
		cadastrar.addActionListener(this);
		
		local.gridx = 1;
		consultar = new JButton(bn.getString("telaInEmpre.botao.consultar"));
		container.add(consultar, local);
		consultar.addActionListener(this);
		
		setTitle(bn.getString("telaInEmpre.titulo"));
		
	}
	public void actionPerformed(ActionEvent event)
	{
		
		if(event.getSource() == cadastrar){
			JanelaCadastrar layout = new JanelaCadastrar(bn);
			layout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			layout.setSize(600,350);
			layout.setVisible(true);
			layout.setLocation(400,150);
			layout.setResizable(false);
		}
		if(event.getSource() == consultar){
			JanelaConsultar layout2 = new JanelaConsultar(bn);
			layout2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			layout2.setSize(600, 350);
			layout2.setVisible(true);
			layout2.setLocation(400, 150);
			layout2.setResizable(false);
		}
	}
	
	
	
	
}
