package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HousePetItem;

/**
 * Servlet implementation class EditHousePetItemServlet
 */
@WebServlet("/editHousePetItemServlet")
public class EditHousePetItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditHousePetItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HousePetItemHelper housePet = new HousePetItemHelper();
		
		String species = request.getParameter("species");
		String name = request.getParameter("name");
		int tempId = Integer.parseInt(request.getParameter("id"));
		
		HousePetItem housePetToUpdate = housePet.searchForItemById(tempId);
		housePetToUpdate.setName(name);
		housePetToUpdate.setSpecies(species);
		
		housePet.updateItem(housePetToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllHousePetsServlet").forward(request, response);
		
	}

}
