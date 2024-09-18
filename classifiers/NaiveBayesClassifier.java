package classifiers;

import java.util.HashMap;
import java.util.Map;

public class NaiveBayesClassifier {

    private Map<String, Integer> classCounts = new HashMap<>();
    private Map<String, Map<String, Integer>> featureCounts = new HashMap<>();
    private Map<String, Integer> totalFeatureCounts = new HashMap<>();
    private int totalDocuments = 0;

    public void train(String[] features, String className) {
        totalDocuments++;
        
        classCounts.put(className, classCounts.getOrDefault(className, 0) + 1);
        
        for (String feature : features) {
            featureCounts
                .computeIfAbsent(className, k -> new HashMap<>())
                .put(feature, featureCounts.get(className).getOrDefault(feature, 0) + 1);
            
            totalFeatureCounts.put(feature, totalFeatureCounts.getOrDefault(feature, 0) + 1);
        }
    }

    public String predict(String[] features) {
        double bestScore = Double.NEGATIVE_INFINITY;
        String bestClass = null;

        for (String className : classCounts.keySet()) {
            double logProbability = Math.log((double) classCounts.get(className) / totalDocuments);

            for (String feature : features) {
                int featureCount = featureCounts.getOrDefault(className, new HashMap<>()).getOrDefault(feature, 0);
                int totalFeatureCount = totalFeatureCounts.getOrDefault(feature, 0);
                double probability = (featureCount + 1.0) / (totalFeatureCount + 2.0); // Laplace smoothing
                logProbability += Math.log(probability);
            }

            if (logProbability > bestScore) {
                bestScore = logProbability;
                bestClass = className;
            }
        }

        return bestClass;
    }
}
