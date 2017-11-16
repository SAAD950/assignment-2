import java.util.ArrayList;

public class Course {
   private Department dept;
   private String title; // title of the course (e.g. “Intro to programming”);
   private String code; // course code, e.g. SOFE, ELEE, MANE, etc.
   private int number; // course number, e.g. 1200, 2710, 2800, etc.
   ArrayList<Course> classList; // contains all students registered in this course


   //constructor
   public Course(String code, int number, Department dept, String title) 
   {
	   setCode(code);
	   setNumber(number);
	   setDept(dept);
	   setTitle(title);
	   createList();
   }
   /**
    * setter method
    * @param code
    */
   public void setCode(String c)
   {
	   code = c;
   }
   /**
    * setter method
    * @param number
    */
   public void setNumber(int n)
   {
	   number = n;
   }
   /**
    * setter method
    * @param dept
    */
   public void setDept(Department d)
   {
	   dept = d;
   }
   /**
    * setter method
    * @param title
    */
   public void setTitle(String t)
   {
	   title = t;
   }
   /**
    * setter method
    * create class list
    */
   public void createList()
   {
	   classList = new ArrayList<Course>();
   }

   /**
    * insertCourserInClass
    * @param course
    */
   public void insertCourseInClass(Course c)
   {
	   classList.add(c);
  }
   /**
    * getter method
    * @return class list
    */
   public ArrayList<Course> getClassList()
   {
	   return classList;
   }
   /**
    * getter method
    * @return department
    */
   public Department getDept() 
   {
	   return this.dept;
   }
   /**
    * getter method
    * @return title
    */
  public String getTitle()
  {
	  return title;
  }
   /** 
    * getter method
    * @return course code
    */
   public String getCode() 
   {
	   return this.code;
   }

   /**
    * getter method
    * @return course number
    */
 public int getNumber()
 {
 	return this.number;
 }
  public String toString() {
     // return a string representation of the course with the course code,
     // name, and number of people registered in the course in the following
     // format:
     // SOFE 2710 Object Oriented Programming and Design, Enrollment = 260
	  
	  return getCode()+" "+getNumber()+ " "+getTitle()+", Enrollment = "+getClassList().size();
  }


}
