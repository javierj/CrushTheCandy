package org.iwt2.crushthecady.presenter;

import java.util.Random;

import org.iwt2.crushthecady.model.Candy;
import org.iwt2.crushthecady.view.Constants;
import org.iwt2.crushthecady.view.TextureDict;

import com.badlogic.gdx.graphics.Texture;

public class CandyFactory {

	private TextureDict textureDict;
	private String[] colors;
	private Random random;

	public CandyFactory(TextureDict textureDict) {
		this.textureDict = textureDict;
		this.colors = Constants.COLORS;
		this.random = new Random();
	}

	public Candy createwithColorId(String colorId) {
		Texture t = this.textureDict.getTexture(colorId);
		Candy c;
		if ( t == null) {
			System.err.println("CandyFactory::createwithColorId() - ColorID:"+ colorId+ " returns a null texture");
			c = new Candy(colorId);
		} else {
			c = new Candy(colorId, t);

		}
		
		return c;
	}
	
	public void setColors(String[] colors) {
		this.colors = colors;	
	}

	public Candy createwithRandomColorId() {
		
		String colorId = this.colors[random.nextInt(this.colors.length)];
		
		return this.createwithColorId(colorId);
	}

}
