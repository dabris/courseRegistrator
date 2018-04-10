import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class EnrolmentResults {
public static void main(String args[]) {
	CourseList cL1=new CourseList();
	CourseList cL2=new CourseList(cL1);
	BufferedReader br;
	try {
		File A4files=new File("C:\\Users\\Dabris\\Desktop\\workspace\\249A4");
		br=new BufferedReader(new FileReader(A4files));
	
	}catch(FileNotFoundException e) {
		
	}
}
}
