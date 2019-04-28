package edu.handong.analysis;
import java.lang.String;
import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;
 
class HGUCoursePatternAnalyzer {
    private String[] lines = {
    		"1999-1, JC Nam, Java Programming",
    		"1999-2, JC Nam, Programming Language Theory",
            "1999-1, JC Nam, Data Structures",
            "2001-1, JC Nam, Database Systems",
            "2018-1, SB Lim, Java Programming",
            "2018-2, SB Lim, Programming Language Theory",
            "2019-1, SB Lim, Data Structures",
            "2019-1, SB Lim, Algorithm Analysis",
            "2018-1, SJ Kim, Java Programming",
            "2018-2, SJ Kim, Programming Language Theory",
            "2019-1, SJ Kim, Logic Design",
            "2019-1, SJ Kim, Algorithm Analysis",
            };

    private int numOfStudents;
    private int numOfCourses;
    Student[] students;
    Course[] courses;
    public int cnt;

    /**
     * This method runs our analysis logic to get the list of student and course
     * names from lines.
     * 
     * @param args
     */
    public void run(String[] args) {
        numOfStudents = Integer.parseInt(args[0]);
        numOfCourses = Integer.parseInt(args[1]);

        initiateStudentArrayFromLines(lines);
        initiateCourseArrayFromLines(lines);

        System.out.println("Number of All Students: " + numOfStudents);
 
        for(int t = 0; t < students.length; t++)
        {
        	cnt = t;
        	if(!(studentExist(students, students[t])))
        	{
        		System.out.println(students[t].getName());
        	}
        }
        System.out.println("Number of All Courses: " + numOfCourses);
        for(int t = 0; t < courses.length; t++)
        {
        	cnt = t;
        	if(!(courseExist(courses, courses[t])))
        	{
        		System.out.println(courses[t].getCourseName());
        	}
        }
    }
    
    /**
     * This method returns a Student array to initiate the field, students, from
     * lines.
     * 
     * @param lines
     * @return
     */
    private Student[] initiateStudentArrayFromLines(String[] lines) {
    	students = new Student[lines.length];
        for (int i = 0; i < lines.length; i++) {
            students[i] = new Student(lines[i].substring(lines[i].indexOf(", ")+2, lines[i].lastIndexOf(", ")));
        }
        return null;
    }
    
    /**
     * This method check if there is the same name of the second argument in the
     * array, students
     * 
     * @param students
     * @param student
     * @return boolean
     */
    private boolean studentExist(Student[] students, Student student) {
    	for(int i = cnt-1; i > -1; i--)
    	{
    		if(students[i].getName().equals(student.getName()))
    		{
    			return true;
   			}
    		else
    		{
    			continue;
    		}
    	}
    	
    	return false;
    }
    
    /**
     * This method returns a Course array to initiate the field, courses, from
     * lines.
     * 
     * @param lines
     * @return
     */
    private Course[] initiateCourseArrayFromLines(String[] lines) {
        courses= new Course[lines.length];
        for (int i = 0; i < lines.length; i++) {
            courses[i] = new Course(lines[i].substring(lines[i].lastIndexOf(", ")+2, lines[i].length()));
        }
        
        for (int i = 0; i < courses.length; i++) {
            courseExist(courses, courses[i]);
        }
        
        return null;
    }
    
    /**
     * This method check if there is the same name of the second argument in the
     * array, courses.
     * 
     * @param courses
     * @param course
     * @return boolean
     */
    private boolean courseExist(Course[] courses, Course course) {
    	for(int i = cnt-1; i > -1; i--)
    	{
    		if(courses[i].getCourseName().equals(course.getCourseName()))
    		{
    			return true;
   			}
    		else
    		{
    			continue;
    		}
    	}
        return false;
    }
}