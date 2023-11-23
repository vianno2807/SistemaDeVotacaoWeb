package model;

public class Eleicao {
	private int idEleicao;
	private String nomeEleicao;
	private String dataInicio;
	private String dataFim;
	
	public Eleicao() {
		
	}

	public Eleicao(int idEleicao, String nomeEleicao) {
		super();
		this.idEleicao = idEleicao;
		this.nomeEleicao = nomeEleicao;
	}
		

	public Eleicao(int idEleicao, String nomeEleicao, String dataInicio, String dataFim) {
		super();
		this.idEleicao = idEleicao;
		this.nomeEleicao = nomeEleicao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}

	public String getNomeEleicao() {
		return nomeEleicao;
	}

	public void setNomeEleicao(String nomeEleicao) {
		this.nomeEleicao = nomeEleicao;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public int getIdEleicao() {
		return idEleicao;
	}

	public void setIdEleicao(int idEleicao) {
		this.idEleicao = idEleicao;
	}

}
