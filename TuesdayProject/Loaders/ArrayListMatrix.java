package TuesdayProject.Loaders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Tony on 2017-01-28.
 */
public class ArrayListMatrix extends ArrayList{
    //private ArrayList<String> zAxis;                                  //The detail level
    private HashMap<String, ArrayList<String>> xAxis;                   //The title bar level
    private ArrayList<HashMap<String, ArrayList<String>>> movieList;    //The movie ID level
    private int numberOfMovies;
    private ArrayList<UserRatingPair<Integer,Integer>> xAxisUserRating;

    public ArrayListMatrix(){
        numberOfMovies=0;
        movieList = new ArrayList<>();
    }

    public void add(int id, String field, ArrayList<String> detail){
        //Need to learn how to check the hashcode part.
        if(CheckNull(id)){
            xAxis = new HashMap<>();
            xAxis.put(field, detail);
            movieList.add(id, xAxis);
        }
        movieList.get(id).put(field, detail);
    }


    //Private functions
    private boolean CheckNull(int id) {
        return id >= movieList.size() || movieList.get(id) == null;
    }
    private boolean CheckFieldNull(int id, String field){
        if(CheckNull(id)) return true;
        return movieList.get(id).get(field) == null;
    }

    private int Count(String field, String target){
        int counter = 0;
        for(HashMap<String, ArrayList<String>> movie : movieList){
            if(movie.get(field)!=null) {
                if (containsItem(movieList.indexOf(movie), field, target)) counter++;
            }
            else{
                System.out.println("This field is invalid ! (Count)");
                return 0;
                }
            }
        return counter;
    }

    private boolean containsItem(int id, String field, String item){
        if(CheckFieldNull(id,field)) return false;
        //This assumes that there is no duplication within each field of a movie.
        else{
            ArrayList<String> get = movieList.get(id).get(field);
            for (int i = 0, getSize = get.size(); i < getSize; i++) {
                String s = get.get(i);
                return s.toLowerCase().contains(item.toLowerCase());
            }
        }
        return false;
    }


    /*
    Needs to figure out how to override equal and hashcode properly first
    public void ModifyDetailData(int movieID, String field, String data){
        if(!CheckDataPresent(movieID,field.toLowerCase(),data.toLowerCase())) System.out.println("This data cannot be found");
        else{
            subMovieList.get(movieID).get(field.toLowerCase()).indexOf(data)
        }
    }
    public Boolean CheckDataPresent(int movieID, String field, String data){
        return subMovieList.get(movieID).get(field.toLowerCase()).contains(data.toLowerCase());
    }
    */





    //Getters
    public ArrayList<String> getFieldDetails(int movieID, String field){
        //This contains the specific field of a movie, e.g. the actors, the director, etc
        return movieList.get(movieID).get(field);
    }

    public HashMap<String, ArrayList<String>> get(int movieID){
        //This contains all information of a movie
        if(!CheckNull(movieID)) return movieList.get(movieID);
        else{
            System.out.println("This movie does not exist! ALD.get()");
            return null;
        }
    }

    public ArrayList<HashMap<String, ArrayList<String>>> getAllMoviesInfo(){
        return movieList;
    }
    public int getNumberOfMovies(){
        numberOfMovies = movieList.size();
        return numberOfMovies;
    }
    public List<String> getField(){
        //Display available fields in the current movie list
        if(!CheckNull(1)){
            List<String> fieldList;
            fieldList = new ArrayList<>(movieList.get(0).keySet());
            return fieldList;
        }
        else{
            System.out.println("This list is empty (getField) ");
            return null;
        }
    }





}
