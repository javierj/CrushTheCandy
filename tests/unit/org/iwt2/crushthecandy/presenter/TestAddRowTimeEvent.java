package unit.org.iwt2.crushthecandy.presenter;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
import org.iwt2.crushthecady.presenter.AddRowTimeEvent;
import org.iwt2.crushthecandy.model.events.AddRowEvent;
import org.junit.Before;
import org.junit.Test;


public class TestAddRowTimeEvent {

	private AddRowEvent event;
	private AddRowTimeEvent timeEvent;

	@Before
	public void setUp() throws Exception {
		this.event = mock(AddRowEvent.class);
		this.timeEvent = new AddRowTimeEvent(1f);
		timeEvent.setTimeEventCaller(event);
	}

	@Test
	public void testEventCalled() {
		
		
		timeEvent.update(1.1f);
		
		verify(event).timeExpires();
	}

	@Test
	public void testNotEventCalled() {
		
		
		timeEvent.update(0.9f);
		
		verify(event, never()).timeExpires();
	}

	@Test
	public void testResetAfterCall() {
		
		
		timeEvent.update(1.1f);
		timeEvent.update(0.1f);
		
		verify(event, times(1)).timeExpires();
	}

	@Test
	public void testCalledMultipleTimes() {
		
		
		timeEvent.update(1.1f);
		timeEvent.update(1.1f);
		timeEvent.update(1.1f);
		
		verify(event, times(3)).timeExpires();
	}

}
