package main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Edmund on 1/15/14.
 */
public class Map {

    public final int tileSize = 128;
    boolean[][] canPlaceTowers;
    OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera;
    TiledMap map;

    public final Vector3 ULH = new Vector3(1024/2, 768/2 + 12*128 - 768, 0);
    public final Vector3 LLH = new Vector3(1024/2, 768/2, 0);
    public final Vector3 URH = new Vector3(1024/2 + 16*128 - 1024, 768/2 + 12*128 - 768, 0);
    public final Vector3 LRH = new Vector3(1024/2 + 16*128 - 1024, 768/2, 0);

    public Map()
    {
        canPlaceTowers = new boolean[8][5];


        map = new TmxMapLoader().load("level1.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1.0f);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1024, 368);
        camera.update();
        //camera.position.x = ULH.x;
        //camera.position.y = ULH.y;




    }

    public void update(float dt)
    {
        float dp = 5.0f;
        System.out.println(camera.position.x + ", " + camera.position.y);

        if (Gdx.input.isKeyPressed(Input.Keys.W))
        {
            if (camera.position.y + dp < ULH.y)
                camera.position.y += 5;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S))
        {
            if (camera.position.y - dp > LLH.y)
                camera.position.y -= 5;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A))
        {
            if (camera.position.x - dp > LLH.x)
                camera.position.x -= 5;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D))
        {
            if (camera.position.x + dp < LRH.x)
                camera.position.x += 5;
        }
    }

    public void draw()
    {

        //camera.position.x += 2;
        camera.update();
        renderer.setView(camera);
        renderer.render();
    }


}
