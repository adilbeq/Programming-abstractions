public class Test{
	public static void main(String[] args) {
		String myOS = System.getProperty("os.name").toLowerCase();
		//System.out.println(myOS);
		Creator create = getOS(myOS);
//		Creator create = getOS("mac");
//		Creator create = getOS("linux");

		OS os = create.createOS();
		os.createButton();
		os.createCommandLine();
		os.createDesktop();
		os.createControlPanel();
		os.createFolder();
	}

	public static Creator getOS(String os){
		if(os.indexOf("win") >= 0){
			return new WindowsCreator();
		}
		if(os.indexOf("mac") >= 0){
			return new MacCreator();
		}
		if(os.indexOf("lin") >= 0){
			return new LinuxCreator();
		}
		throw new RuntimeException("No such OS: " + os);
	}
}