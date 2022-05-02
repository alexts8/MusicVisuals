package Final;

import processing.core.PVector;
import java.util.ArrayList;

public class renderS1 {

    FinalVisuals v;

    public renderS1(FinalVisuals v)
    {
        this.v = v;
    }

    float y = 0;
    ArrayList<PVector> points = new ArrayList<PVector>();


    public void render()
    {
        v.background(0);
        {
            v.translate(v.width/2, v.height/2);
            float s=2;
            float mag=800;
            for(int k=0; k<1000; k++){
                float wave1 = v.map(v.tan(v.radians((float) (v.frameCount*0.8 + k))), -1, 1, -mag, mag);
                float wave2 = v.map(v.cos(v.radians(v.frameCount + k)), -1, 1, -mag, mag);
                float wave3 = v.map(v.tan(v.radians((float) (v.frameCount*0.8 + k))), 1, -1, mag, -mag);
                float wave4 = v.map(v.sin(v.radians(v.frameCount + k)), 1, -1, mag, -mag);

                float c = v.map(v.sin(v.radians(v.frameCount * 2 + k)), -1, 1, 0, 255);
                v.stroke(c, 255, 255);
                float f = v.getlerpedbuffer()[k] * v.height/2 * 4.0f;
                v.fill(c);
                v.rect(wave1+f, wave2-f, s, s);
                v.rect(wave4-f, wave3+f, s, s);
            }
            v.scale(5);
            v.rotateY(v.deg);
            v.rotateX(v.deg2);
            if(v.keyPressed){
                if (v.key == 'w')
                v.deg2 += 0.05;
                if (v.key == 'a')
                v.deg -= 0.05;
                if (v.key == 's')
                v.deg2 -= 0.05;
                if (v.key == 'd')
                v.deg += 0.05;
            }

            v.lx = (v.a * (v.l - v.x))*v.dt;
            v.ly = (v.x * (v.b - v.z) - v.l)*v.dt;
            v.lz = (v.x * v.l - v.c * v.z)*v.dt;

            v.x = v.x + v.lx;
            v.l = v.l + v.ly;
            v.z = v.z + v.lz;

            points.add(new PVector(v.x, v.l, v.z));

            v.noFill();
            v.beginShape();
            for(int i=0;i<1;i++)
            {
                for (PVector p : points) {
                    float c = v.map(v.sin(v.radians(v.frameCount * 2 + i)),-1,1,0,255);
                    v.stroke(c, 255, 255);
                    float f = v.getlerpedbuffer()[i] * v.height/2 * 0.5f;
                    v.vertex(p.x+f, p.y+f, p.z+f);
                }
            }
            v.endShape();
        }
    }

}
