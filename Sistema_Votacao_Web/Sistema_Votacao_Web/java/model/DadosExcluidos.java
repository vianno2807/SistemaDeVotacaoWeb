package model;

public class DadosExcluidos {
	private int idExclusao;
	private String tabelaExclusao;
	private int id;
	private String dados;
	private String dataExclusao;

	public DadosExcluidos() {
	}

	public DadosExcluidos(int idExclusao, String tabelaExclusao, int id, String dados, String dataExclusao) {
		super();
		this.idExclusao = idExclusao;
		this.tabelaExclusao = tabelaExclusao;
		this.id = id;
		this.dados = dados;
		this.dataExclusao = dataExclusao;
	}

	public int getIdExclusao() {
		return idExclusao;
	}

	public void setIdExclusao(int idExclusao) {
		this.idExclusao = idExclusao;
	}

	public String getTabelaExclusao() {
		return tabelaExclusao;
	}

	public void setTabelaExclusao(String tabelaExclusao) {
		this.tabelaExclusao = tabelaExclusao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDados() {
		return dados;
	}

	public void setDados(String dados) {
		this.dados = dados;
	}

	public String getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(String dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

}
