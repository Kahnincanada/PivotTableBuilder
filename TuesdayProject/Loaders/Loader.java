package TuesdayProject.Loaders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Tony on 2017-01-28.
 */
public class Loader {
    protected ArrayListMatrix importedRawData;  //movie list
    protected ArrayList<String> tagInfo;        //info of all tags
    protected HashMap<Integer, HashMap<Integer, Double>> userListWithRating;   //user rating
    protected ArrayList<HashMap<Integer,Double>> movieListWithRating;           //Movie list with rating

    protected HashMap<String, String> filePath;
    protected String[] fields;
    protected String[] absPaths;
    protected int maxIndex;

    public Loader(){
        absPaths = new String[]{
                //Temporarily using absolute path. Will be linked to a SQL db
                "/Users/Tony/IdeaProjects/PivotBuilder/src/hetrec2011-movielens-2k-v2/movie_actors.csv",    //pathActor
                "/Users/Tony/IdeaProjects/PivotBuilder/src/hetrec2011-movielens-2k-v2/movie_directors.csv", //pathDirector
                "/Users/Tony/IdeaProjects/PivotBuilder/src/hetrec2011-movielens-2k-v2/movie_countries.csv", //pathCountry
                "/Users/Tony/IdeaProjects/PivotBuilder/src/hetrec2011-movielens-2k-v2/movie_genres.csv",    //pathGenre
                "/Users/Tony/IdeaProjects/PivotBuilder/src/hetrec2011-movielens-2k-v2/movie_locations.csv", //pathLocation
                "/Users/Tony/IdeaProjects/PivotBuilder/src/hetrec2011-movielens-2k-v2/movie_tags.csv",      //pathMovieTag
                "/Users/Tony/IdeaProjects/PivotBuilder/src/hetrec2011-movielens-2k-v2/tags.csv",            //pathTags
                "/Users/Tony/IdeaProjects/PivotBuilder/src/hetrec2011-movielens-2k-v2/user_ratedmovies.csv",//pathUserRating
                "/Users/Tony/IdeaProjects/PivotBuilder/src/hetrec2011-movielens-2k-v2/movies.csv"};         //pathMovie
        fields = new String[] {"actor", "director", "country", "genre", "location", "movietag", "tag", "userrating", "movie"};
        filePath = new HashMap<>();
        importedRawData = new ArrayListMatrix();
        for (int i = 0; i < fields.length; i++) filePath.put(fields[i], absPaths[i]);
    }
    public void Load(ArrayList<String> targets) {
        if (!checkAllValid(targets)) System.out.println("Not all field are valid (Load)");
        else {
            for (String tar : targets) {
                try {
                    loadTerm(tar); //System.out.println(tar + " is added to raw data file. (Loader Load)"); //debug
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //need change to DB path somehow later
    }
    protected void loadTerm(String target) throws IOException{
        ArrayList<String> dataFile = new ArrayList<>();
        try {
            ReadFile rf = new ReadFile(FindPath(target.toLowerCase()));
            dataFile = rf.OpenFile();
            //System.out.println("Loading "+ target); //debug
            //System.out.println(dataFile.get(2)); //debug
        }catch (Exception e){
            System.out.println("LoadTerm error" + e.getMessage());
        }
        String[] titleBar = dataFile.get(0).split(",");
        for(int i=1; i<titleBar.length; i++) LoadField(dataFile, i);
    }
    protected String FindPath(String target) {
        if (filePath.containsKey(target.toLowerCase())) return filePath.get(target.toLowerCase());
        System.out.println("This key is invalid!(FindPath)");
        return null;
    }
    protected void LoadField(ArrayList<String> dataFile, int numberOfField){}

    protected boolean checkAllValid(ArrayList<String> targets) {
        int current = 0;
        while (current<targets.size() && checkValid(targets.get(current).toLowerCase())) current++;
        if (current == targets.size()) return true;
        System.out.println("Not all fields are valid (checkAllValid)");
        return false;
    }
    protected boolean checkValid(String target) {return filePath.containsKey(target.toLowerCase());}

    //Getters
    public ArrayListMatrix getImportedRawData(){return importedRawData;}
    public HashMap<String,String> getAbsFilePaths() {return filePath;}
    public int getMaxIndex() {return maxIndex;}
    public ArrayList<String> getTagInfo() {
        return tagInfo;
    }
    public ArrayList<HashMap<Integer, Double>> getMovieListWithRating() {
        return movieListWithRating;
    }
    public HashMap<Integer, HashMap<Integer, Double>> getUserListWithRating() {return userListWithRating;}
}