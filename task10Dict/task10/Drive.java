
public class Drive implements GearBoxState {
	public void changeGear(Car car) {
		System.out.println("Gearbox changed to Drive");
		car.Gas(car);
	}
}
