package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HousePetItem;

/**
 * Servlet implementation class AddHousePetServlet
 */
@WebServlet("/addHousePetServlet")
public class AddHousePetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddHousePetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String species = request.getParameter("species");
		
		
			HousePetItem hpi = new HousePetItem(name, species);
			HousePetItemHelper pet = new HousePetItemHelper();
			pet.insertItems(hpi);
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		
	}

}
