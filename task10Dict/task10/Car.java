
public class Car{
	GearBoxState state;
	boolean moving = false;
	public Car() {
		state = new Park();
	}
	public void setState(GearBoxState g) {
		this.state = g;
	}

	public void changeGear() {
		state.changeGear(this);
	}
	void Gas(Car car) {
		car.moving = true;
	}
	void Break(Car car) {
		car.moving = false;
	}
}
