package TuesdayProject.Functions;

import TuesdayProject.Loaders.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Tony on 2017-01-29.
 */
public class PivotTable {

    private ArrayListMatrix rawData;
    private HashMap<Integer,HashMap<Integer, Double>> userListRatingData;
    private ArrayList<HashMap<Integer,Double>> movieListRatingData;
    private ArrayList<String> tagInfo;

    public PivotTable(){
        rawData= new ArrayListMatrix();
        userListRatingData = new HashMap<>();
        tagInfo = new ArrayList<>();
    }
    public PivotTable(ArrayList<String> fields){
        rawData= new ArrayListMatrix();
        userListRatingData = new HashMap<>();
        tagInfo = new ArrayList<>();
        Load(fields);
    }
    public void Load(ArrayList<String> fields){
        if(fields.contains("tag")) {
            Loader t = new TagLoader();
            t.Load("tag");
            tagInfo = t.getTagInfo();
            fields.remove("tag");
        }
        if(fields.contains("userrating")){
            Loader u = new UserLoader();
            u.Load("userrating");
            userListRatingData = u.getUserListWithRating();
            movieListRatingData = u.getMovieListWithRating();
            fields.remove("userrating");
        }
        Loader l = new MovieLoader();
        l.Load(fields);
        rawData = l.getImportedRawData();
    }





    public static void Filter(){

    }
    public static void Mean(){

    }
    public ArrayListMatrix getRawData() {
        return rawData;
    }

    public HashMap<Integer, HashMap<Integer, Double>> getUserListRatingData() {return userListRatingData;}

    public ArrayList<HashMap<Integer, Double>> getMovieListRatingData() {return movieListRatingData;}

    public ArrayList<String> getTagInfo() {return tagInfo;}
}
