package ua.en.kosse.oksana.hillel.hw13;

import java.io.File;
import java.util.*;

public class FileNavigator {
    protected   Map<String, ArrayList<FileData>> fileMap = new HashMap<>();
    private String pathToFile;

    public void addNew(String filePath) throws Exception {
        File file = new File(filePath);

        if (fileNotExists(file)) {
            throw new Exception("File does not exist!");
        }

        if (file.isDirectory()) {
            for (File files : file.listFiles()) {
                pathToFile = file.getAbsolutePath();
                FileData fileData = new FileData(pathToFile, files.getName(), files.length());
                //System.out.println(file.getAbsolutePath());
                //System.out.println(files.getName());

                if (fileMap.containsKey(pathToFile)) {
                    fileMap.get(pathToFile).add(fileData);
                } else {
                    ArrayList<FileData> fileDataList = new ArrayList<>();
                    fileDataList.add(fileData);
                    fileMap.put(pathToFile, fileDataList);
                }

            }
        } else {
            throw new Exception(" File is a directory!");
        }


    }

    public boolean fileNotExists(File file) {
        return !file.exists();
    }

    public ArrayList<FileData> find(String filePath) {
        return fileMap.get(filePath);
    }

    public ArrayList<FileData> filterBySize(int sizeFileByte) {
        ArrayList<FileData> result = new ArrayList<>();

        for (ArrayList<FileData> myFileValue : fileMap.values()) {
            for (FileData fileValue : myFileValue) {
                if (fileValue.getFileSizeByte() <= sizeFileByte) {
                    result.add(fileValue);
                }
            }
        }
        return result;
    }

    public void remove(String pathFile) {
        fileMap.remove(pathFile);
    }

    public ArrayList<FileData> sortBySize() {
        ArrayList<FileData> sortSize = new ArrayList<>();

        for (ArrayList<FileData> myFileSize : fileMap.values()) {
            for (FileData fileSize : myFileSize) {
                sortSize.add(fileSize);
            }
        }
        Collections.sort(sortSize);
        return sortSize;
    }

    @Override
    public String toString() {
       return "\n\t FileNavigator{" +
                "fileMap=" + fileMap +"\n\t"+
                '}';


    }


}



