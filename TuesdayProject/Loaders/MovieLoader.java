package TuesdayProject.Loaders;

import java.util.ArrayList;

/**
 * Created by Tony on 2017-01-29.
 */
public class MovieLoader extends Loader {
    private ArrayList<String> detail;
    private String field;
    private String[] currLine;
    public MovieLoader() {
        detail = new ArrayList<>();
    }
    protected void LoadField(ArrayList<String> dataFile, int numberOfField){
        LoadMovieField(dataFile,numberOfField);
    }
    protected void LoadMovieField(ArrayList<String> dataFile, int numberOfField){
        //set line 0 which consists of headers
        currLine = dataFile.get(0).split(",");
        detail.add(0, currLine[numberOfField]);
        field = currLine[numberOfField]; //get the header name
        importedRawData.add(0,field,detail);

        //System.out.println(field + " header line added"); //debug
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

                if( i == (dataFile.size()-1)){
                    //It is the last in the arraylist
                    detail.add(currLine[numberOfField]);
                    maxIndex=currID;
                    importedRawData.add(prevID,field,detail);
                    importedRawData.trimToSize();
                }
            }
            else{
                importedRawData.add(prevID,field,detail);
                if( i == dataFile.size()-1) {
                    //It is the last in the arrayList
                    detail = new ArrayList<>();
                    detail.add(currLine[numberOfField]);
                    maxIndex=currID;
                    importedRawData.add(currID, field, detail);
                    importedRawData.trimToSize();
                }
                else{
                    if(prevID+1!=currID) {
                        //a gap has been encountered
                        while (prevID != currID - 1) {
                            detail = new ArrayList<>();
                            detail.add("NA");
                            importedRawData.add((prevID+1),field,detail);
                            prevID++;
                        }
                    }
                    prevID++;
                    detail = new ArrayList<>();
                    //System.out.println(prevID); //debug
                    if(currLine.length!=correctLineLength) detail.add("NA");
                    else detail.add(currLine[numberOfField]);
                }
            }
        }
    }
}
