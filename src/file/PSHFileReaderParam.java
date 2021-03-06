package file;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class PSHFileReaderParam extends PSHFileReader {
	
	private List<String> params;
	
	/*
	protected List<String> parameters;

	public PSHFileReaderParam(String fileName, List<String> param) {
		super(fileName);
		this.parameters = param;
	}
	
	public PSHFileReaderParam(String fileName) {
		super(fileName);
	}

	protected List<List<Object>> readList(BufferedReader reader) throws IOException {
		List<List<Object>> list = new ArrayList<List<Object>>();
		
		for(String param : parameters) {
			list.add(readSubList(param));
		}

		return list;
	}

	protected abstract List<Object> readSubList(String param);

	public List<String> getParameter() {
		return parameters;
	}

	public void setParameter(String ...parameters) {
		ArrayList<String> newParameters = new ArrayList<String>();
		for(String param : parameters)
			newParameters.add(param);
		this.parameters = newParameters;
	}
	*/
	
}
