package coursesRegistration.scheduler;

import java.util.Comparator;

public class SortStudentsByYear implements Comparator<Student> 
{ 
    public int compare(Student a, Student b) 
    { 
        return b.getLevel().getYear() - a.getLevel().getYear(); 
    } 
} 

