package ru.wjs.volodin.practicaltasks6.task10;


import java.util.Set;
import java.util.function.Predicate;


public class CommentFilter implements BlackListFilter {

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

    public static String createMask(String wordForMask) {
        StringBuilder replacement = new StringBuilder();
        for (int i = 0; i < wordForMask.length(); i++) {
            replacement.append("*");
        }
        return replacement.toString();
    }

    public static Predicate<StringBuilder> createBlackListPredicate(Set<String> blackList) {// использую SB, чтоб вернуть этот комментарий из лямбды
        return comment -> {
            String commentStr = comment.toString();
            for (String word : commentStr.split("[;,\n  ]+")) {
                for (String banWord : blackList) {
                    if (checkErrorInBanWord(banWord, word)) {
                        comment.replace(0,comment.length(),commentStr.replaceAll(word, createMask(word)));
                    }
                }
            }
            return true; // то есть мой дефолтный фильтр в интерфейсе будет всегда его фильтровать->добавлять в новые фильтрованные комментарии
        };
    }

    public static Predicate<String> createBlackListPredicateDeleter(Set<String> blackList) {
        return comment -> {
            for (String word : comment.split("[;,\n  ]+")) {
                for (String banWord : blackList) {
                    if (banWord.equalsIgnoreCase(word)) {
                        return false; // то есть, если оно совпадет, то моим дефолтным методом не будет добавлено в отфильтрованные коммент.
                    }
                }
            }
            return true;
        };
    }
}
