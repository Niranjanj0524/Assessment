import java.util.HashMap;

public class WorkoutFrequency {
    public static void main(String[] args) {
        String[] words = { "Bench", "Squat", "Bench", "Deadlift", "Squat", "Bench" };
        String result = firstUnique(words);
        System.out.println(result);

    }

    public static String firstUnique(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : words) {
            if (map.get(s) == 1) {
                return s; 
            }
        }
        return null;
    }

}