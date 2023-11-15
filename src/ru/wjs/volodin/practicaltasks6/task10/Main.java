package ru.wjs.volodin.practicaltasks6.task10;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static ru.wjs.volodin.practicaltasks6.task10.CommentFilter.createBlackListPredicate;
import static ru.wjs.volodin.practicaltasks6.task10.CommentFilter.createBlackListPredicateDeleter;

public class Main {
    public static void main(String[] args) {
        CommentFilter commentFilter =new CommentFilter();
        List<StringBuilder> commentsToMask = new ArrayList<>();
        Set<String> blackListToMask = new TreeSet<>();

        commentsToMask.add(new StringBuilder("плохEе слово")); // "плохое" будет замаскировано (тут фильтр с опечаткой)
        commentsToMask.add(new StringBuilder("Хорошее слово"));
        blackListToMask.add("ПлоХое"); // Слово для маскировки с опечаткой

        List<String> commentsToDelete = new ArrayList<>();
        Set<String> blackListToDelete = new TreeSet<>();
        commentsToDelete.add("Это фигня и она удалится");
        commentsToDelete.add("А это уже нет");
        blackListToDelete.add("Фигня");

        System.out.println("Для маскировки звездочками: "+ commentsToMask);
        System.out.println("Для удаления: "+ commentsToDelete);
        commentFilter.filterComments(commentsToMask,createBlackListPredicate(blackListToMask));
        System.out.println();
        System.out.println("Для маскировки звездочками: "+ commentsToMask);
        System.out.println("Для удаления: "+ commentFilter.filterComments(commentsToDelete,createBlackListPredicateDeleter(blackListToDelete)));

    }
}
