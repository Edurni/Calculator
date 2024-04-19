package di.calculadorafx;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;


public class HelloController {

    private double memoria = 0.0;
    private boolean resultadoGuardado = false;

    private Stage primarystage;

    @FXML
    private VBox cientifica;
    @FXML
    private ImageView imagenicon;
    @FXML
    private Button btn_igual;
    @FXML
    private Pane paneCombos;
    @FXML
    private MenuItem cientificaidS;
    @FXML
    private Menu Edicionid;
    @FXML
    private Label label;
    @FXML
    private VBox vb;
    @FXML
    private ComboBox combobox2;
    @FXML
    private ComboBox combobox1;
    @FXML
    private MenuItem sencillaidS;
    @FXML
    private ComboBox combobox3;
    @FXML
    private Label labelmemoria;
    @FXML
    private MenuItem fijarvalorid;
    @FXML
    private Menu Ayudaid;
    @FXML
    private MenuBar menuS;
    @FXML
    private Menu menuidS;
    @FXML
    private Pane pane;
    @FXML
    private CheckBox checkMoneda;
    @FXML
    private CheckBox checklongitud;
    @FXML
    private CheckBox checkpeso;
    @FXML
    private CheckBox checktiempo;
    @FXML
    private CheckBox checkalmacen;
    private TextField valorMoneda;
    @FXML
    private ListView<String> historialListView;


    public TextField getValorMoneda() {
        return valorMoneda;
    }
    @FXML
    //inicialización al iniciar el controlador de la interfaz
    public void initialize() {
        Datos.inicializarHistorial();
        Datos.setControlador(this);

    }

    public void setValorMoneda(TextField valorMoneda) {
        this.valorMoneda = valorMoneda;
    }

    @FXML
    public void clickac(ActionEvent actionEvent) {
        digito = false;
        punto = false;
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
        double resultado = 0.0;

        switch (String.valueOf(combobox1.getValue())) {
            case "Moneda":
                if (combobox2.getValue() != null && combobox3.getValue() != null && combobox2.getValue().equals("Euro")) {
                    double cantidadEuro = Double.parseDouble(label.getText());
                    resultado = Datos.convertirEuroADolar(cantidadEuro);
                }
                if (combobox3.getValue() != null && combobox2.getValue() != null && combobox3.getValue().equals("Euro")) {
                    double cantidadDolar = Double.parseDouble(label.getText());
                    resultado = Datos.convertirDolarAEuro(cantidadDolar);
                }
                break;
            case "Peso":
                resultado = Datos.setconvertirPeso(Double.parseDouble(label.getText()), (String) combobox2.getValue(), (String) combobox3.getValue());
                break;
            case "Tiempo":
                resultado = Datos.convertirTiempo(Double.parseDouble(label.getText()), (String) combobox2.getValue(), (String) combobox3.getValue());
                break;
            case "Almacenamiento":
                resultado = Datos.convertirAlmacenamiento(Double.parseDouble(label.getText()), (String) combobox2.getValue(), (String) combobox3.getValue());
                break;
            case "Longitud":
                resultado = Datos.convertirLongitud(Double.parseDouble(label.getText()), (String) combobox2.getValue(), (String) combobox3.getValue());
                break;
        }

        Datos.addToHistorial(String.valueOf(resultado));
        label.setText(String.valueOf(resultado));
        historialListView.setItems(Datos.getHistorialItems());
    }

