import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        
        ArrayList<String> list = getList("input.txt");

        System.out.println("\n Количество слов в файле: " + list.size()+"\n");
        

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

}