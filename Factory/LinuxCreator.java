public class LinuxCreator implements Creator{
	public OS createOS(){
		return new Linux();
	}
}