package simplicity;

import org.joml.Vector2f;

import components.Component;
import editor.SImGui;

public class Transform extends Component {
    public Vector2f position;
    public Vector2f scale;
    public float rotation = 0.0f;
    public int zIndex;

    public Transform() {
        init(new Vector2f(), new Vector2f());
    }

    public Transform(Vector2f position) {
        init(position, new Vector2f());
    }

    public Transform(Vector2f position, Vector2f scale) {
        init(position, scale);

    }
    
    public void init(Vector2f position, Vector2f scale) {
        this.position = position;
        this.scale = scale;
        this.zIndex = 0;
    }

    public Transform copy() {
        return new Transform(new Vector2f(this.position), new Vector2f(this.scale));
    }

    @Override
    public void imgui() {
        gameObject.name = SImGui.inputText("Name: ", gameObject.name);
        SImGui.drawVec2fControl("Position", this.position);
        SImGui.drawVec2fControl("Scale", this.scale, 32.0f);
        this.rotation = SImGui.dragFloat("Rotation", this.rotation);
        this.zIndex = SImGui.dragInt("Z-Index", this.zIndex);
    }

    public void copy(Transform to) {
        to.position.set(this.position);
        to.scale.set(this.scale);
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if(!(o instanceof Transform)) return false;

        Transform t = (Transform)o;
        return t.position.equals(this.position) && t.scale.equals(this.scale) && t.rotation == this.rotation && t.zIndex == this.zIndex;
    }
}