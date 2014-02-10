package unit.factory.mocks;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MockStage extends Stage {
	
	public boolean drawCalled = false;

	public MockStage(int i, int j, boolean b, Batch dummyBatch) {
		super(i, j, b, dummyBatch);
	}

	@Override
	public void act(float delta) {}
	
	@Override
	public void draw() {
		drawCalled  = true;
	}
}