package Lambda;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {



        /*
            TASK :
            fields --> Universite (String)
           bolum (String)
           ogrcSayisi (int)
           notOrt (int)
           olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
        */

    public static void main(String[] args) {

        Universite u01 = new Universite("bogazici", "matematik",571,93);
        Universite u02 = new Universite("istanbul tk", "matematik",600,81);
        Universite u03 = new Universite("istanbul", "hukuk",1400,71);
        Universite u04 = new Universite("marmara", "bilg muh",1080,77);
        Universite u05 = new Universite("odtu", "gemi muh",333,74);

        List<Universite> unv = new ArrayList<>(Arrays.asList(u01,u02,u03,u04,u05));

        System.out.println(notOrt74BykUnv(unv));
        System.out.println(matBolumVarMi(unv));
        System.out.println(ogrSayisiBykdenKcge(unv));
        System.out.println("matBolSayisi: " + matBolSayi(unv));
        System.out.println(ogrcSayisiByk550(unv));
        System.out.println(ogrcSayisi1050AzminNotOrt(unv));

    }

    //task 01: butun unv lerin notOrt'larinin 74'den buyuk oldugunu kontol eden pr create ediniz
    public static boolean notOrt74BykUnv(List<Universite> unv){
       return unv.
               stream().
               allMatch(t -> t.getNotOrt()>74);
    }

    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean matBolumVarMi(List<Universite> unv){
       return unv.
               stream(). //akis saglandi
               anyMatch(t->t.getBolum(). //objeclerin bolum isimleri alindi
                       toLowerCase(). //bolum isimlerindeki karakterler kucuk harfe cevrildi
                       contains("mat")); //mat kelimesi var mi kontrol
    }

    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<Universite> ogrSayisiBykdenKcge(List<Universite> unv){
        return unv.
                stream(). //akis saglandi
                sorted(Comparator.comparing(Universite::getOgrenciSayisi).reversed()).
                //universiteler ogrenci sayisina gore tersden siralandi
                collect(Collectors.toList()); //Stream yapisi List yapisina donusturuldu
    }

    //task 04-->"matematik" bolumlerinin sayisini  print ediniz.
    public static int matBolSayi (List<Universite> unv){
        return (int) unv. //type casting yapildi. long return type i olan count methodu oldugu icin parantez icinde (int) yaparak int return type yarattik
                stream(). //akis saglandi
                filter(t -> t.getBolum(). //matematik bolumu olan unv sectim
                        contains("matematik")). //secilen
                count();
    }

    //task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.
    public static OptionalInt ogrcSayisiByk550(List<Universite> unv){
       return unv.
               stream().
               filter(t->t.getOgrenciSayisi()>550).
               mapToInt(t->t.getNotOrt()).
               max();
    }

    //task 06-->Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.
    public static OptionalInt ogrcSayisi1050AzminNotOrt(List<Universite> unv){
        return unv.
                stream().
                filter(t->t.getOgrenciSayisi()<1050).
                mapToInt(t->t.getNotOrt()).
                min();
    }

}
