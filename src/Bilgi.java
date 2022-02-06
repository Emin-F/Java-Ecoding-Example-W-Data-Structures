
import java.util.ArrayList;
import java.util.ArrayList;


public class Bilgi {
    private String Ad_Soyad;
    private Date biDate;
    private ArrayList <String> klupler;
    
   public String getAd_Soyad() {
        return Ad_Soyad;
    }

   
    public void setAd_Soyad(String Ad_Soyad) {
        this.Ad_Soyad = Ad_Soyad;
    }

    public Date getBiDate() {
        return biDate;
    }

   
    public void setBiDate(Date biDate) {
        this.biDate = biDate;
    }

    
    public ArrayList <String> getKlupler() {
        return klupler;
    }

  
    public void setKlupler(ArrayList <String> klupler) {
        this.klupler = klupler;
    }
  
    @Override
    public String toString(){
        return getAd_Soyad() +" " + getBiDate() +" "+ getKlupler() + "\n";
    }
}

    




    
