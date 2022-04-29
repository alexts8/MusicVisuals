package c20336236;

import processing.core.*;

public class render2
{
    Visuals v;

    public render2(Visuals v) 
    {
        this.v= v;
    }


    public void render()
    {
        v.background(30,100,50);


        //sound hole
        v.stroke(40);
        v.strokeWeight(30);
        v.fill(0);
        v.circle(v.width/2, v.height/2, 450);

        //bridge
        v.strokeWeight(2);
        v.stroke(0);
        v.fill(0);
        v.rect(v.width-90,v.height/2-200,100,400,20);


        //strings
        v.noFill();
        v.stroke(150);
        v.strokeWeight(2);
        int border=150;
        for(int i=0; i<6; i++)
        {
            v.noFill();
            float y = v.map(i, 0,5,border,v.height-border);
            v.bezier(0, y, v.width/2, y+v.getBands()[i]/2, v.width/2, y+v.getBands()[i]/2, v.width, y);
            v.fill(255);
            v.circle(v.width-30,y,15);
        }

    }
}



