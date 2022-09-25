package Demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos1 = new FileOutputStream("./Exercises.txt");
        FileOutputStream fos2 = new FileOutputStream("./Answers.txt");
        ArrayList<String> sl = new ArrayList<String>();
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int fhs;
        String[] strings = new String[2];
        for (int i=0;i<num;i++){
            fhs = 1+r.nextInt(100);
            if(fhs>=30) {
                strings = two(sl);
                fos1.write((i+1+".").getBytes(StandardCharsets.UTF_8));
                fos1.write(strings[0].getBytes(StandardCharsets.UTF_8));
                sl.add(strings[0]);
                fos1.write("\n".getBytes(StandardCharsets.UTF_8));
                fos2.write((i+1+".").getBytes(StandardCharsets.UTF_8));
                fos2.write(strings[1].getBytes(StandardCharsets.UTF_8));
                fos2.write("\n".getBytes(StandardCharsets.UTF_8));
            }
            else {
                strings = three(sl);
                fos1.write((i+1+".").getBytes(StandardCharsets.UTF_8));
                fos1.write(strings[0].getBytes(StandardCharsets.UTF_8));
                sl.add(strings[0]);
                fos1.write("\n".getBytes(StandardCharsets.UTF_8));
                fos2.write((i+1+".").getBytes(StandardCharsets.UTF_8));
                fos2.write(strings[1].getBytes(StandardCharsets.UTF_8));
                fos2.write("\n".getBytes(StandardCharsets.UTF_8));
            }
        }
        fos2.close();
    }
    public static String[] two(ArrayList<String> sl) throws IOException {
        Random r = new Random();
        int fh = 1+r.nextInt(100);//符号
        int a = r.nextInt(100);
        int b = r.nextInt(100);
        int c;
        int answer;
        if(fh>=50&&a<b){
            c=a;
            a=b;
            b=c;
        }
        String s = (fh>=50)?"-":"+";
        answer = (s=="+")?(a+b):(a-b);
        String str = a+s+b+"=";
        for (String so:sl) {
            if(str.equals(so)) return two(sl);
        }
        String ans = answer+"";
        String[] sa = new String[2];
        sa[0] = str;
        sa[1] = ans;
        return sa;
    }
    public static String[] three(ArrayList<String> sl) throws IOException {
        FileInputStream fis = new FileInputStream("./Exercises.txt");
        Random r = new Random();
        int fh1 = 1+r.nextInt(100);
        int fh2 = 1+r.nextInt(100);
        int a = r.nextInt(100);
        int b = r.nextInt(100);
        int c = r.nextInt(100);
        int d;
        int answer;
        String s1 = (fh1>=50)?"-":"+";
        String s2 = (fh2<=50)?"-":"+";
        d = (s1=="+")?(a+b):(a-b);
        answer = (s2=="+")?(d+c):(d-c);
        if(answer<0) return three(sl);
        String str  = a+s1+b+s2+c+"=";
        for (String so:sl) {
            if(str.equals(so)) return three(sl);
        }
        String ans = answer+"";
        String[] sa = new String[2];
        sa[0] = str;
        sa[1] = ans;
        return sa;
    }
}
