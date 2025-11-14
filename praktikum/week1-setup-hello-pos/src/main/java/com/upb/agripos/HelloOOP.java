class Mahasiswa {
   String nama;
   int nim;
   Mahasiswa(String n, int u) { nama = n; nim = u; }
   void sapa(){ System.out.println("Hai, i'm " + nama+ " - " + nim);}
}

public class HelloOOP {
   public static void main(String[] args) {
    Mahasiswa m = new Mahasiswa("Alvirdaus Permathasyahidatama Abadi", 240202852);
     m.sapa();
   }
}