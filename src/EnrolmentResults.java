
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class EnrolmentResults {
	public static void main(String args[]) {
		CourseList cL1 = new CourseList();
		CourseList cL2 = new CourseList(cL1);
		Scanner sc = null;
		try {
			sc = new Scanner(new File("C:\\Users\\Dabris\\Desktop\\workspace\\249A4\\Syllabus.txt"));
			while (sc.hasNextLine()) {
				String ID = sc.next();
				String name = sc.next();
				double credit = sc.nextDouble();
				sc.nextLine();
				String preReq = sc.nextLine();
				String temp[] = preReq.split("\\s+");
				if (temp.length < 2) {
					preReq = null;
				} else {
					preReq = temp[1];
				}
				String coReq = sc.nextLine();
				String temp1[] = coReq.split("\\s+");
				if (temp1.length < 2) {
					coReq = null;
				} else {
					coReq = temp1[1];
				}
				if (!cL1.contains(ID))
					cL1.addToStart(new Course(ID, name, credit, preReq, coReq));
			}

		} catch (FileNotFoundException e) {
			sc.close();
			e.getMessage();
		}
		sc.close();
		System.out.println(cL1.toString());

		Scanner key = new Scanner(System.in), reqSc = null;
		System.out.println("Please enter the path of the file that you wish to read");
		String fName = key.next();
		try {
			reqSc = new Scanner(new File(fName));
			// reads "finished"
			reqSc.nextLine();
			ArrayList<String> cDone = new ArrayList<String>();
			ArrayList<String> cReq = new ArrayList<String>();
			String finished = reqSc.nextLine();
			String requested = null;
			while (reqSc.hasNextLine()) {
				while (!finished.equalsIgnoreCase("requested")) {
					// add all courses that ared finished
					cDone.add(finished);
					// find requested in document
					finished = reqSc.nextLine();
				}
				requested = reqSc.nextLine();
				cReq.add(requested);
			}

		} catch (FileNotFoundException e) {
			reqSc.close();
			e.getMessage();
		}
		sc.close();
	}
}
