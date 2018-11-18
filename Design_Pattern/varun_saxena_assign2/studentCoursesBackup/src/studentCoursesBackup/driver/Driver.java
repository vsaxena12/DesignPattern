package studentCoursesBackup.driver;

import java.util.HashMap;
import java.util.ArrayList;

import studentCoursesBackup.myTree.TreeBuilder;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.StdoutDisplayInterface;
import studentCoursesBackup.util.FileDisplayInterface;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.myTree.ObserverI;
import studentCoursesBackup.myTree.SubjectI;

/**
 * @author Varun Saxena
 *
 */
public class Driver {
	public static void main(String[] args)throws Exception
	{
		String strInput=null;
		String strDelete=null;
		String strOutput1=null;
		String strOutput2=null;
		String strOutput3=null;

		try{
			if (args.length != 5 && args[0].equals("${arg0}") && args[1].equals("${arg1}") && args[2].equals("${arg2}") && args[3].equals("${arg3}") && args[4].equals("${arg4}")) {

				System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
				System.exit(0);
			}

			else if(args.length == 5)
			{
				if(args[0].endsWith(".txt") && args[1].endsWith(".txt") && args[2].endsWith(".txt") && args[3].endsWith(".txt") && args[4].endsWith(".txt"))
				{

					System.out.println("Hello World! Lets get started with the assignment");

					System.out.println(args[0]+"\n"+args[1]+"\n"+args[2]+"\n"+args[3]+"\n"+args[4]+"\n");
					strInput=args[0];
					strDelete=args[1];
					strOutput1=args[2];
					strOutput2=args[3];
					strOutput3=args[4];

					String inputString=null;
					String str;
					//FileProcessor fProcess = new FileProcessor();
					//fProcess.readInputFile(inputString);

					TreeBuilder myTreeBuilder = new TreeBuilder(args[0],args[1]);
					Results input = new Results(args[0]);
					Results delete = new Results(args[1]);
					Results output1 = new Results(args[2]);
					Results output2 = new Results(args[3]);
					Results output3 = new Results(args[4]);

					output1.stdOutDisplayInterface("Output 1:");
					output1.storeResult(myTreeBuilder.getTree(0).printNodes()); //Print Data into files
					output1.fileDisplayInterface();
					output1.stdOutDisplayInterface(myTreeBuilder.getTree(0).printNodes()); //Print Console
					System.out.println("--------------------------------------------------------------------");
					output2.stdOutDisplayInterface("Output 2:");
					output2.storeResult(myTreeBuilder.getTree(1).printNodes());
					output2.fileDisplayInterface();
					output2.stdOutDisplayInterface(myTreeBuilder.getTree(1).printNodes());
					System.out.println("--------------------------------------------------------------------");
					output3.stdOutDisplayInterface("Output 3: ");
					output3.storeResult(myTreeBuilder.getTree(2).printNodes());
					output3.fileDisplayInterface();
					output3.stdOutDisplayInterface(myTreeBuilder.getTree(2).printNodes());

				}
			}

			else{
				System.out.println("Wrong file type!");
				System.exit(0);
			}

		}

		catch(RuntimeException e){
			System.out.println("Error: "+e.toString());
			System.exit(1);
		}
	}
}


///home/codestack/Desktop/Design_Patterns/Assignment_2/TestCase/input_file.txt
/**
 *Issues with driver code
 *Does not display error message while parsing more arguments than needed-Validation requires
 */