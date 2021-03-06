package file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class PSHFileReader {
	protected String fileName;
	
	/*
	public PSHFileReader(String fileName) {
		this.fileName = fileName;
	}
	
	public List<T> read() {
		List<T> list = new ArrayList<T>();

		try {
			System.out.println("fileName : " + fileName);
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			list = readList(reader);
			reader.close();

			return list;

		} catch (FileNotFoundException e) {
			System.err.println("File not found : " + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	protected abstract List<T> readList(BufferedReader reader) throws IOException;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	*/
	
}
