package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Eleicao;

public class CadastroEleicaoDAO {

	public String addEleicao(Eleicao eleicao) {

		String sql = "INSERT INTO Eleicoes (nomeEleicao, dataInicio, dataFim) VALUES (?, ?, ?);";
		PreparedStatement stmt = null;
		Connection conn = null;
		
		try {

			conn = new Banco().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, eleicao.getNomeEleicao());
			stmt.setString(2, eleicao.getDataInicio());
			stmt.setString(3, eleicao.getDataFim());
			stmt.executeUpdate();
			
			ResultSet rs = stmt.getGeneratedKeys();
			
			stmt.close();
			conn.close();
			 return "Eleição cadastrada com sucesso";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao cadastrar eleição: " + e.getMessage();
        }

	}

	public void deletar(Integer id) {
		String sql = "DELETE FROM Eleicoes WHERE idEleicao = ?";
		PreparedStatement stmt = null;
		Connection conn = null;

		try {

			conn = new Banco().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);

			int ret = stmt.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
