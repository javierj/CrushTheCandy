package org.iwt2.crushthecady.model;


import org.iwt2.crushthecady.view.Constants;
import org.iwt2.crushthecady.model.logic.CandyListener;
import org.iwt2.crushthecady.model.logic.NotificationAction;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actions.AfterAction;
import com.badlogic.gdx.scenes.scene2d.actions.AlphaAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Candy extends Image {

	String colorId;
	
	public Candy(String colorId) {
		this.colorId = colorId;
	}

	public Candy(String colorId, Texture texture) {
		super(texture);
		this.colorId = colorId;
	}

	public String getColorId() {
		return this.colorId;
	}

	
	
	public void moveTo(float x, float y) {
		MoveToAction move = new MoveToAction();
		move.setPosition(x, y);
		move.setDuration(0.6f);
		this.addAction(move);
	}

	
	public void moveTo(float x, float y, CandyListener listener) {
		this.moveTo(x, y);
		
		
		this.addAction(createNotifyAction(listener));
	}


	private AfterAction createNotifyAction(CandyListener listener) {
		NotificationAction notification = new NotificationAction(listener, this);
		AfterAction notifyAction = new AfterAction();
		notifyAction.setAction(notification);
		
		return notifyAction;
	}






	public boolean deleted = false;
	
	public void delete(CandyListener listener) {
		deleted = true;
		AlphaAction aa = new AlphaAction();
		aa.setAlpha(0f);
		aa.setDuration(0.5f);
		
		this.addAction(aa);
		
		this.addAction(createNotifyAction(listener));

	}

	public boolean deleted() {
		return deleted;
	}

	public boolean sameColor(Candy candyFromPlayer) {
		return this.colorId.equals(candyFromPlayer.getColorId());
	}
}
