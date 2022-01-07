package ExamMidTermOOP;

import java.io.IOException;

public interface Computer {
	public void writeFile() throws IOException;
    public void readFile() throws IOException;
    public void writeFile_Backup() throws IOException;
    public void readFile_Backup() throws IOException;
}
