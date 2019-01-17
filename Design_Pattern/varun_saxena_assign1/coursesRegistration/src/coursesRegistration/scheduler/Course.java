package coursesRegistration.scheduler;

public class Course {
	private char name;
	private int capacity;
	private int timing;

	public Course(char courseInfo, int capacity, int timing) {
		super();
		this.name = courseInfo;
		this.capacity = capacity;
		this.timing = timing;
	}

	public char getCourseInfo() {
		return name;
	}

	public void setCourseInfo(char courseInfo) {
		this.name = courseInfo;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getTiming() {
		return timing;
	}

	public void setTiming(int timing) {
		this.timing = timing;
	}

	@Override
	public String toString() {
		return "Course [courseInfo=" + name + ", capacity=" + capacity + ", timing=" + timing + "]";
	}

}
