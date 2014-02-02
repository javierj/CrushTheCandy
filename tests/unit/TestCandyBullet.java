package unit;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.iwt2.crushthecady.model.Candy;
import org.iwt2.crushthecady.model.CandyBullet;
import org.iwt2.crushthecady.view.Constants;
import org.junit.Before;
import org.junit.Test;

public class TestCandyBullet {

	private CandyBullet cb;
	private Candy c02;
	private Candy c01;

	@Before
	public void setUp() throws Exception {
		this.cb = new CandyBullet();
		this.c01 = new Candy("Red");
		this.c02 = new Candy("Red");
		c01.setPosition(-1f, -1f);
		c02.setPosition(-1f, -1f);
		
		cb.addCandy(c01);
		cb.addCandy(c02);
	}

	@Test
	public void whenAddigANewCady_Xis0() {
		assertThat(c01.getX(), is(0f));
		assertThat(c02.getX(), is(0f));

	}

	@Test
	public void whenAddigANewCady_Yis50perEachCandy() {
		Candy c03 = new Candy("Red");
		
		cb.addCandy(c03);

		assertThat(c01.getY(), is(0f));
		assertThat(c02.getY(), is((float)Constants.CANDYHEIDHT));
		assertThat(c03.getY(), is((float)Constants.CANDYHEIDHT * 2));
	}

}
