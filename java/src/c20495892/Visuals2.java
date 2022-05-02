package c20495892;

import example.AudioBandsVisual;
import ie.tudublin.*;

public class Visuals2 extends Visual
{    
   
    Terrain t1;
    maskVisual m1;
    
    public void settings()
    {
       
        //size(1024, 500);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        fullScreen(P3D, SPAN); 
    }

    public void setup()
    {       
        startMinim();
        
        t1 = new Terrain(this);
        m1 = new maskVisual(this);
       

        m1.loadSvg();
        m1.printSvg();
        
                
        // Call loadAudio to load an audio file to process 
        loadAudio("crystalised.mp3"); 
        
       
        

       
        
        // Call this instead to read audio from the microphone
        //startListening(); 
      

        try {
            
            calculateFFT();
        } catch (VisualException e) {
            System.out.println("please loadfile or start listening");
        }
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
    }

    public void draw()
    {
        background(0);
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();        

      m1.render();
    }
}
