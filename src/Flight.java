import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class Flight extends JFrame implements Runnable{
	
	private String airlinename;
	private String flightnumber;
	private String aircraftmodel;
	private String departure;
	private String arrivaltime;
	private String departuredate;
	private String arrivaldate;
	private String from;
	private String to;
	private static int g=0;
	private static int o=0;
	private int update;
	private int thisg;
	private int thiso;
	private int stopThread;
	private int delaytime=0;
	private int change=0;
	private int takedoff=0;
	private int waitair=0;
	private static String totext="";
	private static Writefile texte=new Writefile();
	public void setUpdate(int update) {
		this.update = update;
	}



	private Kapital k1,i1;
	private Kronometre ax;
	
	public Flight(String airlinename, String flightnumber, String aircraftmodel, String departure, String arrivaltime,
			String from, String to, String departuredate, String arrivaldate, Kronometre kr,int up) 
	{
		this.airlinename = airlinename;
		this.flightnumber = flightnumber;
		this.aircraftmodel = aircraftmodel;
		this.departure = departure;
		this.arrivaltime = arrivaltime;
		this.from = from;
		this.to = to;
		this.departuredate = departuredate;
		this.arrivaldate = arrivaldate;
		this.ax = kr;
		this.update=up;
		stopThread=0;
	}
	
	
	
	public void runflight () 
	{
	    JFrame k1x=new JFrame();
	    k1x.setSize(310,140);
		k1x.getContentPane().setLayout(new BorderLayout());
		if(update==0) 
		{
			k1x.setLocation(o+405,g);
		}
		else 
		{
			k1x.setLocation(thiso+405,thisg);
		}
		
		JButton ekle = new JButton("AIRPORT IS READY TO LAND");
		JButton ekle1 = new JButton("WAIT IN AIR 20 MINUTES");
		JTextArea alancik1 =new JTextArea();
		alancik1.append(from+"- - - - - - - - - - >"+to+"\n"
				+ "FN:"+flightnumber);
		alancik1.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		k1x.add(ekle,BorderLayout.NORTH);
		k1x.add(alancik1,BorderLayout.CENTER);
		k1x.add(ekle1,BorderLayout.SOUTH);
		JFrame k=new JFrame();
		k.setSize(310,140);
		if(update==0) 
		{
			k.setLocation(o+405,g);
			thisg=g;
			thiso=o;
		}
		else 
		{
			k.setLocation(thiso+405,thisg);
		}
		
		
		ekle1.addActionListener(event->delaytime= 44);
		ekle1.addActionListener(event->k1x.dispose());
		ekle.addActionListener(event->delaytime= -10);
		ekle.addActionListener(event->k1x.dispose());
		
		k.getContentPane().setLayout(new BorderLayout());
		
		
		JTextArea alancik =new JTextArea();
		alancik.setEditable(false);
		alancik.append(from+"- - - - - - - - - ->"+to+"\n"
				+ "AIRLINE:"+airlinename+"     FN:"+flightnumber+"\n"+"AIRCRAFT:"+aircraftmodel+"\n"+"Take-Off/Landing: "+departure+" -- "+arrivaltime + "\nDeparture Date:" + departuredate + "\n"+"Arrival Date: " + arrivaldate);
		k.getContentPane().add(alancik);
		alancik.setFont(new Font("Tahoma", Font.BOLD, 14));
		if(update==0) {
			alancik.setBackground(Color.CYAN);
		}
		else {
			alancik.setBackground(Color.ORANGE);
		}
		
		if(update==0) {
			g=g+140;
		if(g%700==0) 
			{
			o=o+310;
			g=0;
			}
		}
		
		
		k.setVisible(true);
		Timer tmer = new Timer();
		TimerTask task = new TimerTask() {
		
				

            @Override
            public void run() {
            
            	String sistemtime= ax.getHours()+":"+ax.getMinutes()+":"+ax.getSeconds();
            	String sistemdate= ax.getDays()+"/"+ax.getMonths()+"/"+ax.getYears();
            	
            	if(change==1) {
            		alancik1.setBackground(Color.yellow);
            		change=0;
            	}
            	else {
            		alancik1.setBackground(Color.blue);
            		change=1;
            	}
            	
            	if(departure.compareTo(sistemtime)== 0 && departuredate.compareTo(sistemdate) == 0 ){
            		if(takedoff==0) {
            			k1.setTakeoffs(flightnumber);
            			takedoff=1;
            		}
    				
    			}
    			
    			if(delaytime>0)
    			{
    				delaytime--;
    				if(delaytime==1) 
    				{
    					k1x.setVisible(true);
        				alancik1.setBackground(Color.BLUE);
        				delaytime=0;
    				}
    				waitair++;
    			}
    			
    			if(delaytime==-10) {
    				i1.setLanded(flightnumber);
    				alancik.setBackground(Color.GREEN);
    				totext=totext+from+"- - - - - - - - - - ->"+to+"\n"
    						+ "AIRLINE:"+airlinename+"     FN:"+flightnumber+"\n"+"AIRCRAFT:"+aircraftmodel+"\n"+"Take-Off/Landing: "+departure+" -- "+arrivaltime + "\nDeparture Date:" + departuredate + "\n"+"Arrival Date: " + arrivaldate+"\nLanding Delay: "+(waitair/2)+"minutes \n \n \n \n";
    				texte.Writeto(totext);
    				tmer.cancel();
    			}
    			
    			if(arrivaltime.compareTo(sistemtime)== 0 && arrivaldate.compareTo(sistemdate) == 0){
    				
    				k1x.setVisible(true);
    				alancik1.setBackground(Color.BLUE);
    				change=1;
    				
    				
    				
    			}
    			if(stopThread==1) {
    				
    				alancik.setBackground(Color.RED);
    				if(update==1) {
    					k.dispose();
    				}
    				
    				tmer.cancel();
    			
    			}
            }
        };
        tmer.schedule(task, 0, 500); 
        
       
        
	}
	


	public void setK1(Kapital k1) {
		this.k1 = k1;
	}

	public void setI1(Kapital i1) {
		this.i1 = i1;
	}

	public void setAx(Kronometre ax) {
		this.ax = ax;
	}
	

	public String getAirlinename() {
		return airlinename;
	}

	public void setAirlinename(String airlinename) {
		this.airlinename = airlinename;
	}

	public String getFlightnumber() {
		return flightnumber;
	}

	public void setFlightnumber(String flightnumber) {
		this.flightnumber = flightnumber;
	}

	public String getAircraftmodel() {
		return aircraftmodel;
	}

	public void setAircraftmodel(String aircraftmodel) {
		this.aircraftmodel = aircraftmodel;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrivaltime() {
		return arrivaltime;
	}

	public void setArrivaltime(String arrivaltime) {
		this.arrivaltime = arrivaltime;
	}

	public String getDeparturedate() {
		return departuredate;
	}

	public void setDeparturedate(String departuredate) {
		this.departuredate = departuredate;
	}

	public String getArrivaldate() {
		return arrivaldate;
	}

	public void setArrivaldate(String arrivaldate) {
		this.arrivaldate = arrivaldate;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public void run() 
		{
		runflight();
		}

	public int getThisg() {
		return thisg;
	}

	public void setThisg(int thisg) {
		this.thisg = thisg;
	}

	public int getThiso() {
		return thiso;
	}

	public void setThiso(int thiso) {
		this.thiso = thiso;
	}

	public void setStopThread(int stopThread) {
		this.stopThread = stopThread;
	}



	public int getTakedoff() {
		return takedoff;
	}
	
	

	
	
}
