package view;

import javax.swing.*;

import model.Empresa;
import model.EmpresaDAO;

import java.awt.*;
import java.awt.event.*;
import java.util.ResourceBundle;


public class JanelaCadastrar extends JFrame implements ActionListener{
	private JLabel razaoSocial, numCnpj, conj, horario, entrada,
			saida, tempMax, horarioAr, inicioAr, fimAr;
	public JTextField txtRazao, txtNum, txtConj, txtEntrada,
			txtSaida, txtTempMax, txtInicioAr,txtFimAr;
	private JButton confirmaCad, cancelaCad;
	private Container container;
	public ResourceBundle bn = null;
	Empresa empresa = new Empresa();
	
	public JanelaCadastrar(ResourceBundle bn)
	{
		//criar janela
		super("Cadastrar empresa");
		this.bn=bn;
		container = getContentPane();
		setLayout(new GridBagLayout());
		
		GridBagConstraints local = new GridBagConstraints();
		
		//local.anchor = GridBagConstraints.FIRST_LINE_START;
		
		//criar cnpj
		local.gridx =0;
		local.gridy=0;		
		numCnpj = new JLabel(bn.getString("telaCadastraEmpre.label.CNPJ"));
		container.add(numCnpj,local);
		local.gridx=1;
		txtNum = new JTextField();
		
		txtNum.setPreferredSize(new Dimension(150, 25));//define o tamanho do textField
		
		container.add(txtNum, local);
		
		//Criar razao social
		local.gridx =0;
		local.gridy=1;
		razaoSocial = new JLabel(bn.getString("telaCadastraEmpre.label.razao"));
		container.add(razaoSocial, local);
		local.gridx = 1;
		txtRazao = new JTextField();
		txtRazao.setPreferredSize(new Dimension(150, 25));//define o tamanho do textField
		
		container.add(txtRazao, local);
		
		//Criar conjuntos
		local.gridx = 0;
		local.gridy = 2;
		conj = new JLabel(bn.getString("telaCadastraEmpre.label.conjunto"));
		container.add(conj,local);
		local.gridx = 1;
		txtConj= new JTextField();
		txtConj.setPreferredSize(new Dimension(150,25));//define o tamanho do textField
		
		container.add(txtConj, local);
		
		//criar Horario funcionamento
		local.gridx = 0;
		local.gridy = 3;
		horario = new JLabel(bn.getString("telaCadastraEmpre.label.funcionamento"));
		container.add(horario, local);
		
		//criar horario de entrada e saida
		local.gridx = 0;
		local.gridy = 4;
		entrada = new JLabel(bn.getString("telaCadastraEmpre.label.entrada"));
		container.add(entrada,local);
		local.gridx = 1;
		txtEntrada = new JTextField();
		txtEntrada.setPreferredSize(new Dimension(150, 25));//define o tamanho do textField
		
		container.add(txtEntrada, local);
		local.gridx = 3;
		local.gridy = 4;
		saida = new JLabel(bn.getString("telaCadastraEmpre.label.saida"));
		container.add(saida, local);
		local.gridx = 4;
		txtSaida = new JTextField();
		txtSaida.setPreferredSize(new Dimension(150, 25));//define o tamanho do textField
		
		container.add(txtSaida, local);
		
		//criar temperatura maxima
		local.gridx = 0;
		local.gridy = 5;
		tempMax = new JLabel(bn.getString("telaCadastraEmpre.label.tempMax"));
		container.add(tempMax,local);
		local.gridx = 1;
		txtTempMax = new JTextField();
		txtTempMax.setPreferredSize(new Dimension(150, 25));//define o tamanho do textField
		
		container.add(txtTempMax, local);
		
		//criar horario de funcionamento do ar condicionado
		local.gridx = 0;
		local.gridy = 6;
		horarioAr = new JLabel("Horario de Funcionamento do ar-condicionado");
		
		//horario de inicio e fim
		local.gridx = 0;
		local.gridy = 7;
		inicioAr = new JLabel(bn.getString("telaCadastraEmpre.label.inicio"));
		container.add(inicioAr,local);
		local.gridx = 1;
		txtInicioAr = new JTextField();
		txtInicioAr.setPreferredSize(new Dimension(150, 25));//define o tamanho do textField
		
		container.add(txtInicioAr, local);
		local.gridx = 3;
		fimAr = new JLabel(bn.getString("telaCadastraEmpre.label.fim"));
		container.add(fimAr, local);
		local.gridx = 4;
		txtFimAr = new JTextField();
		txtFimAr.setPreferredSize(new Dimension(150, 25));//define o tamanho do textField
		
		container.add(txtFimAr, local);
		
		//criar botao
		local.gridx = 0;
		local.gridy = 8;
		confirmaCad = new JButton(bn.getString("telaCadastraEmpre.botao.confirmar"));
		confirmaCad.addActionListener(this);
		container.add(confirmaCad,local);
		local.gridx = 4;
		cancelaCad = new JButton(bn.getString("telaCadastraEmpre.botao.cancelar"));
		container.add(cancelaCad, local);
		cancelaCad.addActionListener(this);
		setTitle(bn.getString("telaCadastraEmpre.titulo"));
		

	}
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == cancelaCad)
		{
			this.dispose();
		}
		if(event.getSource() == confirmaCad)
		{
			EmpresaDAO d = new EmpresaDAO();

//			empresa.setFimAr(txtFimAr.getText());
//			txtFimAr.setText(" ");
//			empresa.setInicioAr(txtInicioAr.getText());
//			txtInicioAr.setText(" ");
//			empresa.setTempMax(txtTempMax.getText());
//			txtTempMax.setText(" ");
			empresa.setSaida(txtSaida.getText());
			txtSaida.setText(" ");
			empresa.setEntrada(txtEntrada.getText());
			txtEntrada.setText(" ");
			empresa.setConjunto(txtConj.getText());
			txtConj.setText(" ");
			empresa.setRazaoSocial(txtRazao.getText());
			txtRazao.setText(" ");
			empresa.setCnpj(txtNum.getText());
			txtNum.setText(" ");
			if(d.inserirEmpresa(empresa)){
			JOptionPane.showMessageDialog(null, "Dados Cadastrados!");
			}else{
				JOptionPane.showMessageDialog(null, "Dados invalidos");
			}
		}
	}
	
}
