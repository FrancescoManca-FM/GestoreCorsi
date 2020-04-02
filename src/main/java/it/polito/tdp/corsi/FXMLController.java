package it.polito.tdp.corsi;

import java.util.*;
import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.corsi.model.Model;
import it.polito.tdp.corsi.model.Studente;
import it.polito.tdp.corsi.model.Corso;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class FXMLController {
	
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtPeriodo;

    @FXML
    private TextField txtCorso;

    @FXML
    private Button btnCorsiPerPeriodo;

    @FXML
    private Button btnStudenti;

    @FXML
    private Button btnNumeroStudenti;

    @FXML
    private Button btnDivisioneStudenti;

    @FXML
    private TextArea txtRisultato;

    @FXML
    void corsiPerPeriodo(ActionEvent event) {
    	txtRisultato.clear();
    	String pdString = txtPeriodo.getText();
    	Integer pd;
    	
    	try {
    	pd = Integer.parseInt(pdString);
    	}catch(NumberFormatException nfe) {
    		txtRisultato.setText("Devi inserire un numero(1 o 2)");
    		return;
    	}
    	
    	if(!pd.equals(2) && !pd.equals(1)) {
    		txtRisultato.setText("Devi inserire un numero(1 o 2)!");
    		return;
    	}

    	
    	List<Corso> corsi = this.model.getCorsiByPeriodo(pd);
    	for(Corso a : corsi) {
    		txtRisultato.appendText(a.toString()+"\n");
    	}
    }

    @FXML
    void numeroStudenti(ActionEvent event) {
    	txtRisultato.clear();
    	String pdString = txtPeriodo.getText();
    	Integer pd;
    	
    	try {
    	pd = Integer.parseInt(pdString);
    	}catch(NumberFormatException nfe) {
    		txtRisultato.setText("Devi inserire un numero(1 o 2)");
    		return;
    	}
    	
    	if(!pd.equals(2) && !pd.equals(1)) {
    		txtRisultato.setText("Devi inserire un numero(1 o 2)!");
    		return;
    	}
    	
    	Map<Corso,Integer> numeroStudenti = this.model.getIscrittiByPeriodo(pd);
    	for(Corso c : numeroStudenti.keySet()) {
    		txtRisultato.appendText(c.getNome()+ " " + numeroStudenti.get(c) +"\n" );
    	}
    }

    @FXML
    void stampaDivisone(ActionEvent event) {
    	
    	txtRisultato.clear();
    	
    	String codins = txtCorso.getText();
    	
    	if(!this.model.esisteCorso(codins)) {
    		txtRisultato.appendText("Il corso non esiste!");
    		return;
    	}
    	
    	Map<String,Integer> statistiche = this.model.getDivisioneCds(new Corso(codins, null,null,null));
    	
    	for(String cds : statistiche.keySet()) {
    		txtRisultato.appendText(cds+" "+statistiche.get(cds)+"\n");
    	}
    	
    }

    @FXML
    void stampaStudenti(ActionEvent event) {

    	String codins = txtCorso.getText();
    	txtRisultato.clear();
    	
    	// Controllo se il codice corso corrispodne ad uno esistente
    	
    	if(!this.model.esisteCorso(codins)) {
    		txtRisultato.appendText("Il corso non esiste!");
    		return;
    	}
    	
    	List<Studente> studenti = this.model.getStudentiByCorso(new Corso(codins, null,null,null));
    	
    	if(studenti.size()==0) {
    		txtRisultato.setText("Il corso non ha studenti iscritti");
    		
    	}else {
    		for(Studente s:studenti) {
    			txtRisultato.appendText(s.toString()+"\n");
    		}
    	}
    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
    @FXML
    void initialize() {
        assert txtPeriodo != null : "fx:id=\"txtPeriodo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCorsiPerPeriodo != null : "fx:id=\"btnCorsiPerPeriodo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnStudenti != null : "fx:id=\"btnStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnNumeroStudenti != null : "fx:id=\"btnNumeroStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnDivisioneStudenti != null : "fx:id=\"btnDivisioneStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
