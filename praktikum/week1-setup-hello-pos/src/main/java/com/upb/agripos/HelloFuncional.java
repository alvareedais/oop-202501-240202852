import java.util.function.BiConsumer;
 public class HelloFuncional 
 { public static void main(String[] args) {
    BiConsumer<String,Integer> sapa = (nama, nim)  ->
    System.out.println("Hello world, i'm " + nama+ " - " + nim);
    sapa.accept("Alvirdaus Permathasyahidatama Abadi", 240202852);
 }
    
}
