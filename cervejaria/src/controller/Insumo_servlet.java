package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.InsumoDAO;
import model.Insumo;

/**
 * Servlet implementation class Insumo_servlet
 */
@WebServlet(urlPatterns={"/Insumo_servlet"})
public class Insumo_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InsumoDAO i_dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insumo_servlet() {
        super();
        i_dao = new InsumoDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
        String action = request.getParameter("action");
        
		if (action.equalsIgnoreCase("add")){
            forward = "/insumo_form.jsp";

        } else if (action.equalsIgnoreCase("list")){
            forward = "/insumo_list.jsp";
            request.setAttribute("insumos", i_dao.getAllInsumo());
           
        } else if (action.equalsIgnoreCase("edit")){
            forward = "/insumo_form.jsp";
            int insumo_id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("insumo", i_dao.getInsumoById(insumo_id));
        } else if (action.equalsIgnoreCase("delete")){
            int insumo_id= Integer.parseInt(request.getParameter("id"));
            int deletar = i_dao.deleteInsumo(insumo_id);
            if (deletar == 0){
            	forward = "/erro.jsp";
            }else {
            forward = "/insumo_list.jsp";
            request.setAttribute("insumos", i_dao.getAllInsumo());    
        
            }
        }
		RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		String nome = request.getParameter("nome");
		String id = request.getParameter("id");
		Insumo insumo = new Insumo();
		insumo.setNome(nome);
		
		if(id == null || id.isEmpty())
        {
            i_dao.addInsumo(insumo);
            
        }
        else
        {
        	
        	insumo.setId(Integer.parseInt(id));
            i_dao.updateInsumo(insumo);
        }
		
		RequestDispatcher view = request.getRequestDispatcher("/insumo_list.jsp");
        request.setAttribute("insumos", i_dao.getAllInsumo());
        view.forward(request, response);

	}

}
