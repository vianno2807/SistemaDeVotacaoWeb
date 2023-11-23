package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Eleicao;

public class NomeEleicaoDAo {

	public List<Eleicao> nomeEleicao() {
		List<Eleicao> nomesEleicoes = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = new Banco().getConnection();
			String sql = "SELECT idEleicao, nomeEleicao FROM Eleicoes";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int id = (rs.getInt("idEleicao"));
				String nome = (rs.getString("nomeEleicao"));
				Eleicao eleicao = new Eleicao(id, nome);
				nomesEleicoes.add(eleicao);
				System.out.println(nomesEleicoes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return nomesEleicoes;
	}

	public List<Eleicao> ListaEleicao() {
		List<Eleicao> listaEleicoes = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = new Banco().getConnection();
			String sql = "SELECT * FROM Eleicoes";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idEleicao = (rs.getInt("idEleicao"));
				String nomeEleicao = (rs.getString("nomeEleicao"));
				String dataInicio = (rs.getString("dataInicio"));
				String dataFim = (rs.getString("dataFim"));
				Eleicao eleicao = new Eleicao(idEleicao, nomeEleicao, dataInicio, dataFim);
				listaEleicoes.add(eleicao);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return listaEleicoes;
	}

}
