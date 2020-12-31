package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import model.*;

/**
 * Servlet implementation class Receita_servlet
 */
@WebServlet("/Receita_servlet")
public class Receita_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CervejaDAO c_dao = new CervejaDAO();
    private InsumoDAO i_dao =  new InsumoDAO();
    private UnidadesDAO u_dao = new UnidadesDAO();   
    private ReceitaDAO r_dao = new ReceitaDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Receita_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
        String action = request.getParameter("action");
        
		if (action.equalsIgnoreCase("add")){
            forward = "/receita_form.jsp";
            request.setAttribute("cervejas", c_dao.getAllCerveja());
            request.setAttribute("insumos", i_dao.getAllInsumo());
            request.setAttribute("unidades", u_dao.getAllUnidade());
            
        } else if (action.equalsIgnoreCase("list")){
            forward = "/receita_list.jsp";
            List<Receita> lista = r_dao.getAllReceitas(); 
//            lista.forEach(receita->System.out.println(receita.getCerveja_id().getNome() + " " + 
//            receita.getInsumos_id().getNome()));
            request.setAttribute("receitas", lista);
           
        } else if (action.equalsIgnoreCase("edit")){
            forward = "/receita_form.jsp";
            int cerveja_id = Integer.parseInt(request.getParameter("cerveja_id"));
            int insumo_id = Integer.parseInt(request.getParameter("insumo_id"));
            int unidade_id = Integer.parseInt(request.getParameter("unidade_id"));
            
            Receita receita =  r_dao.getReceitaById(cerveja_id, unidade_id, insumo_id);
            
            List<Cerveja> cerva = new ArrayList<Cerveja>(); 
            cerva.add(receita.getCerveja_id());
            List<Insumo> ingrediente = new ArrayList<Insumo>(); 
            ingrediente.add(receita.getInsumos_id());
            List<Unidades> unit = new ArrayList<Unidades>(); 
            unit.add(receita.getUnidades_id());
            
            request.setAttribute("insumos", ingrediente);
            request.setAttribute("cervejas", cerva);
            request.setAttribute("unidades", unit);
            request.setAttribute("quantidade", receita.getQuantidade());
            
        } else if (action.equalsIgnoreCase("delete")){
        	int cerveja_id = Integer.parseInt(request.getParameter("cerveja_id"));
            int insumo_id = Integer.parseInt(request.getParameter("insumo_id"));
            int unidade_id = Integer.parseInt(request.getParameter("unidade_id"));
          
            Receita receita =  r_dao.getReceitaById(cerveja_id, unidade_id, insumo_id);
            r_dao.deleteReceita(receita);
            
            forward = "/receita_list.jsp";
            request.setAttribute("receitas", r_dao.getAllReceitas());    
        
        }
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		int cerveja = Integer.parseInt(request.getParameter("Cerveja"));
		int ingrediente= Integer.parseInt(request.getParameter("ingrediente"));
		int quantidade= Integer.parseInt(request.getParameter("quantidade"));  
		int unidade= Integer.parseInt(request.getParameter("unidade"));
		
		Receita receita =  r_dao.getReceitaById(cerveja, unidade, ingrediente);
		
		Receita novaReceita = new Receita();
		novaReceita.setCerveja_id(c_dao.getCervejaById(cerveja));
		novaReceita.setInsumos_id(i_dao.getInsumoById(ingrediente));
		novaReceita.setUnidades_id(u_dao.getUnidadeById(unidade));
		novaReceita.setQuantidade(quantidade);
		
		if(receita.getCerveja_id() == null)
        {
            r_dao.addReceita(novaReceita);
            
        }
        else
        {
            r_dao.updateReceita(novaReceita);
        }
		
		RequestDispatcher view = request.getRequestDispatcher("/receita_list.jsp");
        request.setAttribute("receitas", r_dao.getAllReceitas());
        view.forward(request, response);
	}

}
