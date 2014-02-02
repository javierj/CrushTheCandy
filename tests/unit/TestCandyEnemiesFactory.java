package unit;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.iwt2.crushthecady.model.CandyEnemies;
import org.iwt2.crushthecady.model.CandyEnemiesFactory;
import org.iwt2.crushthecady.model.EnemyColumn;
import org.iwt2.crushthecady.view.Constants;
import org.junit.Before;
import org.junit.Test;

import unit.factory.CandyFactoryFactory;

public class TestCandyEnemiesFactory {

	private CandyEnemies ce;

	@Before
	public void setUp() throws Exception {
		CandyEnemiesFactory ceFactory= new CandyEnemiesFactory(new CandyFactoryFactory().createCandyFactory());
		this.ce = ceFactory.create(9);
	}

	@Test
	public void test_9_columns() {
		assertThat(ce.columns().size(), is(9));
	}

	@Test
	public void test_3_candiesInEachColumns() {
		for (EnemyColumn ec: ce.columns()) {
			assertThat(ec.candies(), is(3));	
		}
	}

	/**
	 * The last candy in the list is the first i the column
	 * Last cadie in the column is always 0
	 */
	@Test
	public void test_CandiesAreInTheTopOfTheColumn() {
		EnemyColumn ec = ce.columns().get(0);
		
		assertThat(ec.getCandies().get(2).getY(), is((float)(Constants.HEIGHT - Constants.CANDYHEIDHT )));	
		assertThat(ec.getCandies().get(1).getY(), is((float)(Constants.HEIGHT - (Constants.CANDYHEIDHT * 2) )));	
		
	}

	
	@Test
	public void test_CandiesAreInTheRow() {
		EnemyColumn ec1 = ce.columns().get(0);
		EnemyColumn ec2 = ce.columns().get(1);
		
		assertThat(ec1.getCandies().get(0).getX(), is((float)(Constants.STARTENEMIESX)));	
		assertThat(ec2.getCandies().get(0).getX(), is((float)(Constants.STARTENEMIESX + Constants.CANDYWIDHT )));	
		
	}

	/*@Test
	public void test_EnemyColumnsXandY() {
		EnemyColumn ec1 = ce.columns().get(0);
		EnemyColumn ec2 = ce.columns().get(1);
		
		assertThat(ec1.getX(), is((float)(Constants.STARTENEMIESX)));	
		assertThat(ec2.getX(), is((float)(Constants.STARTENEMIESX + Constants.CANDYWIDHT )));	
		assertThat(ec1.getY(), is(0f));	
		assertThat(ec2.getY(), is(0f));	

	}*/

}
