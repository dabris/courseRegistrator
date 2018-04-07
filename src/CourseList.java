
public class CourseList {
	private CourseNode head;
	private int size;

	/** default constructor */
	public CourseList() {
		head = null;
		size = 0;
	}

	/** copy constructor */
	public CourseList(CourseList cList) {
		//prevent crashing
		if (cList != null) {
			size = cList.size;
			//pointer n to the new list
			//extra pointer t to navigate through old list
			CourseNode n, t=cList.head;
			//go through the list until t points to null
			while(t!=null) {
				n=new CourseNode(t.c1.clone(t.c1.getCourseID()), null);
				t=t.next;
			}
			

		}

	}

	/** inner class CourseNode */
	private class CourseNode {
		private Course c1;
		private CourseNode next;

		/** defaut constructor */
		public CourseNode() {
			c1 = null;
			next = null;
		}

		/** parametrized constructor */
		public CourseNode(Course c1, CourseNode next) {

			this.c1 = c1;
			this.next = next;
		}

		/** copy constructor */
		public CourseNode(CourseNode cn) {
			c1 = cn.c1;
			next = cn.next;
		}

		/** clone method */
		public CourseNode clone() {
			return new CourseNode(this);
		}

		/** accessors and mutators */
		public Course getC1() {
			return c1;
		}

		public void setC1(Course c1) {
			this.c1 = c1;
		}

		public CourseNode getNext() {
			return next;
		}

		public void setNext(CourseNode next) {
			this.next = next;
		}

	}
}
