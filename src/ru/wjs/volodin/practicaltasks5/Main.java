package ru.wjs.volodin.practicaltasks5;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        BlackListFilterDeleter blackListFilterDeleter = new BlackListFilterDeleter();
        BlackListFilterMasker blackListFilterMasker=new BlackListFilterMasker();
        BlackListFilterUpgrade blackListFilterUpgrade = new BlackListFilterUpgrade();
        List<String> commentsToDelete = new ArrayList<>();
        List<String> commentsToMask = new ArrayList<>();
        List<String> commentsToMaskUpgrade = new ArrayList<>();
        commentsToDelete.add("Это фигня"); // комментарий, удаляющийся из-за слова фигня
        commentsToDelete.add("А это нет");
        commentsToMask.add("плохое, слово"); // "плохое" будет удалено (тут фильтр без опечатки)
        commentsToMask.add("Хорошее слово");
        commentsToMaskUpgrade.add("Розетка");
        commentsToMaskUpgrade.add("РаСтенЬе; зеленое");  // комментарий с опечаткой в слове из БЛ - РаСтенЬе -> ********

        Set<String> blackListToDelete = new TreeSet<>();
        Set<String> blackListToMask = new TreeSet<>();
        Set<String> blackListToMaskUpgrade = new TreeSet<>();
        blackListToDelete.add("Фигня"); // Слово для удаления
        blackListToMask.add("ПлоХое"); // Слово для маскировки без опечатки
        blackListToMaskUpgrade.add("Растение"); // Слово для маскировки с одной опечаткой (всё в независимости от регистра)


        System.out.println("Для удаление: "+ commentsToDelete);
        System.out.println("Для маскировки звездочками: "+ commentsToMask);
        System.out.println("Для маскировки звездочками с 1 опечаткой: "+ commentsToMaskUpgrade);
        blackListFilterDeleter.filterComments(commentsToDelete,blackListToDelete);
        blackListFilterMasker.filterComments(commentsToMask,blackListToMask);
        blackListFilterUpgrade.filterComments(commentsToMaskUpgrade,blackListToMaskUpgrade);
        System.out.println();
        System.out.println("Для удаление: "+ commentsToDelete);
        System.out.println("Для маскировки звездочками: "+ commentsToMask);
        System.out.println("Для маскировки звездочками с 1 опечаткой: "+ commentsToMaskUpgrade);


    }
}
