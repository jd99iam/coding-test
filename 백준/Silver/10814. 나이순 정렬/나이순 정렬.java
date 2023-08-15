import java.util.*;

class Member implements Comparable{
    int age;
    int order;
    String name;

    public Member(int age, int order, String name){
        this.age = age;
        this.order = order;
        this.name = name;
    }

    public int compareTo(Object o){
        Member m = (Member)o;
        if (age==m.age){
            return order-m.order;
        }
        return age-m.age;
    }

}

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        Member[] arr = new Member[count];
        for (int i=0; i<count; i++){
            int age = in.nextInt();
            String name = in.next();
            arr[i] = new Member(age,i,name);
        }


        Arrays.sort(arr);

        for (Member m : arr){
            System.out.println(m.age+" "+m.name);
        }
    }
}