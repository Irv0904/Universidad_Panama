package proyectoCalculadora;import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

    private JTextField display;
    private StringBuilder input;

    public Calculator() {
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);

        input = new StringBuilder();
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        JPanel controlPanel = new JPanel(new GridLayout(1, 2));
        JButton backButton = new JButton("Borrar");
        JButton clearButton = new JButton("Limpiar");
        backButton.addActionListener(new BackButtonClickListener());
        clearButton.addActionListener(new ClearButtonClickListener());
        controlPanel.add(backButton);
        controlPanel.add(clearButton);

        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String text = source.getText();
            if (text.equals("=")) {
                calcularResultado();
            } else {
                input.append(text);
                display.setText(input.toString());
            }
        }
    }

    private class BackButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (input.length() > 0) {
                input.deleteCharAt(input.length() - 1);
                display.setText(input.toString());
            }
        }
    }

    private class ClearButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            input.setLength(0);
            display.setText("");
        }
    }

    private void calcularResultado() {
        try {
            String resultado = evaluarExpresion(input.toString());
            display.setText(resultado);
            input.setLength(0);
            input.append(resultado);
        } catch (ArithmeticException | NumberFormatException ex) {
            display.setText("Error");
            input.setLength(0);
        }
    }

    private String evaluarExpresion(String expresion) {
        // Puedes usar una biblioteca de evaluación de expresiones matemáticas o
        // implementar tu propia lógica aquí. En este ejemplo simple, se utiliza
        // la función eval de JavaScript a través de la clase ScriptEngineManager.
        javax.script.ScriptEngineManager mgr = new javax.script.ScriptEngineManager();
        javax.script.ScriptEngine engine = mgr.getEngineByName("JavaScript");
        try {
            return engine.eval(expresion).toString();
        } catch (javax.script.ScriptException e) {
            throw new ArithmeticException("Expresión inválida");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calculator().setVisible(true);
            }
        });
    }
}
