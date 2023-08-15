import java.util.*;

class Word implements Comparable{
    String content;
    int length;

    public Word(String content){
        this.content = content;
        this.length = content.length();
    }

    public int compareTo(Object o){
        Word w = (Word)o;
        if (length==w.length){
            return content.compareTo(w.content);
        }
        return length-w.length;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TreeSet<Word> set = new TreeSet<>();
        for (int i=0; i<n; i++){
            String s = in.next();
            set.add(new Word(s));
        }

        for (Word w : set){
            System.out.println(w.content);
        }

    }
}