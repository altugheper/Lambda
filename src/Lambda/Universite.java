package Lambda;

public class Universite {

    private String university;
    private String bolum;
    private int ogrenciSayisi;
    private int notOrt;

    //parametresiz constructor
    public Universite() {
    }

    //parametreli constructor
    public Universite(String university, String bolum, int ogrenciSayisi, int notOrt) {
        this.university = university;
        this.bolum = bolum;
        this.ogrenciSayisi = ogrenciSayisi;
        this.notOrt = notOrt;
    }

    //GETTER & SETTER
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public int getOgrenciSayisi() {
        return ogrenciSayisi;
    }

    public void setOgrenciSayisi(int ogrenciSayisi) {
        this.ogrenciSayisi = ogrenciSayisi;
    }

    public int getNotOrt() {
        return notOrt;
    }

    public void setNotOrt(int notOrt) {
        this.notOrt = notOrt;
    }

    @Override
    public String toString() {
        return "Universite{" +
                "university='" + university + '\'' +
                ", bolum='" + bolum + '\'' +
                ", ogrenciSayisi=" + ogrenciSayisi +
                ", notOrt=" + notOrt +
                '}';
    }
}
