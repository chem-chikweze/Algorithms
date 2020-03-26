package Section1;

import java.util.Arrays;

import Section.StdDraw;
import Section.StdRandom;

public class drawings {
	
	int N;
	public drawings(int N) {
		this.N = N;
	}
	public void function() {
		boolean k = false;
		StdDraw.setXscale(0, N);
		StdDraw.setYscale(0, N*N);
		StdDraw.setPenRadius(.01);
		for(int i = 1; i <= N; i++) {
			if(i==N )
				k = true;
			StdDraw.point(i, i);
			StdDraw.point(i, i*i);
			StdDraw.point(i, i*Math.log(i));
		}
		if(k)
			lineUpDraw() ;
	}
	
	public void randomValuesDraw() {
		
		double[]a = new double[N];
		for(int i= 0; i < N; i++) 
			a[i] = StdRandom.random();
		for(int i = 0; i <N; i++) {
			double x = 1.0* i/N;
			double y = a[i]/2.0;
			double rw = 0.5/N;
			double rh = a[i]/2.0;
			StdDraw.filledRectangle(x, y, rw,rh);
			
		}
	}
	
	public void lineUpDraw() {
		double [] a = new double[N];
		for( int i = 0; i< N; i++)
			a[i] = StdRandom.random();
		Arrays.sort(a);
		for(int i = 0; i< N; i++) {
			double x = 1.0*i/N;
			double y = a[i]/2.0;
			double rw = .5/N;
			double rh = a[i]/2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
	}
	
	public static void main(String[] args) {
		drawings draw = new drawings(50);
		draw.randomValuesDraw();
		StdDraw.clear();
		//draw.function();
		StdDraw.clear();

		draw.lineUpDraw();


	}

}
