package org.iwt2.crushthecady.view;

import java.util.ArrayList;
import java.util.List;

public class TextureLoader {

	
	TextureDict dict;


	
	public TextureLoader() {
		dict = new TextureDict();
	}
	
	
	void loadCandies() {	
		for(String name: Constants.COLORS) {
			this.dict.addTexture(name);
		}
		this.dict.load();
		
	}


	
	/**
	 * 
	 * @return the dictionary containingall the texturesincluded in this loader.
	 */
	public TextureDict getTextureDictionary() {
		loadCandies();
		return dict;
	}





}
