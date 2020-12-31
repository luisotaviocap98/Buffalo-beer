package controller;

import java.io.IOException;
import java.util.Arrays;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import java.util.ArrayList;
import java.util.List;
//import java.util.Map;
//import java.util.stream.*;

import model.Cerveja_has_Insumo;
import model.CervejaDAO;
import model.InsumoDAO;
import model.UnidadesDAO;
import model.Cerveja_has_InsumoDAO;
/**
 * Servlet implementation class Cerveja_has_Insumo_servlet
 */
@WebServlet("/Cerveja_has_Insumo_servlet")
public class Cerveja_has_Insumo_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CervejaDAO c_dao;
    private InsumoDAO i_dao;
    private UnidadesDAO u_dao;   
    private Cerveja_has_InsumoDAO ci_receita;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cerveja_has_Insumo_servlet() {
        super();
        c_dao = new CervejaDAO();
        i_dao = new InsumoDAO();
        u_dao = new UnidadesDAO();
        ci_receita = new Cerveja_has_InsumoDAO();
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
            List<Cerveja_has_Insumo> lista = ci_receita.getAllReceitas(); 
            lista.forEach(receita->System.out.println((c_dao.getCervejaById(receita.getCerveja_id())).getNome()+" "
            +(i_dao.getInsumoById(receita.getInsumos_id())).getNome()+" "+receita.getQuantidade()+" "+
            (u_dao.getUnidadeById(receita.getUnidades_id()).getNome())));
//              request.setAttribute("cervejas", ci_receita.getAllReceitas());
           
        } else if (action.equalsIgnoreCase("edit")){
            forward = "/receita_form.jsp";
            int insumo_id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("insumo", i_dao.getInsumoById(insumo_id));
        } else if (action.equalsIgnoreCase("delete")){
            int insumo_id= Integer.parseInt(request.getParameter("id"));
            i_dao.deleteInsumo(insumo_id);

            forward = "/receita_list.jsp";
            request.setAttribute("insumos", i_dao.getAllInsumo());    
        
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
		int[] ingredientes= Arrays.stream(request.getParameterValues("ingrediente[]")).mapToInt(Integer::parseInt).toArray();
		int[] quantidade= Arrays.stream(request.getParameterValues("quantidade")).mapToInt(Integer::parseInt).toArray();  
		int[] unidade= Arrays.stream(request.getParameterValues("unidade[]")).mapToInt(Integer::parseInt).toArray();
		
//		String id = request.getParameter("cerveja_id");
//		
//		Cerveja_has_Insumo receita = new Cerveja_has_Insumo();
//		
//		
//		if(id == null || id.isEmpty())
//        {
//            ci_receita.addReceita(receita);
//            System.out.println("vazio");
//        }
//        else
//        {
//        	System.out.println("cheio");
//        	receita.setCerveja_id(cerveja);
//    		receita.setInsumo_id(ingredientes);
//    		receita.setUnidades_id(unidade);
//            ci_receita.updateReceita(receita);
//        }
//		
//		RequestDispatcher view = request.getRequestDispatcher("/cerveja_list.jsp");
//        request.setAttribute("cervejas", c_dao.getAllCerveja());
//        view.forward(request, response);
		
		try (PrintWriter out = response.getWriter()){
			out.println("<!DOCTYPE html>");
			out.println("<html");
			out.println("<head>");
			out.println("<title>Cervejaria</title>");
			out.println("</head>");
			out.println("<body>");
			out.println(cerveja + Arrays.toString(ingredientes) + Arrays.toString(quantidade) + Arrays.toString(unidade));
			out.println("</body>");
			out.println("</html>");
			}
	}

}
