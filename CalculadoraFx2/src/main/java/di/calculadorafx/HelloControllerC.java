package di.calculadorafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloControllerC {

    @FXML
    private Label label;
    @FXML
    private Button btn_multiplicar;
    @FXML
    private Button btn_mas;
    @FXML
    private Button btn_igual;
    @FXML
    private Button btn_dividir;
    @FXML
    private Button btn_restar;
    @FXML
    private ImageView imagenicon;
    @FXML
    private Button btn_MC;
    @FXML
    private Button btn_MS;
    @FXML
    private Button btn_MR;

    private double memoria = 0.0;
    @FXML
    private Label labelmemoria;
    private boolean resultadoGuardado = false;
    @FXML
    private Pane pane;


    private Stage primaryStage;
    @FXML
    private VBox cientifica;
    @FXML
    private MenuItem sencillaid;
    @FXML
    private MenuBar menu;
    @FXML
    private Menu menuid;
    @FXML
    private MenuItem cientificaid;
    @FXML
    private MenuItem cientificaid1;
    @FXML
    private MenuItem cientificaid2;
    @FXML
    private MenuItem sencillaid2;
    @FXML
    private Menu AyudaCid;
    @FXML
    private Menu edicionCid;
    @FXML
    private MenuItem sencillaid1;
    @FXML
    private Button btn_cos;
    @FXML
    private Button btn_log;
    @FXML
    private Button btn_tan;
    @FXML
    private Button btn_exp;
    @FXML
    private Button btn_sin;
    Datos operar = new Datos();
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Deprecated
    public void MostrarResultadoMemoria(ActionEvent actionEvent) {

        if (resultadoGuardado) {
            labelmemoria.setText("Memoria: " + memoria);
        }
    }

    @FXML
    public void clickac(ActionEvent actionEvent) {
        digito=false;
        punto=false;
        numOperando = 0;
        Operando1=0;
        Operando2=0;
        Operador="";
        label.setText("0");
    }

    @FXML
    public void clicknueve(ActionEvent actionEvent) {
        digitoPantalla("9");
    }

    @FXML
    public void clickcero(ActionEvent actionEvent) {
        digitoPantalla("0");
    }

    @FXML
    public void clickigual(ActionEvent actionEvent) {
      evalOperador("=");


    }

    @FXML
    public void clickmenos(ActionEvent actionEvent) {
        evalOperador("-");
    }

    @FXML
    public void clickdividir(ActionEvent actionEvent) {
        evalOperador("/");
    }

    @FXML
    public void clickdos(ActionEvent actionEvent) {
        digitoPantalla("2");
    }

    @FXML
    public void clickocho(ActionEvent actionEvent) {
        digitoPantalla("8");
    }

    @FXML
    public void clickcinco(ActionEvent actionEvent) {
        digitoPantalla("5");
    }

    @FXML
    public void clickuno(ActionEvent actionEvent) {
        digitoPantalla("1");
    }

    @FXML
    public void clickseis(ActionEvent actionEvent) {
        digitoPantalla("6");
    }

    @FXML
    public void clickcuatro(ActionEvent actionEvent) {
        digitoPantalla("4");
    }

    @FXML
    public void clickmasmenos(ActionEvent actionEvent) {
        if(digito){
            label.setText("-"+ label.getText());
        }
    }

    @FXML
    public void clicktres(ActionEvent actionEvent) {
        digitoPantalla("3");
    }

    @FXML
    public void clickpunto(ActionEvent actionEvent) {
        if (!label.getText().contains(".")) {
            // Si no hay un punto, agregar uno
            if (!digito) {
                // Si no hay dígitos aún, establecer el texto como "0."
                label.setText("0.");
                digito = true;
            } else {
                // Si ya hay dígitos, agregar el punto al final del texto
                String valActual = label.getText();
                label.setText(valActual + ".");
            }
            punto = true;
        }
    }



    @FXML
    public void clickmod(ActionEvent actionEvent) {
        numOperando =Double.parseDouble(label.getText());
        // Verificar si se ha ingresado al menos un número
        if (numOperando == 0) {
            label.setText("0"); // Establecer el valor predeterminado en 0 si no hay ningún número ingresado
            return;
        }

        // Calcular el porcentaje del segundo número con respecto al primer número
        double porcentaje = Double.parseDouble(label.getText()) / 100.0;

        // Establecer el resultado del porcentaje en la pantalla
        label.setText(String.valueOf(porcentaje));

        // Restablecer las banderas para permitir la entrada de un nuevo número
        digito = true;
        punto = true;
    }

    @FXML
    public void clickmultiplicar(ActionEvent actionEvent) {
        evalOperador("*");
    }

    @FXML
    public void clicksiete(ActionEvent actionEvent) {
        digitoPantalla("7");
    }

    @FXML
    public void clicksumar(ActionEvent actionEvent) {

        evalOperador("+");

    }

    private boolean digito =false;
    private boolean punto = false;
    private double numOperando =0;
    private double Operando1, Operando2;
    private String Operador="";



    private void digitoPantalla(String numero){
        if (numero.equals(".") && label.getText().contains(".")) {
            // Si el número es un punto y ya hay uno en el texto, no hacer nada
            return;
        }
        if(!digito && numero.equals("0")){
            return;
        }
        if(!digito){
            label.setText("");
            punto=false;
        }
        String valorActual = label.getText();
        label.setText(valorActual + numero);
        digito=true;
    }

    private void evalOperador (String Operador){
        if(digito){
            numOperando++;
        }
        if(numOperando ==1){
            Operando1 = Double.parseDouble(label.getText());
        }
        if(numOperando == 2){
            Operando2 = Double.parseDouble(label.getText());
        switch (this.Operador){
            case "+":
                Operando1 = Operando1 + Operando2;
                break;
            case "-":
                Operando1=Operando1-Operando2;
                break;
            case "/":
                Operando1=Operando1/Operando2;
                break;
            case "*":
                Operando1=Operando1*Operando2;
                break;
            case "=":
                Operando1=Operando2;
                break;
        }
        label.setText(String.valueOf(Operando1));
        numOperando =1;
        punto=false;
        }
        digito=false;
        this.Operador = Operador;

    }

    @FXML
    public void MostrarValorMemoria(ActionEvent actionEvent) {
       label.setText(String.valueOf(memoria));
       Operando1 = Double.parseDouble(label.getText());
        numOperando++;
        if(digito){
            numOperando++;
        }
        if(numOperando ==1){
            Operando1 = Double.parseDouble(label.getText());
        }
        if(numOperando == 2){
            Operando2 = Double.parseDouble(label.getText());
            switch (this.Operador){
                case "+":
                    Operando1 = Operando1 + Operando2;
                    break;
                case "-":
                    Operando1=Operando1-Operando2;
                    break;
                case "/":
                    Operando1=Operando1/Operando2;
                    break;
                case "*":
                    Operando1=Operando1*Operando2;
                    break;
                case "=":
                    Operando1=Operando2;
                    break;
            }
            label.setText(String.valueOf(Operando1));
            numOperando =1;
            punto=false;
        }
        digito=false;
        this.Operador = Operador;

    }



    @Deprecated
    public void MPlusSuma(ActionEvent actionEvent) {
        double valorActual = Double.parseDouble(label.getText());
        memoria += valorActual;
        labelmemoria.setText("Memoria: " + memoria);
    }

    @FXML
    public void borrarMemoria(ActionEvent actionEvent) {
        memoria = 0.0;
        labelmemoria.setText("Memoria: " + memoria);
    }

    @FXML
    public void guardarenMemoria(ActionEvent actionEvent) {
        double valorActual = Double.parseDouble(label.getText());
        memoria = valorActual;
        resultadoGuardado = true;
        labelmemoria.setText("Memoria: " + memoria);
    }

    @Deprecated
    public void CalculadoraSencillaC(ActionEvent actionEvent) {
        cargarCalculadoraSencilla("hello-view.fxml");
    }

    private void cargarCalculadoraSencilla(String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
            VBox newRoot = loader.load();
            HelloController controller = loader.getController(); // Usando el controlador correcto
            controller.setPrimaryStage(primaryStage); // Ajustando el escenario primario
            primaryStage.getScene().setRoot(newRoot);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void menu(ActionEvent actionEvent) {
    }


    @FXML
    public void edicionCaction(ActionEvent actionEvent) {
    }

    @FXML
    public void AyudaCaction(ActionEvent actionEvent) {
    }


    @FXML
    public void exponencial(ActionEvent actionEvent) {
        double value = Double.parseDouble(label.getText());
        double result = operar.calcularExponencial(value);
        label.setText(String.valueOf(result));
    }

    @FXML
    public void tangente(ActionEvent actionEvent) {
        double value = Double.parseDouble(label.getText());
        double result = operar.calcularTangente(value);
        label.setText(String.valueOf(result));
    }

    @FXML
    public void logaritmo(ActionEvent actionEvent) {
        double value = Double.parseDouble(label.getText());
        double result = operar.calcularLogaritmo(value);
        label.setText(String.valueOf(result));
    }

    @FXML
    public void seno(ActionEvent actionEvent) {
        double value = Double.parseDouble(label.getText());
        double result = operar.calcularSeno(value);
        label.setText(String.valueOf(result));
    }

    @FXML
    public void coseno(ActionEvent actionEvent) {
        double value = Double.parseDouble(label.getText());
        double result = operar.calcularCoseno(value);
        label.setText(String.valueOf(result));
    }

    @FXML
    public void CalculadoraSencilla(ActionEvent actionEvent) {
    }

    @FXML
    public void CalculadoraSencillaS(ActionEvent actionEvent) {
        cargarCalculadora("hello-view.fxml");
    }

    @FXML
    public void CalculadoraCientifica(ActionEvent actionEvent) {
    }

    private void cargarCalculadora(String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
            VBox newRoot = loader.load();
            HelloController controller = loader.getController();
            controller.setPrimaryStage(primaryStage);
            primaryStage.getScene().setRoot(newRoot);
            primaryStage.setWidth(600);
            primaryStage.setHeight(600);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
