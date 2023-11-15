package ru.wjs.volodin.practicaltasks6.task10;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public interface BlackListFilter {
    /**
     * From the given list of comments removes ones
     * that contain words from the black list.
     *
     * @param comments list of comments; every comment
     *                 is a sequence of words, separated
     *                 by spaces, punctuation or line breaks
     */
    default <T> Iterable<T> filterComments(Iterable<T> comments, Predicate<T> filter) {
        List<T> filteredComments = new ArrayList<>();
        for(T comment: comments){
            if(filter.test(comment)){
                filteredComments.add(comment);
            }
        }
        return filteredComments;
    }
}
