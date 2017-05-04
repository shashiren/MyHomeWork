package Imp;

import Interface.Car;
import Interface.Factory;
import Po.CarFactory;
import Po.CoachCar;
import Po.SportsCar;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factory<Car> carFactory = new CarFactory();
		Car car2 =carFactory.made(SportsCar.class);
		Car car1 =carFactory.made(CoachCar.class);
		car1.run();
		car2.run();
	}

}
