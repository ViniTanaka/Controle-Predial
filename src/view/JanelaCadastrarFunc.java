package view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.*;

import model.Funcionario;
import model.FuncionarioDAO;

public class JanelaCadastrarFunc extends JFrame implements ActionListener{
	private JLabel user, empresa, cpf, nasc, horarioEntr, horarioSaida;
	private JTextField txtUser, txtEmpresa,txtCpf, txtNasc, txtHorarioEntr, txtHorarioSaida;
	private JButton cadastrar, cancelar;
	private Container container;
	private Dimension dime;
	public ResourceBundle bn = null;
	Funcionario funcionario = new Funcionario();
	
	public JanelaCadastrarFunc(ResourceBundle bn)
	{
		super("Cadastro Funcionário");
		this.bn=bn;
		container = getContentPane();
		setLayout(new GridBagLayout());
		
		GridBagConstraints local = new GridBagConstraints();
		dime = new Dimension(150, 25);
		
		//criar usuario
		local.gridx = 0;
		local.gridy = 0;
		user = new JLabel(bn.getString("telaCadastroFunc.label.usuario"));
		container.add(user, local);
		local.gridx = 1;
		txtUser = new JTextField();
		txtUser.setPreferredSize(dime);
		container.add(txtUser, local);
		
		//criar empresa
		local.gridx = 0;
		local.gridy = 1;
		empresa = new JLabel(bn.getString("telaCadastroFunc.label.empresa"));
		container.add(empresa, local);
		local.gridx = 1;
		txtEmpresa = new JTextField();
		txtEmpresa.setPreferredSize(dime);
		container.add(txtEmpresa, local);
		
		//criar CPF
		local.gridx = 0;
		local.gridy = 2;
		cpf = new JLabel(bn.getString("telaCadastroFunc.label.CPF"));
		container.add(cpf, local);
		local.gridx = 1;
		txtCpf = new JTextField();
		txtCpf.setPreferredSize(dime);
		container.add(txtCpf, local);
		
		//criar nascimento
		local.gridx = 3;
		local.gridy = 2;
		nasc = new JLabel(bn.getString("telaCadastroFunc.label.Nasc"));
		container.add(nasc, local);
		local.gridx = 4;
		txtNasc = new JTextField();
		txtNasc.setPreferredSize(dime);
		container.add(txtNasc, local);
		
		//horarios
		local.gridx = 0;
		local.gridy = 3;
		horarioEntr = new JLabel(bn.getString("telaCadastroFunc.label.horarioEn"));
		container.add(horarioEntr, local);
		local.gridx = 1;
		txtHorarioEntr = new JTextField();
		txtHorarioEntr.setPreferredSize(dime);
		container.add(txtHorarioEntr, local);
		
		local.gridx = 3;
		local.gridy = 3;
		horarioSaida = new JLabel(bn.getString("telaCadastroFunc.label.horarioSai"));
		container.add(horarioSaida, local);
		local.gridx = 4;
		txtHorarioSaida = new JTextField();
		txtHorarioSaida.setPreferredSize(dime);
		container.add(txtHorarioSaida, local);
		
		//Criar botao
		local.gridx = 0;
		local.gridy = 4;
		cadastrar = new JButton(bn.getString("telaCadastroFunc.botao.cadastrar"));
		container.add(cadastrar, local);
		cadastrar.addActionListener(this);
		local.gridx = 3;
		cancelar = new JButton(bn.getString("telaCadastroFunc.botao.cancelar"));
		container.add(cancelar, local);
		cancelar.addActionListener(this);
		
		setTitle(bn.getString("telaCadastroFunc.titulo"));
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource()==cancelar)
		{
			this.dispose();
		}
		if(event.getSource() == cadastrar)
		{
			FuncionarioDAO d = new FuncionarioDAO();

			funcionario.setNome(txtUser.getText());
			funcionario.setEmpresa1(txtEmpresa.getText());
			funcionario.setCpf(txtCpf.getText());
			funcionario.setNascimento(txtNasc.getText());
			funcionario.setHorarioEntrada(txtHorarioEntr.getText());
			funcionario.setHorarioSaida(txtHorarioSaida.getText());
			if(d.consultarNomeEmpresa(funcionario)){
				if(d.inserirFuncionario(funcionario)){
				JOptionPane.showMessageDialog(null, "Dados Cadastrados!");
				}else{
					JOptionPane.showMessageDialog(null, "Dados invalidos");
				}
			}
			
			else{
			JOptionPane.showMessageDialog(null, "Empresa nao existe!");
			}
		}
	}
	
}