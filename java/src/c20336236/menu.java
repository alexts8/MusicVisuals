package c20336236;

public class menu 
{
    Visuals v;

    public menu(Visuals v) 
    {
        this.v= v;
    }

    void render()
    {
        update();
        v.background(0);
        
        v.fill(60);
        v.textAlign(v.CENTER);
        v.textSize(50);
        v.text("Music Visualiser", v.width/2, v.height/2-150);
        v.text("Crystalised - The xx", v.width/2, v.height/2-100);
        v.textSize(30);
        v.text("Press g to begin", v.width/2, v.height/2);
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
