import model.Kontrak.*;
import model.Pembayaran.*;
import util.CreditBy;

public class MainAbstraction {
    public static void main(String[] args) {
        Pembayaran cash = new Cash("CSH-135", 160000, 180000);
        Pembayaran ew = new EWallet("EWL-790", 210000, "JiungAE@ewallet", "135790");

        System.out.println(((Receiptable) cash).cetakStruk());
        System.out.println(((Receiptable) ew).cetakStruk());

        CreditBy.print("240202852", "Alvirdaus Permathasyahidatama Abadi");
    }
}