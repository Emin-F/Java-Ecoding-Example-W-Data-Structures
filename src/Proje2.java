
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;

public class Proje2 extends JFrame{
        JTextField tf1,tf2,tf3,tf4 ;  
        JButton b1,b2,b3,b4;
        
        public Proje2() throws IOException{
        LinkedList liste = new LinkedList();
        String line;
        BufferedReader reader;
                
        try{
            reader = new BufferedReader(new FileReader("sporcu.txt"));
            line = null; 
            
           while ((line = reader.readLine()) != null){
               
                liste.sirali_Ekle(tokenizer(line));               
            }
            
        }
        catch(FileNotFoundException e){
            System.out.println("DOSYA BULUNAMADI!");
        }
        
        
        JFrame f= new JFrame("Arayüz Ekranı");  
        tf1=new JTextField(); 
        tf1.setBounds(80,80,150,50);  //x axis  y axis witdh height
           
        tf2=new JTextField();  //eklemek iÃ§in ad soyad
        tf2.setBounds(380,80,150,50);
        
        tf3=new JTextField();  //doÄŸum tarihi
        tf3.setBounds(380,150,150,50);
        
        tf4=new JTextField();  //takÄ±mlar iÃ§in
        tf4.setBounds(380,220,150,50);
            
         
        
        
        JLabel l3=new JLabel("Ad Soyad:");    //oyuncu eklemek iÃ§in
        l3.setBounds(280,80,150,50); 
        
        JLabel l2=new JLabel("Ad Soyad:");     //oyuncu silmek iÃ§in olanÄ±n
        l2.setBounds(20,75, 80,30); 
        
        JLabel l4=new JLabel("Doğum Tarihi:");   //oyuncu eklemek iÃ§in 
        l4.setBounds(280,160,80,30); 
        
        JLabel l5=new JLabel("Oynadığı Takım:");    //oyuncu eklemek iÃ§in
        l5.setBounds(280,210,150,50);
        
        
        
        f.add(tf1);
        f.add(tf2);
        f.add(tf3);
        f.add(tf4);
        
        TextArea area = new TextArea(); 
        area.setBounds(650,120,300,300);
        area.setText(liste.toString());
        area.setEditable(false);
        f.add(area);
        TextArea area2 = new TextArea();
        area2.setBounds(650,500,300,300);
        area2.setText("Oyuncu Bilgileri");
        area2.setEditable(false);
        f.add(area2);
                
        
         TextArea area3 = new TextArea(); 
        area3.setBounds(1000,120,300,300);
         area3.setText(liste.toString2());
         area3.setEditable(false);

        f.add(area3);
        
        
        b1=new JButton("OYUNCUYU SİL"); 
        b1.setBounds(20,280,150,150); 
        b1.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                String Ad_Soyad = tf1.getText();
                System.out.println(tf1.getText());
                liste.remove(Ad_Soyad);
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");
                
                
                area.setText(liste.toString());
                 area3.setText(liste.toString2());

                
            }});  
        
        b2=new JButton("OYUNCUYU EKLE");  
        b2.setBounds(350,280,150,150);
        b2.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                String Ad_Soyad = tf2.getText();
                String Date = tf3.getText();               
                String klupler = tf4.getText();
                
                String[] dateler = Date.split("/");
                int gun = Integer.valueOf(dateler[0]);
                int ay = Integer.valueOf(dateler[1]);
                int yil = Integer.valueOf(dateler[2]);
                Date biDate = new Date(ay, gun, yil);
                
                StringTokenizer ak = new StringTokenizer(klupler,",");
                ArrayList <String> kluplerr = new ArrayList<> ();     
                while(ak.hasMoreTokens()){
                    kluplerr.add(ak.nextToken());
                }
                
                Bilgi data = new Bilgi();                              
                data.setAd_Soyad(Ad_Soyad);
                data.setBiDate(biDate);
                data.setKlupler(kluplerr);
                
                liste.sirali_Ekle(data);
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");
                
                area.setText(liste.toString());
                area3.setText(liste.toString2());
                
            }});
        
        b3=new JButton("ÇIKIŞ");  
        b3.setBounds(350,430,150,150); 
        b3.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                try {                
                    liste.dosyaya_yazdirma();
                    System.exit(0);
                    
                } catch (IOException ex) {
                    System.out.println("Error");
                }
            }});  
  b4=new JButton("BİLGİLERİ GÖRÜNTÜLE");   
        b4.setBounds(20,430,150,150); 
        b4.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                String Ad_Soyad = tf1.getText();
                area2.setText(liste.bilgi_goruntule(Ad_Soyad));
                

                
            }});
       
        f.add(l5);
        
        f.add(l4);
        
        f.add(l3);
        
        f.add(l2);
        
        f.add(b1);  
        f.add(b2);   
        f.add(b3);
        f.add(b4);
        f.setSize(300,300);   
        f.setLayout(null);   
        f.setVisible(true);   

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }       

    
    public static void main(String[] args) throws IOException {
        Proje2 gui = new Proje2();
        
    }
    
    public static Bilgi tokenizer(String line) {
        
        
            Bilgi new_sporcu = new Bilgi();

            String [] veriler = line.split(",");
            
            String Ad_Soyad = veriler[0];
            new_sporcu.setAd_Soyad(Ad_Soyad);
                         
            String[] dateler = veriler[1].split("/");
            int gun = Integer.valueOf(dateler[0]);
            int ay = Integer.valueOf(dateler[1]);
            int yil = Integer.valueOf(dateler[2]);
            Date biDate = new Date(ay, gun, yil);
            new_sporcu.setBiDate(biDate);
            
            int i = 2;
            int size = veriler.length;
            ArrayList <String> klupler = new ArrayList<String>();
            for( int j= 0; j < size - 2 ; j++){
                
                klupler.add(veriler[i]);
                i++;
            }
            new_sporcu.setKlupler(klupler);
            
            return new_sporcu;
    }
    
    
}