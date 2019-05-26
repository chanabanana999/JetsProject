package com.skilldistillery.jets;

import java.util.ArrayList;
import java.util.List;

public abstract class Jet {

	private String model;
	private double speed;
	private int range;
	private long price;
	private String type;
	private double timeInAir;

	public Jet(String model, double speed, int range, long price, String type) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
		this.type = type;
	}

	public double fly(double speed, int range) {
		this.timeInAir = range / speed;
		return timeInAir;
	}

	public void getSpeedInMach() {
//		Mach is airplane speed in mph / 767.269
		double machSpeed = this.speed / 767.269;
		System.out.print("Speed in mach: ");
		System.out.printf("%.2f %n%n", machSpeed);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Jet [model=");
		builder.append(model);
		builder.append(", speed=");
		builder.append(speed);
		builder.append(", range=");
		builder.append(range);
		builder.append(", price=");
		builder.append(price);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getTimeInAir() {
		return timeInAir;
	}

	public void setTimeInAir(double timeInAir) {
		this.timeInAir = timeInAir;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + (int) (price ^ (price >>> 32));
		result = prime * result + range;
		long temp;
		temp = Double.doubleToLongBits(speed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Jet other = (Jet) obj;
		if (model == null) {
			if (other.model != null) {
				return false;
			}
		} else if (!model.equals(other.model)) {
			return false;
		}
		if (price != other.price) {
			return false;
		}
		if (range != other.range) {
			return false;
		}
		if (Double.doubleToLongBits(speed) != Double.doubleToLongBits(other.speed)) {
			return false;
		}
		return true;
	}
}
