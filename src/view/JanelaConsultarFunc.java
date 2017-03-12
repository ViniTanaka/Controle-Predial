package view;


import javax.swing.*;

import model.Empresa;
import model.EmpresaDAO;
import model.Funcionario;
import model.FuncionarioDAO;

import java.awt.*;
import java.awt.event.*;
import java.util.ResourceBundle;

public class JanelaConsultarFunc extends JFrame implements ActionListener {
	private JLabel cpf;
	private JTextField txtCpf;
	private JButton buscar;
	private Container container;
	public ResourceBundle bn = null;
	
	public JanelaConsultarFunc(ResourceBundle bn)
	{
		super("Consultar Funcionario");
		this.bn=bn;
		container = getContentPane();
		setLayout(new GridBagLayout());
		
		GridBagConstraints local = new GridBagConstraints();
		
		//criar cpf
		local.gridx = 0;
		local.gridy = 0;
		cpf = new JLabel(bn.getString("telaConsultaFunc.cpf"));
		container.add(cpf,local);
		local.gridx = 1;
		txtCpf = new JTextField();
		txtCpf.setPreferredSize(new Dimension(150,25));
		container.add(txtCpf, local);
		
		//criar botao
		local.gridx = 2;
		buscar = new JButton(bn.getString("telaConsultaFunc.botao.busca"));
		container.add(buscar, local);
		buscar.addActionListener(this);
		
		setTitle(bn.getString("telaConsultaFunc.titulo"));
	}
	
	public void actionPerformed(ActionEvent event)
	{
		if(event.getSource() == buscar)
		{
			Funcionario funcionario = new Funcionario();
			funcionario.setCpf(txtCpf.getText());
			FuncionarioDAO d = new FuncionarioDAO();
			d.consultarFuncionario(funcionario);
			if(funcionario.getCpf() == null)
			{
				JOptionPane.showMessageDialog(null, "Empresa Não cadastrada!");
			}else{
				JanelaAlterarFunc layout = new JanelaAlterarFunc(bn, funcionario);
				layout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				layout.setSize(600,350);
				layout.setVisible(true);
				layout.setLocation(400,150);
				layout.setResizable(false);
			}
		}
	}
}
