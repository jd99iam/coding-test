import java.util.HashMap;

class Solution {

    private static final int MID = 4;
    private static char[] types = {'R','T','C','F','J','M','A','N'};

    public String solution(String[] survey, int[] choices) {
       // String answer = "";

        HashMap<Character, Integer> score = new HashMap<>();
        score.put('R', 0);
        score.put('T', 0);
        score.put('C', 0);
        score.put('F', 0);
        score.put('J', 0);
        score.put('M', 0);
        score.put('A', 0);
        score.put('N', 0);

        Character first, second;
        int choice;
        for (int i = 0; i < survey.length; i++) {
            first = survey[i].charAt(0);
            second = survey[i].charAt(1);
            choice = choices[i];
            if (choice < MID) {
                score.put(first, score.get(first) + (MID - choice));
            }
            if (choice > MID) {
                score.put(second, score.get(second) + (choice - MID));
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<=6; i+=2){
            char f = types[i];
            char s = types[i+1];
            if (score.get(f)>score.get(s)){
                sb.append(f);
            } else if (score.get(f)<score.get(s)){
                sb.append(s);
            } else {
                char fast;
                if (s<f) {
                    fast = s;
                } else {
                    fast = f;
                }
                sb.append(fast);
            }
            System.out.println(sb.toString());
        }

        // return answer;
        return sb.toString();
    }
}