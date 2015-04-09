/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javafx.main.search;

import com.javafx.main.JDBC;
import com.javafx.main.patient.Patient;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
/**
 *
 * @author crepanich23
 */
public class searchController implements Initializable{
   public Patient patient;
   public static String doctorID;
   static int selectedRow = -1;
   
   @FXML private Label userLabel;
   @FXML private TextField searchInput;
   @FXML private Button searchButton;
   @FXML private Button continueButton;
   @FXML private TableView searchTable;
   @FXML private TableColumn firstNameCol;
   @FXML private TableColumn lastNameCol;
   @FXML private TableColumn medicalNumCol;
   @FXML private TableColumn lastVisitCol;
   @FXML private ObservableList patientArrayList;
   
   @Override
   public void initialize(URL url, ResourceBundle rb) {
      ObservableList<Patient> data = searchTable.getItems();
      
      JDBC db = new JDBC();
      List<List> list = db.querySelect("SELECT firstName, lastName, patientID FROM"+
       " patient WHERE doctorID='"+doctorID+"';", 3);
      int i=0;
      for (List item: list){
         Patient add = new Patient((String)item.get(0), (String)item.get(1),
          "", (String)item.get(2), "");
         data.add(add);
      }
   }  
}