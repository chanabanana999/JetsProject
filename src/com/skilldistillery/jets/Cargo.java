package com.skilldistillery.jets;

public class Cargo extends Jet implements CargoCarrier {

	public Cargo(String model, double speed, int range, long price, String type) {
		super(model, speed, range, price, type);
	}

	@Override
	public void loadCargo() {
		System.out.println("\t....Loading stuff");
	}

	@Override
	public void countWeight() {
		System.out.println("\t....Weighing stuff");
	}

	@Override
	public void measureEmptySpace() {
		System.out.println("\t....Measuring empty air\n");
	}
}
