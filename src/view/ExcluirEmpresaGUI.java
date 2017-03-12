package view;
//Lista de Imports referente ao GridBagLayout e Evento de botão
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.print.DocFlavor.READER;
import javax.swing.*;

import model.Empresa;
import model.EmpresaDAO;


public class ExcluirEmpresaGUI extends JFrame implements ActionListener{
	private JButton bConfirma, bCancela;
	public JTextField tCNPJ;
	private JTextField tRazao;
	private JLabel lCNPJ, lRazao, lDescricao;
	private Container container;
	public ResourceBundle bn = null;
	private Empresa empresa;
	
	public ExcluirEmpresaGUI(ResourceBundle bn, Empresa empresa)
	{
		super("Confirmação de exclusão");//Nome que vai aparecer na barra de cima
		this.empresa = empresa;
		this.bn=bn;
		container = getContentPane();//Cria "tela" cinza na variavel container
		setLayout(new GridBagLayout());//Instancia o GridBagLayout direto no parametro de escolha de layout
		GridBagConstraints atrib = new GridBagConstraints();//Cria variavel auxiliar que define os atributos do layout
		
		atrib.gridx = 0;//Posição Inicial(Centro)
		atrib.gridy = 0;//Posição Inicial(Centro)
		
		atrib.insets = new Insets(0,0,25,0);//Adiciona espaçamento- NOTE QUE ESTA ALTERAÇÃO É APENAS PARA ESTE CASO.
		lDescricao = new JLabel(bn.getString("telaExcluirEmpre.label.Descricao"));//Instancia Label Descricao
		container.add(lDescricao,atrib);//Adiciona Label Descricao no container na posicao do Atrib.

		atrib.insets = new Insets(10,0,0,0);//Retorna o espaçamento padrão para todo ATRIB.
		++atrib.gridy;//Aumenta apenas a posicao Y,descendo ela.
		lCNPJ = new JLabel(bn.getString("telaExcluirEmpre.label.CNPJ"));//Instancia Label CNPJ
		container.add(lCNPJ,atrib);//Adiciona Label CNPJ no container na posicao do Atrib.
		++atrib.gridx;//Aumenta apenas posicao X, indo para a proxima célula ao lado direito.
		tCNPJ = new JTextField(20);//Instancia TextField do CNPJ com 14 caracteres
		tCNPJ.setText(empresa.getCnpj());
		container.add(tCNPJ,atrib);//Adiciona TextCNPJ no container na posicao do Atrib.
		
		++atrib.gridy;//Aumenta posicao Y novamente, descendo denovo
		atrib.gridx = 0;//Retorna X para posicao Inicial(zero).
		
		lRazao = new JLabel(bn.getString("telaExcluirEmpre.label.Razao"));//Instancia Label Razao Social
		container.add(lRazao,atrib);//Adiciona Label Razao Social no container na posicao Atrib.
		++atrib.gridx;//Aumenta Posicao X, indo para a proxima celular ao lado direito;
		tRazao = new JTextField(20);//Instancia TextRazao Social com 25 caracteres
		tRazao.setText(empresa.getRazaoSocial());
		container.add(tRazao,atrib);//Adiciona TextRazao Social no container na posicao Atrib.
		
		++atrib.gridy;//Aumenta posicao Y novamente, descendo denovo.
		atrib.gridx = 0;//Retorna X para posicao Inicial(Zero).
		//Agora no caso dos botões, irei alterar o width para 2, para ficar visualmente mais bonito.
		atrib.gridwidth = 2;
		atrib.insets = new Insets(10,0,0,15);//Adiciona espaçamento na direita
		bConfirma = new JButton(bn.getString("telaExcluirEmpre.botao.Confirma"));//Instancia Botão de Confirmar
		container.add(bConfirma,atrib);//Adiciona Botao Entrar no container e posicao do atrib.
		bConfirma.addActionListener(this);
		++atrib.gridx;//Aumenta Posicao X para o proximo botão ficar na celula ao lado.
		atrib.insets = new Insets(10,15,0,0);//Adiciona espaçamento na esquerda
		bCancela = new JButton(bn.getString("telaExcluirEmpre.botao.Cancela"));//Instancia Botão de Cancelar
		container.add(bCancela,atrib);//Adiciona Botão Cancelar no container na posicao do atrib.
		bCancela.addActionListener(this);
		
		tRazao.setEditable(false);
		tCNPJ.setEditable(false);
		
		setTitle(bn.getString("telaExcluirEmpre.titulo"));
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == bCancela )
		{
			this.dispose();
		}
		if(event.getSource() == bConfirma)
		{
			EmpresaDAO eda = new EmpresaDAO();
			eda.deletarEmpresa(empresa);
			JOptionPane.showMessageDialog(null, "Empresa excluida!");
			this.dispose();
		}
	}

}
