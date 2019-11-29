package dad.cambioDivisas;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CambiaDivisas extends Application {

	private TextField Cantidad1;
	private TextField Cantidad2;
	private ComboBox<Divisa> comboDivisa1;
	private ComboBox<Divisa> comboDivisa2;
	private Button calcularButton;
	
	private Divisa Euro = new Divisa("Euro", 1.0);
	private Divisa Libra = new Divisa("Libra", 0.8873);
	private Divisa Dolar = new Divisa("Dolar", 1.2007);
	private Divisa Yen = new Divisa("Yen", 133.59);
	
	public void start(Stage primaryStage) throws Exception {
	
	Cantidad1 = new TextField();
	Cantidad1.setPromptText("Divisa 1");
	Cantidad1.setAlignment(Pos.CENTER);
	Cantidad1.setPrefWidth(50);
	
	Cantidad2 = new TextField();
	Cantidad2.setPromptText("Divisa 2");
	Cantidad2.setAlignment(Pos.CENTER);
	Cantidad2.setPrefWidth(50);
	Cantidad2.setEditable(false);
	
	comboDivisa1 = new ComboBox<Divisa>();
	comboDivisa1.setPromptText("Divisa 1");
	comboDivisa1.getItems().addAll(Euro, Libra, Dolar, Yen);
	comboDivisa1.getSelectionModel().selectFirst();
	
	comboDivisa2 = new ComboBox<Divisa>();
	comboDivisa2.setPromptText("Divisa 2");
	comboDivisa2.getItems().addAll(Euro, Libra, Dolar, Yen);
	comboDivisa2.getSelectionModel().selectFirst();
	
	calcularButton = new Button();
	calcularButton.setText("Calcular");
	calcularButton.setOnAction(e -> oncalcularButtonAction(e));
	
	
	HBox hBox1 = new HBox(5,Cantidad1,comboDivisa1);
	hBox1.setAlignment(Pos.CENTER);
	
	HBox hBox2 = new HBox(5,Cantidad2,comboDivisa2);
	hBox2.setAlignment(Pos.CENTER);
	
	VBox root = new VBox(5,hBox1,hBox2,calcularButton);
	root.setAlignment(Pos.CENTER);
	
	Scene scene = new Scene(root,400,320);
	
	primaryStage.setTitle("Cambio de Divisas");
	primaryStage.setScene(scene);
	primaryStage.show();
	
	
	}
	
	private void oncalcularButtonAction(ActionEvent e) {

		Divisa origen = comboDivisa1.getSelectionModel().getSelectedItem();
		Divisa destino = comboDivisa2.getSelectionModel().getSelectedItem();
		
		String cantidad = Cantidad1.getText();
		
		try {
			
			this.Cantidad2.setText(destino.fromEuro(origen.toEuro(Double.parseDouble(cantidad))).toString());
			
		} catch (NumberFormatException e2) {
			Cantidad1.setText("Introduce numeros aquí");	
			}
		
	}

	//
	public static void main(String[] args) {
		launch(args);

	}

	

}
