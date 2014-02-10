package unit.factory.mocks;

import org.iwt2.crushthecady.model.Candy;
import org.iwt2.crushthecady.presenter.CandyFactory;

import unit.factory.Candies;

public class FakeCandyFactory extends CandyFactory {

	public FakeCandyFactory() {
		super(new FakeTextureDict());
	}
	
	@Override
	public Candy createwithRandomColorId() {
		return Candies.red();
	}

}
