package ru.wjs.volodin.practicaltasks5;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BlackListFilterMasker implements BlackListFilter {

    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        List<String> filteredComments = new ArrayList<>();
        for(String comment: comments){
            StringBuilder maskedComment=new StringBuilder(comment);
            for(String word: comment.split("[;,\n  ]+")){
                if(blackList.contains(word.toLowerCase())){
                    int firstIndex = maskedComment.indexOf(word);
                    int lastIndex = firstIndex+word.length();
                    for(int i=firstIndex;i<lastIndex;i++){
                        maskedComment.setCharAt(i,'*');
                    }
                }
            }
                filteredComments.add(String.valueOf(maskedComment));
        }
        comments.clear();
        comments.addAll(filteredComments);
    }
}

