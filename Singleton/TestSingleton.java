public class TestSingleton {
	public static void main(String args[]){
		System.out.println("run");
		Thread first = new Thread(){
			public void run(){
				System.out.println("t1");
				LoggerSingleton logger1 = LoggerSingleton.getInstance();
				System.out.println("t1 end");
				logger1.logError("11111", "HIGH");
				logger1.logConnection("100.10.0.82", "18:12");
				logger1.logChange("Folder bin", "00:42");
			}
		};

		Thread second = new Thread(){
			public void run(){
				LoggerSingleton logger2 = LoggerSingleton.getInstance();
				logger2.logError("11251", "LOW");
				logger2.logConnection("122.10.0.7", "11:36");
			}
		};

		Thread third = new Thread(){
			public void run(){
				LoggerSingleton logger3 = LoggerSingleton.getInstance();
				logger3.logConnection("28.100.0.19", "06:37");
				logger3.logChange("File exam.txt", "07:44");
			}
		};			
		
		first.start();
		second.start();
		third.start();	
	}
}
 