package org.iwt2.crushthecady.model;

import java.util.ArrayList;
import java.util.List;

import org.iwt2.crushthecady.view.Constants;



public class EnemyColumn /*extends VerticalGroup*/ {
	List<Candy> candies;
	
	public EnemyColumn() {
		this.candies = new ArrayList<Candy>();
	}

	public int candies() {
		return this.candies.size();
	}

	public void addCandy(Candy candy) {
		this.candies.add(candy);
	}

	public List<Candy> getCandies() {
		return this.candies;
	}

	public void allCandiesDown() {
		for (Candy c: this.candies) {
			c.setY(c.getY() - Constants.CANDYHEIDHT);
		}
		
	}
	
	

}
