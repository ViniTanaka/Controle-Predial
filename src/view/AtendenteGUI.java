package view;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.*;

import model.Atendente;
import model.AtendenteDAO;

public class AtendenteGUI extends JFrame implements ActionListener {
	private JLabel lNome,lSobreNome, lCpf, lData;
	private JTextField tNome,tSobreNome, tCpf, tData;
	private JButton bCadastrar,bExcluir;
	private Container container;
	private Dimension dime;
	public ResourceBundle bn = null;
	Atendente atendente = new Atendente();
	
	public AtendenteGUI(ResourceBundle bn)
	{
		super("Cadastro Atendente");
		this.bn = bn;
		container  = getContentPane();
		setLayout(new GridBagLayout());
		
		GridBagConstraints local = new GridBagConstraints();
		dime = new Dimension(150, 25);
		
		//criar nome
		local.gridx = 0;
		local.gridy = 0;
		lNome = new JLabel(bn.getString("telaAtendente.label.nome"));
		container.add(lNome, local);
		local.gridx = 1;
		tNome = new JTextField();
		tNome.setPreferredSize(dime);
		container.add(tNome, local);
		
		//criar sobreNome
		local.gridx = 0;
		local.gridy = 1;
		lSobreNome = new JLabel(bn.getString("telaAtendente.label.sobreNome"));
		container.add(lSobreNome, local);
		local.gridx = 1;
		tSobreNome = new JTextField();
		tSobreNome.setPreferredSize(dime);
		container.add(tSobreNome, local);
		
		//criar cpf
		local.gridx = 0;
		local.gridy = 2;
		lCpf = new JLabel(bn.getString("telaAtendente.label.cpf"));
		container.add(lCpf, local);
		local.gridx = 1;
		tCpf = new JTextField();
		tCpf.setPreferredSize(dime);
		container.add(tCpf, local);
		
		//criar data
		local.gridx = 0;
		local.gridy = 3;
		lData = new JLabel(bn.getString("telaAtendente.label.data"));
		container.add(lData, local);
		local.gridx = 1;
		tData = new JTextField();
		tData.setPreferredSize(dime);
		container.add(tData, local);
		
		//criar botao
		local.gridx = 1;
		local.gridy = 4;
		bCadastrar = new JButton(bn.getString("telaAtende.botao.cadastrar"));
		bCadastrar.addActionListener(this);
		container.add(bCadastrar, local);
		bCadastrar.addActionListener(this);
		local.gridx = 2;
		bExcluir = new JButton(bn.getString("telaAtende.botao.excluir"));
		container.add(bExcluir, local);
		bExcluir.addActionListener(this);
		
		setTitle(bn.getString("telaInAtendente.titulo"));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//gera login getNome() gera senha getCPF()
		AtendenteDAO att = new AtendenteDAO();
		if(e.getSource() == bCadastrar){
			atendente.setCpf(tCpf.getText());
			atendente.setNome(tNome.getText());
			atendente.setSobreNome(tSobreNome.getText());
			atendente.setData(tData.getText());
			att.inserirAtendente(atendente);
		}
		if(e.getSource() == bExcluir){
			att.deletarAtendente(atendente);
			JOptionPane.showMessageDialog(null, "Atendente excluido");
		}
		
	}
}
