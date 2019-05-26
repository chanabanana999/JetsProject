package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, int range, long price, String type) {
		super(model, speed, range, price, type);
	}

	@Override
	public void fight() {
		System.out.println("\tThis plane does fight-y things. Bang, bang!");
	}

	@Override
	public void maneuvers() {
		System.out.println("\tNow I'm doing crazy maneuvers. My pilot just threw up.");
	}

	@Override
	public void refuel() {
		System.out.println("\tOutta gas! Refueling....\n");
	}

}