    public void setComboBox1(ComboBox combobox1) {
        this.combobox1 = combobox1;
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
    public void clicktres(ActionEvent actionEvent) {
        digitoPantalla("3");
    }

    @FXML
    public void clickpunto(ActionEvent actionEvent) {

        if (!label.getText().contains(".")) {
        if (!digito) {

            label.setText("0.");
            digito = true;
        }else{
            String valActual = label.getText();
            label.setText(valActual + ".");
        }
        punto = true;
    }
        }


    @FXML
    public void clicksiete(ActionEvent actionEvent) {
        digitoPantalla("7");
    }


    private boolean digito = false;
    private boolean punto = false;
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;

        combobox1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String anterior, String nuevo) {

                combobox2.getItems().clear();
                combobox3.getItems().clear();

                if (nuevo.equals("Moneda")) {

                    combobox2.getItems().addAll( "Dolar");
                    combobox2.getItems().addAll("Euro");

                    combobox3.getItems().addAll( "Dolar");
                    combobox3.getItems().addAll( "Euro");
                }
                if (nuevo.equals("Longitud")) {

                    combobox2.getItems().addAll( "mm");
                    combobox2.getItems().addAll("m");
                    combobox2.getItems().addAll("km");

                    combobox3.getItems().addAll( "mm");
                    combobox3.getItems().addAll( "m");
                    combobox3.getItems().addAll( "km");
                }
                if (nuevo.equals("Peso")) {

                    combobox2.getItems().addAll( "mg");
                    combobox2.getItems().addAll("g");
                    combobox2.getItems().addAll( "kg");

                    combobox3.getItems().addAll( "mg");
                    combobox3.getItems().addAll( "g");
                    combobox3.getItems().addAll( "kg");
                }
                if (nuevo.equals("Tiempo")) {

                    combobox2.getItems().addAll("sec");
                    combobox2.getItems().addAll( "min");
                    combobox2.getItems().addAll( "hora");

                    combobox3.getItems().addAll( "sec");
                    combobox3.getItems().addAll( "min");
                    combobox3.getItems().addAll("hora");
                }
                if (nuevo.equals("Almacenamiento")) {

                    combobox2.getItems().addAll("b");
                    combobox2.getItems().addAll( "B");
                    combobox2.getItems().addAll( "KB");
                    combobox2.getItems().addAll( "MB");

                    combobox3.getItems().addAll( "b");
                    combobox3.getItems().addAll( "B");
                    combobox3.getItems().addAll( "KB");
                    combobox3.getItems().addAll( "MB");
                }

            }
        });


    }

    @FXML
    public void CalculadoraCientificaS(ActionEvent actionEvent) {
        cargarCalculadoraCientifica("hello-viewC.fxml");
    }

    private void cargarCalculadoraCientifica(String fxmlFileName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
            VBox newRoot = loader.load();
            HelloControllerC controller = loader.getController();
            controller.setPrimaryStage(primaryStage);
            primaryStage.getScene().setRoot(newRoot);
            primaryStage.setWidth(700);
            primaryStage.setHeight(650);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void digitoPantalla(String numero) {
        if (!digito && numero.equals("0")) {
            return;
        }
        if (!digito) {
            label.setText("");
            punto = false;
        }
        String valorActual = label.getText();
        label.setText(valorActual + numero);
        digito = true;
    }

    @FXML
    public void menuS(ActionEvent actionEvent) {
    }


    @FXML
    public void AyudaAction(ActionEvent actionEvent) {
    }

    @FXML
    public void Edicionaction(ActionEvent actionEvent) {
    }

    @FXML
    public void CalculadoraSencillaS(ActionEvent actionEvent) {
    }

    @FXML
    public void combobox3action(ActionEvent actionEvent) {
    }

    @FXML
    public void combobox1action(ActionEvent actionEvent) {

    }

    @FXML
    public void combobox2action(ActionEvent actionEvent) {
    }

    // ********************* Ventana Modal  **************************
    @FXML
    public void fijarvalorid(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-modal.fxml"));
            Parent root = loader.load();
// Conseguir controlador aunque sea el mismo !!
            HelloController modalController = loader.getController();
            modalController.setComboBox1(combobox1);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.setTitle("Fijar Valor");
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void aceptarAction(ActionEvent actionEvent) {
        Datos.setMonedaSeleciconada(checkMoneda.isSelected());
        Datos.setLongitudSeleccionada(checklongitud.isSelected());
        Datos.setAlmacenamientoSeleccionado(checkalmacen.isSelected());
        Datos.setPesoSeleccionada(checkpeso.isSelected());
        Datos.setTiempoSeleccionado(checktiempo.isSelected());

        combobox1.getItems().clear();

        if (Datos.isMonedaSeleccionada()){
            combobox1.getItems().addAll( "Moneda");
        }
        if(Datos.isLongitudSeleccionada()){
            combobox1.getItems().addAll("Longitud");
        }
        if(Datos.isPesoSeleccionado()){
            combobox1.getItems().addAll("Peso");
        }
        if (Datos.isTiempoSeleccionado()){
            combobox1.getItems().addAll("Tiempo");
        }
        if(Datos.isAlmacenamientoSeleccionado()){
            combobox1.getItems().addAll("Almacenamiento");
        }


        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        System.out.println(checkMoneda.isSelected());
    }

    @FXML
    public void volverAction(ActionEvent actionEvent) {
        // Obtener el Stage de la ventana modal
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}