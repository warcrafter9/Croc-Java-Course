package ru.wjs.volodin.practicaltask4.task7;

import ru.wjs.volodin.practicaltasks5.BlackListFilterMasker;
import ru.wjs.volodin.practicaltasks5.BlackListFilterUpgrade;
import ru.wjs.volodin.practicaltasks5.BlackListFilterDeleter;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        BlackListFilterDeleter blackListFilterDeleter = new BlackListFilterDeleter();
        BlackListFilterMasker blackListFilterMasker=new BlackListFilterMasker();
        BlackListFilterUpgrade blackListFilterUpgrade = new BlackListFilterUpgrade();
        List<String> commentsToDelete = new ArrayList<>();
        List<String> commentsToMask = new ArrayList<>();
        List<String> commentsToMaskUpgrade = new ArrayList<>();
        commentsToDelete.add("Это фигня");
        commentsToDelete.add("А это нет");
        commentsToMask.add("Плохое, слово");
        commentsToMask.add("Хорошее слово");
        commentsToMaskUpgrade.add("Розетка");
        commentsToMaskUpgrade.add("РастенЬе; высокое");

        Set<String> blackListToDelete = new TreeSet<>();
        Set<String> blackListToMask = new TreeSet<>();
        Set<String> blackListToMaskUpgrade = new TreeSet<>();
        blackListToDelete.add("фигня");
        blackListToMask.add("плохое");
        blackListToMaskUpgrade.add("растение");

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
