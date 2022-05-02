package ie.tudublin;

import example.CubeVisual;
import example.MyVisual;
import c20336236.Visuals;
import c20495892.Visuals2;
import c20465804.Visuals3;
import example.RotatingAudioBands;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MyVisual());		
	}

	public void visuals()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Visuals());		
	}

	public void visuals2()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Visuals2());		
	}

	public void visuals3()
	{
		String[] a = {"MAIN"};
	processing.core.PApplet.runSketch( a, new Visuals3());
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.visuals2();			
	}
}