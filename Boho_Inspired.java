import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 
import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Boho_Inspired extends PApplet {

int x;
int y;
float outsideRadius = 250;
float insideRadius = 200;

public void setup() { 
  x = width/2;
  y = height/2;
}

public void draw() {
  
  background(0xff2E2E5D);
  
  
  stroke(0);
  fill(0xff2E2E5D);
  ellipse(width/2,height/2,400,400);
  
  fill(0);
  stroke(0);
  ellipse(width/2,height/2,335,335);
  
  pushMatrix();
  fill(0xffB20D4C);
  noStroke();
  translate(width/2, height/2);
  rotate(frameCount / -100.0f);
  polygon(0, 0, 120, 7);  // Heptagon
  
  popMatrix();
  
  int numPoints = PApplet.parseInt(map(mouseX, 0, width, 6, 60));
  float angle = 0;
  float angleStep = 180.0f/numPoints;
  
  pushMatrix();
  translate(width*0.5f, height*0.5f);
  fill(0);
  star(0, 0, 40, 90, 50); 
  popMatrix();
    
  beginShape(TRIANGLE_STRIP); 
  stroke(0);
  strokeWeight(3);
  fill(0xffB20D4C);
  for (int i = 0; i <= numPoints; i++) {
    float px = x + cos(radians(angle)) * outsideRadius;
    float py = y + sin(radians(angle)) * outsideRadius;
    angle += angleStep;
    vertex(px, py);
    px = x + cos(radians(angle)) * insideRadius;
    py = y + sin(radians(angle)) * insideRadius;
    vertex(px, py); 
    angle += angleStep;
    
  }
  endShape();
}

public void polygon(float x, float y, float radius, int npoints) {
  float angle = TWO_PI / npoints;
  beginShape();
  for (float a = 0; a < TWO_PI; a += angle) {
    float sx = x + cos(a) * radius;
    float sy = y + sin(a) * radius;
    vertex(sx, sy);
  }
  endShape(CLOSE);
}

public void star(float x, float y, float radius1, float radius2, int npoints) {
  float angle = TWO_PI / npoints;
  float halfAngle = angle/2.0f;
  beginShape();
  for (float a = 0; a < TWO_PI; a += angle) {
    float sx = x + cos(a) * radius2;
    float sy = y + sin(a) * radius2;
    vertex(sx, sy);
    sx = x + cos(a+halfAngle) * radius1;
    sy = y + sin(a+halfAngle) * radius1;
    vertex(sx, sy);
  }
  endShape(CLOSE);
}
  public void settings() {  size(640, 560); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Boho_Inspired" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
