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
 * Servlet implementation class EditListDetailsServlet
 */
@WebServlet("/EditListDetailsServlet")
public class EditListDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditListDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*ListDetailsHelper ldh = new ListDetailsHelper();
		HousePetItemHelper hpih = new HousePetItemHelper();
		OwnerHelper oh = new OwnerHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		ListDetails listDetailsToUpdate = ldh.searchForListDetailsById(tempId);
		
		String newOwnerName = request.getParameter("ownerName");
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String ownerName = request.getParameter("ownerName");
		//Owner newOwner = oh.findOwner(ownerName);
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex){
			ld = LocalDate.now();
		}
		
		try {
			String[] selectedHousePets = request.getParameterValues("allHousePetsToAdd");
			List<HousePetItem> selectedHousePetsInList = new ArrayList<HousePetItem>();
			
			for (int i = 0; i < selectedHousePets.length; i++) {
				System.out.println(selectedHousePets[i]);
				HousePetItem c = hpih.searchForItemById(Integer.parseInt(selectedHousePets[i]));
				selectedHousePetsInList.add(c);
			}
			listDetailsToUpdate.setListOfItems(selectedHousePetsInList);
		} catch (NullPointerException ex) {
			//no items selected in list - set to an empty list
			List<HousePetItem> selectedHousePetsInList = new ArrayList<HousePetItem>();
			listDetailsToUpdate.setListOfItems(selectedHousePetsInList);
		}
		
		listDetailsToUpdate.setListName(newOwnerName);
		listDetailsToUpdate.setTripDate(ld);
		listDetailsToUpdate.setOwner(newOwner);
		
		ldh.updateList(listDetailsToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllHousePetsServlet").forward(request, response);*/
	}

}
