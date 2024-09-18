import classifiers.NaiveBayesClassifier;

public class Main {
    public static void main(String[] args) {
        NaiveBayesClassifier classifier = new NaiveBayesClassifier();

        // Training data - Adding various kickoff times and weather descriptions
        classifier.train(new String[]{"12:00:00", "sunny"}, "home_win");
        classifier.train(new String[]{"13:30:00", "rainy"}, "away_win");
        classifier.train(new String[]{"15:00:00", "cloudy"}, "home_win");
        classifier.train(new String[]{"16:45:00", "foggy"}, "home_win");
        classifier.train(new String[]{"18:00:00", "thunderstorm"}, "away_win");
        classifier.train(new String[]{"19:30:00", "sunny"}, "home_win");
        classifier.train(new String[]{"20:00:00", "drizzle"}, "away_win");
        classifier.train(new String[]{"20:45:00", "hailstorm"}, "home_win");

        // Adding more variations for training
        classifier.train(new String[]{"12:00:00", "cloudy"}, "away_win");
        classifier.train(new String[]{"14:15:00", "sunny"}, "home_win");
        classifier.train(new String[]{"15:30:00", "rainy"}, "away_win");
        classifier.train(new String[]{"17:00:00", "foggy"}, "home_win");
        classifier.train(new String[]{"18:30:00", "sunny"}, "away_win");
        classifier.train(new String[]{"19:00:00", "thunderstorm"}, "home_win");
        classifier.train(new String[]{"19:45:00", "drizzle"}, "away_win");
        classifier.train(new String[]{"20:30:00", "hailstorm"}, "home_win");

        // More diverse data to cover various scenarios
        classifier.train(new String[]{"12:30:00", "rainy"}, "away_win");
        classifier.train(new String[]{"13:45:00", "cloudy"}, "home_win");
        classifier.train(new String[]{"15:15:00", "foggy"}, "home_win");
        classifier.train(new String[]{"16:30:00", "sunny"}, "away_win");
        classifier.train(new String[]{"17:45:00", "thunderstorm"}, "home_win");
        classifier.train(new String[]{"18:15:00", "drizzle"}, "away_win");
        classifier.train(new String[]{"19:30:00", "hailstorm"}, "home_win");
        classifier.train(new String[]{"20:00:00", "sunny"}, "away_win");

        // Test data
        String[] testFeatures = {"16:00:00", "sunny"};
        String prediction = classifier.predict(testFeatures);

        System.out.println("Predicted class: " + prediction);
    }
}
