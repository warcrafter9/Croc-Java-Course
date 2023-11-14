package ru.wjs.volodin.practicaltasks5;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BlackListFilterMasker implements BlackListFilter {

    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        List<String> filteredComments = new ArrayList<>();
        for (String comment : comments) {
            for (String word : comment.split("[;,\n  ]+")) {
                for (String banWord : blackList) {
                    if (banWord.equalsIgnoreCase(word)) {
                        comment = comment.replaceAll(word, createMask(word));
                    }
                }
            }
            filteredComments.add(comment);
        }
        comments.clear();
        comments.addAll(filteredComments);
    }

    public static String createMask(String wordForMask) {
        StringBuilder replacement = new StringBuilder();
        for (int i = 0; i < wordForMask.length(); i++) {
            replacement.append("*");
        }
        return replacement.toString();
    }
}

