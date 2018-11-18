package coursesRegistration.util;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	public void stdOutDisplayInterface(String msg){
		System.out.println(msg);
	}
	public void fileDisplayInterface(String msg){
		FileProcessor.writeMessage(msg);
	}
}
