package coursesRegistration.scheduler;

public enum StudentLevel {
	FIRST_YEAR(1), 
	SECOND_YEAR(2), 
	THIRD_YEAR(3);
	
    private final int year;

    private StudentLevel(int year) {
        this.year = year;
    }
    
    public int getYear() {
        return this.year;
    }

}
