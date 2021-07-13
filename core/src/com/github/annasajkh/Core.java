package com.github.annasajkh;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;

public class Core extends ApplicationAdapter
{
	public static float gameScale = 0.35f;
	public static Player player;	
	public static Platform lastPlatform;
	
	SpriteBatch spriteBatch;
	Sprite background;

	List<Platform> platforms;
	
	@Override
	public void create()
	{
		background = new Sprite(new Texture(Gdx.files.internal("Background.png")));
		Sprite playerSprite = new Sprite(new Texture(Gdx.files.internal("Doodler.png")));
		Sprite platformSprite = new Sprite(new Texture(Gdx.files.internal("Platform.png")));
		
		spriteBatch = new SpriteBatch();
		
		float mostBottomPlatformY = 1000;
		float mostBottomPlatformX = 1000;
		
		platforms = new ArrayList<>();
		for(int i = 0; i < 30; i++)
		{
			Platform platform = new Platform(	MathUtils.random(Gdx.graphics.getWidth() -  platformSprite.getWidth() / 2),
								MathUtils.random(Gdx.graphics.getHeight() + Gdx.graphics.getHeight() + 200),
								platformSprite);
			
			platforms.add(platform);
			
			if(mostBottomPlatformY > platform.rect.y)
			{
				mostBottomPlatformY = platform.rect.y;
				mostBottomPlatformX = platform.rect.x;
			}
		}
		

		player = new Player(mostBottomPlatformX, mostBottomPlatformY + platformSprite.getHeight() * 2, playerSprite);
		
		
	}
	
	public void update(float delta)
	{
		player.update(delta);
		
		for(Platform platform : platforms)
		{
			platform.update(delta);
		}
		
		for(Platform platform : platforms)
		{
			
			if(platform.rect.overlaps(player.rect))
			{
				player.collide(platform, delta);
				lastPlatform = platform;
			}
		}
		
		if(lastPlatform != null && lastPlatform.rect.y > Gdx.graphics.getHeight() * 3)
		{
			create();
		}
		
		
	}

	@Override
	public void render()
	{
		update(Gdx.graphics.getDeltaTime());
		
		ScreenUtils.clear(0, 0, 0, 1);
		
		spriteBatch.begin();
		
		spriteBatch.draw(background,0,0,0,0,background.getWidth(),background.getHeight(),0.7f,0.7f,0);
		
		player.draw(spriteBatch);
		
		for(Platform platform : platforms)
		{
			platform.draw(spriteBatch);
		}
		
		spriteBatch.end();
	}

	@Override
	public void dispose()
	{
		spriteBatch.dispose();
	}
}
