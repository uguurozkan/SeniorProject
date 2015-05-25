package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriter {

	private String path, fileName, content;

	public FileWriter() {
		this.path = "";
		this.fileName = "";
		this.content = "";
	}

	public void setPath(String path) {
		if (path.contains("/") && (path.charAt(path.length() - 1) != '/'))
			this.path = path + '/';
		else if (path.contains("\\") && (path.charAt(path.length() - 1) != '\\'))
			this.path = path + '\\';
		else
			this.path = path;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName.substring(0, 1).toUpperCase()
				+ fileName.substring(1);
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void writeFile() {
		try {
			PrintWriter pw = new PrintWriter(new File(path + fileName));
			pw.write(content);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
