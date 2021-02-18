import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.Timer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class denemewindow implements ActionListener{

	private JFrame frame;
	private static JTextField airlinename;
	private static JTextField aircraftmodel;
	private static JTextField airportfrom;
	private static JTextField airportto;
	private static JTextField departure;
	private static JTextField arrivaltime;
	private static JTextField flightnumber;
	private static JTextField idTextField;
	JTextArea idTextField1;
	static JTextArea capitali = new JTextArea();
	static Kronometre kronometre = new Kronometre();
	JLabel time=new JLabel("1/1/2000     0:0:0");
	Timer zaman;
	static ArrayList<Flight> ucuslar = new ArrayList<>();
	
	private static ArrayList<Kapital> kapitals=new ArrayList<Kapital>();
	
	Kapital o;
	Kapital n;
	
	private JTextField setday;
	private JTextField sethour;
	private JTextField setmonth;
	private JTextField setyear;
	private JTextField setminute;
	private static JTextField departuredate;
	private static JTextField arrivaldate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					denemewindow window = new denemewindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
		Kapital capi1=new Kapital("Frankfurt");
		Kapital capi2=new Kapital("Izmir");
		Kapital capi3=new Kapital("Ankara");
		Kapital capi4=new Kapital("Munchen");
		Kapital capi5=new Kapital("Istanbul");
		kapitals.add(capi1);
		kapitals.add(capi2);
		kapitals.add(capi3);
		kapitals.add(capi4);
		kapitals.add(capi5);
		yenile();
		
		Flight x=new Flight ("TURKISH AIRLINES","500","AIRBUS A380","0:10:0","0:15:0","Frankfurt","Izmir","1/1/2000","1/1/2000",kronometre,0);
		ucuslar.add(x);
		x.setI1(capi2);
		x.setK1(capi1);
		x.setAx(kronometre);
		Thread t1 = new Thread(x);
		t1.start();
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Flight x1=new Flight ("TURKISH AIRLINES","501","AIRBUS A380","0:10:0","0:15:0","Izmir","Ankara","1/1/2000","1/1/2000",kronometre,0);
		ucuslar.add(x1);
		x1.setI1(capi3);
		x1.setK1(capi2);
		x1.setAx(kronometre);
		Thread t2 = new Thread(x1);
		t2.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Flight x2=new Flight ("TURKISH AIRLINES","502","AIRBUS A380","0:10:0","0:15:0","Ankara","Munchen","1/1/2000","1/1/2000",kronometre,0);
		ucuslar.add(x2);
		x2.setI1(capi4);
		x2.setK1(capi3);
		x2.setAx(kronometre);
		Thread t3 = new Thread(x2);
		t3.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Flight x3=new Flight ("TURKISH AIRLINES","503","AIRBUS A380","0:10:0","0:15:0","Munchen","Istanbul","1/1/2000","1/1/2000",kronometre,0);
		ucuslar.add(x3);
		x3.setI1(capi5);
		x3.setK1(capi4);
		x3.setAx(kronometre);
		Thread t4 = new Thread(x3);
		t4.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Flight x4=new Flight ("TURKISH AIRLINES","504","AIRBUS A380","0:10:0","0:15:0","Izmir","Istanbul","1/1/2000","1/1/2000",kronometre,0);
		ucuslar.add(x4);
		x4.setI1(capi5);
		x4.setK1(capi2);
		x4.setAx(kronometre);
		Thread t5 = new Thread(x4);
		t5.start();
		
	
	}

	/**
	 * Create the application.
	 */
	public denemewindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		frame = new JFrame();
		frame.setBounds(0, 0, 415, 628);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 395, 591);
		frame.getContentPane().add(tabbedPane);
		
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("INSTRUCTION", null, panel, null);
		panel.setLayout(null);
		
		idTextField1 = new JTextArea();
		idTextField1.setToolTipText("");
		idTextField1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idTextField1.setColumns(15);
		idTextField1.setBackground(Color.yellow);
		idTextField1.setBounds(0, 0, 390, 565);
		idTextField1.append("\n         THE SYSTEM WORKS AS FOLLOWS\n                        INFORMATIONS\n\n\n\n"
				+ "Every Flight will appear in a new window \nwith its Information.\n\nIf the Flight is "
				+ "scheduled it will apper \nin a Light Blue front.\n\nIf the scheduled flight is updated"
				+ " it will \nappear in a Orange front.\n\nIf a scheduled flight is deleted it will \nappear"
				+ " in a red front.\n\nAnd if the scheduled flight is completet \nit will appear in a green front.\n\n"
				+ "To begin simulating the flights don't for\nget to set and start the system time&date.");
		idTextField1.setFont(new Font("Tahoma",Font.BOLD, 16));
		panel.add(idTextField1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Capital Add/Delete", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton ekle = new JButton("Add");
		ekle.setForeground(Color.BLACK);
		ekle.setFont(new Font("Tahoma", Font.BOLD, 16));
		ekle.setBackground(Color.GREEN);
		ekle.setBounds(108, 437, 126, 33);
		panel_1.add(ekle);
		
		JButton sil = new JButton("Delete");
		sil.setFont(new Font("Tahoma", Font.BOLD, 16));
		sil.setBackground(Color.RED);
		sil.setBounds(244, 437, 126, 33);
		panel_1.add(sil);
		
		idTextField = new JTextField();
		idTextField.setToolTipText("");
		idTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idTextField.setColumns(15);
		idTextField.setBackground(Color.LIGHT_GRAY);
		idTextField.setBounds(226, 383, 130, 27);
		panel_1.add(idTextField);
		
		JLabel idLabel = new JLabel("Capital: ");
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		idLabel.setBounds(115, 378, 130, 33);
		panel_1.add(idLabel);
		
		capitali.setBackground(Color.LIGHT_GRAY);
		capitali.setEditable(false);
		capitali.setBounds(10, 10, 360, 363);
		panel_1.add(capitali);
		
		JPanel panel_2 = new JPanel();
		panel_2.setToolTipText("");
		tabbedPane.addTab("Flight Add/Delete", null, panel_2, null);
		panel_2.setLayout(null);
		
		airlinename = new JTextField();
		airlinename.setFont(new Font("Tahoma", Font.PLAIN, 14));
		airlinename.setToolTipText("");
		airlinename.setColumns(15);
		airlinename.setBackground(Color.LIGHT_GRAY);
		airlinename.setBounds(120, 29, 130, 27);
		panel_2.add(airlinename);
		
		JLabel idLabel1 = new JLabel("Airline Name: ");
		idLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idLabel1.setBounds(10, 24, 130, 33);
		panel_2.add(idLabel1);
		
		JButton ekle2 = new JButton("Add");
		ekle2.setFont(new Font("Tahoma", Font.BOLD, 16));
		ekle2.setForeground(Color.BLACK);
		ekle2.setBackground(Color.CYAN);
		ekle2.setBounds(10, 436, 126, 33);
		panel_2.add(ekle2);
		
		JButton sil2 = new JButton("Delete");
		sil2.setFont(new Font("Tahoma", Font.BOLD, 16));
		sil2.setBackground(Color.RED);
		sil2.setBounds(140, 436, 126, 33);
		panel_2.add(sil2);
		
		aircraftmodel = new JTextField();
		aircraftmodel.setToolTipText("");
		aircraftmodel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		aircraftmodel.setColumns(15);
		aircraftmodel.setBackground(Color.LIGHT_GRAY);
		aircraftmodel.setBounds(120, 71, 130, 27);
		panel_2.add(aircraftmodel);
		
		JLabel idLabel3 = new JLabel("Aircraft Model: ");
		idLabel3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idLabel3.setBounds(10, 66, 130, 33);
		panel_2.add(idLabel3);
		
		airportfrom = new JTextField();
		airportfrom.setToolTipText("");
		airportfrom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		airportfrom.setColumns(15);
		airportfrom.setBackground(Color.LIGHT_GRAY);
		airportfrom.setBounds(120, 113, 130, 27);
		panel_2.add(airportfrom);
		
		JLabel idLabel6 = new JLabel("Airport From: ");
		idLabel6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idLabel6.setBounds(10, 108, 130, 33);
		panel_2.add(idLabel6);
		
		airportto = new JTextField();
		airportto.setToolTipText("");
		airportto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		airportto.setColumns(15);
		airportto.setBackground(Color.LIGHT_GRAY);
		airportto.setBounds(120, 155, 130, 27);
		panel_2.add(airportto);
		
		JLabel idLabel7 = new JLabel("Airport To: ");
		idLabel7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idLabel7.setBounds(10, 150, 130, 33);
		panel_2.add(idLabel7);
		
		departure = new JTextField();
		departure.setToolTipText("");
		departure.setFont(new Font("Tahoma", Font.PLAIN, 14));
		departure.setColumns(15);
		departure.setBackground(Color.LIGHT_GRAY);
		departure.setBounds(120, 197, 130, 27);
		panel_2.add(departure);
		
		JLabel idLabel4 = new JLabel("Departure: ");
		idLabel4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idLabel4.setBounds(10, 192, 130, 33);
		panel_2.add(idLabel4);
		
		arrivaltime = new JTextField();
		arrivaltime.setToolTipText("");
		arrivaltime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		arrivaltime.setColumns(15);
		arrivaltime.setBackground(Color.LIGHT_GRAY);
		arrivaltime.setBounds(120, 239, 130, 27);
		panel_2.add(arrivaltime);
		
		JLabel idLabel5 = new JLabel("Arrival Time: ");
		idLabel5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idLabel5.setBounds(10, 234, 130, 33);
		panel_2.add(idLabel5);
		
		flightnumber = new JTextField();
		flightnumber.setToolTipText("");
		flightnumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		flightnumber.setColumns(15);
		flightnumber.setBackground(Color.LIGHT_GRAY);
		flightnumber.setBounds(120, 281, 130, 27);
		panel_2.add(flightnumber);
		
		JLabel idLabel2 = new JLabel("Flight Number: ");
		idLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		idLabel2.setBounds(10, 276, 130, 33);
		panel_2.add(idLabel2);
		
		departuredate = new JTextField();
		departuredate.setToolTipText("");
		departuredate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		departuredate.setColumns(15);
		departuredate.setBackground(Color.LIGHT_GRAY);
		departuredate.setBounds(120, 323, 130, 27);
		panel_2.add(departuredate);
		
		JLabel lblDepartureDate = new JLabel("Departure Date: ");
		lblDepartureDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepartureDate.setBounds(10, 318, 130, 33);
		panel_2.add(lblDepartureDate);
		
		arrivaldate = new JTextField();
		arrivaldate.setToolTipText("");
		arrivaldate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		arrivaldate.setColumns(15);
		arrivaldate.setBackground(Color.LIGHT_GRAY);
		arrivaldate.setBounds(120, 365, 130, 27);
		panel_2.add(arrivaldate);
		
		JLabel lblArrivalDate = new JLabel("Arrival Date: ");
		lblArrivalDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblArrivalDate.setBounds(10, 360, 130, 33);
		panel_2.add(lblArrivalDate);
		
		JLabel lblNewLabel_1 = new JLabel("(ex :: 23:16:0 or 4:18:0)");
		lblNewLabel_1.setBounds(260, 206, 130, 13);
		panel_2.add(lblNewLabel_1);
		
		JButton update = new JButton("Update");
		update.setForeground(Color.BLACK);
		update.setFont(new Font("Tahoma", Font.BOLD, 16));
		update.setBackground(Color.ORANGE);
		update.setBounds(70, 479, 126, 33);
		panel_2.add(update);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Time", null, panel_3, null);
		panel_3.setLayout(null);
		
		JButton runStop = new JButton("RUN");
		runStop.addActionListener(this);
		runStop.setFont(new Font("Tahoma", Font.PLAIN, 18));
		runStop.setBackground(Color.GREEN);
		runStop.setBounds(50, 181, 121, 50);
		panel_3.add(runStop);
		
		JButton restart = new JButton("RESTART");
		restart.setFont(new Font("Tahoma", Font.PLAIN, 18));
		restart.addActionListener(this);
		restart.setBackground(Color.RED);
		restart.setBounds(210, 181, 121, 50);
		panel_3.add(restart);
		
		time.setHorizontalAlignment(SwingConstants.CENTER);
		time.setFont(new Font("Tahoma", Font.BOLD, 24));
		time.setBounds(25, 85, 330, 69);
		panel_3.add(time);
		
		JButton SetDate = new JButton("Set Date");
		SetDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		SetDate.setBackground(Color.GREEN);
		SetDate.setBounds(50, 380, 121, 50);
		panel_3.add(SetDate);
		
		JButton SetTime = new JButton("Set Time");
		SetTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		SetTime.setBackground(Color.GREEN);
		SetTime.setBounds(210, 380, 121, 50);
		panel_3.add(SetTime);
		
		setday = new JTextField();
		setday.setBounds(50, 329, 27, 27);
		panel_3.add(setday);
		setday.setColumns(2);
		
		sethour = new JTextField();
		sethour.setColumns(2);
		sethour.setBounds(235, 329, 34, 27);
		panel_3.add(sethour);
		
		setmonth = new JTextField();
		setmonth.setColumns(2);
		setmonth.setBounds(80, 329, 27, 27);
		panel_3.add(setmonth);
		
		setyear = new JTextField();
		setyear.setColumns(4);
		setyear.setBounds(110, 329, 71, 27);
		panel_3.add(setyear);
		
		setminute = new JTextField();
		setminute.setColumns(2);
		setminute.setBounds(275, 329, 34, 27);
		panel_3.add(setminute);
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("Please stop the system before you set the time and date.");
		lblNewLabel.setBounds(41, 50, 350, 30);
		panel_3.add(lblNewLabel);
		SetDate.addActionListener(event->setDate());
		SetTime.addActionListener(event->setSaat());
		ekle2.addActionListener(event->ucusolustur());
		ekle.addActionListener(event->basekle());
		sil.addActionListener(event->sil());
		update.addActionListener(event->ucusguncelle());
		sil2.addActionListener(event->ucussil());
		zaman= new Timer(1000,this);
	}
	
	public void ucusguncelle() {
		int k=0;
		for(Flight f : ucuslar) {
			if(f.getFlightnumber().compareTo(flightnumber.getText())==0) {
				
				k=1;
				
				if(f.getTakedoff()==0) {
					if(checkcapital()==1) {
						Flight x=new Flight (airlinename.getText(),flightnumber.getText(),aircraftmodel.getText(),departure.getText(),arrivaltime.getText(),airportfrom.getText(),airportto.getText(),departuredate.getText(),arrivaldate.getText(),kronometre,1);
						x.setThisg(f.getThisg());
						x.setThiso(f.getThiso());
						f.setUpdate(1);
						x.setAx(kronometre);
						x.setI1(n);
						x.setK1(o);
						f.setStopThread(1);
						ucuslar.remove(f);
						f=null;
						ucuslar.add(x);
						Thread t1 = new Thread(x);
						t1.start();
						break;
					}
				}
					else {
						JOptionPane.showMessageDialog(null,"The Plane has taked off you can not change the details!!");
						break;
					}
				
				
			}
		}
		if(k==0) {
			JOptionPane.showMessageDialog(null,"There is not such a Flight Number(FN)!");
			checkcapital();
		}
	}
	
	public void ucussil() {
		int k=0;
		for(Flight f : ucuslar) {
			if(f.getFlightnumber().compareTo(flightnumber.getText())==0) {
				k=1;
				if(f.getTakedoff()==0) {
				f.setStopThread(1);
				f.setUpdate(0);
				ucuslar.remove(f);
				f=null;
				JOptionPane.showMessageDialog(null,"The flight was deleted successfully!");
				break;	
				}
				else {
					JOptionPane.showMessageDialog(null,"The Plane has taked off you can not change the details!!");
					break;
				}
			}
			
		}
		if(k==0) {
			JOptionPane.showMessageDialog(null,"There is not such a Flight Number(FN)!");
		}
	}

	public static void yenile() {
		capitali.setText("");
		for(Kapital x : kapitals) {
			capitali.append(x.toString());
		}
	}
	
	public void setDate()
	{
		int gun = Integer.parseInt(setday.getText());
		int ay = Integer.parseInt(setmonth.getText());
		int yil = Integer.parseInt(setyear.getText());
		
		if (gun > 0 && ay > 0 && ay <= 12 && yil > 1999)
		{
			int aylar31[] = {1, 3, 5, 7, 8, 10, 12};
			int aylar30[] = {4, 6, 9, 11};
			boolean otuzbir = false;
			boolean otuz = false;
			
			for (int i : aylar31)
				if (i == ay) {otuzbir = true;}
			for (int i : aylar30)
				if (i == ay) {otuz = true;}
			
			if ((otuzbir &&  gun <= 31) || (otuz &&  gun <= 30) || (ay == 2 && yil % 4 == 0 && gun <= 29) || (ay == 2 && yil % 4 != 0 && gun <= 28))
			{
				kronometre.setDays(gun);
				kronometre.setMonths(ay);
				kronometre.setYears(yil);
			}
			else
			{
				JOptionPane.showMessageDialog(null,"DATE ERROR !!");
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"DATE ERROR !!");
		}
		
	}
	public void setSaat()
	{
		if (Integer.parseInt(sethour.getText()) < 24 && Integer.parseInt(setminute.getText()) < 60)
		{
			kronometre.setHours(Integer.parseInt(sethour.getText()));
			kronometre.setMinutes(Integer.parseInt(setminute.getText()));
			return;
		}
		else
		{
			JOptionPane.showMessageDialog(null,"TIME ERROR !!");
		}
	}
	
	private void basekle() {
		for (Kapital x : kapitals)
		{
			if (x.getCity().compareTo(idTextField.getText()) == 0)
			{
				JOptionPane.showMessageDialog(null,"City is already added !");
				return;
			}
		}
		kapitals.add(new Kapital(idTextField.getText()));
		capitali.setText("");
		yenile();	
	}
	private void sil()
	{
		for (Kapital x : kapitals)
		{
			if (x.getCity().compareTo(idTextField.getText()) == 0)
			{
				kapitals.remove(x);
				capitali.setText("");
				yenile();
				return;
			}
		}
		JOptionPane.showMessageDialog(null,"City cnnot be found !!");
		return;
	}
	
	private int checkcapital() {
		int correct=0;
		boolean kalk=false;
		boolean var=false;
		for(Kapital x: kapitals) 
		{
			if(x.getCity().compareTo(airportfrom.getText())==0) {
				kalk=true;
				o=x;
			}
			if(x.getCity().compareTo(airportto.getText())==0) {
				var=true;
				n=x;
			}
		}
		
		if((kalk&&var)==true) 
		{
			correct=1;
		}
		else if((kalk==false)&&(var==false)) {
			JOptionPane.showMessageDialog(null,"There are not airports like these");
		}
		else if((kalk==false)&&(var==true)) {
			JOptionPane.showMessageDialog(null,"There is not such a departure airport");
		}
		else{
			JOptionPane.showMessageDialog(null,"There is not such a destination airport");
		}
		
		return correct;
	}
	
	private int checkflightnumber() {
		for(Flight f : ucuslar) {
			if(f.getFlightnumber().compareTo(flightnumber.getText())==0) {
				JOptionPane.showMessageDialog(null,"This flight number is added before if you want you can update it!");
				return 0;
			}
		}
		return 1;
	}
	
	private void ucusolustur() {
		
		
		if((checkcapital()&checkflightnumber())==1) 
		{
			Flight x=new Flight (airlinename.getText(),flightnumber.getText(),aircraftmodel.getText(),departure.getText(),arrivaltime.getText(),airportfrom.getText(),airportto.getText(),departuredate.getText(),arrivaldate.getText(),kronometre,0);
				ucuslar.add(x);
				x.setI1(n);
				x.setK1(o);
				x.setAx(kronometre);
				Thread t1 = new Thread(x);
				t1.start();
		}
	}
	
public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() instanceof Timer) {
			kronometre.arttir();
			time.setText(kronometre.getDays()+"/"+kronometre.getMonths()+"/"+kronometre.getYears()+"     "+ kronometre.getHours()+":"+kronometre.getMinutes()+":"+kronometre.getSeconds());
			yenile();
		}
		if(e.getSource() instanceof JButton) {
			
			JButton button=(JButton)e.getSource();
			if(button.getText().equals("RUN")) {
				zaman.start();
				button.setText("STOP");
			}
			else if(button.getText().equals("STOP")) {
				zaman.stop();
				button.setText("RUN");
			}
			else if(button.getText().equals("RESTART")) {
				kronometre.setDays(1);
				kronometre.setMonths(1);
				kronometre.setYears(2000);
				kronometre.setSeconds(0);
				kronometre.setMinutes(0);
				kronometre.setHours(0);
				zaman.stop();
				time.setText(kronometre.getDays()+"/"+kronometre.getMonths()+"/"+kronometre.getYears()+"     "+ kronometre.getHours()+":"+kronometre.getMinutes()+":"+kronometre.getSeconds());
			}
		}
	}
	@SuppressWarnings("unused")
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

