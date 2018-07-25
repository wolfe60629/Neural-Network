import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader {
	private String location;
	
	public CsvReader(String location) { 
		this.location = location;
	}
	
	public void readFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(location));
			String line = null;
			while((line = br.readLine()) != null) {
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
}
