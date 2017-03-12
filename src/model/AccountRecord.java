package model;

import control.CryptoDum;

public class AccountRecord
{
   private String login;
   public String senha;
   private String perfil;
   public AccountRecord()
   {
      this("", "", "" ); 
   } 
 
   public AccountRecord(String login, String senha, String perfil )
   {
      setLogin(login);
      setSenha(senha);
      setPerfil(perfil);
   } 
 
   public void setLogin(String login)
   {
      this.login = login;
   } 

   public String getLogin()
   {
      return login;
   }

   public void setSenha( String senha )
   {
      this.senha = senha;
   } 

   public String getSenha()
   {
	   return senha;
   }

	public String getPerfil() {
		return perfil;
	}
	
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	} 
   
} 