

int x;
int y;
float outsideRadius = 250;
float insideRadius = 200;

void setup() {
  size(640, 560);
  x = width/2;
  y = height/2;
}

void draw() {
  
  background(#2E2E5D);
  
  stroke(0);
  fill(#2E2E5D);
  ellipse(width/2,height/2,400,400);
  
  fill(0);
  stroke(0);
  ellipse(width/2,height/2,335,335);
  
  pushMatrix();
  fill(#B20D4C);
  noStroke();
  translate(width/2, height/2);
  rotate(frameCount / -100.0);
  polygon(0, 0, 120, 7);  // Heptagon
  
  popMatrix();
  
  int numPoints = int(map(mouseX, 0, width, 6, 60));
  float angle = 0;
  float angleStep = 180.0/numPoints;
  
  pushMatrix();
  translate(width*0.5, height*0.5);
  fill(0);
  star(0, 0, 40, 90, 50); 
  popMatrix();
    
  beginShape(TRIANGLE_STRIP); 
  stroke(0);
  strokeWeight(3);
  fill(#B20D4C);
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

void polygon(float x, float y, float radius, int npoints) {
  float angle = TWO_PI / npoints;
  beginShape();
  for (float a = 0; a < TWO_PI; a += angle) {
    float sx = x + cos(a) * radius;
    float sy = y + sin(a) * radius;
    vertex(sx, sy);
  }
  endShape(CLOSE);
}

void star(float x, float y, float radius1, float radius2, int npoints) {
  float angle = TWO_PI / npoints;
  float halfAngle = angle/2.0;
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