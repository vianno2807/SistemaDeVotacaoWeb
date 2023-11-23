package model;

public class Candidato {
	private String nome;
	private String partido;
	private String numPartido;
	private String idEleicao;
	private Integer idCandidato;
	
	public Candidato(){		
	}
	
	public Candidato(String nome, String partido, String numPartido, String idEleicao, Integer idCandidato) {
		super();
		this.nome = nome;
		this.partido = partido;
		this.numPartido = numPartido;
		this.idEleicao = idEleicao;
		this.idCandidato = idCandidato;
	}


	public Integer getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(Integer idCandidato) {
		this.idCandidato = idCandidato;
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

	public String getNumPartido() {
		return numPartido;
	}

	public void setNumPartido(String numPartido) {
		this.numPartido = numPartido;
	}

	public String getIdEleicao() {
		return idEleicao;
	}

	public void setIdEleicao(String idEleicao) {
		this.idEleicao = idEleicao;
	}

}
