package TuesdayProject.Loaders;

import java.util.Currency;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Created by Tony on 2017-01-29.
 */
public class UserLoader extends Loader {
    HashMap<Integer,Double> subMovieList;
    HashMap<Integer,Double> subUserList;
    int movieListMaxIndex; // size-1

    public UserLoader(){
        userListWithRating= new HashMap<>();
        movieListWithRating = new ArrayList<>();
        movieListMaxIndex=0;
    }
    protected void LoadField(ArrayList<String> dataFile, int numberOfField){
        //System.out.println("userLoad loadField initialized"); // debug
        LoadUserField(dataFile);
    }
    private void LoadUserField(ArrayList<String> dataFile) {
        String[] currLine;
        for (String s : dataFile.subList(1, dataFile.size())) {
            currLine = s.split(",");
            int userID = Integer.parseInt(currLine[0]);
            int movieID = Integer.parseInt(currLine[1]);
            double score = Double.parseDouble(currLine[2]);
            while (movieListMaxIndex < movieID) {
                //System.out.println("empty line has been added"); //debug
                subMovieList = new HashMap<>();
                subMovieList.put(-1, -1.0);// -1,-1 for no score entry
                movieListWithRating.add(movieListMaxIndex, subMovieList);
                movieListMaxIndex++;// movieListMaxIndex == movieID at exit of while loop
                //movieListWithRating.get(movieListMaxIndex) != null;
                //movieListWithRating.get(movieID) ==null
            }
            if (movieID == movieListMaxIndex) {
                //add to new index
                subMovieList.put(userID, score);
                movieListWithRating.add(movieID, subMovieList);
                movieListMaxIndex++;
            } else {
                movieListWithRating.get(movieID).put(userID, score);
                if (movieListWithRating.get(movieID).containsKey(-1)) movieListWithRating.get(movieID).remove(-1);
                //remove the default -1,-1
            }
            if(!userListWithRating.containsKey(userID)){
                subUserList = new HashMap<>();
                subUserList.put(movieID,score);
                userListWithRating.put(userID,subUserList);
            }
            else {userListWithRating.get(userID).put(movieID, score);}
        }
    }
}