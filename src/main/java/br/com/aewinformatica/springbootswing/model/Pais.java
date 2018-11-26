package br.com.aewinformatica.springbootswing.model;

public class Pais {

	private String codigo;
	private String nome;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public Pais(String codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}
	
	public Pais() {
		super();

	}
	
	
}
