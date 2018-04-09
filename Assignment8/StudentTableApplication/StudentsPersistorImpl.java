package Assignment8.StudentTableApplication;

import java.io.*;

public class StudentsPersistorImpl implements StudentsPersistor {

    String file = "/Users/jingluqing/Desktop/NEU/Info5100/samplestudents.txt";

    @Override
    public void save(StudentsManager manager) throws Exception {

        File f = new File(file);
        if (!f.exists()) {
            f.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(f);
        PrintStream ps = new PrintStream(fos);
        for (Student s : manager.getStudents()) {
            ps.println(s.getLine());
        }
        ps.flush();
        ps.close();
    }

    @Override
    public StudentsManager load() throws Exception {

        File f = new File(file);
        if (!f.exists())
            return new StudentsManagerImpl();

        FileInputStream fis = new FileInputStream(f);
        StudentsManager manager = new StudentsManagerImpl();
        DataInputStream dis = new DataInputStream(fis);
        while (true) {
            String line = dis.readLine();
            if (line == null)
                break;
            Student s = Student.fromLine(line);
            manager.addStudent(s);
        }
        dis.close();
        return manager;
    }
}
