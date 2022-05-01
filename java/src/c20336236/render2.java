package c20336236;

public class render2
{
    Visuals v;

    public render2(Visuals v) 
    {
        this.v= v;
    }


    public void render()
    {
        v.background(20);

        //sound hole
        v.stroke(40);
        v.strokeWeight(30);
        v.fill(0);
        v.circle(v.width/2, v.height/2, 550);

        //bridge
        v.strokeWeight(2);
        v.stroke(130);
        v.fill(70);
        v.rect(v.width-90,v.height/2-400,100,800,20);


        //strings
        v.noFill();
        v.stroke(150);
        v.strokeWeight(2);
        int border=150;
   
        for(int i=0; i<6; i++)
        {
            v.stroke(v.map(i,0,6,0,255),255,255);

            v.noFill();
            float y = v.map(i, 0,5,border,v.height-border);
            v.bezier(0, y, v.width/2, y+v.getBands()[i]/3, v.width/2, y+v.getBands()[i]/3, v.width, y);
            v.fill(255);
            v.stroke(255);
            v.circle(v.width-30,y,20);
        }

    }
}



