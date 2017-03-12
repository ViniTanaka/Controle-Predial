package control;
import java.io.File;
import java.io.IOException;

import model.AccountRecord;
import view.LoginGUI;

public class CryptoDum {
	
	public static String sMsgDecifrada = null;
	public static String sMsgClara;
	public void teste(AccountRecord sMsgClara) throws Exception {

		
		String sMsgCifrada = null;
		byte[] bMsgClara = null;
		byte[] bMsgCifrada = null;
		byte[] bMsgDecifrada = null;
		byte[] bNovaCifra = null;

		CryptoDummy c = new CryptoDummy();
		
		//Crio a chave
		//c.geraChave(new File("chave.dummy")); não use jamais
		
		//Cria a mensagem clara
		
		//Tranforma em byte - só criptografa em bytes
		 bMsgClara = sMsgClara.getSenha().getBytes("ISO-8859-1");
		 
		 //Cifra
		c.geraCifra(bMsgClara, new File("chave.dummy"));//Gera cifra
		
		//Pega a cifra
		bNovaCifra = c.getTextoCifrado();
		
		//Transforma em String para leitura
		sMsgCifrada = new String(bNovaCifra,"ISO-8859-1");
		
		System.out.println("cifrado " + sMsgCifrada);
	
		
		//Informa o arquivo chave criado
		//Informa a mesagem a ser decifrada
		c.geraDecifra(bNovaCifra, new File ("chave.dummy"));
		
		//Recebe a decifrada em bytes
		bMsgDecifrada = c.getTextoDecifrado();
		
		System.out.println("decifrado " + new String(bMsgDecifrada,"ISO-8859-1"));
		sMsgDecifrada = new String(bMsgDecifrada);

		sMsgClara.setSenha(sMsgCifrada);


	}
}
