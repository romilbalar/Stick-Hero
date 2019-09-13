import java.awt.*;
import java.applet.*;
import java.awt.event.*;
/*<applet code="MoveCharacter" width=2000 height=900>
</applet>*/
public class MoveCharacter extends Applet{
	Image image[],modifiedImage[];
	Thread t;
	boolean suspend;
	int number,column;
	public void init() {
		System.out.println("INIT");
		number = 1;
		column = 140;
		image = new Image[]{getImage(getCodeBase(),"Images/"+number+".JPG"),getImage(getCodeBase(),"Images/2.JPG"),getImage(getCodeBase(),"Images/3.JPG"),getImage(getCodeBase(),"Images/4.JPG")};
		modifiedImage =new Image[] {image[0].getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH),image[1].getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH),image[2].getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH),image[3].getScaledInstance(50,50,java.awt.Image.SCALE_SMOOTH)};
	}
	public void start() {
		System.out.println("START");
	}
	public void stop() {
		System.out.println("STOP");
	}
	public void imageCount() {
		column+=10;
	}
	public void paint(Graphics g) {
		imageCount();
		System.out.println("PAINT");
		for(int i=0,j=0;i<15;i++,j++) {
			if(j==4)
				j=1;
			if(i==14)
				break;
			g.drawImage(modifiedImage[j],column,500,this);
			imageCount();
			try {
				Thread.sleep(300);
			}
			catch(InterruptedException e) {}
		}
//		imageCount();
//		g.drawImage(modifiedImage,column,500,this);
		
	}
}
