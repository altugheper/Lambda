package lambdapractice;

import Lambda.Lambda01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaPrac02 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Elma");
        list.add("portakal");
        list.add("uzum");
        list.add("cilek");
        list.add("greyfurt");
        list.add("nar");
        list.add("mandalina");
        list.add("armut");
        list.add("elma");
        list.add("keciboynuzu");
        list.add("Ayva");

        System.out.println("ilkHrfBykDigerKck(list) = " + ilkHrfBykDigerKck(list));
        System.out.println("ecIleBaslayanList(list) = " + ecIleBaslayanList(list));
        basaVeSonaYildiz(list);
        System.out.println();
        System.out.println("icindeEOlanList(list) = " + icindeEOlanList(list));
        removeLPrint(list);

    }

    //list elemanlarini ilk harf buyuk gerisi kucuk seklinde listeleyelim
    public static List<String> ilkHrfBykDigerKck (List<String> list){
      return list.stream().
              map(t->t.substring(0,1).toUpperCase()+t.substring(1).toLowerCase()).
              collect(Collectors.toList());
    }

    //ilk harfi e veya c olanlari listeleyelim
    public static List<String> ecIleBaslayanList(List<String> list){
       return list.stream().filter(t->t.toLowerCase().startsWith("e") || t.startsWith("c")).collect(Collectors.toList());
    }

    //tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim
    public static void basaVeSonaYildiz(List<String> list){
        list.stream().map(t->"*"+t+"*").forEach(Lambda01::yazdir);
    }

    //Icinde e olanlardan yeni bir list olusturunuz
    public static List<String> icindeEOlanList(List<String> list){
      return   list.stream().filter(t->t.toLowerCase().contains("e")).collect(Collectors.toList());
    }

    //tum "l"leri silelim yazdiralim
    public static void removeLPrint(List<String> list){
        list.stream().map(t->t.replace("l","")).forEach(Lambda01::yazdir);
    }

    //List elemanlarinin 2. harfe gore siralayip
    //ilk 5 elemandan char sayisi en buyuk elemani print et

}
