package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Candidato;

public class ListaCandidatoDAO {
	public List<Candidato> listaCandidatos() {
		List<Candidato> lista = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = new Banco().getConnection();
			String sql = "SELECT * FROM Candidatos";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Integer idCandidato = (rs.getInt("idCandidato"));
				String nome = (rs.getString("nome"));
				String partido = (rs.getString("partido"));
				String numPartido = (rs.getString("numPartido"));
				String idEleicao = (rs.getString("idEleicao"));
				Candidato candidato = new Candidato(nome, partido, numPartido, idEleicao, idCandidato);
				lista.add(candidato);

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
}
