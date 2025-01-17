package Final;

import processing.core.*;
import ie.tudublin.Visual;
import processing.core.PApplet;
import java.util.ArrayList;
import java.util.Map;



import com.jogamp.graph.geom.Vertex;

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
    float rotationRate;
    int index1 = 0;
    
    ArrayList<pParticle> particles = new ArrayList<pParticle>();

   
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

     
        rotationRate  += 0.01f;


        float colorfill = PApplet.map(index1, 0, 8, 0 , 255) ;
      
       



            v.shapeMode(PApplet.CENTER);
        for(int i = 0 ; i <= sides ; i ++)
        {
        
            float r = radius;
            float theta = PApplet.map(i, 0, sides, 0, PApplet.TWO_PI);
            float x = cx + PApplet.sin(theta) * r;
            float y = cy - PApplet.cos(theta) * r;
            
            v.strokeWeight(2);
            v.noFill();
            v.stroke(colorfill, 255, 255,125);

          
            v.circle(0, 0, radius *2 + 100);
            v.circle(0, 0, radius *2 - 100);

           
            v.pushMatrix();
            v.beginShape();
            
            
            for (float theta2 = 0; theta2<=  2*PApplet.PI; theta2 += 0.01)
            {

                float formula = superFormula(theta2,
                 2, //size x
                 2,  // size y
                index1, // number of points
                 1, // resolution quality
                  v.sin(v.degrees(t)) * 0.5f +  v.getSmoothedAmplitude(),
                  v.cos(v.degrees(t)) *0.5f + v.getSmoothedAmplitude()  
                 ) ;
                float x2 = x + formula * v.cos(theta2) * 25;
                float y2 = y +  formula * v.sin(theta2)* 25;
                
                v.vertex(x2,y2);
                v.rotate(rotationRate);
                    
            }

            v.endShape();

            v.popMatrix();
         
           
            px = x;
            py = y;
       }
        v.fill(255);
       pParticle p = new pParticle(v);
       particles.add(p);

       for (int i = 0; i < particles.size(); i++) {
           if(!particles.get(i).removeParticle())
           {
            particles.get(i).update( v.getSmoothedAmplitude()> 0.06f || freq > 500f);
            particles.get(i).show();
           }

           else{
               particles.remove(i);
           }
       }

       t = t + 0.5f ;
      
       

            v.fill(colorfill, 255, 255,125);
            v.stroke(colorfill, 255, 255,125);
            myMasks.get(index1).disableStyle();
            v.shape(myMasks.get(index1), 0, 0, 200* ( 1 +  v.getSmoothedAmplitude() * 5), 300* ( 1 +  v.getSmoothedAmplitude() * 5) );

        for( int t = -1; t <= 1 ; t += 2){
            v.beginShape();
            for(int i = 0 ; i <= 180 ; i++)
            {
                int index2 = v.floor(v.map(i, 0 , 180, 0, v.getAudioBuffer().size() - 1));
                v.noFill();
              
                
                float radius2 = v.map(v.getAudioBuffer().get(index2), -1, 1, 150, 350);
                
                float x4 = radius2 * v.sin( v.radians(i) ) * t; 
                float y4 = radius2 * v.cos( v.radians(i) );
                v.vertex(x4, y4);
            }
            v.endShape();
        }

         

    }


    float superFormula(float theta, float a, float b, float m, float n1, float n2, float n3)
    {
        return v.pow(v.pow(v.abs(v.cos(m * theta / 4) / a), n2) + v.pow(v.abs(v.sin(m * theta / 4) / b), n3), -1 / n1);
    }

    
    
}
