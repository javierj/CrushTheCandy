package org.iwt2.crushthecady;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import static org.hamcrest.CoreMatchers.*;

import org.iwt2.crushthecady.model.Room;
import org.iwt2.crushthecady.presenter.AddRowTimeEvent;
import org.junit.Before;
import org.junit.Test;

import unit.factory.RoomFactory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.GLCommon;

public class TestCrsuhTheCandy {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testWenRenderIsCalled_AddRowTimeEventIsUpdated() {
		AddRowTimeEvent event = new AddRowTimeEvent(1f);
		MockCrushTheCandy crush = new MockCrushTheCandy();
		crush.setTimeEvent(event);
		Gdx.graphics = mock(Graphics.class);
		Gdx.gl = mock(GLCommon.class);
		Room mockRoom = RoomFactory.createRoom();
		crush.setRoom(mockRoom);
		
		when(Gdx.graphics.getDeltaTime()).thenReturn(0.1f);
		crush.render();
		
		assertThat(event.getTime(), is(0.1f));
		
	}
	
	//--------------------------------------
	
	class MockCrushTheCandy extends CrushTheCandy {
		public MockCrushTheCandy() {
			super(1);
		}
		@Override
		void draw() { }
	}

}
