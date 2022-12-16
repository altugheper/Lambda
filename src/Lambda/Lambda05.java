package Lambda;

import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {
        System.out.println(topla(5));
        System.out.println(toplaCincix(5));
        System.out.println(ciftSayiTopla(2));
        System.out.println(toplaCiftIlk(2));
        System.out.println(toplaIlkXCift(5));
        System.out.println(toplaIlkXTek(2));
        ikininilkXKuvvetiPrint(6);
        System.out.println();
        istenenSayiIlkXKuvvetPrint(2,5);
        System.out.println();
        System.out.println(istenenSayiFaktorCal(5));


    }

    //TASK 01 --> Structured Programming ve Functional Programming ile
    // 1'den x'e kadar (x dahil) tamsayilari toplayan bir program create ediniz.

    //Structured
    public static int topla(int x){
        int toplam = 0;
        for (int i=0;i<=x;i++){
            toplam += i;
        }
        return toplam;
    }

    //Functional
    public static int toplaCincix(int x){ //List<Integer> x
        return IntStream. //int degerlerde bi akis saglar
                range(1, x + 1). //range(a,b) --> a dan b ye kadar int degerler akisa alindi
                sum(); //akisdan gelen degerler toplandi
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int ciftSayiTopla(int x){
        return IntStream.
                range(1,x+1).
                filter(Lambda01::ciftBul).
                sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int toplaCiftIlk(int x){
        return IntStream.
                rangeClosed(1, x*2).
                filter(Lambda01::ciftBul).
                sum();
    }

    public static int toplaIlkXCift(int x){
        return IntStream.
                iterate(2,t->t+2). //2 den sonsuza kadar elemanlari 2 artirarak akisa alir --> 2,4,6,8,...
                limit(x). //verilen int variableina kadar donguyu limitler. sonsuza kadar gitmesini engeller
                sum();
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int toplaIlkXTek(int x) {
        return IntStream.
                iterate(1, t -> t + 2). // 1,3,5,7,9...
                limit(x). //ilk x tek tamsayi ile sinirlandirildi
                sum(); //akistan gelen degerler toplandi
    }

    //TASK 05 --> 2'nin ilk pozitif x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininilkXKuvvetiPrint(int x){
        IntStream.
                iterate(2,t->t*2). //iterasyon icin sartimizi yazdik
                limit(x). //x degeri ile sinirladik
                forEach(Lambda01::yazdir); //Lambda01 classindaki yazdir methoduyla yazdirdik
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void istenenSayiIlkXKuvvetPrint(int istenenSayi, int x){
        IntStream.
                iterate(istenenSayi,t->t*2).
                limit(x).
                forEach(Lambda01::yazdir);
    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static int istenenSayiFaktorCal(int x){
        return IntStream. //int akis basladi
                rangeClosed(1,x). //1 den akis baslatip x e kadar
                reduce(1,(t,u)->t*u);
    }
}
