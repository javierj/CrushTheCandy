package org.iwt2.crushthecady.presenter;

import static org.junit.Assert.*;

import org.iwt2.crushthecady.model.CandyEnemies;
import org.iwt2.crushthecady.model.Room;
import org.junit.Before;
import org.junit.Test;

import unit.factory.CandyFactoryFactory;
import unit.factory.RoomFactory;

public class TestGamePlay {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void whenTimeExpires_ANewRowIsAdded() {
		Room r = RoomFactory.createRoom();
		MockCandyEnemies mockCandyEnemies = new MockCandyEnemies(1);
		r.setCandyEnemies(mockCandyEnemies);
		AddRowTimeEvent event = new AddRowTimeEvent(1f);
		event.setTimeEventCaller(r);
		
		event.update(1.1f);
		
		assertTrue(mockCandyEnemies.called_oneRowMore );
	}
	
	//-------------------------------------
	
	class MockCandyEnemies extends CandyEnemies {

		public MockCandyEnemies(int numOfColumns) {
			super(numOfColumns);
			//this.factory = new CandyFactoryFactory().createCandyFactory();
		}

		public boolean called_oneRowMore = false;
		
		@Override
		public void addOneRow(/*CandyFactory factory*/) {
			this.called_oneRowMore = true;
		}
		
	}

}
