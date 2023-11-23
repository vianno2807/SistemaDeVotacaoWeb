package model;

public class Resultados {

	private String nome;
	private String partido;
	private int totalVotos;

	public Resultados() {

	}

	public Resultados(String nome, String partido, int totalVotos) {
		super();
		this.nome = nome;
		this.partido = partido;
		this.totalVotos = totalVotos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public int getTotalVotos() {
		return totalVotos;
	}

	public void setTotalVotos(int totalVotos) {
		this.totalVotos = totalVotos;
	}
}