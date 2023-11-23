package dao;

import java.util.ArrayList;
import java.util.List;
import model.DadosExcluidos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DadosExcluidosDAO {

	public List<DadosExcluidos> ListaDados() {
		List<DadosExcluidos> listadados = new ArrayList<>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = new Banco().getConnection();
			String sql = "SELECT * FROM dadosExcluidos";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int idExclusao = (rs.getInt("idExclusao"));
				String tabelaExclusao = (rs.getString("tabelaExclusao"));
				int id = (rs.getInt("id"));
				String dados = (rs.getString("dados"));
				String dataExclusao = (rs.getString("dataExclusao"));
				DadosExcluidos dadosEX = new DadosExcluidos(idExclusao, tabelaExclusao, id, dados, dataExclusao);
				listadados.add(dadosEX);

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
		return listadados;
	}
}
