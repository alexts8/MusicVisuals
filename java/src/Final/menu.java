package Final;

import java.util.Map;

public class menu 
{
    FinalVisuals v;
    int sinVal = 0;
    int cosVal = 0;

    public menu(FinalVisuals v) 
    {
        this.v= v;
    }


    void render()
    {   
        update();
        float color = v.map(cosVal, 0, 360, 0, 255);
        float white = v.map(cosVal, 0, 360, 100, 255);
        v.background(0);
        v.translate(v.width/2, v.height/2);
        v.fill(color,255,255);
        v.textAlign(v.CENTER);
        v.textSize(60 + 5 * (v.cos(v.radians(cosVal))));
        v.text("Music Visualiser", 0, -150 + 160 * v.sin(v.radians(sinVal)));
        v.text("The xx - Crystalised", 0, -100 + 160 * v.sin(v.radians(sinVal)));
        v.textSize(30);
        
        v.fill(white);
        v.text("Press g to begin", 0, 0 + 160 * v.sin(v.radians(sinVal)));

        sinVal = (sinVal + 1) % 361;
        cosVal = (cosVal + 2) % 361;

        
        v.noFill();
        v.beginShape();
        v.stroke(200,255,255);
        v.vertex(40,0);
        v.vertex(200, 160);
        v.vertex(160, 200);
       
        v.stroke(150,255,255);
        v.vertex(0, 40);
        v.vertex(-160, 200);
        v.vertex(-200, 160);
        
        v.stroke(100,255,255);
        v.vertex(-40, 0);
        v.vertex(-200, -160);
        v.vertex(-160, -200);

        v.vertex(0, -40);
        v.stroke(50,255,255);
        v.vertex(160, -200);
        v.vertex(200, -160);
        v.vertex(40, 0);
        
        v.endShape();
    }

    public void update()
    {
  
        if (v.keyPressed)
        {
           
            if (v.key == 'g')
            {
                v.mode=9;
            }

        }
    }



}
