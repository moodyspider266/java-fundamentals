package classifiers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NaiveBayesClassifier {

    private static Map<String, Integer> winTimeCounts = new HashMap<>();
    private static Map<String, Integer> loseTimeCounts = new HashMap<>();
    private static int totalWins = 0;
    private static int totalLosses = 0;

    // Function to categorize time into morning, afternoon, evening
    private static String categorizeTime(String kickoffTime) {
        try {
            // Remove any surrounding quotes or extra characters
            kickoffTime = kickoffTime.replace("\"", "").trim();
            
            // Check if the kickoffTime is valid
            if (kickoffTime.matches("\\d{2}:\\d{2}:\\d{2}")) {
                String[] timeParts = kickoffTime.split(":");
                int hour = Integer.parseInt(timeParts[0]);

                if (hour >= 6 && hour < 12) {
                    return "morning";
                } else if (hour >= 12 && hour < 18) {
                    return "afternoon";
                } else {
                    return "evening";
                }
            } else {
                System.err.println("Invalid time format: " + kickoffTime);
                return "unknown";
            }
        } catch (NumberFormatException e) {
            System.err.println("Error parsing time format: " + kickoffTime);
            return "unknown";
        }
    }

    // Function to predict home team win based on kickoff time category
    private static boolean predictHomeTeamWin(String timeCategory) {
        double probWin = calculateProbability(timeCategory, winTimeCounts, totalWins);
        double probLose = calculateProbability(timeCategory, loseTimeCounts, totalLosses);

        return probWin > probLose;
    }

    // Function to calculate Naive Bayes probabilities
    private static double calculateProbability(String timeCategory, Map<String, Integer> timeCounts, int totalOutcomes) {
        int timeCount = timeCounts.getOrDefault(timeCategory, 0);
        return (double) timeCount / totalOutcomes; // Conditional probability P(kickoff_time_category | outcome)
    }

    public static void main(String[] args) throws IOException {
        // Load dataset from CSV file
        String trainDataset = "../train_dataset.csv"; // Replace with your actual CSV path
        BufferedReader br = new BufferedReader(new FileReader(trainDataset));
        String line;

        // Skip header line if present
        br.readLine();

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length < 7) continue; // Skip lines with insufficient data

            String homeTeamWin = data[5];  // Assuming home_team_win is at column 6 (index 5)
            String kickoffTime = data[6];  // Assuming kickoff_time is at column 7 (index 6)
            String kickoffTimeCategory = categorizeTime(kickoffTime);

            if (homeTeamWin.equalsIgnoreCase("true")) {
                totalWins++;
                winTimeCounts.put(kickoffTimeCategory, winTimeCounts.getOrDefault(kickoffTimeCategory, 0) + 1);
            } else {
                totalLosses++;
                loseTimeCounts.put(kickoffTimeCategory, loseTimeCounts.getOrDefault(kickoffTimeCategory, 0) + 1);
            }
        }
        br.close();

        // Test the classifier with a new kickoff time
        String testKickoffTime = "20:45:00"; // Example test time
        String testCategory = categorizeTime(testKickoffTime);
        boolean predictedWin = predictHomeTeamWin(testCategory);
        System.out.println("Match KickOffTime : "+testKickoffTime+ " ("+testCategory+")");
        if (predictedWin == true) {
            System.out.println("Prediction : HOME TEAM TO WIN!");
        } else {
            System.out.println("Prediction : HOME TEAM TO NOT WIN!");
        }
    }
}
