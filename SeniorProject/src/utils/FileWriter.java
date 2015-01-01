package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriter {

	private String path, fileName, content, fileExtension;

	public FileWriter(String path, String fileName, String content, String fileExtension) {
		setPath(path);
		setFileName(fileName);
		setContent(content);
		setFileExtension(fileExtension);
	}

	private void setPath(String path) {
		if (path.contains("/") && (path.charAt(path.length() - 1) != '/'))
			this.path = path + '/';
		else if (path.contains("\\") && (path.charAt(path.length() - 1) != '\\'))
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

	private void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public void writeFile() {
		try {
			PrintWriter pw = new PrintWriter(new File(path + fileName + fileExtension));
			pw.write(content);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
