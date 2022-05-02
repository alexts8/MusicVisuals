package c20495892;

import processing.core.*;
import ie.tudublin.Visual;
import processing.core.PApplet;
import java.util.ArrayList;

import javax.swing.table.TableStringConverter;

import c20336236.render1;
import processing.data.TableRow;

import processing.data.Table;

public class maskVisual {
    
    Visual v;

    ArrayList<PShape> myMasks = new ArrayList<PShape>();

    public maskVisual(Visual v) {
        
        this.v= v;
    }

    public void loadSvg(){
        
        Table  table = v.loadTable("mask.csv", "header");

        for(TableRow row : table.rows()){
        
            String myString = row.getString(0);
            PShape mask = v.loadShape(myString);
            myMasks.add(mask);
            
        }
    }

    public void printSvg(){

        for (PShape pShape : myMasks) {

            System.out.println(pShape);
            
        }
    }
    float t;
    int index1 = 0;

   
    public void render(){

        v.background(0);
        v.translate(v.width/2, v.height/2);
        
      
        float cx = 0;
	    float cy = 0;
        float radius = 400;	
        int points = 6;
        int sides = points * 2;
        float px = cx;
		float py = cy - radius; 
        index1 = v.second() % 8;
        float freq = v.getFrequency();
        int index = (int)PApplet.map(freq, 44, 1400, 0 , 7) % 8;
      
       
        


            v.shapeMode(PApplet.CENTER);
        for(int i = 0 ; i <= sides ; i ++)
        {
        
            float r = radius;
            float theta = PApplet.map(i, 0, sides, 0, PApplet.TWO_PI);
            float x = cx + PApplet.sin(theta) * r;
            float y = cy - PApplet.cos(theta) * r;
            
            v.strokeWeight(2);
            v.noFill();
            v.stroke(100, 255, 255,125);

          
            v.circle(0, 0, radius *2 + 100);
            v.circle(0, 0, radius *2 - 100);

            v.println(index);

            v.beginShape();
            
            for (float theta2 = 0; theta2<=  2*PApplet.PI; theta2 += 0.01)
            {

                float formula = superFormula(theta2,
                 2, //size x
                 2,  // size y
                index1, // number of points
                 1, // resolution quality
                  v.sin(t) * 0.5f +  v.getSmoothedAmplitude(),
                  v.cos(t) *0.5f + v.getSmoothedAmplitude()  
                 ) ;
                float x2 = x + formula* v.cos(theta2) * 25;
                float y2 = y +  formula * v.sin(theta2)* 25;
                v.vertex(x2,y2);
                    
            }

            v.endShape();
         
            //line(px, py, x, y);
            px = x;
            py = y;
       }

       t = t + 0.5f ;
      
    

            v.fill(100, 255, 255,125);
            v.stroke(100, 255, 255,125);
            myMasks.get(index1).disableStyle();
            v.shape(myMasks.get(index1), 0, 0, 200* ( 1 +  v.getSmoothedAmplitude() * 5), 300* ( 1 +  v.getSmoothedAmplitude() * 5) );

      
       
         

    }


    float superFormula(float theta, float a, float b, float m, float n1, float n2, float n3)
    {
        return v.pow(v.pow(v.abs(v.cos(m * theta / 4) / a), n2) + v.pow(v.abs(v.sin(m * theta / 4) / b), n3), -1 / n1);
    }

    
    
}
