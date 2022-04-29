package c20336236;

import ie.tudublin.*;

public class Visuals extends Visual
{    

    render1 r;
    render2 r2;
    float rotation=0;
    int mode = 0;

    public void settings()
    {
        size(1024, 600);
        
        // Use this to make fullscreen
        fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("crystalised.mp3");   

        
        // Call this instead to read audio from the microphone
        //startListening(); 

        r = new render1(this);
        r2 = new render2(this);
        colorMode(HSB);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }


        if(key=='1')
        {
            mode = 1;
        }

        if(key=='2')
        {
            mode = 2;
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
        

        switch (mode) 
        {
            case 1:
                r2.render();
            break;

            case 2:
                r.render();
            break;

        }
    }
}

