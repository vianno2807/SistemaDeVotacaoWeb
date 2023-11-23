package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.CadastroCadDao;
import dao.CadastroDAO;
import dao.CadastroEleicaoDAO;
import dao.UsuariosDAO;

public class EditarItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditarItem() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CadastroCadDao candidatoDAO = new CadastroCadDao();
		UsuariosDAO usuario = new UsuariosDAO();
		CadastroEleicaoDAO eleicao = new CadastroEleicaoDAO();
		CadastroDAO eleitor = new CadastroDAO();

		if (request.getParameter("editar") != null) {
			if (request.getParameter("idCandidato") != null) {
				Integer idCandidato = Integer.parseInt(request.getParameter("idCandidato"));
				String nome = request.getParameter("nome");
				String numPartido = request.getParameter("numPartido");
				String partido = request.getParameter("partido");
				/* Integer idEleicao = Integer.parseInt(request.getParameter("idEleicao")); */
				candidatoDAO.alterar(idCandidato, nome, numPartido, partido);
			}
		}
		response.sendRedirect("gerenciar.jsp");
	}

}
