import java.util.function.BiConsumer;

public class HelloFunctional {
    public static void main(String[] args) {

        BiConsumer<String, Integer> sapa = (nama, nim) ->
            System.out.println("Halo world, I am " + nama + " - " + nim);

        sapa.accept("Alvirdaus Permathasyahidatama Abadi", 240202852);

    }

}
