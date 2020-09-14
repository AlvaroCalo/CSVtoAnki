package com.web.models;

import java.util.ArrayList;

import com.web.connection.DatabaseMethods;

public class Word {

	// Attributes
	private String name;
	private ArrayList<String> ipas = new ArrayList<String>();
	private ArrayList<String> sounds = new ArrayList<String>();

	// Constructor
	public Word(String name) {
		this.name = name;
		this.ipas = listIpas(name);
		this.sounds = listSounds(name);
	}
	
	// Methods
	public ArrayList<String> listIpas(String word) {
		ArrayList<String> ipaList = new ArrayList<String>();
		int id = DatabaseMethods.returnWordId(word);
		ipaList = DatabaseMethods.returnIpaList(id);
		return ipaList;
	}
	
	public ArrayList<String> listSounds(String word) {
		ArrayList<String> soundList = new ArrayList<String>();
		int id = DatabaseMethods.returnWordId(word);
		soundList = DatabaseMethods.returnSoundList(id);
		return soundList;
	}

	// Getter and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getIpas() {
		return ipas;
	}

	public void setIpas(ArrayList<String> ipas) {
		this.ipas = ipas;
	}

	public ArrayList<String> getSounds() {
		return sounds;
	}

	public void setSounds(ArrayList<String> sounds) {
		this.sounds = sounds;
	}

	// toString()
	@Override
	public String toString() {
		return "Word [name=" + name + ", ipas=" + ipas + ", sounds=" + sounds + "]";
	}

}
