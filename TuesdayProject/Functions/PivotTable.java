package TuesdayProject.Functions;

import TuesdayProject.Loaders.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Tony on 2017-01-29.
 */
public class PivotTable {

    private ArrayListMatrix rawData;
    private HashMap<Integer,HashMap<Integer, Double>> userListRatingData;
    private ArrayList<HashMap<Integer,Double>> movieListRatingData;
    private ArrayList<String> tagInfo;
    private ArrayList<String> schemaChoice;
    private String[] fields = new String[] {"actor", "director", "country", "genre", "location", "movietag", "tag", "userrating", "movie"};

    public PivotTable(){
        rawData= new ArrayListMatrix();
        userListRatingData = new HashMap<>();
        tagInfo = new ArrayList<>();
        ChooseSchema();
    }
    public PivotTable(ArrayList<String> fields){
        rawData= new ArrayListMatrix();
        userListRatingData = new HashMap<>();
        tagInfo = new ArrayList<>();
        Load(fields);
    }
    public void ChooseSchema(){
        //This allows not loading all movies all the times
        //need to add fail proof tests






        //
        System.out.println("Available field for pivot table are : "+ Arrays.toString(fields));
        System.out.println("Please enter the field for pivot table schema:");
        schemaChoice = ReadInput();
        System.out.println(schemaChoice.toString());
        Load(schemaChoice);


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
        tagInfo = l.getTagInfo();
    }

    private ArrayList<String> ReadInput(){
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        ArrayList<String> line = new ArrayList<>();
        try {
            for(String item : br.readLine().split(",")) line.add(item);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*try {
            isr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return line;
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

    public ArrayList<String> getTagInfo() {
        return tagInfo;
    }
}
