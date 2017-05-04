package Po;

import Interface.Car;

public class CoachCar implements Car {
	double price=200000.00;
	@Override
	public void run() {
		System.out.print("this is CoachCar!");
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {this.price = price;}
}
