package model;

import java.sql.Time;

import view.JanelaCadastrar;

public class Empresa {
	String cnpj;
	String razaoSocial;
	String conjunto;
	String entrada, saida;
	String tempMax;
	String inicioAr, fimAr;

	public Empresa(){
		
	}
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getConjunto() {
		return conjunto;
	}
	public void setConjunto(String conjunto) {
		this.conjunto = conjunto;
	}
	public String getEntrada() {
		return entrada;
	}
	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}
	public String getSaida() {
		return saida;
	}
	public void setSaida(String saida) {
		this.saida = saida;
	}
	public String getTempMax() {
		return tempMax;
	}
	public void setTempMax(String tempMax) {
		this.tempMax = tempMax;
	}
	public String getInicioAr() {
		return inicioAr;
	}
	public void setInicioAr(String inicioAr) {
		this.inicioAr = inicioAr;
	}
	public String getFimAr() {
		return fimAr;
	}
	public void setFimAr(String fimAr) {
		this.fimAr = fimAr;
	}
	
	
	
}
