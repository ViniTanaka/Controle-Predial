package view;
import javax.swing.*;

import model.Empresa;
import model.EmpresaDAO;

import java.awt.*;
import java.awt.event.*;
import java.util.ResourceBundle;


public class JanelaAlterar extends JFrame implements ActionListener{
	private JLabel razaoSocial, numCnpj, conj, horario, entrada,
			saida, tempMax, horarioAr, inicioAr, fimAr;
	public JTextField txtRazao, txtNum, txtConj, txtEntrada,
			txtSaida, txtTempMax, txtInicioAr,txtFimAr;
	private JButton alterar, confirma, excluir;
	private Container container;
	public ResourceBundle bn = null;
	
	public JanelaAlterar(ResourceBundle bn, Empresa empresa)
	{
		//criar janela
		super("Alterar empresa");
		this.bn = bn;
		container = getContentPane();
		setLayout(new GridBagLayout());
		
		GridBagConstraints local = new GridBagConstraints();
		
		//criar cnpj
		local.gridx =0;
		local.gridy=0;		
		numCnpj = new JLabel(bn.getString("telaAlteraEmpre.label.CNPJ"));
		container.add(numCnpj,local);
		local.gridx=1;
		txtNum = new JTextField();
		txtNum.setPreferredSize(new Dimension(150, 25));//define o tamanho do textField
		txtNum.setText(empresa.getCnpj());
		txtNum.setEditable(false);
		container.add(txtNum, local);
		
		//Criar razao social
		local.gridx =0;
		local.gridy=1;
		razaoSocial = new JLabel(bn.getString("telaAlteraEmpre.label.razao"));
		container.add(razaoSocial, local);
		local.gridx = 1;
		txtRazao = new JTextField();
		txtRazao.setPreferredSize(new Dimension(150, 25));//define o tamanho do textField
		txtRazao.setText(empresa.getRazaoSocial());
		txtRazao.setEditable(false);
		container.add(txtRazao, local);
		
		//Criar conjuntos
		local.gridx = 0;
		local.gridy = 2;
		conj = new JLabel(bn.getString("telaAlteraEmpre.label.conjunto"));
		container.add(conj,local);
		local.gridx = 1;
		txtConj= new JTextField();
		txtConj.setPreferredSize(new Dimension(150,25));//define o tamanho do textField
		txtConj.setEditable(false);
		txtConj.setText(empresa.getConjunto());
		container.add(txtConj, local);
		
		//criar Horario funcionamento
		local.gridx = 0;
		local.gridy = 3;
		horario = new JLabel(bn.getString("telaAlteraEmpre.label.funcionamento"));
		container.add(horario, local);
		
		//criar horario de entrada e saida
		local.gridx = 0;
		local.gridy = 4;
		entrada = new JLabel(bn.getString("telaAlteraEmpre.label.entrada"));
		container.add(entrada,local);
		local.gridx = 1;
		txtEntrada = new JTextField();
		txtEntrada.setPreferredSize(new Dimension(150, 25));//define o tamanho do textField
		txtEntrada.setEditable(false);
		txtEntrada.setText(empresa.getEntrada());
		container.add(txtEntrada, local);
		local.gridx = 3;
		local.gridy = 4;
		saida = new JLabel(bn.getString("telaAlteraEmpre.label.saida"));
		container.add(saida, local);
		local.gridx = 4;
		txtSaida = new JTextField();
		txtSaida.setPreferredSize(new Dimension(150, 25));//define o tamanho do textField
		txtSaida.setEditable(false);
		txtSaida.setText(empresa.getSaida());
		container.add(txtSaida, local);
		
		//criar temperatura maxima
		local.gridx = 0;
		local.gridy = 5;
		tempMax = new JLabel(bn.getString("telaAlteraEmpre.label.tempMax"));
		container.add(tempMax,local);
		local.gridx = 1;
		txtTempMax = new JTextField();
		txtTempMax.setPreferredSize(new Dimension(150, 25));//define o tamanho do textField
		txtTempMax.setEditable(false);
		container.add(txtTempMax, local);
		
		//criar horario de funcionamento do ar condicionado
		local.gridx = 0;
		local.gridy = 6;
		horarioAr = new JLabel("Horario de Funcionamento do ar-condicionado");
		
		//horario de inicio e fim
		local.gridx = 0;
		local.gridy = 7;
		inicioAr = new JLabel(bn.getString("telaAlteraEmpre.label.inicio"));
		container.add(inicioAr,local);
		local.gridx = 1;
		txtInicioAr = new JTextField();
		txtInicioAr.setPreferredSize(new Dimension(150, 25));//define o tamanho do textField
		txtInicioAr.setEditable(false);
		container.add(txtInicioAr, local);
		local.gridx = 3;
		fimAr = new JLabel(bn.getString("telaAlteraEmpre.label.fim"));
		container.add(fimAr, local);
		local.gridx = 4;
		txtFimAr = new JTextField();
		txtFimAr.setPreferredSize(new Dimension(150, 25));//define o tamanho do textField
		txtFimAr.setEditable(false);
		container.add(txtFimAr, local);
		
		//criar botao
		local.gridx = 1;
		local.gridy = 8;
		alterar = new JButton(bn.getString("telaAlteraEmpre.botao.alterar"));
		container.add(alterar,local);
		alterar.addActionListener(this);
		confirma = new JButton(bn.getString("telaAlteraEmpre.botao.confirmar"));
		container.add(confirma, local);
		confirma.setVisible(false);
		confirma.addActionListener(this);
		
		local.gridx=2;
		excluir = new JButton(bn.getString("telaAlteraEmpre.botao.excluir"));
		container.add(excluir, local);
		excluir.addActionListener(this);

		setTitle(bn.getString("telaAlteraEmpre.titulo"));
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == alterar)
		{
			confirma.setVisible(true);
			alterar.setVisible(false);
			
			txtRazao.setEditable(true);
			txtNum.setEditable(false);//cnpj
			txtEntrada.setEditable(true);
			txtSaida.setEditable(true);
			txtInicioAr.setEditable(true);
			txtFimAr.setEditable(true);
			txtTempMax.setEditable(true);
			txtConj.setEditable(true);
			//ver quais txt podem ser editaveis
			
		}
		if(event.getSource() == confirma)
		{
			confirma.setVisible(false);
			alterar.setVisible(true);
			
			txtRazao.setEditable(false);
			txtNum.setEditable(false);
			txtEntrada.setEditable(false);
			txtSaida.setEditable(false);
			txtInicioAr.setEditable(false);
			txtFimAr.setEditable(false);
			txtTempMax.setEditable(false);
			txtConj.setEditable(false);
			Empresa e = new Empresa();
			e.setCnpj(txtNum.getText());
			e.setRazaoSocial(txtRazao.getText());
			e.setConjunto(txtConj.getText());
			e.setEntrada(txtEntrada.getText());
			e.setSaida(txtSaida.getText());
			
			EmpresaDAO eda = new EmpresaDAO();
			eda.alterarEmpresa(e);
			
			
		}
		if(event.getSource() == excluir)
		{
			Empresa e = new Empresa();
			e.setCnpj(txtNum.getText());
			e.setRazaoSocial(txtRazao.getText());
			ExcluirEmpresaGUI excluir = new ExcluirEmpresaGUI(bn, e);
			excluir.setVisible(true);//Deixa visivel o container
			excluir.setSize(500,400);//Tamanho do container
			excluir.setLocation(540,220);//Onde o container vai ser posicionado
			excluir.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Ao clicar em sair, fecha a operação
			this.dispose();
		}
		
	}
	
}
