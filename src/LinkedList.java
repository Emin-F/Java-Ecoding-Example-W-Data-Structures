import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public  class  LinkedList{
    Node head;
    Node tail;
    
    public LinkedList(){
        head = null;
        tail = null;
    }
    

    public int listeDolas(){
        Node isaretci=head;
        int sayac = 0;
        while (isaretci != null){
            sayac++;
            isaretci = isaretci.next;
        }
        return sayac;
    }
    
     public void sirali_Ekle(Bilgi Kontrol){
        Node new_Node = new Node(Kontrol);
        if (!doluMu()){  //liste boÅŸsa ilk elemanÄ± ekler
            head = new_Node;
            tail = new_Node;}
         else if (head.next == null){  //listede tek eleman varsa 2. elemanÄ± ekler head ya da tail'i atar
            if(head.data.getAd_Soyad().compareTo(new_Node.data.getAd_Soyad()) <0         
                    || head.data.getAd_Soyad().compareTo(new_Node.data.getAd_Soyad()) ==0 ){

                head.next = new_Node;
                new_Node.previous = head;
                tail = new_Node;}   
            else if (head.data.getAd_Soyad().compareTo(new_Node.data.getAd_Soyad()) > 0
                    || head.data.getAd_Soyad().compareTo(new_Node.data.getAd_Soyad()) ==0){
                new_Node.next = head;
                head.previous = new_Node;
                head = new_Node;}
        }    
        else if (head.next != null){  //listede en az 2 eleman varsa yapÄ±lacaklar
            Node isaretci = head;
            Node isaretci2 = head.next;
            while(isaretci2 != null){  
                if(isaretci.data.getAd_Soyad().compareTo(new_Node.data.getAd_Soyad()) >0  
                        && isaretci == head || isaretci.data.getAd_Soyad().compareTo(new_Node.data.getAd_Soyad()) == 0 ){
                    head.previous = new_Node;
                    new_Node.next = head;
                    head = new_Node;
                    break;
                   //baÅŸa eleman eklemek iÃ§in
 } 
                if ((isaretci2.data.getAd_Soyad().compareTo(new_Node.data.getAd_Soyad())<0 && isaretci2==tail) 
                        || (isaretci2.data.getAd_Soyad().compareTo(new_Node.data.getAd_Soyad()) == 0  && isaretci2 == tail)){  
                    tail.next = new_Node;
                    new_Node.previous = tail;
                    tail = new_Node;
                    break;
                    //sona eleman eklemek iÃ§in
                }
                if(isaretci2.data.getAd_Soyad().compareTo(new_Node.data.getAd_Soyad()) > 0     
                        || isaretci2.data.getAd_Soyad().compareTo(new_Node.data.getAd_Soyad()) == 0
                        ){
                    isaretci.next = new_Node;
                    isaretci2.previous = new_Node;
                    new_Node.previous = isaretci;
                    new_Node.next = isaretci2;
                   break; }
                    isaretci = isaretci2;
                    isaretci2 = isaretci2.next;}
        }
    }

public void remove(String Ad_Soyad){
        Node temp = head;
        
        while (temp.data.getAd_Soyad().compareTo(Ad_Soyad) != 0 && temp != null){
            temp = temp.next;
        }
        
        if(temp == head)
            head = temp.next;
        
        else{
            temp.previous.next = temp.next;
            if (temp == tail)
                tail = temp.previous;
            else 
                temp.previous.next = temp.next;
        }
    }
      
        public boolean doluMu() {
       if ( head != null ){
           return true;
       }
       else {
           return false;
       }
    }
        

    @Override
    public String toString() {
        String result = "Liste  A-Z : \n" ;
        Node isaretci = head;
        while (isaretci.next != null){
            result += isaretci.data + "\n";
            isaretci = isaretci.next;           
        }
        result += isaretci.data;
        return result;
    }

    public String toString2(){
        String result="Liste Z-A : \n" ;
        Node isaretci =tail;
        while(isaretci.previous !=null){
            result+=isaretci.data + "\n";
            isaretci=isaretci.previous;
        }
        result+=isaretci.data;
        return  result;
    }
    
    public String bilgi_goruntule(String Ad_Soyad){
        String result="Oyuncu Bilgileri:  \n";
        Node isaretci=head;
        while(isaretci!=null){
            if(isaretci.data.getAd_Soyad().compareTo(Ad_Soyad)==0){
                 result+=isaretci.data.getAd_Soyad()+ "\n" + isaretci.data.getBiDate() + "\n" + isaretci.data.getKlupler() ;
            }
            isaretci=isaretci.next;
        }
                        return result;

    }
    
 
   public void dosyaya_yazdirma() throws IOException{
       Node isaretci = head;
       BufferedWriter writer = new BufferedWriter(new FileWriter("sporcu.txt"));
       while (isaretci != null){
           writer.write(isaretci.data.getAd_Soyad() + ", " +isaretci.data.getBiDate()+ ", " + isaretci.data.getKlupler()+ "\n" );
           isaretci = isaretci.next;
       }
       writer.close();
   }
}
