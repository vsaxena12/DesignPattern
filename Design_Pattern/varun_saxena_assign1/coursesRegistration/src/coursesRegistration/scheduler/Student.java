package coursesRegistration.scheduler;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
	private String id;
	private StudentLevel level;
	private Course[] preferences;
	private ArrayList<Course> coursesAllocated;
	private int lastCourseCheckedPreferenceIndex;

	public Student(String id, StudentLevel level, Course[] courses) {
		super();
		this.id = id;
		this.level = level;
		this.preferences = courses;
		coursesAllocated = new ArrayList<>();
		lastCourseCheckedPreferenceIndex = -1;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public StudentLevel getLevel() {
		return level;
	}

	public void setLevel(StudentLevel level) {
		this.level = level;
	}

	public Course[] getPreferences() {
		return preferences;
	}

	public void setPreferences(Course[] preferences) {
		this.preferences = preferences;
	}

	public ArrayList<Course> getCoursesAllocated() {
		return coursesAllocated;
	}

	public void setCoursesAllocated(ArrayList<Course> coursesAllocated) {
		this.coursesAllocated = coursesAllocated;
	}

	public int getLastCourseCheckedPreferenceIndex() {
		return lastCourseCheckedPreferenceIndex;
	}

	public void setLastCourseCheckedPreferenceIndex(int lastCourseCheckedPreferenceIndex) {
		this.lastCourseCheckedPreferenceIndex = lastCourseCheckedPreferenceIndex;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", level=" + level + ", preferences=" + Arrays.toString(preferences)
				+ ", coursesAllocated=" + coursesAllocated + ", lastCourseCheckedPreferenceIndex="
				+ lastCourseCheckedPreferenceIndex + "]";
	}
}

