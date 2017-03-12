package model;

public class Funcionario {

	String cpf;
	String nome;
	String empre;
	String nascimento;
	String horarioEntrada;
	String horarioSaida;
	
	public Funcionario()
	{
		
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmpresa() {
		return empre;
	}
	
	public void setEmpresa1(String empresa){
		this.empre=empresa;
	}

	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public String getHorarioEntrada() {
		return horarioEntrada;
	}
	public void setHorarioEntrada(String horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}
	public String getHorarioSaida() {
		return horarioSaida;
	}
	public void setHorarioSaida(String horarioSaida) {
		this.horarioSaida = horarioSaida;
	}
	
	
}
