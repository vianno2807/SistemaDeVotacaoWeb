package controller;

import java.util.ArrayList;
import java.util.List;

import dao.NomeEleicaoDAo;
import model.Eleicao;

public class ListaEleicao {

	public List<Eleicao> getItems(){
		List<Eleicao> list = new  ArrayList<Eleicao>();
		NomeEleicaoDAo dao = new NomeEleicaoDAo();
		
		list = dao.nomeEleicao();
		for ( Eleicao eleicao : list) {
			System.out.println(eleicao.getNomeEleicao());
			
		}
		return list;
	}
}
