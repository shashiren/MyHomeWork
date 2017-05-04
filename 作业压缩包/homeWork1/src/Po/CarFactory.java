package Po;

import Interface.Car;
import Interface.Factory;

public class CarFactory implements Factory<Car> {

	@Override
	public Car made(Class<? extends Car> Type) {
		// TODO Auto-generated method stub
		try {
			return Type.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
