package Final;

import ie.tudublin.*;

public class FinalVisuals extends Visual
{    

    render1 r;
    render2 r2;
    renderS1 r3;
    renderS2 r4;
    maskVisual r5;
    menu menu;
    float rotation=0;
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
        //size(1024, 600, P3D);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        fullScreen(P3D, SPAN); 


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

        r = new render1(this);
        r2 = new render2(this);
        r3 = new renderS1(this);
        r4 = new renderS2(this);
        menu = new menu(this);
        r5 = new maskVisual(this);

        r5.loadSvg();
        r5.printSvg();
        colorMode(HSB);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {

            //getAudioPlayer().cue(0);
            //getAudioPlayer().play();
        }


        if(key=='1')
        {
            mode = 1;
        }

        if(key=='2')
        {
            mode = 2;
        }

        if(key=='3')
        {
            mode = 3;
        }

        if(key=='4')
        {
            mode = 4;
        }

        if(key=='5')
        {
            mode = 5;
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
        if (mode==0)
        {
            menu.render();
        }

        switch (mode) 
        {
            case 1:
                r2.render();
            break;

            case 2:
                r.render();
            break;

            case 3:
                r3.render();
            break;

            case 4:
                r4.render();
            break;

            case 5:
                r5.render();
            break;

            case 9:
                getAudioPlayer().cue(0);
                getAudioPlayer().play();
                mode=1;

            break;

        }
    }
}

