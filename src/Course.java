
public class Course implements DirectlyRelatable {
	String courseID, courseName, preReqID, coReqID;
	double credit;
	/*Implemented method**/
	public boolean isDirectlyRelated(Course C) {
		return true;
	}
	
	
	
/*mutators and accessors**/
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
	/*5 parameter constructor**/
	public Course(String courseID,String courseName,int credit,String preReqID,String coReqID) {
		this.courseID=courseID;
		this.courseName=courseName;
		this.credit=credit;
		this.preReqID=preReqID;
		this.coReqID=coReqID;
	}
	/*copy constructor**/
	public Course(Course c, String courseID) {
		this.courseID=courseID;
		courseName=c.courseName;
		credit=c.credit;
		preReqID=c.preReqID;
		coReqID=c.coReqID;
	}
}
