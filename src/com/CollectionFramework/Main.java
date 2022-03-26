package com.CollectionFramework;

import java.awt.*;
import java.util.*;

/**
 *
 * @author Yusuf Enes Aras
 *
 **/

public class Main {

    public static void main(String[] args){

        /*
        1. Set
        Set’in karakteristik özelliği aynı elemandan birden fazla
        olmasına izin vermemesi ve birden fazla null eleman kabul etmemesidir.
        Yani e1 ve e2 elementleri için e1.equals(e2) ise bu iki eleman aynı Set içinde barınamaz.
        Şimdi Set interface’inden türetilen diğer collection framework üyelerine bakalım.

        HashSet:
        HashSet’te veriler hashleme yöntemi ile tutulur. Verilerin sırasının korunacağını garanti etmez.
        Yani önce e1, sonra e2 elementini kaydedip e2, e1 sırasında çekebilirsiniz.
        Aynı zamanda HashSet non-synchronized olduğu için birden fazla thread
        aynı anda bir HashSet’e erişip değiştirmeye çalışırsa problem yaşamamak için
        manuel bir çözüm olarak synchronized erişim sağlamalıyız.
         */


        String[] arr = {"Yusuf","ZZZ","ZZZ"};

        boolean b;

        HashSet hs = new HashSet(); //non generic

        for(String s : arr)
        {
            b = hs.add(s);
            if(!b)
            {
                System.out.println("*****Kopya Eleman: " + s);
            }

            Iterator it = hs.iterator();

            while(it.hasNext())
            {
                System.out.println("Küme Elemanı : " + it.next());
            }
        }

        System.out.println();
        System.out.println("--------------------------------------------");

        HashSet<String> meyveler = new HashSet<String>();
        meyveler.add("Elma");
        meyveler.add("Armut");
        meyveler.add("Muz");
        meyveler.add("Çilek");

        // Aynı elementten bir tane daha eklemeye çalışıyoruz.
        meyveler.add("Armut"); //tekrar eklemiyor

        // İki tane null eklemeye çalışıyoruz.
        meyveler.add(null);
        meyveler.add(null);
        System.out.print("HashSet -> ");

        meyveler.forEach(meyve -> System.out.print(meyve + " - "));

        System.out.println();
        System.out.println("--------------------------------------------");

        /*
        LinkedHashSet
        HashSet’ten tek farkı, eklenen elementlerin ekleme sırasına göre tutulmasıdır.
        (Insertion order) Tekrarlı element eklendiğinde ilk eklenen element bundan etkilenmez.
        */

        LinkedHashSet<String> gunler = new LinkedHashSet<String>();
        gunler.add("Pazartesi");
        gunler.add("Salı");
        gunler.add("Çarşamba");
        gunler.add("Perşembe");
        gunler.add("Cuma");
        gunler.add("Cumartesi");
        gunler.add("Pazar");

        // Aynı elementten tekrar kaydediyoruz.
        // Tekrarlı element sıralamayı değiştirmeyecek.
        gunler.add("Pazartesi");

        System.out.print("LinkedHashSet -> ");
        gunler.forEach(gun -> System.out.print(gun + " - "));

        System.out.println();
        System.out.println("--------------------------------------------");

        /*
        TreeSet
        TreeSet’lerde elementler artan sıralamayla, yani ascending order ile tutulur.
         null element kabul etmez. Eklenmeye çalışılırsa NullPointerException hatası verir.
         */

        TreeSet<Integer> sayilar = new TreeSet<Integer>();
        sayilar.add(4);
        sayilar.add(7);
        sayilar.add(2);
        sayilar.add(9);

        // Tekrarlı element ekliyoruz.
        // Kaydetmeyecek.
        sayilar.add(7);

        sayilar.forEach(sayi -> System.out.print(sayi + " - "));

        System.out.println();
        System.out.println("--------------------------------------------");

        System.out.println();
        System.out.println("Some Example");
        System.out.println();

        TreeSet<Integer> ts = new TreeSet<Integer>();

        ts.add(101);
        ts.add(201);
        ts.add(301);
        ts.add(401);
        ts.add(551);
        ts.add(601);
        ts.add(701);
        ts.add(801);

        System.out.println("TreeSet koleksiyon ogeleri : " + ts);
        System.out.println("koleksiyonun ilk ögesi : " + ts.first());
        System.out.println("koleksiyonın son ögesi : " + ts.last());
        System.out.println("7 den küçük elemanlar : "  + ts.headSet(7));
        System.out.println("6 ile 13 arasındaki elemanlar : " + ts.subSet(6, 13));
        System.out.println("7 ve 7 den büyük elemanlar : "  + ts.tailSet(7));

        System.out.println();
        System.out.println("--------------------------------------------");

        /*
        2. List
        List’in karakteristik özellikleri tekrarlı elementlere izin vermesi,
        elementleri ekleme sırasına göre tutması ve istediğimiz index’e element eklememize izin vermesidir.

        ArrayList
        Collection framework’de en çok kullanılan class’tır. List özelliklerini barındırır.
         */

        ArrayList<String> sehirler = new ArrayList<String>();
        sehirler.add("Ankara");
        sehirler.add("Edirne");
        sehirler.add("Manisa");
        sehirler.add("İzmir");
        sehirler.add("Aydın");

        // Tekrarlı element ekliyoruz.
        sehirler.add("Edirne");

        // İstediğimiz index'e eleman ekliyoruz.
        sehirler.add(3, "Çanakkale"); // bellekte onu kaydırıyor ve o indexe yerleştiriyor.

        System.out.print("ArrayList -> ");
        sehirler.forEach(sehir -> System.out.print(sehir + " - "));

        System.out.println();
        System.out.println("--------------------------------------------");

        /*
        LinkedList
        Sonuçları bakımından ArrayList ile aynıdır.
        Fakat aralarında bazı farklar mevcuttur.
        Arama işlemlerinde LinkedList O(n) iken ArrayList’te O(1)’dir.
        Silme işlemlerinde ise ArrayList O(n) iken LinkedList O(1)’dir.
        Ekleme işlemleri de aynı sonuçları verir.
        Dolayısıyla eğer ekleme ve silme işlemleri sık yapılacaksa LinkedList kullanmak daha avantajlıdır.
        Arama işlemleri sık yapılacak ise de ArrayList daha avantajlıdır.
         */

        LinkedList<String> filmler = new LinkedList<String>();
        filmler.add("The Silence of the Lambs");
        filmler.add("The Shining");
        filmler.add("Full Metal Jacket");
        filmler.add("Fargo");

        // İstediğimiz index'e eleman ekliyoruz.
        filmler.add(4, "2001: A Space Odyssey");

        System.out.print("LinkedList -> ");
        filmler.forEach(film -> System.out.print(film + " - "));

        System.out.println();
        System.out.println("--------------------------------------------");

        /*
        3.Queue
        Queue interface’i FIFO (first in first out) prensibini uygular.
        Yani sıraya ilk giren kişi ilk çıkar. Günlük hayattaki market sırası gibidir.
        offer() ve add() metodu ile ekleme yapıyoruz.
         Burada ki temel fark ekleme işleminde bir problem olursa offer() bir değer döndürür, add() ise hata fırlatır.
        */

        Queue<Object> tail = new LinkedList<Object>();
        tail.offer(-196);
        tail.add(null);
        tail.offer("String value");
        tail.offer(225);
        tail.offer(true);
        tail.offer("/");
        tail.offer(new Point(176, 394));
        tail.offer(0.000000000111222);

        for (Object o : tail) {
            System.out.println("Get Queue : " + o);
        }

        System.out.println();
        System.out.println("--------------------------------------------");

         /*
        Tekrarlayıcı (Iterator) List ve Set koleksiyonları üzerinde,
        bütün öğeleri tarayacak biçimde tekrarlanan eylemleri gerçekleştirmek için kullanılır.
        java.util.Iterator<E> arayüzü koleksiyonu baştan sona doğru tek yönlü tarar.

        next() : ileri doğru
        previous(): geri doğru
        hasNext(): ileride eleman varmı?
        hasPrevious(): geride elaman varmı? true yada false
         */

        ArrayList alist = new ArrayList(); //generic type yok.

        alist.add(1);
        alist.add(2);
        alist.add(3);

        /*
        ListIterator, Iterator arabiriminin alt arabirimidir.
        Iterator ve ListIterator arasındaki en büyük fark,
        Iterator'ın koleksiyondaki öğeleri yalnızca ileri yönde hareket ettirebilmesidir.
        ListIterator ise bir koleksiyondaki öğeleri hem ileri hem de geri yönde hareket ettirebilir.
        */

        ListIterator i = alist.listIterator();

        System.out.println("ArrayList i baştan sona doğru tarıyoruz...");

        while(i.hasNext())
        {
            System.out.println(i.nextIndex() + ".cı elaman ");
            System.out.println(i.next());
        }

        System.out.println("Arraylist i sondan başa doğru tarıyoruz...");

        while(i.hasPrevious())
        {
            System.out.println(i.previousIndex() + ".cı eleman");
            System.out.println(i.previous());
        }

        System.out.println();
        System.out.println("Some Example");
        System.out.println();

        LinkedHashSet<String> linkhs = new LinkedHashSet<String>();

        linkhs.add("Yusuf");
        linkhs.add("Enes");
        linkhs.add("Aras");
        linkhs.add("Trakya University");
        linkhs.add("Information Systems and Technology");

        Iterator itr = linkhs.iterator(); //iterator ile tarıyoruz

        while(itr.hasNext()) //forEach ile yapılabilir.
        {
            System.out.println("Collection Values : " + itr.next());
        }

        System.out.println();
        System.out.println("--------------------------------------------");

        /*
         HashMap:
        -HashMap temel olarak Map arayüzünün özelliklerini barındıran somut bir sınıf yapısıdır.
        -Yapı içerisinde yinelenen key (anahtar) verilerinin eklenmesine izin verilmez.
         ancak yinelenen value (değer) eklenmesine izin verir.
        -HashMap üzerinde eklenen değerlere erişmek için o yapının anahtarını bilmemiz gerekmektedir.
        -HashMap, senkronize bir yapı içerisinde bulunmamaktadır.
        -Bu yüzden verilerin sırasına ilişkin bir garanti verilmez.
        -Özellikle oluşan sıranın zaman içerisinde sabit kalacağını garanti etmez.
        */

        // HashMap Metotları:

        /*
        Put(Key,Value): Parametre olarak aldığı anahtar değeri yapı içerisinde bulunmuyor ise almış olduğu değer ile anahtar yapısını eşler ve depolar.
        Remove(Key): Parametre olarak almış olduğu anahtar değeri yapı içerisinde bulunduğu takdirde anahtar değeri ve eşleşen veriyi siler.
        Get(Key): HashMap içerisinde parametre olarak almış olduğu anahtar değeri bulunuyorsa eşleşmiş olduğu değeri geri döndürür.
        ContainsKey(Key) & ContainsValue(Value): HashMap içerisinde belirtilen anahtar veya değer varsa true yoksa false değerini döndüren metotlardır.
        Clear(): HashMap içerisinde yer alan tüm verileri silmek için kullanılır.
        EntrySet(): HashMap içerisine eklemiş olduğumuz öğeleri bir küme halinde geriye döndüren metot.
        HashCode(): Oluşturmuş olduğumuz HashMap’in hashCode’unu bizlere döndürür.
        KeySet(): HashMap içerisine eklemiş olduğumuz anahtarları küme halinde geriye döndürür.
        Size(): Anahtar ve değer eşleşmelerinin toplam sayısını geriye döndürür.
        Values(): HashMap içerisinde yer alan değerleri bir koleksiyon olarak geriye döndürür.
        */

        HashMap hm = new HashMap(10, 0.75f); //non generic

        hm.put("Bir", 1);
        hm.put("iki", 2);
        hm.put("Uc", 3);
        hm.put("Dort", 4);
        hm.put("Bes", 5);
        hm.put("Altı", 6);
        hm.put("Bir", 7);
        hm.put("Uc", 8);
        hm.put("Yedi", 2);

        Set data = hm.entrySet();
        Set key = hm.keySet();

        System.out.println("HashMap Öğesinin verileri :");
        Iterator it = data.iterator();

        while(it.hasNext())
            System.out.println(it.next());

        System.out.println("HashMap Öğesinin anahtarları : ");
        Iterator iterator = key.iterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());

