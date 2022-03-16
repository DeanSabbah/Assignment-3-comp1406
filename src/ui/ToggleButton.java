package ui;

import javafx.scene.control.Button;

public class ToggleButton extends Button{
    private boolean on;

    public ToggleButton(){
        this("");
    }
    public ToggleButton(String text){
        super(text);
        setOn(false);
    }
    public void setOn(boolean newValue){
        on = newValue;
        if (on){
            setDisable(false);
        }
        else{
            setDisable(true);
        }
    }
    public void toggle(){
        setOn(!on);
    }
}
