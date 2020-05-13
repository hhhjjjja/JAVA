/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafinal;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class BgmPlay {
    static Clip clip;
        
    static public void playMusic(String bgmfile, boolean loop) {
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(bgmfile))));
            clip.start();
            if(loop) clip.loop(-1);
        } catch(Exception e) { }
    }
    static public void stopMusic() {
        clip.stop();
    }
    
}