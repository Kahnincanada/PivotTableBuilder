package TuesdayProject;

import TuesdayProject.Loaders.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        Loader m = new MovieLoader();

        ArrayList<String> test = new ArrayList<>();

        test.add("actor");
        test.add("director");
        test.add("country");
        test.add("genre");
        //test.add("movietag"); // need to link tag to it
        //test.add("movie");
        m.Load(test);
        ArrayListMatrix alm = m.getPivotTable();
        int result = alm.Count("country","cHin");
        System.out.println(result);

        System.out.println(alm.get(1).get("directorName")+" "+ alm.get(1).get("country")+" "+alm.get(1).get("genre"));
        //System.out.println(alm.get(1).get("tagID"));
        System.out.println(alm.get(1).get("actorName"));

        //System.out.println(alm.get(3));
        /*Loader u = new Loader();
        test.add("userrating");
        u.Load(test);
        ArrayListMatrix alm2 = u.getPivotTable();
        System.out.println(alm2.get(75));
        */





    }
}