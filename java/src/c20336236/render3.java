package c20336236;

import processing.core.PVector;
import java.util.ArrayList;

public class render3
{
    Visuals v;

    public render3(Visuals v) 
    {
        this.v= v;
    }
    
    float y = 0;
    float x, l, z;
    float a, b, c;
    float lx, ly, lz;
    float dt, deg, deg2;
    ArrayList<PVector> points = new ArrayList<PVector>();
    

    public void render()
    {
        
        a = 10;
        b = 28;
        c = 8/3;

        x = (float) 0.01;
        l = z = 0;
        dt = (float) 0.01;

        v.background(0);
        {
            v.translate(v.width/2, v.height/2);
            v.scale(8);
            v.rotateY(deg);
            v.rotateX(deg2);
            if(v.keyPressed){
                if (v.key == 'w')
                deg2 += 0.05;
                if (v.key == 'a')
                deg -= 0.05;
                if (v.key == 's')
                deg2 -= 0.05;
                if (v.key == 'd')
                deg += 0.05;
            }
                
            lx = (a * (l - x))*dt;
            ly = (x * (b - z) - l)*dt;
            lz = (x * l - c * z)*dt;

            x = x + lx;
            l = l + ly; 
            z = z + lz;

            points.add(new PVector(x, l, z));
            
            v.noFill();
            v.beginShape();
            for(int i=0;i<1;i++)
            {
                for (PVector p : points) {
                    float c = v.map(v.sin(v.radians(v.frameCount * 2 + i)),-1,1,0,255);
                    v.stroke(c, 255, 255);
                    float f = v.getSmoothedBands()[i] * v.height/2 * 0.5f;
                    v.vertex(p.x+f, p.y+f, p.z+f);
                }
            }
            v.endShape();

         }
    }
}



