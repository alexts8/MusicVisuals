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
        //float x1 = PApplet.map(0, 0, 300* ( 1 +  v.getSmoothedAmplitude()), 0, v.width);
        //float y1 = PApplet.map(0, 0, 400* ( 1 +  v.getSmoothedAmplitude()), 0, v.height);

        //for(int i = 0; i <= 8; i++){
        //int index = (int)v.map(v.getSmoothedAmplitude(), 85f, 155f, 0, 8f);
        int index = (int)v.random(0, 8);
        float cx = 0;
	    float cy = 0;
        float radius = 400;	
        int points = 6;
        int sides = points * 2;
        float px = cx;
		float py = cy - radius; 
        index1 = v.second() % 8;
     

        myMasks.get(1).disableStyle();
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
            v.beginShape();
            for (float theta2 = 0; theta2<=  2*PApplet.PI; theta2 += 0.01)
            {

                float formula = superFormula(theta2,
                 2,
                 2,
                index1,
                 1,
                 v.sin(t)*0.5f + v.getSmoothedAmplitude()*25 ,
                 v.cos(t)*0.5f + v.getSmoothedAmplitude()*25 
                 ) ;
                float x2 = x + formula* v.cos(theta2) * 10;
                float y2 = y +  formula * v.sin(theta2)* 10;
                v.vertex(x2,y2);
                    
            }

            v.endShape();
            t = (t + v.second())  % 360;

            
            //line(px, py, x, y);
            px = x;
            py = y;
       }
       /*
       float thisFreq;

        thisFreq = v.getFrequency();
        if(thisFreq > 1000f){

            index1 = (int)v.random(0,8);
            v.println(index1);

        }
       
        */
       
        v.fill(100, 255, 255,125);
        v.stroke(100, 255, 255,125);
        myMasks.get(index1).disableStyle();
        v.shape(myMasks.get(index1), 0, 0, 200* ( 1 +  v.getSmoothedAmplitude() * 10), 300* ( 1 +  v.getSmoothedAmplitude() * 10) );
        
       
        //}

    }


    float superFormula(float theta, float a, float b, float m, float n1, float n2, float n3)
    {
        return v.pow(v.pow(v.abs(v.cos(m * theta / 4) / a), n2) + v.pow(v.abs(v.sin(m * theta / 4) / b), n3), -1 / n1);
    }

    
    
}
