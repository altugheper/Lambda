package Lambda;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList("trilece", "havucDilim", "guvec", "kokorec", "kusleme",
                "arabAsi", "waffle", "kunefe", "guvec"));

        alfBykTekrsz(menu);
        System.out.println();
        chrSayisiTersSiraliUnique(menu);
        System.out.println();
        chrSayisiSiralamaUnique(menu);
        System.out.println();
        elKarakterSayisi(menu);
        System.out.println();
        wIleBaslayanElKontrol(menu);
        System.out.println();
        xIleBitenElKontrol(menu);
        System.out.println();
        charSayisiEnBykElPrint(menu);


    }
    //Task -1: List elemanlarini alfabetik siraya gore buyuk harf ve tekrarsiz print ediniz
    public static void alfBykTekrsz(List<String> yemek){
        yemek.
                stream(). //akis basladi
                map(String::toUpperCase). //Buyuk harf
                sorted(). //dogal siralama
                distinct(). //elemanlarin tekrarsiz olmasini sagladi
                forEach(t -> System.out.print(t + " ")); //print
    }

    // Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..
    public static void chrSayisiTersSiraliUnique(List<String> ikram){
        ikram.
                stream(). //akis alindi
                map(String::length). //akisi guncelledim, kelimelerin uzunlugu olarak
                sorted(Comparator.reverseOrder()). //ters sortladim
                distinct(). //elemanlarin tekrarsiz olmasini sagladim
                forEach(Lambda01::yazdir); //print
    }

    // Task-3 : List elemanlarini character sayisina gore kckten byk e gore print ediniz..
    public static void chrSayisiSiralamaUnique(List<String> ikram){
        ikram.
                stream(). //akis saglandi
                sorted(Comparator.comparing(String::length)). //String ifadeleri karakter sayisina gore k->b ye gore siraladim
                distinct(). //elemanlarin tekrarsiz olmasini sagladim
                forEach(Lambda01::yazdir); //print
    }

    // ******************************************************************************************
    // *********************** anyMatch() *** allMatch() **** noneMatch() ************************
    //*******************************************************************************************

    //anyMatch() --> en az bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    // Task-4 : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void elKarakterSayisi(List<String> ikram){
        System.out.print(ikram.
                stream().
                allMatch(t->t.length()<=7) ? "list elemanlari 7 ve daha az harften olusuyor":
                "list elemanlari 7 harften buyuk");
    }

    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.
    public static void wIleBaslayanElKontrol(List<String> ikram) {
        System.out.print(ikram.
                stream().
                noneMatch(t -> t.startsWith("w")) ? "w ile yemek ismi mi olur" :
                "w ile yemek icat ettik");
    }
    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.
    public static void xIleBitenElKontrol(List<String> ikram) {
        System.out.print(ikram.
                stream().
                anyMatch(t -> t.endsWith("x")) ? "maşallah" : "x ile yemek ismi mi biter");
    }
    // Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void charSayisiEnBykElPrint(List<String> ikram){
        Stream<String> sonIsim = ikram.
                stream(). //akis saglandi
                sorted(Comparator.comparing(t->t.toString().length()).
                        reversed()). //karakter sayisina gore tersden siralandi
                limit(1); //limit methodu kullanarak sadece ilk eleman cagrildi
        // limit() methodunun donen degeri Stream<String> yapidadir
        System.out.print(Arrays.toString(sonIsim.toArray()));
        //sonIsim.toArray() --> Stream olan akis Array e cevrildi
        //Arrays.toString(sonIsim.toArray()) --> Arrayi string yapica ceviriyor
    }

    // Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void ilkElHaricSonHarfSiraliPrint(List<String> ikram){
        ikram.
                stream(). //akis saglandi
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))). //son harfine gore alfabetik siralandi
                skip(1). //akisdaki ilk eleman haric tutuldu
                forEach(Lambda01::yazdir); //ekrana print edildi
    }

}
