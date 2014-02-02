package unit;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.iwt2.crushthecady.model.Candy;
import org.junit.Before;
import org.junit.Test;

public class TestCandy {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testANewCandy_HasAColor() {
		Candy c = new Candy("Red");
		
		assertThat(c.getColorId(), is("Red"));
	}

}
