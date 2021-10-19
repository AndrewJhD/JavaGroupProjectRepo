package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PetItem;

/**
 * Servlet implementation class EditPetServlet
 */
@WebServlet("/editPetServlet")
public class EditPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPetServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ListPetHelper dao = new ListPetHelper();
		
		String name = request.getParameter("name");
		String species = request.getParameter("species");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		PetItem petToUpdate = dao.searchForBreedById(tempId);
		petToUpdate.setSpecies(name);
		petToUpdate.setName(species);
		
		dao.updateItem(petToUpdate);
		getServletContext().getRequestDispatcher("/viewAllPetsServlet").forward(request, response);
	}

}
