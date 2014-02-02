package unit.factory;

import static org.mockito.Mockito.mock;

import org.iwt2.crushthecady.model.Room;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class RoomFactory {

	public static Room createRoom() {
		Gdx.graphics = mock(Graphics.class);
		Batch dummyBatch =mock(Batch.class);
		Stage mockStage = new Stage(750, 500, false, dummyBatch);
		
		return new Room(mockStage);
	}
}
