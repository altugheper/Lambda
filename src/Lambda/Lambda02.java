package Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
 * Yazili Olmayan Kural *
 * Lambda kullanirken mumkun mertebe "lambda expression"dan kacinilmasi önerilir.
 * Eger mumkunse "method referance" kullanilmasi tavsiye edilir.
 */

public class Lambda02 {
    public static void main(String[] args) {
        List<Integer> sayi = new ArrayList<>(Arrays.asList(4,2,6,11,-5,7,3,15));

        ciftKarePrint(sayi);
        System.out.println();
        tekKareArtiBirPrint(sayi);
        System.out.println();
        ciftKareKokPrint(sayi);
        System.out.println();
        enBuyukEleman(sayi);
        System.out.println();
        structuredMaxElBul(sayi);
        System.out.println();
        ciftKareEnBuyukPrint(sayi);
        System.out.println();
        elTopla(sayi);
        System.out.println();
        ciftElCarp(sayi);
        System.out.println();
        minBul(sayi);
        System.out.println();
        besdenBuyukEnKucukTekSayi(sayi);
        System.out.println();
        ciftElKareKucuktenBuyuge(sayi);


    }

    // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini
    // ayni satirda aralarina bosluk bırakarak print ediniz

    public static void ciftKarePrint(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul). //akisdaki cift sayilari filtreledim
                map(t -> t*t). // map(): Stream icerisindeki elemanlari baska degerlere donusturur
                forEach(Lambda01::yazdir);
    }

    // Task : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini
    // ayni satirda aralarina bosluk birakarak print edin
    public static boolean tekBul(int a){
        return a % 2 == 1;
    }

    public static void tekKareArtiBirPrint(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda02::tekBul).
                map(t->(t*t*t)+1).
                forEach(Lambda01::yazdir);
    }

    // Task-3 : Functional Programming ile listin cift elemanlarinin
    // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void ciftKareKokPrint(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt). //double
                forEach(t-> System.out.print(t+" "));
    }

    // Task-4 : list'in en buyuk elemanini yazdiriniz
    public static void enBuyukEleman(List<Integer> sayi){
        Optional<Integer> maxSayi = sayi.
                stream().
                reduce(Math::max); // Eger benim resultim tek bir deger ise o zaman reduce terminal operatoru kullanilir
        System.out.print(maxSayi);
    }

    //Ustteki taski structural ile cozelim
    public static void structuredMaxElBul(List<Integer> sayi){
        int max = Integer.MIN_VALUE;
        for (int i=0;i<sayi.size();i++){
            if (sayi.get(i)>max) max= sayi.get(i);
        }
        System.out.print("max = " + max);
    }

    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz
    public static void ciftKareEnBuyukPrint(List<Integer> sayi){
        System.out.print(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(a -> a * a).
                reduce(Integer::max)); //Integer::max methodu Math::max methoduna gore daha hizli calisir
    }

    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...
    public static void elTopla(List<Integer> sayi){
        int toplam = sayi.stream().reduce(0, Integer::sum);
        System.out.print("toplam = " + toplam);
    }

    // Task-7 : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void ciftElCarp(List<Integer> sayi){
        System.out.print(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(Math::multiplyExact)); //1. Yol //method reference

        System.out.print(sayi.
                stream().
                filter(Lambda01::ciftBul).
                reduce(1,(a,b)->(a*b))); //2. Yol //lambda expression
    }

    // Task-8 : List'teki elemanlardan en kucugunu  print ediniz.
    public static void minBul(List<Integer> sayi){
        //1. Yol
        System.out.println(sayi.
                stream().
                reduce(Integer::min)); //Math::min

        //2. Yol
        System.out.print(sayi.stream().reduce(Lambda02::byMiracMin));
    }
    public static int byMiracMin(int a, int b){
        return a<b ? a : b;
    }

    // Task-9 : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.
    public static void besdenBuyukEnKucukTekSayi(List<Integer> sayi){
        System.out.print(sayi.
                stream().
                filter(t -> t % 2 == 1 && t > 5).
                reduce(Lambda02::byMiracMin));
    }

    // Task-10 : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.
    public static void ciftElKareKucuktenBuyuge(List<Integer> sayi){
        sayi.
                stream(). //akisi baslattik
                filter(Lambda01::ciftBul). //akis icindeki cift sayilari aldik
                map(t -> t * t). //cift sayilarin karesini aldik
                sorted(). //karesini aldigimiz cift sayilari sort'ladik
                forEach(Lambda01::yazdir); //foreach ile yazdirdik
    }

}
