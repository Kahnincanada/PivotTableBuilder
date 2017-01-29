package TuesdayProject.Loaders;
import java.util.ArrayList;
import java.io.*;
/**
 * Created by Tony on 2017-01-27.
 */
public class ReadFile {
    private String path;
    public ReadFile(String file_path){
        path = file_path;
    }

    public ArrayList<String> OpenFile() throws IOException{
        FileReader fr= new FileReader(path);
        BufferedReader br = new BufferedReader(fr);

        int numberOfLines = readLines();
        ArrayList<String> textData = new ArrayList<>();

        for(int i=0; i<numberOfLines; i++){
            textData.add(i,br.readLine());
        }
        br.close();
        return textData;
    }
    public int readLines() throws IOException{
        FileReader fr=new FileReader(path);
        BufferedReader br = new BufferedReader(fr);

        String aLine;
        int numberOfLines=0;
        while((aLine = br.readLine())!=null){
            numberOfLines++;
        }
        return numberOfLines;
    }
}
