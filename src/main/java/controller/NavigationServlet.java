package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HousePetItem;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		// TODO Auto-generated method stub
		response.getWriter().append("Pet Owner: ").append(request.getContextPath());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		HousePetItemHelper hpih = new HousePetItemHelper();
		
		String act = request.getParameter("doThisToDino");
		
		String path = "/viewAllHousePetsServlet";
		
		if (act.equals("delete")) {
			
			try {
				int tempId = Integer.parseInt(request.getParameter("id"));
				HousePetItem housePetToDelete = hpih.searchForItemById(tempId);
				hpih.deleteItems(housePetToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a Pet");
			}
			
		} else if (act.equals("edit")) {
			try {
				int tempID = Integer.parseInt(request.getParameter("id"));
				HousePetItem housePetToEdit = hpih.searchForItemById(tempID);
				request.setAttribute("petToEdit", housePetToEdit);
				path = "/edit-housepet.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a Pet");
			}
			
		} else if (act.equals("add")) {
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request,response);
	}

}
