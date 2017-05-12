import java.applet.Applet;  
import java.awt.*;  
import java.util.Random;
  
public class Graphicsdemo extends Applet implements Runnable {  
  public double thres=160,agethr=60;
String str1,str2;
Image bg,inside,stand,young,darkroom,bulb_on,bulb_off,alarm,timer;
Random rn=new Random();
Thread t;
int age,in,time;

  public void init()
  {
	  bg=getImage(getCodeBase(),"background.jpg");
	  inside=getImage(getCodeBase(),"inside.png");
	  stand=getImage(getCodeBase(),"stand.jpg");
	  darkroom=getImage(getCodeBase(),"darkroom.jpg");
	  young=getImage(getCodeBase(),"young.jpg");
	  bulb_on=getImage(getCodeBase(),"bulb_on.jpg");
	  bulb_off=getImage(getCodeBase(),"bulb_off.jpg");
	  timer=getImage(getCodeBase(),"timer.png");
	  alarm=getImage(getCodeBase(),"alarm.jpg");
	  t=new Thread(this);
	  t.start();
	  }
  public void run()
  {
	  try
	  {
		  while(true)
		  {
			  setSize(1500,750);
			  age=rn.nextInt(100)+20;
			  in=rn.nextInt(200)+10;
			  time=rn.nextInt(40)+10;
			  if(age>60 && in<160)
			  {   //if(time<20)
				  str1="Lights ON";
			  if(time>20)
				  str2="alarm";
			  }
			 
			  else
			  {
				  str1="Lights oFF";
			  }
			  repaint();
			  Thread.sleep(2000);
		  }
	  }
  catch(Exception e)
  {
	  e.printStackTrace();
  }
  }
  public void paint(Graphics g)
  {
	  int width=bg.getWidth(this);
	  int height=bg.getHeight(this);
	  g.drawImage(bg, 0, 0, 1500, 750, this);
	  g.setFont(new Font("default",Font.BOLD,40));
	  
	  g.drawString("Elderly Caring System", 250, 50);
	  g.drawRect(100,100,100,100);
	  g.drawRect(100, 250, 100, 100);
	  g.setFont(new Font("default",Font.BOLD,30));
	  g.drawString("Age:"+age, 250, 150);
	  g.drawString("Intensity:"+in, 250, 300);
	  g.drawString("Time:"+time, 250, 450);
	  g.drawImage(timer,100,400,100,100,this);
	  if(age>60)
	  {
		  g.drawImage(stand,100,100,100,100,this); 
	  }
	  else
		  g.drawImage(young,100,100,100,100,this);
	  if(in>160)
	  {
		  g.drawImage(darkroom,100,250,100,100,this);
	  }
	  else
		  g.drawImage(inside,100,250,100,100,this);    
	  if(age>60 && in<160)
	  { 
		g.drawImage(bulb_on,800,250,200,200,this);
		
		  g.drawRect(1000, 250, 200, 200);
		  if(time>20)
		  {
			  g.drawImage(alarm, 1000, 250, 200, 200, this);
		  }
		  
	  }
	  else
	  {g.drawImage(bulb_off,1000,250,200,200,this);
	  
	   
		  g.drawRect(800, 250, 200, 200);
		  
	  }
	  g.setColor(Color.black);
	  g.setFont(new Font("default",Font.BOLD,30));
	  g.drawString(str1, 910, 500);
	  
  }
}
