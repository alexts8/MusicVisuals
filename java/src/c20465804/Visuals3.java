package c20465804;

import ie.tudublin.*;

public class Visuals3 extends Visual {
    renderS1 s1;
    renderS2 s2;
    int mode = 0;
    float a, b, c;
    float x, l, z;
    float lx, ly, lz;
    float dt, deg, deg2;
    int cols;
    int rows;
    float[][] current = new float[cols][rows];
    float[][] prev = new float[cols][rows];

    public void settings()
    {
        size(1024, 600,P3D);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 

        a = 10;
        b = 28;
        c = 8/3;

        x = (float) 0.01;
        l = z = 0;
        dt = (float) 0.01;

        cols = width;
        rows = height;
        current = new float[cols][rows];
        prev = new float[cols][rows];

        current[width/4][height/4]= 255;
        current[width/4*3][height/4] = 255;
        current[width/4][height/4*3] = 255;
        current[width/4*3][height/4*3] = 255;
    }

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("crystalised.mp3");   

        
        // Call this instead to read audio from the microphone
        //startListening(); 

        s1 = new renderS1(this);
        s2 = new renderS2(this);
        colorMode(HSB);
    }

    public void keyPressed()
    {
        if (key == '1')
        {
            mode = 1;
        }
        if (key == '2')
        {
            mode = 2;
        }
        if (key == '3')
        {
            mode = 3;
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
        // Call this if you want to use frequency bands
        calculateAverageAmplitude();
        switch(mode)
        {
            case 1:
                s1.render();
            break;

            case 2:
                s2.render();
            break;

            case 9:
                getAudioPlayer().cue(0);
                getAudioPlayer().play();
                mode=1;

            break;
        }
    }
}