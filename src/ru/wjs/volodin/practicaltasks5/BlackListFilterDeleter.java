package ru.wjs.volodin.practicaltasks5;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BlackListFilterDeleter implements BlackListFilter {

    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        List<String> filteredComments=new ArrayList<>();
        for(String comment: comments){
            boolean isBadComment = false;
            for(String word: comment.split("[;,\n  ]+")){
                if(blackList.contains(word.toLowerCase())){
                    isBadComment=true;
                    break;
                }
            }
            if(!isBadComment){
                filteredComments.add(comment);
            }
        }
        comments.clear();
        comments.addAll(filteredComments);
    }
}
