package TuesdayProject.Loaders;

import java.util.ArrayList;

/**
 * Created by Tony on 2017-01-29.
 */
public class TagLoader extends Loader {
    private String[] currLine;

    public TagLoader(){
        tagInfo = new ArrayList<>();
    }
    protected void LoadField(ArrayList<String> dataFile, int numberOfField){
        LoadTagField(dataFile);
    }
    private void LoadTagField(ArrayList<String> dataFile){
        //set arrayList(0);
        //need to fix the gap existed in this list
        currLine = dataFile.get(0).split(",");
        tagInfo.add(0,currLine[1]);

        int correctLineLength= currLine.length;

        //following lines
        int prevID=1;//this empty tag
        int currID;

        for (String s : dataFile.subList(1,dataFile.size())) {
            currLine = s.split(",");
            currID = Integer.parseInt(currLine[0]);

            if(prevID!=currID) {
                //a gap has been encountered
                while (prevID != currID) {
                    tagInfo.add(prevID, "NA");
                    prevID++;
                }
            }
            prevID++;
            //System.out.println(prevID); //debug
            if(currLine.length!=correctLineLength) tagInfo.add("NA");
            else tagInfo.add(currID,currLine[1]);
        }
    }
}
