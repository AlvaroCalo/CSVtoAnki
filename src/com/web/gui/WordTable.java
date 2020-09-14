package com.web.gui;

import java.util.ArrayList;

import com.web.models.Word;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class WordTable extends TableView<Word> {

	TableView<Word> myword;
	// TableColumn<Word, String> nameColumn = new TableColumn<>("IPA");

	public WordTable(ObservableList<Word> arg0, String word) {
		super(arg0);
		initTable(word);
		// TODO Auto-generated constructor stub
	}

	// Methods

	private void initTable(String word) {
		TableColumn<Word, String> nameColumn = new TableColumn<>("IPA");
		nameColumn.setMinWidth(100);
		
	}

	public ObservableList<String> getIpas(String word) {
		Word myWord = new Word(word);
		ArrayList<String> ipaList = myWord.getIpas();
		ObservableList<String> ipas = FXCollections.observableArrayList(ipaList);
		return ipas;
	}

	public ObservableList<String> getSounds(String word) {
		Word myWord = new Word(word);
		ArrayList<String> soundsList = myWord.getIpas();
		ObservableList<String> sounds = FXCollections.observableArrayList(soundsList);
		return sounds;
	}

}
