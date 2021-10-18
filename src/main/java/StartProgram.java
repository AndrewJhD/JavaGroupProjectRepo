import java.util.List;
import java.util.Scanner;

import controller.HousePetItemHelper;
import model.HousePetItem;

/**
 * @author alexanderpontier - ampontier1
 * CIS175 - Spring 2021
 * Oct 13, 2021
 */

/**
 * @author alexanderpontier
 * We'll need to replace all the Dinosaur references with Pet stuff
 */
public class StartProgram {
	
	static Scanner in = new Scanner(System.in);
	static HousePetItemHelper hpih = new HousePetItemHelper();

	private static void addAPet() {
		// TODO Auto-generated method stub
		System.out.print("Enter a species: ");
		String species = in.nextLine();
		System.out.print("Enter an name: ");
		String name = in.nextLine();
		HousePetItem toAdd = new HousePetItem(name,species);
		hpih.insertItems(toAdd);

	}

	private static void deleteAPet() {
		// TODO Auto-generated method stub
		System.out.print("Enter the species to delete: ");
		String species = in.nextLine();
		System.out.print("Enter the color to delete: ");
		String name = in.nextLine();
		HousePetItem toDelete = new HousePetItem(name,species);
		hpih.deleteItems(toDelete);

	}

	private static void editAPet() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Species");
		System.out.println("2 : Search by Name");
		int searchBy = in.nextInt();
		in.nextLine();
		List<HousePetItem> foundPets;
		if (searchBy == 1) {
			System.out.print("Enter the species name: ");
			String speciesName = in.nextLine();
			foundPets = hpih.searchForPetByName(speciesName);
			
		} else {
			System.out.print("Enter the color: ");
			String nameName = in.nextLine();
			foundPets = hpih.searchForPetByName(nameName);
			

		}

		if (!foundPets.isEmpty()) {
			System.out.println("Found Results.");
			for (HousePetItem hpih : foundPets) {
				System.out.println(hpih.getId() + " : " + hpih.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			HousePetItem toEdit = hpih.searchForSpeciesById(idToEdit);
			System.out.println("Retrieved " + toEdit.getName() + " from " + toEdit.getSpecies());
			System.out.println("1 : Update Species");
			System.out.println("2 : Update Name");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Species: ");
				String newSpecies = in.nextLine();
				toEdit.setSpecies(newSpecies);
			} else if (update == 2) {
				System.out.print("New Name: ");
				String newName = in.nextLine();
				toEdit.setName(newName);
			}

			hpih.updateItem(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runMenu();

	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to the CIS 175 HOA Pet Database! ---");
		System.out.println("-------- Please enter the new pet's species: --------");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add a species");
			System.out.println("*  2 -- Edit a species");
			System.out.println("*  3 -- Delete a species");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Delete Household :( ");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAPet();
			} else if (selection == 2) {
				editAPet();
			} else if (selection == 3) {
				deleteAPet();
			} else if (selection == 4) {
				viewTheList();
			} else {
				hpih.cleanUp();
				System.out.println("   Household deleted   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		// TODO Auto-generated method stub
		List<HousePetItem> allPets = hpih.showAllItems();
		for(HousePetItem singlePet : allPets) {
			System.out.println(singlePet.returnItemDetails());
		}

	}

}
