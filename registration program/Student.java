import java.util.ArrayList;

public class Student {
  private String id;
  private String name;
  private ArrayList<Course> courses; // contains all courses the student is registered in

  /**
   * constructor
   * @param id
   * @param name
   */
  public Student(String id, String name) 
  {
	  setId(id);
	  setName(name);
	  createCourseList();
  }
  public void createCourseList()
  {
	  courses = new ArrayList<Course>();
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
   * @return name
   */
  public String getName() {
	  return this.name;
  }

  /**
   * getter method
   * @return id
   */
  public String getId()
  {
	  return this.id;
  }
  /**
   * getter method
   * @return courses list
   */
  public ArrayList<Course> getCourses()
  {
	  return this.courses;
  }


  /**
   * toString
   */
  public String toString() {
     // return a string representation of a student using the following format:
     // 100234546 John McDonald
     // Registered courses: ELEE 2110, ELEE 2790, SOFE 2710, SOFE 2800, SOFE 2850
	  return getId()+" "+getName();
  }

  /**
   * register course
   * @param course
   */
public void registerFor(Course c) 
{
	
	if(!isCourseExist(c))//if course not exist
	{
		courses.add(c);//course registration
		c.getDept().registerStudent(this);// assign student to dept
		c.insertCourseInClass(c);//assign course to class
	}
}

/**
 * help method to check course exist or not
 * @return true or false
 */
public boolean isCourseExist(Course c)
{

		for(int i=0;i<courses.size();i++)
		{
			if(courses.get(i) == c)
				return true;
		}
	return false;
}

/**
 * isRegisteredInCourse
 * @param course
 * @return return true if student register for given course else return false
 */
public boolean isRegisteredInCourse(Course c) 
{
	for(int i=0;i<courses.size();i++)
	{
		if(c == courses.get(i))
			return true;
	}
	return false;
}
}
