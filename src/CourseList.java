import java.util.NoSuchElementException;

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
		// prevent crashing
		if (cList != null) {
			size = cList.size;
			if (cList.head == null) {
				head = null;
			} else {
				// pointer t1 to the new list
				// extra pointer t to navigate through old list
				CourseNode t = cList.head, t1;
				// clone head. of the original course list
				t1 = head = new CourseNode(t.c1.clone(t.c1.getCourseID()), null);
				// go through the list until t.next points to null
				while (t.next != null) {
					// move pointer of the original list
					t = t.next;
					// clone the new node
					t1.next = new CourseNode(t.c1.clone(t.c1.getCourseID()), null);
					// move pointer of the new list
					t1 = t1.next;
				}
				// make the temporary pointers point to null
				t = t1 = null;
			}
		}

	}

	/**
	 * toString
	 * 
	 * @return
	 */
	public String toString() {
		CourseNode t = head;
		String a = null;
		while (t != null) {
			if (a == null) {
				a = t.c1.toString();
			} else {
				a += t.c1.toString();
			}
			t = t.next;

		}
		return a;
	}

	public String getC1PReq(String courseID) {
		return (find(courseID).c1.getPreReqID());
	}

	public String getC1coReq(String courseID) {
		return (find(courseID).c1.getCoReqID());
	}

	/** addToStart method */
	public void addToStart(Course c) {
		// create node with value c that points to head
		CourseNode cn;
		if (c != null) {
			// in case c belongs to another course list, clone c
			cn = new CourseNode(c.clone(c.getCourseID()), head);
		} else {
			cn = new CourseNode(c, head);
		}
		// move head
		head = cn;
		// point cn to null
		cn = null;
		size++;
	}

	/** insertAtIndex method */
	public void insertAtIndex(Course c, int index) throws NoSuchElementException {
		CourseNode cn;
		if (index < 0 || index > size - 1) {
			throw new NoSuchElementException();
		} else {
			if (c == null) {
				cn = new CourseNode(c, null);
			} else {
				// clone c in case c belongs to another list
				cn = new CourseNode(c.clone(c.getCourseID()), null);
			}
			if (head == null) {
				head = cn;
				cn = null;
			} else {
				if (index > 0) {
					// create pointer t to navigate through the list,
					// and temp to store the value of the node at index of the original list
					CourseNode t = head, temp;
					if (index > 1) {
						// point the pointer t to index-1
						for (int i = 1; i < index; i++) {
							t = t.next;
						}
					}
					// store value at index of the original list
					temp = t.next;
					// insert new node
					t.next = cn;
					// add the value at index back to the list
					t.next.next = temp;
					// point all temporary pointers to null
					temp = t = cn = null;
				} else {
					// add c to start if index is 0
					addToStart(c);
				}
			}
			size++;
		}
	}

	/** deleteFromIndex method */
	public void deleteFromIndex(int index) throws NoSuchElementException {
		if (index < 0 || index > size - 1) {
			throw new NoSuchElementException();
		} else {
			// pointer to navigate through the list
			CourseNode t = head;
			if (t != null) {
				if (index == 0) {
					// remove first element
					head = head.next;
				} else {
					// go through list til index-1
					for (int i = 1; i < index; i++) {
						t = t.next;
					}
					// skip element at index
					t.next = t.next.next;
				}
				size--;
			} else {
				System.out.println("Nothing to delete");
			}
			t = null;
		}
	}

	/** deleteFromStart */
	public void deleteFromStart() {
		deleteFromIndex(0);
	}

	/** replaceAtIndex */
	public void replaceAtIndex(Course c, int index) {
		insertAtIndex(c, index);
		deleteFromIndex(index + 1);
	}

	/**
	 * find method this method will allow a security leak since it returns a pointer
	 * this pointer can be used to alternate the elements of the list
	 */
	public CourseNode find(String courseID) {
		// t pointer to navigate through list and found pointer that points to the
		// courseNode found
		CourseNode t = head, found = null;
		while (t != null) {
			if (t.c1.getCourseID().equals(courseID)) {
				found = t;
				break;
			}
			t = t.next;
		}
		if (found == null) {
			System.out.println("Course not found");
		}
		t = null;
		return found;

	}

	/** contains method */
	public boolean contains(String courseID) {
		CourseNode t = head;
		while (t != null) {
			if (t.c1.getCourseID().equals(courseID)) {
				t = null;
				return true;
			} else {
				t = t.next;
			}
		}
		t = null;
		// if it breaks out of the while loop, then the course is not found
		return false;
	}

	/** equals method */
	public boolean equals(CourseList cL) {

		if (cL == null) {
			return false;
		} else {
			// copy CourseList to manipulate without affecting the original one
			CourseList temp = new CourseList(cL);
			if (temp.size != size) {
				return false;
			} else {
				CourseNode t = head;
				while (t != null) {
					CourseNode t1 = temp.head;
					for (int i = 0; i < temp.size; i++) {
						if (i == 0 && t1.c1.equals(t.c1)) {
							temp.deleteFromStart();
						} else if (t1.c1.equals(t.c1)) {
							t1.next = t1.next.next;
							temp.size--;
						}
						t1 = t1.next;
					}
					t = t.next;
				}
				t = null;
				if (temp.size == 0) {
					temp = null;
					return true;
				} else {
					temp = null;
					return false;
				}
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
			if (cn != null) {
				if (cn.c1 != null) {
					// clone cn's course object
					c1 = cn.c1.clone(cn.c1.getCourseID());
				} else {
					c1 = null;
				}
				if (cn.next != null) {
					CourseNode t = cn;
					CourseNode h, t1;
					// head and pointer t1 at t.next(clone t.next)
					t1 = h = new CourseNode(t.next.c1.clone(t.next.c1.getCourseID()), null);

					while (t.next != null) {
						t = t.next;
						t1.next = new CourseNode(t.next.c1.clone(t.next.c1.getCourseID()), null);
						t1 = t1.next;
					}
					next = h;
					h = t1 = t = null;
				} else {
					next = null;
				}
			}
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
