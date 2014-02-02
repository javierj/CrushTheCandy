package org.iwt2.crushthecady.presenter;

import org.iwt2.crushthecady.model.Room;
import org.iwt2.crushthecandy.model.events.AddRowEvent;

public class AddRowTimeEvent {

	
	private Room room;
	private float timeToExpire;
	private AddRowEvent caller;
	private float time;

	public AddRowTimeEvent(float f) {
		this.timeToExpire = f;
		this.setTime(0f);
	}
/*
	public void setRoom(Room r) {
		this.room = r;
		
	}
*/
	public void update(float delta) {
		setTime(getTime() + delta);
		if (getTime() > this.timeToExpire) {
			this.caller.timeExpires();
			this.setTime(0f);
		}
	}

	public void setTimeEventCaller(AddRowEvent event) {
		this.caller = event;
		
	}
	public float getTime() {
		return time;
	}
	public void setTime(float time) {
		this.time = time;
	}

}
