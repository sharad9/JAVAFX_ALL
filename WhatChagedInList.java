import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class WhatChagedInList{
        public static void main (String args []){
            List <String> list = new ArrayList<String>();
            ObservableList <String> observableList = FXCollections.observableList(list);
            observableList.addListener(new ListChangeListener(){
                @Override
                public void onChanged(ListChangeListener.Change change){
                    System.out.println("Detected a change !");
                    
                    while(change.next()){
                     System.out.println("was added? "+change.wasAdded());
                     System.out.println("was removed? "+change.wasRemoved());
                     System.out.println("was replaced" +change.wasReplaced());
                     System.out.println("was permutated?"+change.wasPermutated());
                    }
                }
                
        });
        observableList.add("item two");
        list.add("item two");
        System.out.println("Size :"+observableList.size());
        
    }
}