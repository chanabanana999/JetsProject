package com.skilldistillery.jets;

import java.util.Scanner;

public class JetsApp {
	Scanner scanner = new Scanner(System.in);
	Airfield airfield = new Airfield();

	public static void main(String[] args) {
		JetsApp jetsapp = new JetsApp();
		jetsapp.launch();
	}

	public JetsApp() {
	}

	private void launch() {
		System.out.println("Welcome to the Jets Application. We have tons of info");
		System.out.println("on planes.\n");
		displayUserMenu();
	}

	private void displayUserMenu() {
		boolean displayMenu = true;
		int menuChoice = 0;

		while (displayMenu = true) {
			System.out.println("1. List fleet\n" + "2. Fly all jets\n" + "3. View fastest jet\n"
					+ "4. View jet with longest range\n" + "5. Load all Cargo Jets\n" + "6. Dogfight!\n"
					+ "7. Add a jet to Fleet\n" + "8. Remove a jet from Fleet\n" + "9. Quit");
			menuChoice = scanner.nextInt();

			switch (menuChoice) {
			case 1:
				airfield.printAllJets();
				System.out.println();
				break;
			case 2:
				airfield.printAllJets();
				System.out.println("\nFly time:");
				airfield.printTimeinAir();
				break;
			case 3:
				airfield.getFastest();
				break;
			case 4:
				airfield.getLongest();
				break;
			case 5:
				airfield.loadCargo();
				break;
			case 6:
				airfield.dogfight();
				break;
			case 7:
				airfield.addJet(scanner);
				break;
			case 8:
				airfield.removeJet(scanner);
				break;
			case 9:
				displayMenu = false;
				System.out.println("Thank you for using the Jet Invetory Application.");
				System.out.println("Peace out!\n");
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Invalid option. Please choose from the options above.");
			}
		}
	}
}
