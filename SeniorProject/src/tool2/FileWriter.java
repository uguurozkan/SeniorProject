package tool2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriter {

	private final String FILE_EXTENSION = ".graphml";
	private String path, fileName, content;

	public FileWriter(String path, String fileName, String content) {
		setPath(path);
		setFileName(fileName);
		setContent(content);
	}

	private void setPath(String path) {
		if (path.contains("/") && (path.charAt(path.length() - 1) != '/'))
			this.path = path + '/';
		if (path.contains("\\") && (path.charAt(path.length() - 1) != '\\'))
			this.path = path + '\\';
		else
			this.path = path;
	}

	private void setFileName(String fileName) {
		this.fileName = fileName.substring(0, 1).toUpperCase()
				+ fileName.substring(1);
	}

	private void setContent(String content) {
		this.content = content;
	}

	public void writeFile() {
		try {
			PrintWriter pw = new PrintWriter(new File(path + fileName + FILE_EXTENSION));
			pw.write(content);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
