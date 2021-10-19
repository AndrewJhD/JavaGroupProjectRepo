package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PuppyItem;

/**
 * Servlet implementation class EditPuppyServlet
 */
@WebServlet("/editPuppyServlet")
public class EditPuppyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPuppyServlet() {
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
		ListPuppyHelper dao = new ListPuppyHelper();
		
		String puppy = request.getParameter("puppy");
		String breed = request.getParameter("breed");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		PuppyItem puppyToUpdate = dao.searchForBreedById(tempId);
		puppyToUpdate.setBreed(breed);
		puppyToUpdate.setPuppy(puppy);
		
		dao.updateItem(puppyToUpdate);
		getServletContext().getRequestDispatcher("/viewAllPuppysServlet").forward(request, response);
	}

}
