package file;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class PSHFileReaderBasic extends PSHFileReader {
	
	/*
	public PSHFileReaderBasic(String fileName) {
		super(fileName);
	}
	
	protected List<T> readList(BufferedReader reader) throws IOException {
		List<T> list = new ArrayList<T>();
		String line;

		while ((line = reader.readLine()) != null) {
			list.add(convertTo(line));
		}

		return list;
	}

	protected abstract T convertTo(String line);
	*/
}
