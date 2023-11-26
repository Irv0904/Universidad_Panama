package proyectoCalculadora;
import javax.swing.*; 
import java.awt.event.*;
public class Calculadora implements ActionListener{
    JTextField campo; 
    String operador = ""; 
    double num = 0.0; 
    double num2 = 0.0; 
    
    public Calculadora(JTextField campo){
        this.campo = campo; 
    }
    
    public void actionPerformed(ActionEvent e){
        String accion = e.getActionCommand(); 
        
        if(accion.equals("9") || accion.equals("8") || accion.equals("7")
                || accion.equals("6") || accion.equals("5") || accion.equals("4")
                || accion.equals("3") || accion.equals("2") || accion.equals("1") || accion.equals("0")){
            campo.setText(campo.getText() + accion); 
        } else if(accion.equals("/") || accion.equals("*") || accion.equals("-") || accion.equals("+")){
            operador = accion; 
            num = Double.parseDouble(campo.getText());
            campo.setText(" "); 
        } else if(accion.equals("=")){
            num2 = Double.parseDouble(campo.getText()); 
            double resultado = 0.0; 
            
            switch(operador){
                case "/" -> { 
                    if(num2 == 0){
                        campo.setText("Syntax Error"); 
                        return; 
                    }else{
                        resultado = num / num2; 
                    }
                    break;
                }
                
                case "*"->{
                    resultado = num * num2; 
                    break; 
                }
                
                case "-" ->{
                    resultado = num - num2; 
                    break; 
                }
                
                case "+" ->{
                    resultado = num + num2; 
                    break; 
                } 
            }
            campo.setText(Double.toString(resultado)); 
        } else if(accion.equals("C")){
            campo.setText(""); 
            operador = ""; 
            num = 0.0; 
            num2 = 0.0; 
        }
    }
}
    

