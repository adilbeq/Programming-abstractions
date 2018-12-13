public class MacCreator implements Creator{
	public OS createOS(){
		return new MacOS();
	}
}