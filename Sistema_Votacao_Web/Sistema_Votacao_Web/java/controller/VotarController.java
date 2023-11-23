package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.CadastroCadDao;
import dao.VotarDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Candidato;
import model.Voto;

@WebServlet(name = "VotarController", urlPatterns = { "/votarController" })
public class VotarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public int idCandidato;
	public String voto;
    public int idEleicaoSelecionada;
    public int idUsuarioLogado;
    
	public VotarController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();	
		Object idUsuSee =  session.getAttribute("usuario");
		idUsuarioLogado = (Integer) idUsuSee;//idUs

		if (request.getParameter("pesquisarCand") != null) {
			Integer idEleicao = Integer.parseInt(request.getParameter("eleicao"));
			List<Candidato> listaC = new ArrayList<>();	
			idEleicaoSelecionada = idEleicao;

			listaC = buscarCandidatos(idEleicao);
			session.setAttribute("listaC", listaC);
		}
		if (!request.getParameter("voto").isEmpty()) {
			voto = request.getParameter("voto");
			System.out.println("voto:  " + voto);
			CadastroCadDao candidatoDAO = new CadastroCadDao();
			idCandidato = candidatoDAO.buscarIdCandidato(Integer.parseInt(voto)); // idCandidato
		}
		Voto vot = new Voto();
		vot.setIdCandidato(idCandidato);
		vot.setIdEleicao(idEleicaoSelecionada);
		vot.setIdUsuario(idUsuarioLogado);
		
		VotarDAO vota = new VotarDAO();	
		vota.addVoto(vot);
		session.setAttribute("mensagemVoto", "Voto registrado com sucesso!");
		response.sendRedirect("Votar.jsp");
	}

	public List<Candidato> buscarCandidatos(Integer id) {
		VotarDAO dao = new VotarDAO();

		List<Candidato> listaCandidato = new ArrayList<>();
		List<Candidato> lista = new ArrayList<>();

		listaCandidato = dao.listaCandidato(id);

		for (Candidato candidato : listaCandidato) {
			Integer idCandidato = candidato.getIdCandidato();
			String nome = candidato.getNome();
			String partido = candidato.getPartido();
			String numPartido = candidato.getNumPartido();
			Candidato cand = new Candidato(nome, partido, numPartido, "", idCandidato);
			lista.add(cand);
		}
		return lista;
	}
}
