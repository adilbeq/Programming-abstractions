
public class Park implements GearBoxState{
	public void changeGear(Car car) {
		System.out.println("Gearbox changed to Park");
		car.Break(car);
	}
}
