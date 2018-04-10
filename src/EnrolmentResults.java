
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EnrolmentResults {
	public static void main(String args[]) {
		CourseList cL1 = new CourseList();
		CourseList cL2 = new CourseList(cL1);
		Scanner sc;
		try {
			sc = new Scanner(new File("C:\\Users\\Dabris\\Desktop\\workspace\\249A4\\Syllabus.txt"));
			while (sc.hasNextLine()) {
				String ID=sc.next();
				String name=sc.next();
				double credit=sc.nextDouble();
				sc.nextLine();
				String preReq=sc.nextLine();
				String temp[]=preReq.split("\\s+");
				if (temp.length<2) {
					preReq=null;
				}else {
					preReq=temp[1];
				}
				String coReq=sc.nextLine();
				String temp1[]=coReq.split("\\s+");
				if (temp1.length<2) {
					coReq=null;
				}else {
					coReq=temp1[1];
				}
				if(!cL1.contains(ID))
				cL1.addToStart(new Course(ID,name,credit,preReq,coReq));
			}

		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		System.out.println(cL1.toString());
	}
}
