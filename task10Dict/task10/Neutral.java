
public class Neutral implements GearBoxState{
	public void changeGear(Car car) {
		System.out.println("Gearbox changed to Neutral");
		car.Break(car);
	}
}
