package TuesdayProject.Loaders;

import java.util.ArrayList;

/**
 * Created by Tony on 2017-01-29.
 */
public class MovieLoader extends Loader {


    public MovieLoader() {

    }
    protected void LoadField(ArrayList<String> dataFile, int numberOfField){
        LoadMovieField(dataFile,numberOfField);
    }
    private void LoadMovieField(ArrayList<String> dataFile, int numberOfField){
        String field;
        ArrayList<String> detail = new ArrayList<>();
        String[] currLine;

        //set line 0 which consists of headers

        currLine = dataFile.get(0).split(",");
        detail.add(0, currLine[numberOfField]);
        field = currLine[numberOfField]; //get the header name
        pivotTable.AddMovie(0,field,detail);
        System.out.println(field + " header line added");
        int correctLineLength= currLine.length;
        detail = new ArrayList<>();

        //following lines

        int prevID=1;//this movie ID for ALM
        int currID;
        for (int i=1; i<dataFile.size();i++) {
            currLine = dataFile.get(i).split(",");
            currID = Integer.parseInt(currLine[0]);

            if(prevID == currID){
                if(currLine.length!=correctLineLength) detail.add("NA");
                else detail.add(currLine[numberOfField]);

                if ( i == (dataFile.size()-1)){
                    //It is the last in the arraylist
                    detail.add(currLine[numberOfField]);
                    maxIndex=currID;
                    pivotTable.AddMovie(prevID,field,detail);
                    pivotTable.trimToSize();
                }
            }
            else{
                pivotTable.AddMovie(prevID,field,detail);

                if( i == dataFile.size()-1) {
                    //It is the last in the arrayList
                    detail = new ArrayList<>();
                    detail.add(currLine[numberOfField]);
                    pivotTable.AddMovie(currID, field, detail);
                    pivotTable.trimToSize();
                }
                else{
                    if(prevID+1!=currID) {
                        //a gap has been encountered
                        while (prevID != currID - 1) {
                            detail = new ArrayList<>();
                            detail.add("NA");
                            pivotTable.AddMovie((prevID+1),field,detail);
                            prevID++;
                        }
                    }
                    prevID++;
                    detail = new ArrayList<>();
                    //System.out.println(prevID);
                    if(currLine.length!=correctLineLength) detail.add("NA");
                    else detail.add(currLine[numberOfField]);
                }
            }
        }
    }
}
