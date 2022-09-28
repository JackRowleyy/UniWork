package part03;

public enum Department {
    ELECTRICAL("Electrical"), PHOTOGRAPHIC("Photographic"), COMPUTING("Computing"), BOOKS("Books"), MUSIC("Music"), FASHION("Fashion"), OTHER("Other");
private String department;
private Department(String data){
    department = data;
}
public String toString() {
    return department;
  }
}
