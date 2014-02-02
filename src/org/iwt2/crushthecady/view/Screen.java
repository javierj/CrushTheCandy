package org.iwt2.crushthecady.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

public class Screen {

	public static void Clear() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
	}

}
