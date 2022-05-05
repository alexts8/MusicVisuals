package Final;

import processing.core.*;
import ie.tudublin.Visual;
import processing.core.PApplet;
import java.util.ArrayList;
import java.util.Map;


public class pParticle {

    Visual v;

    PVector pos;
    PVector vel;
    PVector acc;
    float widthPVector;

    public pParticle(Visual v) {

        this.v = v;

        this.pos = PVector.random2D().mult(250);
        this.vel = new PVector(0,0);
        this.acc = this.pos.copy().mult(v.random(0.0001f, 0.00001f));

        this.widthPVector = v.random(3f,5f);

    }

    //Update the smpeed
    public void update(boolean myCondition){
        this.vel.add(this.acc);
        this.pos.add(this.vel);

        if(myCondition){
            this.pos.add(this.vel);
            this.pos.add(this.vel);
            this.pos.add(this.vel);
            this.pos.add(this.vel);


        }
    }
    
    public void show(){
        v.noStroke();
        v.fill(50);
        v.circle(this.pos.x, this.pos.y, this.widthPVector);
    }

    public boolean removeParticle(){
        if(this.pos.x < -v.width/2 || this.pos.x > v.width/2 || this.pos.y < -v.height/ 2 ||  this.pos.y > v.height/2){

            return true;

        }

        else{
            return false;
        }
    }
    
}
