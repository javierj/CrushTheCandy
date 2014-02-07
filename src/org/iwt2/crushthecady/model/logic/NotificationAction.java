package org.iwt2.crushthecady.model.logic;



import org.iwt2.crushthecady.model.Candy;

import com.badlogic.gdx.scenes.scene2d.Action;

public class NotificationAction extends Action {

	private CandyListener listener;
	Candy candy;

	public NotificationAction(CandyListener testActionNotification, Candy candy) {
		listener = testActionNotification;
		this.candy = candy;
	}

	@Override
	public boolean act(float delta) {
		listener.candyEvent(candy);
		return true;
	}
	
}