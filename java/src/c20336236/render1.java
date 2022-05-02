package c20336236;



public class render1
{
    Visuals v;

    public render1(Visuals v) 
    {
        this.v= v;
    }



    float rotation;
    float col=0;



    public void update()
    {
  
        if (v.keyPressed)
        {
           
            if (v.key == 'a')
            {
                rotation -= 0.01f;
            }
            if (v.key == 'd')
            {
                rotation += 0.01f;
            }
        }
    }

    public void render()
    {
        update();

        float mag = 200;
        float s = 1;
        v.noStroke();


        v.translate(v.width/2, v.height/2);

        for(int i=0;i<360;i++)
        {

            float wave1 = v.map(v.tan(v.radians((float) (v.frameCount*0.8 + i))), -1, 1, -mag, mag);
            float wave2 = v.map(v.cos(v.radians(v.frameCount + i)), -1, 1, -mag, mag);
            float wave3 = v.map(v.tan(v.radians((float) (v.frameCount*0.8 + i))), 1, -1, mag, -mag);
            float wave4 = v.map(v.sin(v.radians(v.frameCount + i)), 1, -1, mag, -mag);

            // change first 255 to 0 for flashy thingy
            float c = v.map(v.sin(v.radians(v.frameCount * 2 + i)),-1,1,0,255);
            v.stroke(c, 255, 255, 25);
            v.strokeWeight(10);
            float f = v.getlerpedbuffer()[i] * v.height/2 * 2.0f;
  
                        
            v.fill(c,255,255,70);
            for (int offs = -100; offs<=100; offs+=100)
            {
                v.rect(wave1+f, wave2-f+offs, s,s);
                v.rect(wave3+f, wave4-f+offs, s,s);
            }
        }


            v.strokeWeight(2);
            v.noFill();
            v.stroke(col, 255, 255,175);
            col = (col + 1f) % 255;

            for (int num = 5; num<=50; num+=5)
            {
                
                v.beginShape();
                for (float theta = 0; theta<= 2*v.PI; theta+=0.01)
                {
    
                    float r = r(theta, 2,2,9,1,v.getSmoothedAmplitude()*25,v.getSmoothedAmplitude()*25);
                    float x =  r * v.cos(theta) * num;
                    float y = r * v.sin(theta)* num;
                    v.rotate(rotation);
                    v.vertex(x,y);
                        
                }
                v.endShape();
            }


    }




    float r(float theta, float a, float b, float m, float n1, float n2, float n3)
    {
        return v.pow(v.pow(v.abs(v.cos(m * theta / 4) / a), n2) + v.pow(v.abs(v.sin(m * theta / 4) / b), n3), -1 / n1);
    }
}

