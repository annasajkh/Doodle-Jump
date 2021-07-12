package com.github.annasajkh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;

public class Platform extends GameObject
{

	public Platform(float x, float y, Sprite sprite)
	{
		super(x, y, sprite);
	}

	@Override
	public void update(float delta)
	{
		velY = -Core.player.velY;
		
		super.update(delta);
		
		if(rect.y < -Gdx.graphics.getHeight() / 2)
		{
			rect.y = Core.player.rect.y + Gdx.graphics.getHeight();
			rect.x = MathUtils.random(Gdx.graphics.getWidth() - sprite.getWidth() / 2);
		}
	}

}
