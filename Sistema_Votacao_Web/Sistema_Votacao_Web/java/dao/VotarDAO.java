package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Candidato;
import model.Voto;

public class VotarDAO {
	public List<Candidato> listaCandidato(Integer id) {
		List<Candidato> lista = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = new Banco().getConnection();
			String sql = "SELECT * FROM Candidatos where idEleicao = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Integer idCandidato = (rs.getInt("idCandidato"));
				String nome = (rs.getString("nome"));
				String partido = (rs.getString("partido"));
				String numPartido =	(rs.getString("numPartido"));
				String idEleicao = (rs.getString("idEleicao"));
				Candidato candidato = new Candidato(nome, partido, numPartido, idEleicao, idCandidato);
				lista.add(candidato);
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
		return lista;
	}

public String addVoto(Voto voto) {
	String sql = "INSERT INTO Votos (idUsuario, idCandidato, idEleicao)" + "VALUES (?, ?, ?);";
	PreparedStatement stmt = null;
	Connection conn = null;
	
	try {
		conn = new Banco().getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, voto.getIdUsuario());
		stmt.setInt(2, voto.getIdCandidato());
		stmt.setInt(3, voto.getIdEleicao());
		stmt.executeUpdate();

		stmt.close();
		conn.close();
		return "Voto salvo!";

	} catch (SQLException e) {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		e.printStackTrace();
		return "Erro ao salvar voto: " + e.getMessage();
	}
}
}
