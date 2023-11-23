package controller;

import java.io.IOException;
import java.util.List;

import dao.CadastroCadDao;
import dao.NomeEleicaoDAo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Candidato;
import model.Usuario;

@WebServlet(name = "CadastroCadController", urlPatterns = { "/CadastroCadController" })
public class CadastroCadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastroCadController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String result = null;
		CadastroCadDao cadastroCad = new CadastroCadDao();
		Candidato cad = new Candidato();
		Usuario usu = new Usuario();

		cad.setNome(request.getParameter("nome"));
		cad.setPartido(request.getParameter("partido"));
		cad.setNumPartido(request.getParameter("numPartido"));
		//cad.setIdEleicao(request.getParameter("idEleicao"));
		cad.setIdEleicao(request.getParameter("eleicao"));
		result = cadastroCad.addCandidato(cad);

		if (result == "Candidato cadastrado com sucesso") {

			usu.setLogin(request.getParameter("nome"));
			usu.setSenha(request.getParameter("senha"));
			result = cadastroCad.usuCad(usu);
			response.sendRedirect("cadastrarCandidato.jsp?status=success");
		}

	}

}
