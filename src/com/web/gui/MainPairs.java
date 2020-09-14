package com.web.gui;

import java.util.ArrayList;

import com.web.connection.DatabaseMethods;
import com.web.models.Word;
import com.web.models.WordPairs;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainPairs extends Application {

	public static void main(String[] args) {
		launch(args);
	}

// https://www.youtube.com/watch?v=RDvAx1_rIxk
	@Override
	public void start(@SuppressWarnings("exports") Stage prymaryStage) throws Exception {
		prymaryStage.setTitle("From DataBase to CSV");

		// VBoxes (se puede meter una dentro de otra sin problema
		VBox boxWord1 = new VBox();
		VBox boxWord2 = new VBox();

		// HBox
		HBox boxFooter = new HBox();

		// box Word 1
		boxWord1.setPadding(new Insets(10, 10, 10, 10));
		boxWord1.setPrefWidth(600);
//		boxWord1.setPrefHeight(100);
		boxWord1.setAlignment(Pos.TOP_CENTER);
		boxWord1.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));

		// box Word 2
		boxWord2.setPadding(new Insets(10, 10, 10, 10));
		boxWord2.setPrefWidth(600);
//		boxWord2.setPrefHeight(100);
		boxWord2.setAlignment(Pos.TOP_CENTER);
		boxWord2.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));

		// box footer
		boxFooter.setPadding(new Insets(10, 10, 10, 10));
		boxFooter.setPrefHeight(100);
		boxFooter.setAlignment(Pos.BASELINE_CENTER);
		boxFooter.setBorder(new Border(
				new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));

		// Label word Title 1
		Label labelWordTitle1 = new Label("Word 1:");
		labelWordTitle1.setFont(new Font("Arial", 30));
		labelWordTitle1.setPadding(new Insets(10, 10, 10, 10)); // top/right/bottom/left

		// Label word Title 2
		Label labelWordTitle2 = new Label("Word 2:");
		labelWordTitle2.setFont(new Font("Arial", 30));
		labelWordTitle2.setPadding(new Insets(10, 10, 10, 10));

		// Label word Real 1
		Label labelWordReal1 = new Label();
		labelWordReal1.setFont(new Font("Arial", 15));
		labelWordReal1.setPadding(new Insets(10, 10, 10, 10)); // top/right/bottom/left

		// Label word Real 2
		Label labelWordReal2 = new Label();
		labelWordReal2.setFont(new Font("Arial", 15));
		labelWordReal2.setPadding(new Insets(10, 10, 10, 10));

		// Label ipa 1
		Label labelIpaWord1 = new Label("IPA");
		labelIpaWord1.setFont(new Font("Arial", 15));
		labelIpaWord1.setPadding(new Insets(10, 10, 10, 10));

		// Label ipa 2
		Label labelIpaWord2 = new Label("IPA");
		labelIpaWord2.setFont(new Font("Arial", 15));
		labelIpaWord2.setPadding(new Insets(10, 10, 10, 10));

		// Label sound 1
		Label labelSoundWord1 = new Label("Sound");
		labelSoundWord1.setFont(new Font("Arial", 15));
		labelSoundWord1.setPadding(new Insets(10, 10, 10, 10));

		// Label sound 2
		Label labelSoundWord2 = new Label("Sound");
		labelSoundWord2.setFont(new Font("Arial", 15));
		labelSoundWord2.setPadding(new Insets(10, 10, 10, 10));

		// Label log
		Label labelLog = new Label("Log:");
		labelLog.setFont(new Font("Arial", 15));
		labelLog.setPadding(new Insets(10, 10, 10, 10));

		// Label log content
		Label labelLogContent = new Label("Default");
		labelLogContent.setFont(new Font("Arial", 15));
		labelLogContent.setPadding(new Insets(10, 10, 10, 10));

		// ChoiceBox for word1
		ChoiceBox<String> choiceBoxWord1Ipa = new ChoiceBox<>();
		ChoiceBox<String> choiceBoxWord1Sound = new ChoiceBox<>();

		// ChoiceBox for word2
		ChoiceBox<String> choiceBoxWord2Ipa = new ChoiceBox<>();
		ChoiceBox<String> choiceBoxWord2Sound = new ChoiceBox<>();

		// Button play Audio1
		Button buttonPlayAudio1 = new Button("Play Audio");
		VBox.setMargin(buttonPlayAudio1, new Insets(10, 10, 10, 10));

		// Button play Audio2
		Button buttonPlayAudio2 = new Button("Play Audio");
		VBox.setMargin(buttonPlayAudio2, new Insets(10, 10, 10, 10));

		// Button add to CSV word1
		Button buttonAddCSVWord1 = new Button("Add word to CSV");
		VBox.setMargin(buttonAddCSVWord1, new Insets(10, 10, 10, 10));

		// Button add to CSV word2
		Button buttonAddCSVWord2 = new Button("Add word to CSV");
		VBox.setMargin(buttonAddCSVWord2, new Insets(10, 10, 10, 10));

		// Button Load Next
		Button buttonLoadNext = new Button("Load next pair");
		buttonLoadNext.setOnAction(e -> {
			WordPairs wordP = new WordPairs();
			// word1 features
			Word w1 = wordP.getWord1();
			labelWordReal1.setText(w1.getName());
			ArrayList<String> ipaList1 = new ArrayList<String>();
			ipaList1 = w1.getIpas();
			choiceBoxWord1Ipa.getItems().addAll(ipaList1);
			ArrayList<String> soundList1 = new ArrayList<>();
			soundList1 = w1.getSounds();
			choiceBoxWord1Sound.getItems().addAll(soundList1);
			buttonPlayAudio1.setOnAction(f -> {
				String path = "";
				String audio = path + choiceBoxWord1Sound.getValue();
				// System.out.println(audio);
				GuiMethods.playAudio(audio);
			});
			buttonAddCSVWord1.setOnAction(g -> {
				String sound = choiceBoxWord1Sound.getValue();
				String word1 = labelWordReal1.getText();
				String word2 = labelWordReal2.getText();
				String IPA = choiceBoxWord1Ipa.getValue();
				String csvString = GuiMethods.createString(sound, word1, word2, IPA, 1);
				// System.out.println(csvString);
				GuiMethods.writeCSV(csvString);
				String path = "";
				String audio = path + choiceBoxWord1Sound.getValue() + " ";
				String path2 = "";
				GuiMethods.copyFile(audio, path2);
				labelLogContent.setText("First word added");
			});

			// word2 features
			Word w2 = wordP.getWord2();
			labelWordReal2.setText(w2.getName());
			ArrayList<String> ipaList2 = new ArrayList<String>();
			ipaList2 = w2.getIpas();
			choiceBoxWord2Ipa.getItems().addAll(ipaList2);
			ArrayList<String> soundList2 = new ArrayList<>();
			soundList2 = w2.getSounds();
			choiceBoxWord2Sound.getItems().addAll(soundList2);
			buttonPlayAudio2.setOnAction(f -> {
				String path = "";
				String audio = path + choiceBoxWord2Sound.getValue();
				// System.out.println(audio);
				GuiMethods.playAudio(audio);
			});
			buttonAddCSVWord2.setOnAction(g -> {
				String sound = choiceBoxWord2Sound.getValue();
				String word1 = labelWordReal1.getText();
				String word2 = labelWordReal2.getText();
				String IPA = choiceBoxWord2Ipa.getValue();
				String csvString = GuiMethods.createString(sound, word1, word2, IPA, 2);
				// System.out.println(csvString);
				GuiMethods.writeCSV(csvString);
				String path = "";
				String audio = path + choiceBoxWord2Sound.getValue() + " ";
				String path2 = "";
				GuiMethods.copyFile(audio, path2);
				labelLogContent.setText("Second word added");
			});
			labelLogContent.setText("Pair loaded");

		});
		HBox.setMargin(buttonLoadNext, new Insets(10, 10, 10, 10));

		// Button unload pair
		Button buttonUnloadNext = new Button("Unload pair");
		buttonUnloadNext.setOnAction(e -> {
			labelWordReal1.setText("");
			labelWordReal2.setText("");
			choiceBoxWord1Ipa.getItems().clear();
			choiceBoxWord2Ipa.getItems().clear();
			choiceBoxWord1Sound.getItems().clear();
			choiceBoxWord2Sound.getItems().clear();
			labelLogContent.setText("Pair unloaded");
		});
		HBox.setMargin(buttonUnloadNext, new Insets(10, 10, 10, 10));

		// Button pair added CSV == 1
		Button buttonAddPair = new Button("Pair added");
		buttonAddPair.setOnAction(e -> {
			DatabaseMethods.setLastPairCSV();
			labelLogContent.setText("Pair added");			
		});
		HBox.setMargin(buttonAddPair, new Insets(10, 10, 10, 10));

		// Button Discard Pair CSV == 2
		Button buttonDiscardPair = new Button("Discard pair");
		buttonDiscardPair.setOnAction(e -> {
			DatabaseMethods.discardLastPairCSV();
			labelLogContent.setText("Pair discarded");
		});
		HBox.setMargin(buttonDiscardPair, new Insets(10, 10, 10, 10));

		// Adding elements to boxes
		boxWord1.getChildren().addAll(labelWordTitle1, labelWordReal1, labelIpaWord1, choiceBoxWord1Ipa,
				labelSoundWord1, choiceBoxWord1Sound, buttonPlayAudio1, buttonAddCSVWord1);
//		boxWord1.setAlignment(Pos.BASELINE_LEFT);
		boxWord2.getChildren().addAll(labelWordTitle2, labelWordReal2, labelIpaWord2, choiceBoxWord2Ipa,
				labelSoundWord2, choiceBoxWord2Sound, buttonPlayAudio2, buttonAddCSVWord2);
		boxFooter.getChildren().addAll(buttonLoadNext, buttonAddPair, buttonUnloadNext, buttonDiscardPair, labelLog,
				labelLogContent);

		BorderPane borderPane = new BorderPane();
		borderPane.setLeft(boxWord1);
		borderPane.setRight(boxWord2);
		borderPane.setBottom(boxFooter);
		// BorderPane.setAlignment(list, Pos.TOP_LEFT);

		Scene scene = new Scene(borderPane, 1200, 800);

		prymaryStage.setScene(scene);
		prymaryStage.show();
	}

	public void handle(@SuppressWarnings("exports") ActionEvent event) {
		// TODO Auto-generated method stub

	}

}