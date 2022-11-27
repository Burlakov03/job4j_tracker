package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sum = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
                count++;
            }
        }
        return sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            result.add(new Label(pupil.name(), sum / pupil.subjects().size()));
        }
        return result;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> score = new HashMap<>();
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score.put(subject.name(), score.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (String key : score.keySet()) {
            result.add(new Label(key, (double) score.get(key) / pupils.size()));
        }
        return result;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> result  = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            result.add(new Label(pupil.name(), sum));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> score = new HashMap<>();
        List<Label> result  = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score.put(subject.name(), score.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (String key : score.keySet()) {
            result.add(new Label(key, score.get(key)));
        }
        result.sort(Comparator.naturalOrder());
        return result.get(result.size() - 1);
    }
}
