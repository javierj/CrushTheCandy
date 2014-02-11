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

	
	/**
	 * Duarion is constands and therefrore, the speed depends on
	 * thye distance.
	 * Speed should be standard ans it should be a constant in
	 * Constants class.
	 * @param x
	 * @param y
	 */
	public void moveTo(float x, float y) {
		MoveToAction move = new MoveToAction();
		move.setPosition(x, y);
		move.setDuration(0.4f);
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

	/**
	 * Adds an alpha action to decrease the alphA to cero
	 * @param listener
	 */
	public void delete(CandyListener listener) {		
		AlphaAction aa = new AlphaAction();
		aa.setAlpha(0f);
		aa.setDuration(0.5f);
		
		this.addAction(aa);
		
		//this.addAction(createNotifyAction(listener));
		//listener.candyEvent(this);
		//this.setColor(getColor().r, getColor().g, getColor().b, 0f);
		//System.out.println("Delete");
	}

	public boolean sameColor(Candy candyFromPlayer) {
		return this.colorId.equals(candyFromPlayer.getColorId());
	}
}
