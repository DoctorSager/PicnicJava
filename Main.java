import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        
        ArrayList<String> list = getList("input.txt");

        System.out.println("\n Количество слов в файле: " + list.size()+"\n");
        getIndex(list);
        System.out.println(" Cколько раз какой элемент встречается в файле: \n" + convertToHashMap(list));
        
    }


    private static void getIndex(ArrayList<String> list) {
        int maxSymbols = list.get(0).length();
        int index = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > maxSymbols) {
                maxSymbols = list.get(i).length();
                index = i;
            }  
        }
        System.out.println(" Cамое длинное слово в файле: " + list.get(index) + "\n");
    }


    public static ArrayList<String> getList (String fileName) throws Exception{
        FileReader fr = new FileReader("input.txt");
        Scanner sc = new Scanner(fr);
        Scanner scr;
        sc.useDelimiter(",*");
        String s;
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; sc.hasNext(); i++) {
            s = sc.nextLine();
            scr = new Scanner(s);
            for (int j = 0; scr.hasNext(); j++) {
                list.add(scr.next());
            }
        }
        sc.close();
        return list;
    }

public static HashMap<String,Integer> convertToHashMap(ArrayList<String> arrayList){
    HashMap<String, Integer> hashMap = new HashMap<>();

    for (String str : arrayList){
        if (hashMap.keySet().contains(str)) {
            hashMap.put(str, hashMap.get(str)+1);
        }else{
            hashMap.put(str, 1);
        }
    }
    return hashMap;
    }
}