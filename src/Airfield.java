package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Airfield {

	String file = "planes.txt";
	List<Jet> allJets;

	public Airfield() {
		allJets = new ArrayList<Jet>();
		getJets(file);
	}

	private List<Jet> getJets(String file) {
		List<Jet> jets = new ArrayList<>();
		try (BufferedReader bufIn = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				Jet currentJet = null;
				String[] jetRecord = line.split(", ");
				String model = jetRecord[0];
				double speed = Double.parseDouble(jetRecord[1]);
				int range = Integer.parseInt(jetRecord[2]);
				long price = Long.parseLong(jetRecord[3]);
				String type = jetRecord[4];
				if (type.equalsIgnoreCase("cargo")) {
					currentJet = new Cargo(model, speed, range, price, type);
				}
				if (type.equalsIgnoreCase("fighter")) {
					currentJet = new FighterJet(model, speed, range, price, type);
				}
				allJets.add(currentJet);

			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return jets;
	}

	public void printAllJets() {
		for (Jet jet : allJets) {
			System.out.println(jet);
		}
	}

	public void printTimeinAir() {
		double timeInAir;
		for (Jet jet : allJets) {
			String model = jet.getModel();
			double speed = jet.getSpeed();
			int range = jet.getRange();
			timeInAir = range / speed;
			System.out.print(model + ":\t");
			System.out.printf("%.2f", timeInAir);
			System.out.println(" hours");
		}
		System.out.println();
	}

	public void getFastest() {
		Jet fastestJet = null;
		double fastestSpeed = 0;
		double convertToMach = 0;
		for (Jet jet : allJets) {
			if (fastestSpeed < jet.getSpeed()) {
				fastestSpeed = jet.getSpeed();
				fastestJet = jet;
			}
		}
		System.out.println(fastestJet);
		System.out.println(fastestJet.getModel() + " " + fastestSpeed + " mph");
		fastestJet.getSpeedInMach();
	}

	public void getLongest() {
		Jet longestRangeJet = null;
		double longestRange = 0;

		for (Jet jet : allJets) {
			if (longestRange < jet.getRange()) {
				longestRange = jet.getRange();
				longestRangeJet = jet;
			}
		}
		System.out.println(longestRangeJet);
		System.out.println(longestRangeJet.getModel() + " " + longestRange + " miles \n");
	}

	public void loadCargo() {
		for (Jet jet : allJets) {
			String type = jet.getType();
			if (type.equals("cargo")) {
				System.out.println(jet.getModel() + ":");
			}
			if (jet instanceof CargoCarrier) {
				((CargoCarrier) jet).loadCargo();
				((CargoCarrier) jet).countWeight();
				((CargoCarrier) jet).measureEmptySpace();
			}
		}
	}

	public void dogfight() {
		for (Jet jet : allJets) {
			String type = jet.getType();
			if (type.equals("fighter")) {
				System.out.println(jet.getModel() + ":");
			}
			if (jet instanceof FighterJet) {
				((FighterJet) jet).fight();
				((FighterJet) jet).maneuvers();
				((FighterJet) jet).refuel();
			}
		}
	}

	public void addJet(Scanner input) {
		Jet newJet = null;
		System.out.print("\nEnter a Jet. Please use valid alphanumeric characters. Name: ");
		String model = input.next();
		System.out.print("Speed (value only, no units): ");
		Double speed = input.nextDouble();
		System.out.print("Range (integer value only, no units): ");
		int range = input.nextInt();
		System.out.print("Price: $");
		Long price = input.nextLong();
		System.out.print("Please type \"cargo\" or \"fighter\": ");
		String type = input.next();
		newJet = new JetImpl(model, speed, range, price, type);
		allJets.add(newJet);
		System.out.println();
		System.out.println("New inventory: ");
		printAllJets();
		System.out.println();
	}

	public void removeJet(Scanner input) {
		System.out.println("Please choose a jet to remove. If you remove all jets and then try");
		System.out.println("to remove another from the empty inventory, this won't work.");
		System.out.println("Select a number below:");
		for (int index = 0; index < allJets.size(); index++) {
			System.out.println((index + 1) + " " + allJets.get(index).getModel());
		}
		int choice = input.nextInt();
		allJets.remove(choice - 1);
		System.out.println("New inventory: ");
		printAllJets();
		System.out.println();
	}

}
