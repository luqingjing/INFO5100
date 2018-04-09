package Assignment8.StudentTableApplication;

public interface StudentsPersistor {

    void save(StudentsManager manager) throws Exception;

    StudentsManager load() throws Exception;
}
