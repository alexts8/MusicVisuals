package Final;

public class renderS2 {
    FinalVisuals v;

    public renderS2(FinalVisuals v)
    {
        this.v = v;
    }

    float begin = 0;
    float ph1 = 0;

    float multiplier = (float) 0.997;


    public void render()
    {
        v.background(0);
        v.loadPixels();
        {
            for(int i=1; i<v.cols-1; i++){
                for(int j=1; j<v.rows-1; j++){
                    v.current[i][j] = (v.prev[i-1][j] + v.prev[i+1][j] + v.prev[i][j-1] + v.prev[i][j+1]) / 2 - v.current[i][j];
                    v.current[i][j] = v.current[i][j] * multiplier;
                    int hue = i + j * v.cols;
                    v.pixels[hue] = v.color(v.current[i][j]*255);
                }
            }
            v.updatePixels();

            float[][] temp = v.prev;
            v.prev = v.current;
            v.current = temp;

            v.translate(v.width/2, v.height/2);
            v.rotate((float) (ph1 * 0.9));
            for(int i=0; i<1024; i++){
                float a = i * v.radians((float) 137.5);
                float b = 3 * v.sqrt(i);
                float c = b * v.cos(a);
                float d = b * v.sin(a);
                float e = i+begin;
                e = (float) (i/3.0 % 360);
                v.fill(e, 255, 255);
                v.noStroke();
                float f = v.getlerpedbuffer()[i] * v.height/2 * 4.0f;
                v.ellipse(c+f, d, 4-f, 4);
            }
            ph1 += 10;
            begin += 10;
        }
    }
}
