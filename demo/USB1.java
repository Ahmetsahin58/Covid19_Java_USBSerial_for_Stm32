package com.example.demo;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import com.fazecast.jSerialComm.*;



import java.util.Scanner;
import java.util.concurrent.Delayed;

import org.jfree.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.Series;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.JLabel;
import java.util.*;
import javax.swing.JTextPane;
import javax.swing.DropMode;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class USB1 extends JFrame {

	private JPanel contentPane;
	static SerialPort chosenPort;
	static int x = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					USB1 frame = new USB1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public USB1(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 635);     //açılır pencere büyüklükleri belirlendi.
		contentPane = new JPanel();        //jpanel nesnesi oluşturuldu.
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));   // contentin boyut oranı belirlendi
		contentPane.setLayout(new BorderLayout(0, 0));        //yerleşim belirlendi.
		setContentPane(contentPane); //content set edildi.
		
		JComboBox<String> portList = new JComboBox<String>(); //combobox oluşturuldu.
		JButton connectButton = new JButton("Connect");       //bağlantı buton oluşturuldu
		JPanel topPanel = new JPanel();                       //panel oluşturuldu
		JLabel lblNewLabel = new JLabel("New label");         //deneme labeli oluşturuldu
		JTextPane textPane = new JTextPane();                 //textpane oluşturuldu.
	     textPane.setBackground(getForeground().white);       //textpane arka planı belirlendi.
	     

	     
		topPanel.add(lblNewLabel);  //belirlenen ögeler istenen panele eklendi.
		topPanel.add(portList);
		topPanel.add(connectButton);
		contentPane.add(topPanel, BorderLayout.PAGE_START);   
		//contentPane.add(textPane);
		
		
	    Url cvd=new Url("Turkey");  //URL bağlantısından cvd isimli bir fonk oluşturuldu.
	   
	 	SerialPort[] portNames = SerialPort.getCommPorts(); //port dizi oluşturuldu.
		for(int i = 0; i < portNames.length; i++) //portlar for ile deklendi.
			portList.addItem(portNames[i].getSystemPortName());
		
		
		
		
		
		XYSeries series = new XYSeries("Metrical_Temp_1.0");  //x ve Y greafik cizicisi tanımlandı
		XYSeriesCollection dataset = new XYSeriesCollection(series);  // tanımlanan ver bir kolleksiyona atandı
		JFreeChart chart = ChartFactory.createXYLineChart("Sıcaklık Okuma", "Zaman(saniye)", "Sıcaklık ", dataset); 
		//Özel kütüphane olan JFREECHAR kutuphanesinden nesneler çagrıldı.
		
		contentPane.add(new ChartPanel(chart), BorderLayout.PAGE_END); //Tasarım Panele eklendi.
		series.add(x,500); //Başlangıç degerleri set edildi.
		
		
		
		connectButton.addActionListener(new ActionListener(){
			@Override public void actionPerformed(ActionEvent arg0) {
				
		
				
				if(connectButton.getText().equals("Connect")) {  //buton bağlantı işlemi  koşulu  eşitse bağlantıya
					//seri porta bağlanma denemesi 
					chosenPort = SerialPort.getCommPort(portList.getSelectedItem().toString());
					chosenPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
					
					if(chosenPort.openPort()) { //baglantı hatası
						connectButton.setText("Disconnect"); //bağlantı sağlanamazsa disconnet yazdır.
						portList.setEnabled(false); //port değiştirmeyi kapat.
					}
							
					
					Thread thread = new Thread(){        //port taraması için yeni bir thread oluşturuldu.
						@Override public void run() {    
							Scanner scanner = new Scanner(chosenPort.getInputStream());  //port üzreindeki veri tarandı.
							while(scanner.hasNextLine()) { //port veri  varlığı sorgulandı
								try { 
									String line = scanner.nextLine(); //scanner stringe çevrildi.
									int number = Integer.parseInt(line);       //strign int çevrildi.
			
									series.add(x++, number);
									System.out.println(number);    //veri port sayısı okundu.
									contentPane.repaint();         //değişiklik pane'e işlendi.
								    
								} catch(Exception e) {}
							}
							scanner.close();
						}
					};
					thread.start();     //1.thread başlatışdı
					
					
					
					Thread t2=new Thread() {             //işlem için yeni bir thread oluşturuldu.
						
						@Override public void run() {      
							try {Thread.sleep(100); } catch(Exception e) {}    //thread döngüsü belirlendi.
							
							int a=0;
							  //port için bir yazıcı oluşturuldu.
							         //baudrate hızı belirlendi.
							while (true) {                          //sonsuz döngüye girildi.
											 
								try {                           //try catc hata bloguna girildi.
									   a++;
										lblNewLabel.setText("Metrical");       //deneme için koşul dogüsü tekrarlı şekilde yazıldı.       
										Thread.sleep(500); //500 ms bekleme komutu
										lblNewLabel.setText("Medical");
										Thread.sleep(500);
									    
									     
									     
										
										
										try {Thread.sleep(10); } catch(Exception e) {}
										
									} catch (InterruptedException e) {      //cath genel hata ayıklaması
										// TODO Auto-generated catch block  
										e.printStackTrace();
								  	}
									
						
						 	}
							
							
						}
						
					} ;
				    
					
					t2.start(); //2.thread başlatıldı.
				
					
					
					
					Thread t3=new Thread() { //veri gönderme için yeni threaad oluşturuldu.
						
						@Override public void run() {
							 
							
							while (true) {                           //sonsuz döngüye girildi.					
								try {	
								
							          
		                            
									Thread.sleep(1000);            //işleme 1 sn periyot atandı.	
								} catch (InterruptedException e) { // cath hata blogu 
									// TODO Auto-generated catch block
									e.printStackTrace();
								}					
							}								
						}
						
						
					};
					
					t3.start(); //3.thread başlatıldı.
					
					
				} else {
					// bağlantı kapatma işlemi 
					chosenPort.closePort(); //port kapandı
					portList.setEnabled(true); //liste değiştirme aktif 
					connectButton.setText("Connect"); //bapğlantı connet yazdır
				}
			}
		});
		
		
		contentPane.setVisible(true); //görseli değiştir.
		
		
		
		
		
		
		
		
	}

}
