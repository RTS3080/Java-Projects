import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Keybinds {

    
    public enum Action {
        MOVE_UP,
        MOVE_DOWN,
        MOVE_LEFT,
        MOVE_RIGHT
    }

    
    private final Map<Action, Integer> keybinds;

    public Keybinds() {
        keybinds = new HashMap<>();
        setDefaultKeybinds();
    }
    
    private void setDefaultKeybinds() {
        keybinds.put(Action.MOVE_UP, KeyEvent.VK_W);
        keybinds.put(Action.MOVE_DOWN, KeyEvent.VK_S);
        keybinds.put(Action.MOVE_LEFT, KeyEvent.VK_A);
        keybinds.put(Action.MOVE_RIGHT, KeyEvent.VK_D);
    }

    public void setKeybind(Action action, int keyCode) {
        keybinds.put(action, keyCode);
    }

    public int getKeybind(Action action) {
        return keybinds.getOrDefault(action, -1); 
    }

    public void printKeybinds() {
        for (Map.Entry<Action, Integer> entry : keybinds.entrySet()) {
            System.out.println(entry.getKey() + " -> " + KeyEvent.getKeyText(entry.getValue()));
        }
    }

    public boolean isActionKey(Action action, int keyCode) {
        return keybinds.getOrDefault(action, -1) == keyCode;
    }
}
