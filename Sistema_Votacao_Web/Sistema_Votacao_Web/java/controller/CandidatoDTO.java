package controller;

public class CandidatoDTO {
	private Integer idCandidato;
	private String nome;
	private String partido;
	private String numPartido;
	private String idEleicao;
	
	
	public CandidatoDTO() {
		super();
	}
	
	public CandidatoDTO(Integer idCandidato, String nome, String partido, String numPartido, String idEleicao) {
		super();
		this.idCandidato = idCandidato;
		this.nome = nome;
		this.partido = partido;
		this.numPartido = numPartido;
		this.idEleicao = idEleicao;
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