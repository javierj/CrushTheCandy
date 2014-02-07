package org.iwt2.crushthecady.model.logic;

import static org.junit.Assert.*;

import org.iwt2.crushthecady.model.Candy;
import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class TestActionNotification implements CandyListener {

	private boolean called;

	@Before
	public void setUp() throws Exception {
		called = false;
	}

	@Test
	public void testNitificationWhenActionEnds() {
		Actor demo = new Actor();
		NotificationAction action = new NotificationAction(this, null);
		
		demo.addAction(action);
		
		demo.act((float) 1.0);
		
		assertTrue(called);
		
		
	}
	
	

	@Override
	public void candyEvent(Candy c) {
		this.called = true;
		
	}
	
	//---------------------------------------------------
	


	

}
