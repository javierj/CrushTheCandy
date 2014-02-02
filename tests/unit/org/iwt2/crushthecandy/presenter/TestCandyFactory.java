package unit.org.iwt2.crushthecandy.presenter;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.iwt2.crushthecady.model.Candy;
import org.iwt2.crushthecady.presenter.CandyFactory;
import org.iwt2.crushthecady.view.TextureDict;
import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.graphics.Texture;

public class TestCandyFactory {

	private CandyFactory cf;
	private FakeTextureDict mockDict;

	@Before
	public void setUp() throws Exception {
		this.mockDict = new FakeTextureDict();
		this.cf = new CandyFactory(mockDict);
	}

	@Test
	public void candyFactory_createsCandywithIndicatedColor() {
		
		Candy c = cf.createwithColorId("Red");
		
		assertThat(c.getColorId(), is("Red"));
	}

	@Test
	public void candyFactory_createsCandywithTheTextureforTheColor() {
		
		Candy c = cf.createwithColorId("Red");
		
		assertThat(this.mockDict.texture, is("Red"));
	}

	@Test
	public void testCreateWirhRandomColorId() {
		String[] color = { "Red", "Yellow", "Orange" };
		List<String> colors = Arrays.asList("Red", "Yellow", "Orange");
		this.cf.setColors(color);
		
		Candy c = this.cf.createwithRandomColorId();
		
		assertTrue(colors.contains(c.getColorId()));
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
