package TuesdayProject;

import TuesdayProject.UnitTests.*;
import TuesdayProject.Functions.*;
import TuesdayProject.Loaders.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        LoaderTests lt = new LoaderTests();
        ArrayListMatrix mat = new ArrayListMatrix();
        mat = lt.getAlm();
        int i = mat.Count("actorName","berg");
        System.out.println(mat.get(1).get("actorName"));
        //System.out.println(mat.getField());
        System.out.println(i);
    }
}