package Po;

import Interface.Car;

public class SportsCar implements Car {
	double price=500000.00;
	@Override
	public void run() {
		System.out.print("this is SportsCar!");
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
