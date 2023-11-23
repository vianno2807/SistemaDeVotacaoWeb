package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Resultados;


public class ResultadosDAO {
		
	public List<Resultados> listaResultado(Integer id){
		List <Resultados> resultados = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = new Banco().getConnection();
			String sql = "SELECT Candidatos.nome, Candidatos.partido, COUNT(*) as totalvotos"
					+ " FROM Candidatos"
					+ " INNER JOIN Votos ON Candidatos.idCandidato = Votos.idCandidato AND Candidatos.idEleicao = Votos.idEleicao"
					+ " WHERE Votos.idEleicao = ?" 
					+ " GROUP BY Candidatos.nome, Candidatos.partido";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				String nome = rs.getString("nome");
				String partido = rs.getString("partido");
				int totalVotos = rs.getInt("totalvotos");
				Resultados result = new Resultados(nome, partido, totalVotos);
				resultados.add(result);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				rs.close();
				stmt.close();
				conn.close();
			}catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return resultados;
	}
	
}
