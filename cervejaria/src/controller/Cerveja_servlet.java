package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
 
import model.CervejaDAO;
import model.Cerveja;


/**
 * Servlet implementation class Cerveja_servlet
 */
@WebServlet(urlPatterns={"/Cerveja_servlet"})
public class Cerveja_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CervejaDAO c_dao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cerveja_servlet() {
        super();
        c_dao = new CervejaDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
        String action = request.getParameter("action");
        
		if (action.equalsIgnoreCase("add")){
            forward = "/cerveja_form.jsp";
            
        } else if (action.equalsIgnoreCase("list")){
            forward = "/cerveja_list.jsp";
            request.setAttribute("cervejas", c_dao.getAllCerveja());
        }else if (action.equalsIgnoreCase("edit")){
            forward = "/cerveja_form.jsp";
            int cerveja_id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("cerveja", c_dao.getCervejaById(cerveja_id));
        } else if (action.equalsIgnoreCase("delete")){
            int cerveja_id= Integer.parseInt(request.getParameter("id"));
            int deletar = c_dao.deleteCerveja(cerveja_id);
            if (deletar == 0){
            	forward = "/erro.jsp";
            }else {
            	forward = "/cerveja_list.jsp";
            	request.setAttribute("cervejas", c_dao.getAllCerveja());    
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
		float alcool = Float.parseFloat(request.getParameter("alcool"));
		int ml = Integer.parseInt(request.getParameter("ml"));
		float preco = Float.parseFloat(request.getParameter("preco"));
		String id = request.getParameter("id");
		
		Cerveja cerveja = new Cerveja();
		cerveja.setNome(nome);
		cerveja.setIndice_alcool(alcool);
		cerveja.setMililitros(ml);
		cerveja.setPreco(preco);
		
		if(id == null || id.isEmpty())
        {
            c_dao.addCerveja(cerveja);
            
        }
        else
        {
        	
        	cerveja.setId(Integer.parseInt(id));
            c_dao.updateCerveja(cerveja);
        }
		
		RequestDispatcher view = request.getRequestDispatcher("/cerveja_list.jsp");
        request.setAttribute("cervejas", c_dao.getAllCerveja());
        view.forward(request, response);
	}

}
