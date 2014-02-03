package org.iwt2.crushthecady.model;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Candy extends Image {

	String colorId;
	
	public Candy(String colorId) {
		this.colorId = colorId;
	}

	public Candy(String colorId, Texture texture) {
		super(texture);
		this.colorId = colorId;
	}

	public String getColorId() {
		return this.colorId;
	}
}
