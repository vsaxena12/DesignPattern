package coursesRegistration.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.BufferedWriter;


import coursesRegistration.driver.Driver;
import coursesRegistration.scheduler.Course;
import coursesRegistration.scheduler.Student;
import coursesRegistration.scheduler.StudentLevel;

public class FileProcessor {
	static Results logger = new Results();
	private static final String OUTPUT_FILENAME = "registration_results.txt";

	private BufferedReader getReader(String filename) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File(filename)));
		} catch (FileNotFoundException e) {
			logger.stdOutDisplayInterface("File not found ");
			Driver.endProgram(1);
		}
		return reader;
	}

	public HashMap<Character, Course> readCourses(String strCourseDetailsFile) {
		HashMap<Character, Course> hmapCourses = new HashMap<>();
		try {
			BufferedReader reader = getReader(strCourseDetailsFile);
			String line;

			if (reader != null) {
				// Read course
				while ((line = reader.readLine()) != null) {
					Course course = new Course(line.split("-")[0].trim().charAt(0),
							Integer.parseInt(line.split(";")[0].split(":")[1].trim()),
							Integer.parseInt(line.split(";")[1].split(":")[1].trim()));
					hmapCourses.put(course.getCourseInfo(), course);

				}
			}
		} catch (Exception e1) {
			logger.stdOutDisplayInterface("Error:" + e1.toString());
			Driver.endProgram(1);
		}
		return hmapCourses;
	}

	public ArrayList<Student> readStudentsPref(String strStudentPrefCourseInputFile,
			HashMap<Character, Course> hmapCourses) {
		ArrayList<Student> students = new ArrayList<>();
		try {
			BufferedReader reader = getReader(strStudentPrefCourseInputFile);
			String line;

			if (reader != null) {
				// Read students
				while ((line = reader.readLine()) != null) {
					students.add(new Student(line.substring(0, 3),
							StudentLevel.valueOf(line.split(";")[1].split(":")[1].trim()),
							Arrays.stream(line.split(";")[0].substring(3).split(","))
									.map(i -> hmapCourses.get(i.trim().charAt(0))).toArray(Course[]::new)));
				}
			}
		} catch (Exception e1) {
			logger.stdOutDisplayInterface("Error:" + e1.toString());
			Driver.endProgram(1);
		}
		return students;
	}

	public static void writeMessage(String msg) {
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(OUTPUT_FILENAME));
			writer.append(msg);
			writer.close();
		} catch (IOException e) {
			logger.stdOutDisplayInterface("Error:" + e.toString());
			Driver.endProgram(1);
		}
	}

}
