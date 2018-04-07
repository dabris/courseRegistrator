
public class Course implements DirectlyRelatable {
	private String courseID, courseName, preReqID, coReqID;
	private double credit;

	/* Implemented method **/
	public boolean isDirectlyRelated(Course c) {
		return (c.courseID==preReqID||c.courseID==coReqID);
	}

	/* mutators and accessors **/
	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getPreReqID() {
		return preReqID;
	}

	public void setPreReqID(String preReqID) {
		this.preReqID = preReqID;
	}

	public String getCoReqID() {
		return coReqID;
	}

	public void setCoReqID(String coReqID) {
		this.coReqID = coReqID;
	}

	public double getCredit() {
		return credit;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

	/* 5 parameter constructor **/
	public Course(String courseID, String courseName, int credit, String preReqID, String coReqID) {
		this.courseID = courseID;
		this.courseName = courseName;
		this.credit = credit;
		this.preReqID = preReqID;
		this.coReqID = coReqID;
	}

	/* copy constructor **/
	public Course(Course c, String courseID) {
		this.courseID = courseID;
		if (c!=null) {
		courseName = c.courseName;
		credit = c.credit;
		preReqID = c.preReqID;
		coReqID = c.coReqID;}
	}

	/* clone method **/
	public Course clone(String courseID) {
		return new Course(this, courseID);
	}

	/* toString method **/
	public String toString() {
		return "Course information\nCourse ID: " + courseID + "\nCourse name: " + courseName + "\nCredit: " + credit
				+ "\nPrerequisite ID: " + preReqID + "\nCorequisite ID: " + coReqID;
	}

	/* equals method **/
	@Override
	public boolean equals(Object c) {
		if ( c == null || this.getClass() != c.getClass()) {
			return false;
		}else {
			Course y=(Course) c;
			return(courseName==y.courseName&&credit==y.credit&&preReqID==y.preReqID&&coReqID==y.coReqID);
		}
	}
	
}
