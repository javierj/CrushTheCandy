package org.iwt2.crushthecady.presenter;

import static org.junit.Assert.*;

import org.iwt2.crushthecady.model.Room;
import org.junit.Before;
import org.junit.Test;

public class TestGamePlay {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void whenTimeExpires_ANewRowIsAdded() {
		Room r = new Room();
		r.setCandyEnemies(mockCandyEnemies);
		AddRowEvent event = new AddRowEvent(r);
		Timer t = Timer(1f, event);
		
		t.expires();
		
		assertTrue(mockCandyEnemies.called_oneRowMore);
	}

}
