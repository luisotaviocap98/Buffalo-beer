package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UnidadesDAO;
import model.Unidades;
/**
 * Servlet implementation class Unidades_servlet
 */
@WebServlet("/Unidades_servlet")
public class Unidades_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UnidadesDAO u_dao; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Unidades_servlet() {
        super();
        u_dao = new UnidadesDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
        String action = request.getParameter("action");
        
		if (action.equalsIgnoreCase("add")){
            forward = "/unidade_form.jsp";

        } else if (action.equalsIgnoreCase("list")){
            forward = "/unidade_list.jsp";
            request.setAttribute("unidades", u_dao.getAllUnidade());
           
        } else if (action.equalsIgnoreCase("edit")){
            forward = "/unidade_form.jsp";
            int unidade_id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("unidade", u_dao.getUnidadeById(unidade_id));
        } else if (action.equalsIgnoreCase("delete")){
            int unidade_id= Integer.parseInt(request.getParameter("id"));
            int deletar = u_dao.deleteUnidade(unidade_id);
            if (deletar == 0){
            	forward = "/erro.jsp";
//            	passar um parametro e depois chamar o js
            }else {
            	forward = "/unidade_list.jsp";
            	request.setAttribute("unidades", u_dao.getAllUnidade());    
            	
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
		Unidades unidade = new Unidades();
		unidade.setNome(nome);
		
		String id = request.getParameter("id");
		if(id == null || id.isEmpty())
        {
            u_dao.addUnidade(unidade);
            
        }
        else
        {
        	
        	unidade.setId(Integer.parseInt(id));
            u_dao.updateUnidade(unidade);
        }
		
		RequestDispatcher view = request.getRequestDispatcher("/unidade_list.jsp");
        request.setAttribute("unidades", u_dao.getAllUnidade());
        view.forward(request, response);
	}

}
