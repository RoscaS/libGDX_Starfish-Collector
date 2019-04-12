package ch3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Turtle extends BaseActor {

    public Turtle(float x, float y, Stage s) {
        super(x, y, s);
        String[] filenames = {
                "ch3/turtle-1.png", "ch3/turtle-2.png", "ch3/turtle-3.png",
                "ch3/turtle-4.png", "ch3/turtle-5.png", "ch3/turtle-6.png"
        };
        loadAnimationFromFiles(filenames, 0.1f, true);

        setAcceleration(400);
        setMaxSpeed(100);
        setDeceleration(400);
    }

    public void act(float dt) {
        super.act(dt);

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) accelerateAtAngle(180);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) accelerateAtAngle(0);
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) accelerateAtAngle(90);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) accelerateAtAngle(270);

        applyPhysics(dt);
        setAnimationPaused(!isMoving());

        // turtle is always facing the direction of his movement
        if (getSpeed() > 0) setRotation(getMotionAngle());
    }
}
