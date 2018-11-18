package coursesRegistration.scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


import coursesRegistration.driver.Driver;
import coursesRegistration.scheduler.Course;
import coursesRegistration.scheduler.SortStudentsByYear;
import coursesRegistration.scheduler.Student;
import coursesRegistration.util.Results;

public class Scheduler {
	static Results logger = new Results();

	public String scheduleCourses(HashMap<Character, Course> hmapCourses, ArrayList<Student> students) {

		String allocatedResult = null;
		try {

			// sort students based on year
			students = sortStudentsOnYear(students);

			// Allocating courses to each student
			for (Student student : students) {
				Course[] preferences = student.getPreferences();
				for (Course course : preferences) {
					if (student.getCoursesAllocated().size() == 3) {
						break;
					} else if (course.getCapacity() > 1) {
						course.setCapacity(course.getCapacity() - 1);
						student.getCoursesAllocated().add(course);
					}
				}
			}

			allocatedResult = formatOutputOfAllocatedCourseToStudent(students);

			logger.stdOutDisplayInterface("Course allocated successfully");
		} catch (Exception e1) {
			logger.stdOutDisplayInterface("Error:" + e1.toString());
			Driver.endProgram(1);
		}

		return allocatedResult;

	}

	private String formatOutputOfAllocatedCourseToStudent(ArrayList<Student> students) {
		StringBuffer result = new StringBuffer();

		try {
			for (int i = 0; i < students.size(); i++) {
				Student stud = students.get(i);
				result.append(stud.getId()).append(":");
				for (int j = 0; j < stud.getCoursesAllocated().size(); j++) {
					result.append(stud.getCoursesAllocated().get(j).getCourseInfo()).append(",");
				}
				result.append("\n");
			}
		} catch (Exception e1) {
			logger.stdOutDisplayInterface("Error:" + e1.toString());
			Driver.endProgram(1);
		}
		return result.toString().replaceAll(",\n", "\n").trim();
	}

	private ArrayList<Student> sortStudentsOnYear(ArrayList<Student> students) {
		try {
			Collections.sort(students, new SortStudentsByYear());
		} catch (Exception e1) {
			logger.stdOutDisplayInterface("Error:" + e1.toString());
			Driver.endProgram(1);

		}
		return students;
	}
}
