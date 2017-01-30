package TuesdayProject.Functions;

import TuesdayProject.Loaders.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Tony on 2017-01-29.
 */
public class PivotTable {


    private ArrayListMatrix rawData;
    //private HashMap<Integer,HashMap<Integer, Integer>> userRatingData;
    //private ArrayList<String> tagInfo;

    public PivotTable(){

    }



    public void Load(ArrayList<String> fields){
        if(fields.contains("tag")) {
            Loader t = new TagLoader();
            fields.remove("tag");
        }
        if(fields.contains("userrating")){
            Loader u = new UserLoader();
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
}
