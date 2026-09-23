import java.time.LocalDate;
import java.util.HashSet;

public class LongestWorkoutStreak {
    public static void main(String[] args) {
        String[] WorkoutDate = {
                "2026-09-15",
                "2026-09-16",
                "2026-09-17",
                "2026-09-19",
                "2026-09-20",
                "2026-09-21"
        };

        int longStreak = longestStreak(WorkoutDate);
        System.out.println("Longest Streek: " + longStreak);
    }

    public static int longestStreak(String[] dates){
        if(dates == null || dates.length == 0){
            return 0;
        }
        HashSet<LocalDate> set = new HashSet<>();

        for(String date : dates){
            set.add(LocalDate.parse(date));
        }

        int streak = 0;

        for(LocalDate curr : set){
            if(!set.contains(curr.minusDays(1))){
                LocalDate nextDate = curr;
                int currStreak = 0;

                while(set.contains(nextDate)){
                    currStreak++;
                    nextDate = nextDate.plusDays(1);
                }
                streak = Math.max(streak, currStreak);
            }
        }
        return streak;
    }
}
