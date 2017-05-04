package Po;

import Interface.Car;

public class TruckCar implements Car {
	double price=100000.00;
	@Override
	public void run() {
		System.out.print("this is TruckCar!");
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
