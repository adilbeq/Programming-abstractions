
public class Reverse implements GearBoxState{
	public void changeGear(Car car) {
		System.out.println("Gearbox changed to Reverse");
		car.Gas(car);
	}
}
