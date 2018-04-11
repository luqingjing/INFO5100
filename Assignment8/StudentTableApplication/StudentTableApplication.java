package Assignment8.StudentTableApplication;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StudentTableApplication extends JFrame {

    private JTable studentTable;
    private List<Student> students;
    private StudentsPersistor persistor;
    private StudentsManager manager;
    private StudentTableModel model;
    private JLabel rolllabel, namelabel, genderlabel, gradelabel;
    private JTextField rolljtf, namejtf, genderjtf, gradejtf;
    private JButton add, delete, edit, search, clear;
    OperatorListener operatorListener;

    public static void main(String[] args) throws Exception {
        new StudentTableApplication();
    }

    public StudentTableApplication() throws Exception{
        createComponents();
        setLayout();
        addComponents();
        createListeners();
        addListeners();
        makeItVisible();
    }

    private void makeItVisible() throws Exception {

        setSize(500, 500);
        setVisible(true);

        rolllabel.setHorizontalAlignment(JTextField.RIGHT);
        namelabel.setHorizontalAlignment(JTextField.RIGHT);
        genderlabel.setHorizontalAlignment(JTextField.RIGHT);
        gradelabel.setHorizontalAlignment(JTextField.RIGHT);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
    }

    private void addListeners() throws Exception {

        add.addActionListener(operatorListener);
        delete.addActionListener(operatorListener);
        edit.addActionListener(operatorListener);
        search.addActionListener(operatorListener);
        clear.addActionListener(operatorListener);
    }

    private void createListeners() throws Exception {

        operatorListener = new OperatorListener();
    }

    class OperatorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            Object o = e.getSource();
            String roll = rolljtf.getText();
            String name = namejtf.getText();
            String gender = genderjtf.getText();
            String grade = gradejtf.getText();

            if (o == add) {
                Student s = new Student();
                s.setRoll(roll);
                s.setName(name);
                s.setGender(gender);
                s.setGrade(grade);
                manager.addStudent(s);
                try {
                    persistor.save(manager);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                model = new StudentTableModel(students);
                studentTable.setModel(model);
            }

            if (o == edit) {

                Student s = manager.findStudent(roll);

                if (!name.equals(""))
                    s.setName(name);
                if (!gender.equals(""))
                    s.setGender(gender);
                if (!grade.equals(""))
                    s.setGrade(grade);
                try {
                    persistor.save(manager);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                model = new StudentTableModel(students);
                studentTable.setModel(model);
            }

            if (o == delete) {
                manager.deleteStudent(roll);
                try {
                    persistor.save(manager);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                model = new StudentTableModel(students);
                studentTable.setModel(model);
            }

            if (o == search) {
                Student s = manager.findStudent(roll);
                namejtf.setText(s.getName());
                genderjtf.setText(s.getGender());
                gradejtf.setText(s.getGrade());
            }
            if (o == clear) {
                rolljtf.setText("");
                namejtf.setText("");
                genderjtf.setText("");
                gradejtf.setText("");
            }
        }
    }

    private void addComponents() throws Exception {

        Container c = getContentPane();
        addTable(c);
        addData(c);
        addOperation(c);
    }

    private void addOperation(Container c) throws Exception {

        JPanel panel = new JPanel();
        panel.add(add);
        panel.add(delete);
        panel.add(edit);
        panel.add(search);
        panel.add(clear);

        panel.setLayout(new GridLayout(5,1));
        c.add(panel,"East");
    }

    private void addData(Container c) throws Exception {

        JPanel panel = new JPanel();
        panel.add(rolllabel);
        panel.add(rolljtf);
        panel.add(namelabel);
        panel.add(namejtf);
        panel.add(genderlabel);
        panel.add(genderjtf);
        panel.add(gradelabel);
        panel.add(gradejtf);
        panel.setLayout(new GridLayout(4,2));
        c.add(panel,"West");
    }

    private void addTable(Container c) throws Exception {

        JScrollPane jsp = new JScrollPane(studentTable);
        c.add(jsp,"North");
    }

    private void setLayout() throws Exception {

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
    }

    private void createComponents() throws Exception {

        setTitle("Student Information System");

        persistor = new StudentsPersistorImpl();
        manager = persistor.load();
        students = manager.getStudents();
        model = new StudentTableModel(students);
        studentTable = new JTable(model);

        rolllabel = new JLabel("Roll");
        namelabel = new JLabel("Name");
        genderlabel = new JLabel("Gender");
        gradelabel = new JLabel("Grade");

        rolljtf = new JTextField(10);
        namejtf = new JTextField(10);
        genderjtf = new JTextField(10);
        gradejtf = new JTextField(10);

        add = new JButton("Add new student");
        delete = new JButton("Delete by roll number");
        edit = new JButton("Edit by roll number");
        search = new JButton("Search by roll number");
        clear = new JButton("Clear textfield");
    }

    class StudentTableModel implements TableModel {

        private List<Student> students;

        public StudentTableModel(List<Student> students) {
            this.students = students;
        }

        @Override
        public int getRowCount() {
            return students.size();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public String getColumnName(int columnIndex) {
            if (columnIndex == 0)
                return "Roll";
            if (columnIndex == 1)
                return "Name";
            if (columnIndex == 2)
                return "Gender";
            if (columnIndex == 3)
                return "Grade";
            return null;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Student s = students.get(rowIndex);
            if (columnIndex == 0)
                return s.getRoll();
            if (columnIndex == 1)
                return s.getName();
            if (columnIndex == 2)
                return s.getGender();
            if (columnIndex == 3)
                return s.getGrade();
            return null;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        }

        @Override
        public void addTableModelListener(TableModelListener l) {

        }

        @Override
        public void removeTableModelListener(TableModelListener l) {

        }
    }
}
