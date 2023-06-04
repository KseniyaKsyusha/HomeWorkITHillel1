package ua.en.kosse.oksana.hillel.hw13;

public class FileData implements Comparable<FileData> {

    protected String pathFile;
    protected String nameFile;
    protected long fileSizeByte;

    public FileData(String filePath, String fileName, long fileSizeByte) {
        this.pathFile = filePath;
        this.nameFile = fileName;
        this.fileSizeByte = fileSizeByte;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public long getFileSizeByte() {
        return fileSizeByte;
    }

    public void setFileSizeByte(long fileSizeByte) {
        this.fileSizeByte = fileSizeByte;
    }

    @Override
    public String toString() {
        return "\n\t FileData{" +
                "filePath='" + pathFile + '\'' +
                ", fileName='" + nameFile + '\'' +
                ", fileSize=" + fileSizeByte +
                '}';
    }

    @Override
    public int compareTo(FileData fileNew) {
        return (int) (this.getFileSizeByte() - fileNew.getFileSizeByte());

    }
}
