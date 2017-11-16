import java.util.ArrayList;

public class Department {
private String name; // the name of school “Dept of Computing and Info Science”
private String id; // short name for courses “SOFE”, “ELEE”, “STAT”, etc
ArrayList<Course> courseList; // all courses offered by the department
ArrayList<Student> registerList; // all students taking courses in the department.

/**
 * constructor
 * @param name
 * @param id
 */
public Department(String name, String id)
{
	setName(name);
	setId(id);
	initiateList();
}
public void initiateList()
{
	courseList = new ArrayList<Course>();
	registerList = new ArrayList<Student>();
}
/**
 * setter method
 * @param name
 */
public void setName(String str)
{
	name = str;
}
/**
 * setter method
 * @param id
 */
public void setId(String str)
{
	id = str;
}
/**
 * getter method
 * @return dept name
 */
public String getName()
{
	return this.name;
}
/**
 * getter method
 * @return dept id
 */
public String getId() 
{
	return this.id;
}

/**
 * regiserStudent
 * @param student
 */
public void registerStudent(Student student)
{
	if(!isStudentExist(student))//if student not register already then register it
		registerList.add(student);	
}
/**
 * helper function to check student exist or not
 * @return true or false
 */
public boolean isStudentExist(Student std)
{
	for(int i=0;i<registerList.size();i++)
	{
		if(registerList.get(i).equals(std))
			return true;
	}	
	return false;
}

public String toString() {
// returns a string representation of department name, number
// of courses offered and number of students registered in the
// department. Use the format:
// ECSE: 53 courses, 460 students
	return this.getId()+" "+courseList.size()+" courses, "+registerList.size()+" students";
	
}
/**
 * offerCourse
 * @param course
 */
public void offerCourse(Course course) 
{
	courseList.add(course);
}
/**
 * 
 * @param code
 */
public void printStudentsRegisteredInCourse(int code) 
{
	
	int i=0,j=0;
	while(i<registerList.size())
	{
		j = 0;
		while(j<registerList.get(i).getCourses().size())
		{
			int number = registerList.get(i).getCourses().get(j).getNumber();
			if(number == code)
			{
				System.out.printf("%s %s\n",registerList.get(i).getId(),registerList.get(i).getName());//display student 
			}	
			j++;
		}
		i++;
	}
	
}
/**
 * isStudentRegister
 * @param student 
 * @return true if student register
 */
public boolean isStudentRegistered(Student s) 
{
	for(Student ss: this.registerList)
	{
		if(ss.equals(s))
			return true;
	}
	
	return false;
}
public void printStudentsByName() 
{	
	System.out.printf("%s\n",registerList.toString());
}

public String largestCourse() 
{
	int largest = courseList.get(0).getClassList().size();
	int index = 0;
	for(int i=0;i<courseList.size();i++)
	{
		if(largest < courseList.get(i).getClassList().size())
        {
            largest = courseList.get(i).getClassList().size();
            index = i;
        }
	}
	return courseList.get(index).getClassList().get(0).toString();
}
public void printCoursesOffered() 
{
	for(int i=0;i<courseList.size();i++)
		System.out.printf("%s\n",courseList.get(i).toString());
}
}