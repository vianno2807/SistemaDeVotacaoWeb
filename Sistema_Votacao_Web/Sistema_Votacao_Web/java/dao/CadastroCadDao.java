package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Candidato;
import model.Usuario;

public class CadastroCadDao {

	public String addCandidato(Candidato candidato) {

		String sql = "INSERT INTO Candidatos (nome, partido, numPartido, idEleicao) " + "VALUES (?, ?, ?, ?);";
		PreparedStatement stmt = null;
		Connection conn = null;
		try {

			conn = new Banco().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, candidato.getNome());
			stmt.setString(2, candidato.getPartido());
			stmt.setInt(3, Integer.parseInt(candidato.getNumPartido()));
			stmt.setInt(4, Integer.parseInt(candidato.getIdEleicao()));
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();

			stmt.close();
			conn.close();
			return "Candidato cadastrado com sucesso";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Erro ao cadastrar candidato: " + e.getMessage();
		}

	}

	public String usuCad(Usuario usuario) {

		String getperfil = "candidato";
		String sql = "INSERT INTO Usuarios ( login, senha, perfil) " + "VALUES (?, ?, ?);";
		PreparedStatement stmt = null;
		Connection conn = null;

		try {

			conn = new Banco().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			stmt.setString(3, getperfil);
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();

			stmt.close();
			conn.close();
			return "Candidato cadastrado com sucesso";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Erro ao cadastrar candidato: " + e.getMessage();
		}

	}

	public Integer buscarIdCandidato(Integer voto) {
		String sql = "SELECT idCandidato FROM Candidatos WHERE numPartido = ?";
		PreparedStatement stmt = null;
		Connection conn = null;

		try {

			conn = new Banco().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, voto);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Integer id = rs.getInt("idCandidato");

				conn.close();
				return id;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deletar(Integer id) {
		String sql = "DELETE FROM Candidatos WHERE idCandidato = ?";
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
	
	public void alterar (Integer idCandidato, String nome, String numPartido, String partido) {
		String sql = "UPDATE Candidatos SET nome = ?, numPartido = ?, partido = ? WHERE idCandidato = ?";
		PreparedStatement stmt = null;
		Connection conn = null;
		
		try {
			conn = new Banco().getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, nome);
            stmt.setString(2, numPartido);
            stmt.setString(3,partido );
            stmt.setInt(4, idCandidato);
            
           int ret = stmt.executeUpdate();
           conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Candidato candidatoPorId(Integer id) {
		Candidato candidato = new Candidato();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = new Banco().getConnection();
			String sql = "SELECT * FROM Candidatos where idCandidato = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Integer idCandidato = (rs.getInt("idCandidato"));
				String nome = (rs.getString("nome"));
				String partido = (rs.getString("partido"));
				String numPartido =	(rs.getString("numPartido"));
				String idEleicao = (rs.getString("idEleicao"));
				candidato = new Candidato(nome, partido, numPartido, idEleicao, idCandidato);
//				System.out.println(lista);
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

		return candidato;
	}
}