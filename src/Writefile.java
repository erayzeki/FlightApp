import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Writefile {
	
	public void Writeto(String yaz) {
		
		String fileName="output.txt";
		try {
			PrintWriter out = new PrintWriter(fileName);
			out.println(yaz);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Writefile() {
		
	}
}

