package smartio.api.crud.logic;

import smartio.api.crud.models.ScoreModel;
import smartio.api.crud.models.UserModel;
import smartio.api.crud.models.UserScoreProjection;
import smartio.api.crud.services.UserService;

import java.util.*;

public class Matches {

    public Matches() {
    }


    public List<String> getUserMatches(List<ScoreModel> scores, UserService userService, long userId) {

        Map<Integer, Float> incomingScores = new HashMap<>();
        for (ScoreModel score : scores) {
            incomingScores.put(score.getIntelligence_code(), score.getScore());
        }

        List<UserScoreProjection> us = userService.getUserScoresById();

        //Map<UserId, Map<IntelligenceCode, Score>> map
        Map<Long, Map<Integer, Float>> map = new HashMap<>();
        List<Double> distances = new ArrayList<>();
        Map<Long, Double> distanceMap = new HashMap<>();

        for (UserScoreProjection userScore : us) {
            long uId = userScore.getUserId();

            // Verificar si ya existe una entrada para el userId en el mapa
            Map<Integer, Float> userScoreMap = map.get(uId);
            if (userScoreMap == null) {
                userScoreMap = new HashMap<>();
                map.put(uId, userScoreMap);
            }

            // Agregar la puntuación al mapa
            userScoreMap.put(userScore.getIntelligence(), userScore.getScores());
        }

        for (Map.Entry<Long, Map<Integer, Float>> entry : map.entrySet()) {
            long uId = entry.getKey();
            Map<Integer, Float> userScoreMap = entry.getValue();

            double distance = calculateEuclideanDistance(incomingScores, userScoreMap);
            distances.add(distance);

            // Agregar la distancia al mapa distanceMap
            distanceMap.put(uId, distance);
        }

        Map<Long, Double> sortedDistanceMap = sortMap(distanceMap);

        List<String> names = getUserNamesFromSortedMap(sortedDistanceMap, userService, userId);

        return names;
    }

    public Map<Long, Double> sortMap(Map<Long, Double> distanceMap){

        List<Map.Entry<Long, Double>> sortedEntries = new ArrayList<>(distanceMap.entrySet());

        sortedEntries.sort(Map.Entry.comparingByValue());

        Map<Long, Double> sortedDistanceMap = new LinkedHashMap<>();
        for (Map.Entry<Long, Double> entry : sortedEntries) {
            sortedDistanceMap.put(entry.getKey(), entry.getValue());
        }
        return sortedDistanceMap;
    }

    public double calculateEuclideanDistance(Map<Integer, Float> map1, Map<Integer, Float> map2) {
        double sum = 0.0;

        for (int key : map1.keySet()) {
            if (map2.containsKey(key)) {
                float score1 = map1.get(key);
                float score2 = map2.get(key);
                double diff = score1 - score2;
                sum += diff * diff;
            }
        }

        return Math.sqrt(sum);
    }

    public List<String> getUserNamesFromSortedMap(Map<Long, Double> sortedDistanceMap, UserService userService, long userId) {
        List<String> userNames = new ArrayList<>();

        int count = 0;
        for (long uId : sortedDistanceMap.keySet()) {
            if (count >= 3) {
                break; // Hemos obtenido los 3 primeros nombres, salimos del bucle
            }

            if (uId == userId) {
                continue; // Ignoramos este usuario y pasamos al siguiente
            }

            Optional<UserModel> userOptional = userService.getUserById(uId);
            if (userOptional.isPresent()) {
                UserModel user = userOptional.get();
                String userName = user.getName();
                userNames.add(userName);
                count++;
            }
        }
        return userNames;
    }

}
