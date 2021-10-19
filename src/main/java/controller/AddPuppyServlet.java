package controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PuppyItem;

/**
 * Servlet implementation class AddPuppyServlet
 */
@WebServlet("/addPuppyServlet")
public class AddPuppyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPuppyServlet() {
        super();
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String puppy = request.getParameter("puppy");
		String breed = request.getParameter("breed");
		
		PuppyItem pi = new PuppyItem(puppy, breed);
		ListPuppyHelper dao = new ListPuppyHelper();
		dao.insertItem(pi);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
