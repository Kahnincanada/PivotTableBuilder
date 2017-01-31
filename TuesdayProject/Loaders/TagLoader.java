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
        currLine = dataFile.get(0).split(",");
        tagInfo.add(0,currLine[1]);
        for(String s : dataFile.subList(1,dataFile.size())){
            currLine = s.split(",");
            tagInfo.add(currLine[1]);
            //This is a complete list, don't need to worry about gaps
        }
    }


}
