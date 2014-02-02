package org.iwt2.crushthecady.model;

import java.util.ArrayList;
import java.util.List;

import org.iwt2.crushthecady.view.Constants;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;



public class EnemyColumn extends VerticalGroup {
	//List<Candy> candies;
	
	public EnemyColumn() {
		//this.candies = new ArrayList<Candy>();
		//this.setReverse(true);
		this.setTop();
	}

	public int candies() {
		//return this.candies.size();
		return this.getChildren().size;
	}

	public void addCandy(Candy candy) {
		//this.candies.add(candy);
		this.addActor(candy);
	}
/*
	public List<Candy> getCandies() {
		return this.candies;
	}
*/
	public void allCandiesDown() {
		//Candy c;
		for (Actor c: this.getChildren()) {
			c.setY(c.getY() - Constants.CANDYHEIDHT);
		}
		
	}
	
	

}
