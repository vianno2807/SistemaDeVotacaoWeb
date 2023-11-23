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

public class DeletarItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeletarItem() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int teste = 0;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CadastroCadDao candidatoDAO = new CadastroCadDao();
		UsuariosDAO usuario = new UsuariosDAO();
		CadastroEleicaoDAO eleicao = new CadastroEleicaoDAO();
		CadastroDAO eleitor = new CadastroDAO();
		

		if (request.getParameter("excluir") != null) {
			if (request.getParameter("idCandidato") != null) {
				int id = Integer.parseInt(request.getParameter("idCandidato"));
//				request.getParameter("excluirCandidato");
				candidatoDAO.deletar(id);
			}
			if (request.getParameter("idEleicao") != null) {
				String idEleicao = request.getParameter("no");
				eleicao.deletar(Integer.parseInt(idEleicao));
				response.sendRedirect("Gerenciar.jsp");

			}
			if (request.getParameter("idUsuario") != null) {
				String idUsuario = request.getParameter("idUsuario");
				usuario.deletar(Integer.parseInt(idUsuario));
			}
			if (request.getParameter("nome") != null) {
				String nome = request.getParameter("nome");
				eleitor.deletar((nome));
			}

		}
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
//		request.setAttribute("listaCandidato", candidatoDAO.listaCands());
//		RequestDispatcher rd = request.getRequestDispatcher("/Gerenciar.jsp");
//		rd.forward(request, response);
		response.sendRedirect("gerenciar.jsp");


	}

}
