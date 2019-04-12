package ch3;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class Starfish extends BaseActor {

    private boolean collected;

    public Starfish(float x, float y, Stage s) {
        super(x, y, s);

        collected = false;

        loadTexture("ch3/starfish.png");
        this.addAction(Actions.forever(Actions.rotateBy(30, 1)));
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean value) {
        collected = value;
    }

    public void collect() {
        collected = true;
        clearActions();
        addAction(Actions.fadeOut(1));
        addAction(Actions.after(Actions.removeActor()));
    }
}
