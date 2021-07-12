package com.github.annasajkh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Player extends GameObject
{
	float gravity = 50;
	float speed = 200;
	float jumpHeight = 800;
	float tempY;
	
	
	public Player(float x, float y, Sprite sprite)
	{
		super(x, y, sprite);
		
		tempY = y;
		
	}

	@Override
	public void update(float delta)
	{
		super.update(delta);
		rect.y = tempY;
		
		
		getInput(delta);
		
		velY -= gravity * delta;
	}
	
	public void collide(Platform platform, float delta)
	{
		velY = jumpHeight * delta;
	}
	
	public void getInput(float delta)
	{
		if(Gdx.input.isKeyPressed(Keys.A))
		{
			velX = -speed * delta;
		}
		else if(Gdx.input.isKeyPressed(Keys.D))
		{
			velX = speed * delta;
		}
		else
		{
			velX = 0;
		}
		
	}

}
