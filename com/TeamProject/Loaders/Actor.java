package com.TeamProject.Loaders;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.*;

/**
 * Created by Tony on 2017-01-27.
 */
public class Actor{
    HashMap<Integer, ArrayList<String>> actorList= new HashMap<>();
    ArrayList<String> fileData = new ArrayList<>();
    String filePath = "/Users/Tony/IdeaProjects/PivotBuilder/src/hetrec2011-movielens-2k-v2/movie_actors.csv";
    //this will change to SQL address
    public Actor(){
        System.out.println("new Actor list will be created");
        try{
            LoadActors();
        }catch(Exception e){
            System.out.println("actor constructor error" + e.getMessage());
        }
    }
    public void LoadActors() throws Exception {
        try {
            ReadFile newFile = new ReadFile(filePath);
            fileData = newFile.OpenFile();
        } catch (IOException e) {
            System.out.println("loadActor error" + e.getMessage());
        }
        ArrayList<String> casts = new ArrayList<>();
        int currentID = 1;
        int nextID;

        for (int i = 1; i < fileData.size(); i++) {
            String[] currentLine = fileData.get(i).split(",");
            nextID = Integer.parseInt(currentLine[0]);
            if(currentID == nextID){
                casts.add(currentLine[1]);
                if(i==fileData.size()-1){
                    casts.add(currentLine[1]);
                    actorList.put(currentID, casts);
                }
            }
            else{
                actorList.put(currentID, casts);
                currentID++;
                casts.clear();
                casts.add(currentLine[1]);
                if (i == fileData.size() - 1) {
                    actorList.put(currentID, casts);
                }
            }
        }
    }
    public int size(){
        return actorList.size();
    }
    public void Print(){
        for(int i =1; i<actorList.size(); i++) {
            int sizeI = actorList.get(i).size();
            for (int j = 0; j < sizeI; j++) {
                System.out.println("movie ID: " + i + " Actors are " + actorList.get(i).get(j));
            }
        }
    }



}
