package com.github.annasajkh;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class GameObject
{

	float velX, velY;
	
	Sprite sprite;	
	Rectangle rect;
	
	
	public GameObject(float x, float y, Sprite sprite)
	{
		
		this.sprite = sprite;
		
		rect = new Rectangle(x, y, sprite.getWidth() * Core.gameScale, sprite.getHeight() * Core.gameScale);
	}
	
	public void update(float delta)
	{
		rect.x += velX;
		rect.y += velY;
	}
	
	public void draw(SpriteBatch spriteBatch)
	{
		spriteBatch.draw(sprite, rect.x,rect.y,0,0,sprite.getWidth(), sprite.getHeight(), Core.gameScale, Core.gameScale, 0);
	}
	
	
}
