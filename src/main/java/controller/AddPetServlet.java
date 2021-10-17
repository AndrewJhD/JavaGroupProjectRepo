package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HousePetItem;

/**
 * Servlet implementation class AddPetServlet
 */
@WebServlet("/AddPetServlet")
public class AddPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String species = request.getParameter("species");
		String name = request.getParameter("name");
		if (species.isEmpty() || name.isEmpty() || species == null || name == null) {
			
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
			
		} else {
			
			HousePetItem hpi = new HousePetItem(species, name);
			HousePetItemHelper pet = new HousePetItemHelper();
			pet.insertPet(hpi);
			
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
	}

}
