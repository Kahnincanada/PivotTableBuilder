package TuesdayProject;

import TuesdayProject.Functions.PivotTable;
import TuesdayProject.Loaders.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Tony on 2017-01-30.
 */
public class Test {
    public Test(){
        Run();
    }
    public static void Run(){
        ArrayList<String> test = new ArrayList<>();

        test.add("actor");
        test.add("director");
        test.add("country");
        test.add("genre");

        //userLoader movieListWithRating test
        ArrayList<String> userloadertest = new ArrayList<>();
        userloadertest.add("userrating");
        Loader u = new UserLoader();
        u.Load(userloadertest);
        ArrayList<HashMap<Integer,Double>> ALmovieRating = u.getMovieListWithRating();
        System.out.println(ALmovieRating.get(3));

        //userLoader userListWithRating test
        //ArrayList<String> userloadertest = new ArrayList<>();
        //userloadertest.add("userrating");
        Loader um = new UserLoader();
        um.Load(userloadertest);
        HashMap<Integer,HashMap<Integer,Double>> ALuserRating = um.getUserListWithRating();
        System.out.println(ALuserRating.get(75));

        test.add("movietag"); // need to link tag to it
        test.add("movie");

        Loader l = new MovieLoader();
        l.Load(test);

        //tag loader test
        ArrayList<String> tagTest = new ArrayList<>();
        tagTest.add("tag");
        Loader t = new TagLoader();
        t.Load(tagTest);
        System.out.println(t.getTagInfo());

        PivotTable pt = new PivotTable();
        pt.Load(test);

        ArrayListMatrix alm = pt.getRawData();

        System.out.println(alm.get(1).get("directorName")+" "+ alm.get(1).get("country")+" "+alm.get(1).get("genre"));
        System.out.println(alm.getField());
        System.out.println(alm.get(1).get("actorName"));


    }
}
