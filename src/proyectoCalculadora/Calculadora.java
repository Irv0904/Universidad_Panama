package proyectoCalculadora;
//Dso librerias
import javax.swing.*; 
import java.awt.event.*;
//Creamos la clase e instaciamos la variable campo
public class Calculadora implements ActionListener{
    JTextField campo;
    //creamos 3 variables, un string y dos double.
    String operador = ""; 
    double num = 0.0; 
    double num2 = 0.0;
    public Calculadora(JTextField campo){
        this.campo = campo; 
    }
    //cramos metodo llamado actionPerformed
    public void actionPerformed(ActionEvent e){
        String accion = e.getActionCommand(); 
        //si el usuario toco un botono de numero lo muestra y guarda en las variables
        if(accion.equals("9") || accion.equals("8") || accion.equals("7")
                || accion.equals("6") || accion.equals("5") || accion.equals("4")
                || accion.equals("3") || accion.equals("2") || accion.equals("1") || accion.equals("0")){
            campo.setText(campo.getText() + accion);
            //se es un signo hace la operacio
        } else if(accion.equals("/") || accion.equals("*") || accion.equals("-") || accion.equals("+")){
            operador = accion; 
            num = Double.parseDouble(campo.getText());
            campo.setText(" ");
            //si es igual muestra resultado
        } else if(accion.equals("=")){
            num2 = Double.parseDouble(campo.getText()); 
            double resultado = 0.0;
            //pregunta si el signo es /,*,-,+, y hara su operacion correspondiente
            switch(operador){
                case "/" -> {
                    /*si ek segundo numero es 0, tira error, porque todo divido a cero no tiene resultado o da error*/
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
            //si es ogual muestra el resultado
            campo.setText(Double.toString(resultado));
            //si es boton c , limpia todo
        } else if(accion.equals("C")){
            campo.setText(""); 
            operador = ""; 
            num = 0.0; 
            num2 = 0.0; 
        }
    }
}