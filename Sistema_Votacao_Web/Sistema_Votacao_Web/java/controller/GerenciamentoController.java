package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Candidato;
import model.DadosExcluidos;
import model.Eleicao;
import model.Eleitor;
import model.Resultados;
import model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.CadastroCadDao;
import dao.CadastroDAO;
import dao.CadastroEleicaoDAO;
import dao.DadosExcluidosDAO;
import dao.ListaCandidatoDAO;
import dao.NomeEleicaoDAo;
import dao.ResultadosDAO;
import dao.UsuariosDAO;

@WebServlet(name = "GerenciamentoController", urlPatterns = { "/GerenciamentoController" })

public class GerenciamentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GerenciamentoController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomeTabela = null;
		String selecionado = request.getParameter("tipo");
		HttpSession session = request.getSession();

		if (request.getParameter("pesquisar") != null) {
			if (selecionado.equals("1")) {
				nomeTabela = "Candidatos";
				List<Candidato> listaCand = new ArrayList<>();
				ListaCandidatoDAO listaC = new ListaCandidatoDAO();
				listaCand = listaC.listaCandidatos();
				session.setAttribute("listaCand", listaCand);
			}

			if (selecionado.equals("2")) {
				nomeTabela = "Eleicoes";
				List<Eleicao> listaEle = new ArrayList<>();
				NomeEleicaoDAo listaE = new NomeEleicaoDAo();
				listaEle = listaE.ListaEleicao();
				session.setAttribute("listaEle", listaEle);
			}

			if (selecionado.equals("3")) {
				nomeTabela = "Usuarios";
				List<Usuario> listaUsu = new ArrayList<>();
				UsuariosDAO listaU = new UsuariosDAO();
				listaUsu = listaU.ListaUsuarios();
				session.setAttribute("listaUsu", listaUsu);

			}
			if (selecionado.equals("4")) {
				nomeTabela = "Eleitores";
				List<Eleitor> listaEleit = new ArrayList<>();
				CadastroDAO ListaEle = new CadastroDAO();
				listaEleit = ListaEle.ListaEleitor();
				session.setAttribute("listaEleit", listaEleit);
			}
			if (selecionado.equals("5")) {
				nomeTabela = "dadosExcluidos";
				List<DadosExcluidos> listaDados = new ArrayList<>();
				DadosExcluidosDAO ListaD = new DadosExcluidosDAO();
				listaDados = ListaD.ListaDados();
				session.setAttribute("listaDados", listaDados);
			}
		}
		session.setAttribute("nomeTabela", nomeTabela);
		CadastroCadDao candidatoDAO = new CadastroCadDao();
		UsuariosDAO usuario = new UsuariosDAO();
		CadastroEleicaoDAO eleicao = new CadastroEleicaoDAO();
		CadastroDAO eleitor = new CadastroDAO();
		request.setAttribute("nomeTabela", nomeTabela);

		if (request.getParameter("excluir") != null) {
			if (request.getParameter("idCandidato") != null) {
				int id = Integer.parseInt(request.getParameter("idCandidato"));
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

		/*
		 * if (request.getParameter("editar") != null) { if
		 * (request.getParameter("idCandidato") != null) { Integer idCandidato =
		 * Integer.parseInt(request.getParameter("idCandidato")); String nome =
		 * request.getParameter("nome"); String numPartido =
		 * request.getParameter("numPartido"); String partido =
		 * request.getParameter("partido"); Integer idEleicao =
		 * Integer.parseInt(request.getParameter("idEleicao"));
		 * candidatoDAO.alterar(idCandidato, nome, numPartido, partido); } }
		 */

		response.sendRedirect("gerenciar.jsp");

	}

	public void alterarTabela() {
		System.out.println("gerenciar");
	}
}