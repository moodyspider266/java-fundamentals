import classifiers.NaiveBayesClassifier;

public class Main {
    public static void main(String[] args) {
        NaiveBayesClassifier classifier = new NaiveBayesClassifier();

        // Training data from SQL results
        // Assuming features are in format: [kickoff_time, weather_desc, ...]
        classifier.train(new String[]{"15:00:00", "sunny", "high"}, "home_win");
        classifier.train(new String[]{"17:00:00", "rainy", "normal"}, "away_win");
        classifier.train(new String[]{"19:00:00", "cloudy", "high"}, "home_win");
        // Add more training data...

        // Test data
        String[] testFeatures = {"19:00:00", "sunny", "high"};
        String prediction = classifier.predict(testFeatures);

        System.out.println("Predicted class: " + prediction);
    }
}
