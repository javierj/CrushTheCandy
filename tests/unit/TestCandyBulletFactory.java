package unit;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.iwt2.crushthecady.model.CandyBullet;
import org.iwt2.crushthecady.model.CandyBulletFactory;
import org.iwt2.crushthecady.presenter.CandyFactory;
import org.junit.Before;
import org.junit.Test;

import unit.factory.CandyFactoryFactory;

public class TestCandyBulletFactory {

	private String[] colors = { "Red" };
	private CandyBulletFactory factory;


	@Before
	public void setUp() throws Exception {
		CandyFactory cf = new CandyFactoryFactory().createCandyFactory();
		cf.setColors(colors);		
		this.factory = new CandyBulletFactory(
				cf
				);

	}

	@Test
	public void testCreateACadyBullen_OneBall() {
		CandyBullet cb = factory.create(1);
		
		assertThat(cb.candies(), is(1));		
	}


}
