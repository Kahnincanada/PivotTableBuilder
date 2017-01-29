package TuesdayProject.Loaders;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * Created by Tony on 2017-01-29.
 */
public class UserLoader extends Loader {
    HashMap<Integer, HashMap<Integer, Integer>> userRating;
    HashMap<Integer,Integer> movieUserRating;
    public UserLoader(){
        userRating = new HashMap<>();
    }
    protected void LoadField(ArrayList<String> dataFile, int numberOfField){
        LoadUserField(dataFile, numberOfField);
    }
    private void LoadUserField(ArrayList<String> dataFile, int numberOfField){
        String[] currLine = dataFile.get(0).split(",");


    }


}
