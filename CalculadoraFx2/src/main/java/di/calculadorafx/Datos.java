package di.calculadorafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class Datos {

    private static boolean monedaSeleciconada= false;
    private static boolean longitudSeleccionada= false;
    private static boolean pesoSeleccionada=false;
    private static boolean tiempoSeleccionado=false;
    private static boolean almacenamientoSeleccionado=false;
    private static double tipoCambioEuroADolar = 1.21;
    private static ComboBox  combo ;

    private static HelloController controlador;
    private static ObservableList<String> historialItems;

    public static void inicializarHistorial() {
        historialItems = FXCollections.observableArrayList();
    }

    public static ObservableList<String> getHistorialItems() {
        return historialItems;
    }

    public static void addToHistorial(String entrada) {
        historialItems.add(entrada);
    }

    public static void setControlador(HelloController controller) {
        controlador = controller;
    }
    public static double convertirEuroADolar(double cantidadEuro) {
        double tipoCambioEuroADolar = getTipoCambioEuroADolar();
        return cantidadEuro * tipoCambioEuroADolar;
    }

    public static double convertirDolarAEuro(double cantidadDolar) {
        double tipoCambioEuroADolar = getTipoCambioEuroADolar();
        return cantidadDolar / tipoCambioEuroADolar;
    }
    public static double convertirTiempo(double cantidad, String de, String a) {
        double resultado = 0.0;

        if (de.equals("sec") && a.equals("min")) {
            resultado = cantidad / 60.0;
        }
        else if (de.equals("min") && a.equals("hora")) {
            resultado = cantidad / 60.0;
        }
        else if (de.equals("sec") && a.equals("hora")) {
            resultado = cantidad / 3600.0;
        }
        else if (de.equals("min") && a.equals("sec")) {
            resultado = cantidad * 60.0;
        }
        else if (de.equals("hora") && a.equals("min")) {
            resultado = cantidad * 60.0;
        }
        else if (de.equals("hora") && a.equals("sec")) {
            resultado = cantidad * 3600.0;
        }

        return resultado;
    }

    public static double convertirLongitud(double cantidad, String de, String a) {
        double resultado = 0.0;
        if (de.equals("mm") && a.equals("cm")) {
            resultado = cantidad / 10.0;
        } else if (de.equals("cm") && a.equals("mm")) {
            resultado = cantidad * 10.0;
        } else if (de.equals("cm") && a.equals("m")) {
            resultado = cantidad / 100.0;
        } else if (de.equals("m") && a.equals("cm")) {
            resultado = cantidad * 100.0;
        } else if (de.equals("m") && a.equals("km")) {
            resultado = cantidad / 1000.0;
        } else if (de.equals("km") && a.equals("m")) {
            resultado = cantidad * 1000.0;
        }

        return resultado;
    }
    public static double setconvertirPeso(double candida,String  de, String a) {
        double resultado = 0.0;

        if (de.equals("mg") && a.equals("g")) {
            resultado = candida / 1000.0;
        } else if (de.equals("g") && a.equals("kg")) {
            resultado = candida / 1000.0;
        }else if (de.equals("mg") && a.equals("kg")) {
            resultado = candida / 1000000.0;
        }else if (de.equals("g") && a.equals("mg")) {
            resultado = candida * 1000.0;
        } else if (de.equals("kg") && a.equals("g")) {
            resultado = candida * 1000.0;
        }else if (de.equals("kg") && a.equals("mg")) {
            resultado = candida * 1000000;
        }
        return resultado;
    }
    public static double convertirAlmacenamiento(double cantidad, String de, String a) {
        double resultado = 0.0;

        if (de.equals("b") && a.equals("B")) {
            resultado = cantidad * 0.125;
        } else if (de.equals("B") && a.equals("KB")) {
            resultado = cantidad / 1024;
        } else if (de.equals("KB") && a.equals("MB")) {
            resultado = cantidad / 1024;
        } else if (de.equals("b") && a.equals("KB")) {
            resultado =(cantidad / 8) / 1024;
        } else if (de.equals("B") && a.equals("MB")) {
            resultado = cantidad / 1024 / 1024;
        } else if (de.equals("KB") && a.equals("B")) {
            resultado = cantidad * 1024;
        } else if (de.equals("MB") && a.equals("B")) {
            resultado = cantidad * 1048576;
        } else if (de.equals("MB") && a.equals("KB")) {
            resultado = cantidad * 1024;
        } else if (de.equals("B") && a.equals("b")) {
            resultado = cantidad * 8;
        } else if (de.equals("KB") && a.equals("b")) {
            resultado = cantidad * 8192;
        } else if (de.equals("MB") && a.equals("b")) {
            resultado = cantidad * 8388608;
        }

        return resultado;
    }
    // Obtenemos valor de cada uno
    public static boolean isAlmacenamientoSeleccionado() {
        return almacenamientoSeleccionado;
    }
    public static boolean isMonedaSeleccionada() {
        return monedaSeleciconada;
    }
    public static boolean isLongitudSeleccionada() {
        return longitudSeleccionada;
    }
    public static boolean isPesoSeleccionado() {
        return pesoSeleccionada;
    }
    public static boolean isTiempoSeleccionado() {
        return tiempoSeleccionado;
    }

    //Modificarmos
    public static void setMonedaSeleciconada(boolean monedaSeleciconada) {
        Datos.monedaSeleciconada = monedaSeleciconada;
    }

    public static void setPesoSeleccionada(boolean pesoSeleccionada) {
        Datos.pesoSeleccionada = pesoSeleccionada;
    }

    public static void setTiempoSeleccionado(boolean tiempoSeleccionado) {
        Datos.tiempoSeleccionado = tiempoSeleccionado;
    }

    public static void setAlmacenamientoSeleccionado(boolean almacenamientoSeleccionado) {
        Datos.almacenamientoSeleccionado = almacenamientoSeleccionado;
    }

    public static void setLongitudSeleccionada(boolean longitudSeleccionada) {
        Datos.longitudSeleccionada = longitudSeleccionada;
    }

    public double calcularMultiplicacion(double operando1, double operando2) {
        return operando1 * operando2;
    }
    //*********************** COS/SEN/ LOG / TAN ************************
    public  double calcularExponencial(double valor) {
        return Math.exp(valor);
    }

    public double calcularTangente(double valor) {
        return Math.tan(Math.toRadians(valor));
    }

    public double calcularLogaritmo(double valor) {
        return Math.log(valor);
    }

    public double calcularSeno(double valor) {
        return Math.sin(Math.toRadians(valor));
    }

    public double calcularCoseno(double valor) {
        return Math.cos(Math.toRadians(valor));
    }

    //******************* PARA USAR API *******************************************
    private static double parseTipoCambio(String responseBody) {
        try {
            JSONObject json = new JSONObject(responseBody);
            JSONObject rates = json.getJSONObject("rates");
            double tipoCambio = rates.getDouble("USD");
            System.out.println("Valor del cambio obtenido de la API: " + tipoCambio);
            return tipoCambio;
        } catch (JSONException e) {
            System.err.println("Error al analizar la respuesta de la API. Se usará el valor por defecto.");
            return 1.21; // Valor por defecto
        }
    }
    private static double getTipoCambioEuroADolar() {
        OkHttpClient client = new OkHttpClient();
        String url = "https://api.exchangerate-api.com/v4/latest/EUR";

        Request request = new Request.Builder().url(url).build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                // Analizar el cuerpo de la respuesta para obtener el valor del cambio
                System.out.println(responseBody);
                return parseTipoCambio(responseBody);
            } else {
                System.err.println("Error al obtener el valor del cambio de la API. Se usará el valor por defecto.");
                return 1.21; // Valor por defecto
            }
        } catch (Exception e) {
            System.err.println("Excepción al obtener el valor del cambio de la API. Se usará el valor por defecto.");
            return 1.21; // Valor por defecto
        }
    }

}

