package example;

import ie.tudublin.*;

public class MyVisual extends Visual
{    
    WaveForm wf;
    RotatingAudioBands abv;
    int cols, rows;
    int scl = 20;
    int w = 2000;
    int h = 1600;

    float flying = 0;

    float[][] terrain;

    public void settings()
    {
        size(1024, 500, P3D);
        cols = w / scl;
        rows = h/ scl;
        terrain = new float[cols][rows];
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("heroplanet.mp3");   

        
        // Call this instead to read audio from the microphone
        //startListening(); 
        
        wf = new WaveForm(this);
        abv = new RotatingAudioBands();
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
        wf.render();
        abv.draw();
    }
}
