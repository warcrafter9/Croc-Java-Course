package ru.wjs.volodin.practicaltasks5;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static ru.wjs.volodin.practicaltasks5.BlackListFilterMasker.createMask;

public class BlackListFilterUpgrade implements BlackListFilter {


    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        List<String> filteredComments = new ArrayList<>();
        for (String comment : comments) {
            for (String word : comment.split("[;,\n  ]+")) {
                for (String banWord : blackList) {
                    if (checkErrorInBanWord(banWord, word)) {
                        comment = comment.replaceAll(word, createMask(word));
                    }
                }
            }
            filteredComments.add(comment);
        }
        comments.clear();
        comments.addAll(filteredComments);
    }

    public static boolean checkErrorInBanWord(String banWord, String word) {
        int countErrors = 0;
        if (banWord.length() != word.length()) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            if (!((banWord.charAt(i) == word.charAt(i) || banWord.charAt(i) == word.charAt(i) + 32) || banWord.charAt(i) == word.charAt(i) - 32)) {
                countErrors++; // тут сравнивается символ с верхним и нижним регистром
            }
        }
        return countErrors <= 1;
    }


}


