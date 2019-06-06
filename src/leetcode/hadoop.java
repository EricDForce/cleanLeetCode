/**
 * Created by eric-d on 2017/3/8.
 */
import java.util.*;
import java.io.*;
public class hadoop {

    public static void  main(String[] args){
        System.out.println(new hadoop().getFiles("/Users/eric-d/Desktop"));
    }

    public int getFiles(String path) {
        File[] files = new File(path).listFiles();
        return files.length;
    }
}
