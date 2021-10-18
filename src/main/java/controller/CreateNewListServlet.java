package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HousePetItem;
import model.ListDetails;
import model.Owner;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListHousePetHelper hpih = new ListHousePetHelper();
		String listName = request.getParameter("listName");		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String ownerName = request.getParameter("ownerName");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch(NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		String[] selectedItems = request.getParameterValues("allHousePetsToAdd");
		List<HousePetItem> selectedItemsInList = new ArrayList<HousePetItem>();
		//make sure something was selected = otherwise we get a null pointer exception
		if(selectedItems != null && selectedItems.length > 0) {
			
			for(int i = 0; i<selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				HousePetItem c = hpih.searchForSpeciesById(Integer.parseInt(selectedItems[i]));
				selectedItemsInList.add(c);
			}
		}
		
		Owner owner = new Owner(ownerName);
		ListDetails listD = new ListDetails(listName, ld, owner);
		listD.setListOfItems(selectedItemsInList);
	/**/	ListDetailsHelper ldh = new ListDetailsHelper();
		ldh.insertNewListDetails(listD);
		
		
		getServletContext().getRequestDispatcher("/viewAllHousePetsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
