package unit.factory.mocks;

import com.badlogic.gdx.graphics.g2d.Batch;
import static org.mockito.Mockito.*;

public class Batchs {
	public static Batch dummy() {
		return mock(Batch.class);
	}
}
