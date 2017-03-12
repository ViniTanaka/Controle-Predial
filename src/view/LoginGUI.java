package view;
//Lista de Imports referente ao GridBagLayout e Evento de botão
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.swing.*;

import control.CryptoDum;
import control.LerTxt;
import model.AccountRecord;


public class LoginGUI extends JFrame implements ActionListener {
	public JButton bEntrar;
	private JLabel lLogin, lSenha;
	public JTextField tLogin;
	public JTextField tSenha;
	private JPanel painel;
	private ResourceBundle bn = null;
	private JRadioButton portugues, ingles, espanhol;
	private JMenuItem sobre;

	public LoginGUI()
	{
		super("...::: LOGIN :::...");//Nome que aparece na barra de cima
		try{
			painel = new JPanel(new GridBagLayout());
			bn = ResourceBundle.getBundle("login", new Locale("pt", "BR"));
			adicionarComp();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void adicionarComp()
	{
		//menu
		  JMenuBar barra = new JMenuBar();
		  JMenu menu = new JMenu("Ajuda");
		  menu.setMnemonic('A');
		  
		  barra.add(menu);

		  
		  sobre = new JMenuItem("Sobre");
		  sobre.setMnemonic('S');
		  menu.add(sobre);
		  JMenu idioma = new JMenu("Idiomas");
		  idioma.setMnemonic('I');	
		  menu.add(idioma);
		  sobre.addActionListener(this);
		  
		 
		  portugues = new JRadioButton("Português");
		  ingles = new JRadioButton("Inglês");
		  espanhol = new JRadioButton("Espanhol");
		  ButtonGroup b = new ButtonGroup();
		  b.add(ingles);
		  b.add(portugues);
		  b.add(espanhol);
		  idioma.add(portugues);
		  idioma.add(ingles);
		  idioma.add(espanhol);   
		  idioma.doClick(HIDE_ON_CLOSE);
		  
		  portugues.addActionListener(this);
		  ingles.addActionListener(this);
		  espanhol.addActionListener(this);
		  
		  
		  setJMenuBar(barra);
		  
		  //fim menu
		  
		
		setLayout(new GridBagLayout());//Instancia o GridBagLayout direto no parametro de escolha de Layout
		GridBagConstraints atrib = new GridBagConstraints();//Cria uma variavel auxiliar que define as propriedades do Layout
		
		atrib.gridx = 0;//Posição inicial(Centro)
		atrib.gridy = 0;//Posicao inical(Centro)
		
		lLogin = new JLabel(bn.getString("login.label.login"));//Instancia o Label Login
		painel.add(lLogin,atrib);//Adiciona o Login no painel na posicao do Atrib
		++atrib.gridx;//Aumenta apenas a posicao X
		tLogin = new JTextField(12);//Instancia TextField do Login para 12 Caracteres
		painel.add(tLogin,atrib);//Adiciona o textLogin no painel na posicao nova do Atrib
		
		atrib.gridx = 0;//Retorna a posicao X para 0
		++atrib.gridy;//Aumenta a posicao Y,descendo ele
		
		lSenha = new JLabel(bn.getString("login.label.senha"));//Instancia o Label Senha
		painel.add(lSenha,atrib);//Adiciona a Senha no painel na posicao do Atrib
		++atrib.gridx;//Aumenta a posicao X, fazendo ele ir para a direita
		tSenha = new JPasswordField(12);//Instancia TextField da senha para 12 Caracteres
		painel.add(tSenha,atrib);//Adiciona o textSenha no painel na posicao nova do Atrib
		
		atrib.gridx = 0;//Retorna a posicao X para 0 novamente
		++atrib.gridy;//Aumenta a posicao do Y,fazendo ele descer novamente
		atrib.insets = new Insets(10,15,0,0);//Adiciona um espaçamento..cima,esquerda,baixo,direita
		atrib.gridwidth =2;//Fazendo o botão ocupar 2 espaços. PRESTAR ATENCAO NO RETORNO DELE
		bEntrar = new JButton(bn.getString("login.botao.entrar"));//Instancia o botão com o texto de ENTRAR
		painel.add(bEntrar,atrib);//Adiciona o botao no painel na posicao do Atrib
		bEntrar.addActionListener(this);	
		
		getContentPane().add(painel);//Cria a "tela" cinza com na variavel painel
	}
	public void recolocarComp()
	{
		painel.removeAll();
		adicionarComp();
		painel.updateUI();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		AccountRecord record = new AccountRecord();
		if( event.getSource()== bEntrar)
		{
			AccountRecord acc = new AccountRecord();
			CryptoDum c = new CryptoDum();
			acc.setLogin(tLogin.getText());
			acc.setSenha(tSenha.getText());
			LerTxt lerTxt = new LerTxt();
			try {
				c.teste(acc);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

			try {
				if(lerTxt.existeLogin(acc)) 
				{

						if(lerTxt.contaAtiva.getPerfil().equals("sindico")){	
							Home h = new Home(bn);
							h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							h.setSize(600,350);
							h.setVisible(true);
							h.setLocation(400,150);
							h.setResizable(false);
						}
						if(lerTxt.contaAtiva.getPerfil().equals("atendente")){
							Home h = new Home(bn);
							h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							h.setSize(600,350);
							h.setVisible(true);
							h.setLocation(400,150);
							h.setResizable(false);
							h.empresa.setEnabled(false);
							h.atendente.setEnabled(false);
						}
					
				}else{
					JOptionPane.showMessageDialog(null,"Login e senha nao validos!");

				}
			} catch (HeadlessException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

			//sobre
			if(event.getSource()== sobre )
			{
				Sobre s = new Sobre(bn);
				
			}	
			//Menuportugues
			  if(event.getSource()== portugues ){
				  bn = ResourceBundle.getBundle("login_pt_BR", new Locale("pt", "BR")); 
				
				
			    recolocarComp();
			  }
			  //Menuingles
			  if(event.getSource() == ingles ){
				  bn = ResourceBundle.getBundle("login_en_US", Locale.US);
			   
			   recolocarComp();
			  }
			  //Menuespanhol
			  if(event.getSource() == espanhol){
				  bn = ResourceBundle.getBundle("login_es_ES", new Locale("es", "ES"));
			  
			  recolocarComp();
			  }
	}

}


