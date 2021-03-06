package br.com.unisys.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.unisys.DAO.LocalEstocagem;
import br.com.unisys.DAO.LocalEstocagemDAO;

public class LocalEstocagemAction {
	
	LocalEstocagemDAO localEstocagemDAO = new LocalEstocagemDAO();
	
	
	public String adicionalocalEstocagem(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException, SQLException{
		LocalEstocagem localEstocagem = new LocalEstocagem();
	  // Captura os dados do formulário.
	    String codLocal = request.getParameter("codLocal");
	    String corredor = request.getParameter("corredor");
	    String prateleira = request.getParameter("prateleira");
	    String andar = request.getParameter("andar");
	    String box = request.getParameter("box");
	    localEstocagem.setCodLocal(codLocal);
	    localEstocagem.setCorredor(corredor);
	    localEstocagem.setPrateleira(prateleira);
	    localEstocagem.setAndar(andar);
	    localEstocagem.setBox(box);
		String status =localEstocagemDAO.adicionar(localEstocagem);
		return status;
	}
	
	public List<LocalEstocagem> buscaLocalEstocagem() throws SQLException {
		List<LocalEstocagem> listaLocalEstocagem = new ArrayList<LocalEstocagem>();
		listaLocalEstocagem = localEstocagemDAO.selectLocalEstocagem();
		return listaLocalEstocagem;
	}
	
	public static void main(String[] args) throws SQLException {
		LocalEstocagemAction localEstocagemAction = new LocalEstocagemAction();
		localEstocagemAction.buscaLocalEstocagem();
	}
	
}