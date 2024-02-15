// Aviral Mishra
// TTT with 2D arrays
// Period 5
// 2/16/2024

/**
* .
* .
* .
**/
/**
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileReaderWriter{
  private File playerFile;
  
  public FileReaderWriter(File playerFile){
    this.playerFile = playerFile;
  }

  public Player[] createPlayerList() throws FileNotFoundException{
    Scanner fileReader1 = new Scanner(playerFile);
    Player[] players = new Player[getFileLength() - 1];
    headerLine = fileReader1.nextLine();
    for (int i = 0; fileReader1.hasNextLine(); i++){
      
    }
    
    return players;
  }

  public int getFileLength() throws FileNotFoundException{
    int numLines = 0;
    Scanner fileReader2 = new Scanner(playerFile);
    while (fileReader2.hasNextLine()){
      fileReader2.nextLine();
      numLines++;
    }
    return numLines;
  }
}
**/