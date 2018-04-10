
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
			sc = new Scanner(new FileInputStream(new File("C:\\Users\\Dabris\\Desktop\\workspace\\249A4")));
			while (sc.hasNextLine()) {
				String ID=sc.next();
				String name=sc.next();
				double credit=sc.nextDouble();
				String preReq=sc.nextLine();
				if (preReq.equals("P")) {
					preReq=null;
				}else {
					String temp[]=preReq.split("//s+");
					preReq=temp[1];
				}
				String coReq=sc.nextLine();
				if (coReq.equals("P")) {
					coReq=null;
				}else {
					String temp1[]=preReq.split("//s+");
					coReq=temp1[1];
				}
				if(!cL1.contains(ID))
				cL1.addToStart(new Course(ID,name,credit,preReq,coReq));
			}

		} catch (FileNotFoundException e) {
			e.getMessage();
		}
	}
}
