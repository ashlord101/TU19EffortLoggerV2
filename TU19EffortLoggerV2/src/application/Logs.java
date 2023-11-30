package application;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.RiskReductionFour;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Logs implements Initializable {
	@FXML
	private TableView<String> table;
	
	@FXML
	private TableColumn<String,String> number;
	
	@FXML
	private TableColumn<String, String> date;
	
	@FXML
	private TableColumn<String, String> startCol;
	
	@FXML
	private TableColumn<String, String> stop;
	
	@FXML
	private TableColumn<String, String> timeCol;
	
	@FXML
	private TableColumn<String, String> lifeCycle;
	
	@FXML
	private TableColumn<String, String> category;
	
	@FXML
	private TableColumn<String, String> deliverable;
	
	/*ObservableList<User> list = FXCollections.observableArrayList(
		new User(number: "1", date: "", start: "", stop: "", time: "", lifeCycle: "", category: "", deliverable: "")
	);*/
	ObservableList<String> list = FXCollections.observableArrayList(
		"Planning", "2", "3", "4", "5", "6", "7", "8"
	);
			
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		/*number.setCellValueFactory(new PropertyValueFactory<>("number"));
		date.setCellValueFactory(new PropertyValueFactory<User, String>("date"));
		startCol.setCellValueFactory(new PropertyValueFactory<User, String>("start"));
		stop.setCellValueFactory(new PropertyValueFactory<User, String>("stop"));
		timeCol.setCellValueFactory(new PropertyValueFactory<User, String>("time"));
		lifeCycle.setCellValueFactory(new PropertyValueFactory<User, String>("lifeCycle"));
		category.setCellValueFactory(new PropertyValueFactory<User, String>("category"));
		deliverable.setCellValueFactory(new PropertyValueFactory<User, String>("deliverable"));*/
		
		table.setItems(list);
	}
	private Stage stage;
	private Scene scene;
	private Parent root;
	private RiskReductionFour securityCheck = new RiskReductionFour();
	private double start;
	private double time;
	
    @FXML
    private TextField usernameField;
    
    @FXML
    private TextField passwordField;
    
    @FXML
    private TextField errorLabel;
    
	 public void switchToSignIn(ActionEvent event) throws IOException {
	    	root = FXMLLoader.load(getClass().getResource("signIn.fxml"));
	    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    	scene = new Scene(root);
	    	stage.setScene(scene);
	    	stage.show();
	    }

	    public void login(ActionEvent event) throws IOException {
	        // Check if the username and password are "admin"
	        String username = usernameField.getText();
	        String password = passwordField.getText();
	        
	        securityCheck.insert(username, password);

	        if (securityCheck.search(username, password)) {
	            // Successful login, switch to log editor
	        	switchToConsoleScene(event);
	        } else {
	            // Invalid credentials, you can show an error message or handle it as needed
	        	errorLabel.setVisible(true);
	            
	        }
	    }
	    public void switchToLogEditor(ActionEvent event) throws IOException {
	    	  root = FXMLLoader.load(getClass().getResource("EffortLogEditorScene.fxml"));
	    	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	    	  scene = new Scene(root);
	    	  stage.setScene(scene);
	    	  stage.show();
	    }
	    
	public void switchToDefectConsoleScene(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("DefectConsoleScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show(); 
	}
	
	public void switchToConsoleScene(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("ConsoleScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToDefinitionsPageScene(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("DefinitionsPageScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToLogsScene(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("LogsScene.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void startTime(ActionEvent event) throws IOException {
		start = System.currentTimeMillis();
	}
	
	public void endTime(ActionEvent event) throws IOException {
		time = (System.currentTimeMillis() - start) / 1000;
		System.out.println(time);
	}
}
