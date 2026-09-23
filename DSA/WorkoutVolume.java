import java.util.HashMap;
import java.util.Map;

public class WorkoutVolume {
    public static void main(String[] args) {
        WorkoutRecord[] records = {
            new WorkoutRecord("Bench Press", 60, 10),
            new WorkoutRecord("Squat", 100, 5),
            new WorkoutRecord("Bench Press", 70, 8),
            new WorkoutRecord("Squat", 110, 3),
            new WorkoutRecord("Deadlift", 120, 5)
        };
        String maxVolumeExcercise = MaxVolumeExcercise(records);
        System.out.println("MaxVolmueExcercise: " + maxVolumeExcercise);
    }

    public static class WorkoutRecord {
        String excercise;
        int weight;
        int reps;

        public WorkoutRecord(String excercise, int weight, int reps) {
            this.excercise = excercise;
            this.weight = weight;
            this.reps = reps;
        }
    }

    public static String MaxVolumeExcercise(WorkoutRecord[] records) {
        if (records == null || records.length == 0) {
            return null;
        }

        HashMap<String, Long> map = new HashMap<>();
        for (WorkoutRecord record : records) {
            long currVolume = (long) record.weight * record.reps;
            map.put(record.excercise, map.getOrDefault(record.excercise, 0L) + currVolume);
        }

        String maxExcercise = null;
        long maxVolume = Long.MIN_VALUE;

        for (Map.Entry<String, Long> entry : map.entrySet()) {
            if (entry.getValue() > maxVolume) {
                maxVolume = entry.getValue();
                maxExcercise = entry.getKey();
            }
        }
        return maxExcercise;
    }
}
