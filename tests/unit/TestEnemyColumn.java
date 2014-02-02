package unit;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.iwt2.crushthecady.model.Candy;
import org.iwt2.crushthecady.model.EnemyColumn;
import org.junit.Before;
import org.junit.Test;

import unit.factory.Candies;

public class TestEnemyColumn {

	@Before
	public void setUp() throws Exception {
	}

	
	@Test
	public void testAllCandiesDown() {
		EnemyColumn ec = new EnemyColumn();
		Candy candy = Candies.red();
		candy.setPosition(100, 100);
		ec.addCandy(candy);
		
		ec.allCandiesDown();
		
		assertThat(candy.getX(), is(100f));
		assertThat(candy.getY(), is(50f));
		
		
	}

}
