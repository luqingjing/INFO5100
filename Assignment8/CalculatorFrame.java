package Assignment8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;

public class CalculatorFrame extends JFrame {

    private JLabel firstLabel, secondLabel, resultLabel;
    private JTextField first, second, result;
    private JButton plus, minus, multiply, divide, point, clear;
    private JButton[] jbs = new JButton[10];
    private OperatorListener operatorListener;
    private InputListener inputListener;
    private InputFocusListener inputFocusListener;
    private boolean inputFirst;

    public static void main(String[] args) {

        new CalculatorFrame();
    }

    public CalculatorFrame() {

        createComponents();
        setLayout();
        addComponents();
        createListeners();
        addListeners();
        makeItVisible();
    }

    private void makeItVisible() {

        setSize(500, 500);
        setVisible(true);

        first.setHorizontalAlignment(JTextField.RIGHT);
        second.setHorizontalAlignment(JTextField.RIGHT);
        result.setHorizontalAlignment(JTextField.RIGHT);
        result.setEditable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        pack();
    }

    private void addListeners() {

        first.addFocusListener(inputFocusListener);
        second.addFocusListener(inputFocusListener);

        plus.addActionListener(operatorListener);
        minus.addActionListener(operatorListener);
        multiply.addActionListener(operatorListener);
        divide.addActionListener(operatorListener);

        for (int i = 0; i < 10; i++) {
            jbs[i].addActionListener(inputListener);
        }
        point.addActionListener(inputListener);
        clear.addActionListener(inputListener);
    }

    private void createListeners() {

        inputFocusListener = new InputFocusListener();
        operatorListener = new OperatorListener();
        inputListener = new InputListener();
    }

    class OperatorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            Object o = ae.getSource();
            BigDecimal a = new BigDecimal(first.getText());
            BigDecimal b = new BigDecimal(second.getText());
            if (o == plus) {
                result.setText(a.add(b).doubleValue() + "");
            }
            if (o == minus) {
                result.setText(a.subtract(b).doubleValue() + "");
            }
            if (o == multiply) {
                result.setText(a.multiply(b).doubleValue() + "");
            }
            if (o == divide) {
                result.setText(a.divide(b,10,BigDecimal.ROUND_HALF_UP).doubleValue() + "");
            }
        }
    }

    class InputFocusListener implements FocusListener {

        @Override
        public void focusGained(FocusEvent e) {
            JTextField text= (JTextField) e.getSource();
            if(text == first) {
                inputFirst = true;
            }
            if(text == second) {
                inputFirst = false;
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
        }
    }

    class InputListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String s = e.getActionCommand();
            JTextField jtf = inputFirst ? first : second;

            if ("0123456789.".contains(s))
                jtf.setText(jtf.getText() + s);

            if (s.equals("AC")) {
                first.setText("");
                second.setText("");
                result.setText("");
            }
        }
    }

    private void addComponents() {

        Container c = getContentPane();
        addInput(c);
        addNumber(c);
        addOperation(c);
        addResult(c);
    }

    private void addResult(Container c) {

        JPanel panel = new JPanel();
        panel.add(resultLabel);
        panel.add(result);
        c.add(panel, "South");
    }

    private void addOperation(Container c) {

        JPanel panel = new JPanel();
        panel.add(plus);
        panel.add(minus);
        panel.add(multiply);
        panel.add(divide);
        panel.setLayout(new GridLayout(4,1));
        c.add(panel,"East");
    }

    private void addNumber(Container c) {

        JPanel panel = new JPanel();
        for (int i = 1; i < 10; i++) {
            panel.add(jbs[i]);
        }
        panel.add(jbs[0]);
        panel.add(point);
        panel.add(clear);
        panel.setLayout(new GridLayout(4,3));
        c.add(panel, "Center");
    }

    private void addInput(Container c) {
        JPanel panel = new JPanel();
        panel.add(firstLabel);
        panel.add(first);
        panel.add(secondLabel);
        panel.add(second);
        c.add(panel, "North");
    }

    private void setLayout() {

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
    }

    private void createComponents() {

        setTitle("Calculator");

        firstLabel = new JLabel("Number 1");
        secondLabel = new JLabel("Number 2");
        resultLabel = new JLabel("Result");

        first = new JTextField(10);
        second = new JTextField(10);
        result = new JTextField(10);

        plus = new JButton("+");
        minus = new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");
        point = new JButton(".");
        clear = new JButton("AC");

        jbs[0] = new JButton("0");
        for (int i = 1; i < 10; i++) {
            jbs[i] = new JButton(String.valueOf(i));
        }
    }
}

