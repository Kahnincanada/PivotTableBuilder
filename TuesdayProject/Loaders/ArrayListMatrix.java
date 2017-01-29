package TuesdayProject.Loaders;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Tony on 2017-01-28.
 */
public class ArrayListMatrix extends ArrayList{
    //private ArrayList<String> zAxis;                                  //The detail level
    private HashMap<String, ArrayList<String>> xAxis;                   //The title bar level
    private ArrayList<HashMap<String, ArrayList<String>>> movieList;    //The movie ID level
    private int numberOfMovies;

    public ArrayListMatrix(){
        movieList = new ArrayList<>();
    }

    public void AddMovie(int id, String field, ArrayList<String> detail){
        //Need to learn how to check the hashcode part.
        if(CheckNull(id)){
            xAxis = new HashMap<>();
            xAxis.put(field, detail);
            movieList.add(id, xAxis);
        }
        movieList.get(id).put(field, detail);
    }
    public boolean CheckNull(int id) {
        return id >= movieList.size() || movieList.get(id) == null;
    }
    boolean CheckFieldNull(int id, String field){
        if(CheckNull(id)) return true;
        return movieList.get(id).get(field) == null;
    }

    public int Count(String field, String target){
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

    /*public boolean equals (Object object){
        if (object == null || object.getClass() != getClass()) return false;
        else if (this.toString().toLowerCase().equals(object.toString().toLowerCase())) return true;
        return false;
    }
    */
    public boolean containsItem(int id, String field, String item){
        if(CheckFieldNull(id,field)) return false;
        else{
            for(String s : movieList.get(id).get(field)) {
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
            movieList.get(movieID).get(field.toLowerCase()).indexOf(data)
        }
    }
    public Boolean CheckDataPresent(int movieID, String field, String data){
        return movieList.get(movieID).get(field.toLowerCase()).contains(data.toLowerCase());
    }
    */



    public ArrayList<String> getFieldDetails(int movieID, String field){
        //This contains the specific field of a movie, e.g. the actors, the director, etc
        return movieList.get(movieID).get(field);
    }

    public HashMap<String, ArrayList<String>> get(int movieID){
        //This contains all information of a movie
        return movieList.get(movieID);
    }

    public ArrayList<HashMap<String, ArrayList<String>>> getAllMoviesInfo(){
        return movieList;
    }




}
