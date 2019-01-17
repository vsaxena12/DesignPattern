package coursesRegistration.driver;

import java.util.HashMap;
import java.util.ArrayList;

import coursesRegistration.util.FileProcessor;
import coursesRegistration.util.StdoutDisplayInterface;
import coursesRegistration.util.FileDisplayInterface;
import coursesRegistration.util.Results;
import coursesRegistration.scheduler.Scheduler;
import coursesRegistration.scheduler.Student;
import coursesRegistration.scheduler.Course;
/**
 * @author John Doe
 *
 */
public class Driver {

	static Results logger = new Results();

	public static void main(String[] args) {
		/*
		 * As the build.xml specifies the arguments as argX, in case the argument value
		 * is not given java takes the default value specified in build.xml. To avoid
		 * that, below condition is used
		 */
		if (args.length != 2 || args[0].equals("${arg0}") || args[1].equals("${arg1}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 2 argumnets.");
			System.exit(0);
		}

		String strStudentPrefCourseInputFile = args[0], strCourseDetailsFile = args[1];
		FileProcessor fileProcessor;
		HashMap<Character, Course> hmapCourses;
		ArrayList<Student> students;
		Scheduler scheduler;
		String allocationResult;

		try {
			startProgram();

			validateProgramArguments(args);

			fileProcessor = new FileProcessor();

			// read course
			hmapCourses = fileProcessor.readCourses(strCourseDetailsFile);

			if (hmapCourses.size() == 0) {
				logger.stdOutDisplayInterface("No courses found.");
				Driver.endProgram(1);
			} else {
				logger.stdOutDisplayInterface(hmapCourses.size() + " courses found");
				students = fileProcessor.readStudentsPref(strStudentPrefCourseInputFile, hmapCourses);

				if (students.size() == 0) {
					logger.stdOutDisplayInterface("No students found.");
					Driver.endProgram(1);
				} else {
					logger.stdOutDisplayInterface(students.size() + " students found.");
					scheduler = new Scheduler();
					allocationResult = scheduler.scheduleCourses(hmapCourses, students);

					logger.fileDisplayInterface(allocationResult);
					logger.stdOutDisplayInterface(allocationResult);

					Driver.endProgram(0);
				}
			}
		} catch (Exception e1) {
			logger.stdOutDisplayInterface("Error:" + e1.toString());
			Driver.endProgram(1);
		}
	}

	//
	private static String[] validateProgramArguments(String[] args) {
		try {
			if (args.length != 2 || args[0].equals("${arg0}") || args[1].equals("${arg1}")) {
				logger.stdOutDisplayInterface("Error: Incorrect number of arguments. Program accepts 2 argumnets.");
				endProgram(1);
			} else {
				if (args[0].endsWith(".txt") && args[1].endsWith(".txt")) {
					logger.stdOutDisplayInterface("Input files to be read :" + args[0] + ", " + args[1]);
				} else {
					logger.stdOutDisplayInterface("Wrong file type!");
					endProgram(1);
				}
			}
		} catch (Exception e1) {
			logger.stdOutDisplayInterface("Error:" + e1.toString());
			Driver.endProgram(1);
		}
		return args;
	}
	
	//
	public static void endProgram(int status) {
		logger.stdOutDisplayInterface("Program end");
		System.exit(status);
	}

	public static void startProgram() {
		logger.stdOutDisplayInterface("Hello World! Lets get started with the assignment");
		logger.stdOutDisplayInterface("Program start");
	}
}
