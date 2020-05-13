/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafinal;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;

public class EffectSound {
    
    AudioInputStream ais;
    public void SE(String s) {
        try{
            
            ais = AudioSystem.getAudioInputStream(new File("src/resourcepack/"+s+".wav"));
            
            
            Clip clip = AudioSystem.getClip();
            clip.stop();
            clip.open(ais);
            clip.start();
        }catch(Exception e) {
            
        }
    }
}