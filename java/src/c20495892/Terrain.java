package c20495892;

import processing.core.*;
import ie.tudublin.Visual;
import processing.core.PApplet;

public class Terrain  {


Visual v;

int scl = 20;
int w = 2000;
int h = 1600;
int cols  = w / scl, rows = h/ scl;
float flying = 0;


float[][] terrain1 = new float[cols][rows];
 


public Terrain(Visual v) 
    {
        this.v= v;

        cols = w / scl;
        rows = h/ scl;
        


    }


void render() {

  flying -= 0.1;

  float yoff = flying;
  for (int y = 0; y < rows; y++) {
    float xoff = 0;
    for (int x = 0; x < cols; x++) {
      terrain1[x][y] = Visual.map(v.noise(xoff, yoff), 0, 1, -100, 100);
      xoff += 0.2;
    }
    yoff += 0.2;
  }



  v.background(0);
  v.stroke(255);
  v.noFill();

  v.translate(v.width/2, v.height/2+50);
  v.rotateX(v.PI/3);
  v.translate(-w/2, -h/2);
  for (int y = 0; y < rows-1; y++) {
    v.beginShape(v.TRIANGLE_STRIP);
    for (int x = 0; x < cols; x++) {
      v.vertex(x*scl, y*scl, terrain1[x][y]);
     v.vertex(x*scl, (y+1)*scl, terrain1[x][y+1]);
     // v.rect(x*scl, y*scl, scl, scl);
    }
    v.endShape();
  }
}
    
}
