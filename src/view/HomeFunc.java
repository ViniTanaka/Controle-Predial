package view;

	import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
	public class HomeFunc extends JFrame implements ActionListener{
		 
		private JButton cadastrar, consultar;
		private Container container;
		public ResourceBundle bn = null;
		
		
		public HomeFunc(ResourceBundle bn)
		{
			super("Inicio Funcionario");
			this.bn = bn;
			container = getContentPane();
			setLayout(new GridBagLayout());
			
			GridBagConstraints local = new GridBagConstraints();
			
			//criar botoes
			local.gridx = 0;
			local.gridy = 0;
			cadastrar = new JButton(bn.getString("telaInFunc.botao.cadastrar"));
			container.add(cadastrar, local);
			cadastrar.addActionListener(this);
			
			local.gridx = 1;
			consultar = new JButton(bn.getString("telaInFunc.botao.consultar"));
			container.add(consultar, local);
			consultar.addActionListener(this);
			
			setTitle(bn.getString("telaInFunc.titulo"));
			
		}
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource() == cadastrar){
				JanelaCadastrarFunc layout = new JanelaCadastrarFunc(bn);
				layout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				layout.setSize(600, 350);
				layout.setVisible(true);
				layout.setLocation(400, 150);
				layout.setResizable(false);
			}
			if(event.getSource() == consultar){
				JanelaConsultarFunc layout2 = new JanelaConsultarFunc(bn);
				layout2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				layout2.setSize(600, 350);
				layout2.setVisible(true);
				layout2.setLocation(400, 150);
				layout2.setResizable(false);
			}
		}//fim void
}//homefunc
		
		
		
		



