package ru.wjs.volodin.practicaltasks5;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BlackListFilterUpgrade implements BlackListFilter {


    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        List<String> filteredComments = new ArrayList<>();
        for (String comment : comments) {
            StringBuilder maskedComment = new StringBuilder(comment);
            for (String word : comment.split("[;,\n  ]+")) {
                for (String banWord : blackList) {
                    if (checkErrorInBadWord(banWord, word.toLowerCase())) {
                        int firstIndex = maskedComment.indexOf(word);
                        int lastIndex = firstIndex + word.length();
                        for (int i = firstIndex; i < lastIndex; i++) {
                            maskedComment.setCharAt(i, '*');
                        }
                    }
                }
            }
            filteredComments.add(String.valueOf(maskedComment));
        }
        comments.clear();
        comments.addAll(filteredComments);
    }

    public static boolean checkErrorInBadWord(String word1, String word2) {
        int countErrors = 0;
        if (word1.length() != word2.length()) {
            return false;
        }
        for (int i = 0; i < word2.length(); i++) {
            if (!(word1.charAt(i) == word2.charAt(i))) {
                countErrors++;
            }
        }
        return countErrors <= 1;
    }

}