        System.out.println();
        System.out.println("--------------------------------------------");

        /*
        TreeMap sınıfı Java Collections Framework 'un bir üyesidir.
        NavigableMap 'e dayalı bir kırmızı-siyah (red-black) ağaç yapısıdır.
        Gönderim anahtarların doğal sırasına göre ya da
        kullanılan kurucuya bağlı olarak Comparator'un belirlediği sıraya göre sıralanır.
        */

        TreeMap tm = new TreeMap(); //non generic

        tm.put(1, "Bir");
        tm.put(2, "iki");
        tm.put(6, "altı");
        tm.put(4, "Dört");
        tm.put(3, "Uc");
        tm.put(5, "bes");

        //TreeMap methods

        System.out.println("TreeMap Ogeleri : " + tm);
        System.out.println("3 veya 3 den sonraki en büyük anahtar-veri çifti : " + tm.ceilingEntry(3));
        System.out.println("Azalan Sırada Anahtarlar : " + tm.descendingKeySet());
        System.out.println("7 veya 7 den sonraki en küçük anahtar-veri çifti : " +tm.floorEntry(7));
        System.out.println("4 den küçün olan anahtar-veri çiftleri : " + tm.headMap(4));
        System.out.println("3 den büyük olan anahtar-veri çiftleri : " +  tm.higherEntry(3));
        System.out.println("2 den küçük olan anahtar degerleri : " + tm.lowerKey(2));
        System.out.println("Map içerisindeki son veri ( Silinecek olan veri " + tm.pollLastEntry());
        System.out.println("2 ile 4 değerleri arasındaki anahtar -veri çiftleri : " + tm.subMap(2, 5));
        System.out.println("4 ve 4 ten büyük olan anahtar veri çiftleri : " + tm.tailMap(4));

    }

}
