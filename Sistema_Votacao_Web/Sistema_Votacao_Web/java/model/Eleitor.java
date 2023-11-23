package model;

public class Eleitor {
	private Integer idEleitor;
	private String nome;
	private String endereco;
	private String numRegistroEleitor;

	public Eleitor() {

	}

	public Eleitor(Integer idEleitor, String nome, String endereco, String numRegistroEleitor) {
		super();
		this.idEleitor = idEleitor;
		this.nome = nome;
		this.endereco = endereco;
		this.numRegistroEleitor = numRegistroEleitor;
	}

	public Integer getIdEleicao() {
		return idEleitor;
	}

	public void setIdEleicao(Integer idEleicao) {
		this.idEleitor = idEleicao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumRegistroEleitor() {
		return numRegistroEleitor;
	}

	public void setNumReegistroEleitor(String numRegistroEleitor) {
		this.numRegistroEleitor = numRegistroEleitor;
	}

}
