package unit.factory;


import org.iwt2.crushthecady.presenter.CandyFactory;
import org.iwt2.crushthecady.view.TextureDict;

import com.badlogic.gdx.graphics.Texture;

public class CandyFactoryFactory {

	public  CandyFactory createCandyFactory() {
		FakeTextureDict fake = new FakeTextureDict();
		CandyFactory cf = new CandyFactory(fake);
		
		return cf;
	}
	
	public CandyFactory create(String[] colors) {
		CandyFactory cf = createCandyFactory();
		cf.setColors(colors);
		return cf;
	}

	
	//----------------------------------
	 class FakeTextureDict extends TextureDict {
		public String texture = "";
		@Override
		public Texture getTexture(String name) {
			this.texture = name;
			return null;
		}
	}



}
