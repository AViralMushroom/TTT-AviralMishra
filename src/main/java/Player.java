// Aviral Mishra
// TTT with 2D arrays
// Period 5
// 02/16/2024

/**
* This is where player information is held
* There isn't that much code, most of it is to retrieve information and update winLossDraw
* This class is not dependent on the Game or Main class whatsoever
**/

import java.util.Scanner;

public class Player{
  /////////////////////////////////
  // PROPERTIES/FIELDS
  /////////////////////////////////
  
  private String name;
  private int[] winLossDraw = new int[3];
  
  /////////////////////////////////
  // CONSTRUCTORS
  /////////////////////////////////
  public Player(String name){
    this.name = name;
  }

  public Player(Scanner console){
    System.out.print("What's your name? ");
    this.name = console.next();
  }

  /////////////////////////////////
  // METHODS
  /////////////////////////////////

  // GETTERS/ACCESSPRS

  // retrieve name string
  public String getName(){
    return name;
  }

  // reteieve winLossDraw stats (currently unused)
  public int[] getWinLossDraw(){
    return winLossDraw;
  }

  // print all relevent player information
  @Override
  public String toString(){
    return "Overall stats for " + name + ":" +
            "\n Total wins:   " + winLossDraw[0] + 
            "\n Total losses: " + winLossDraw[1] + 
            "\n Total draws:  " + winLossDraw[2];
  }

  // update winLossDraw wins
  public void addWin(){
    winLossDraw[0]++;
  }

  // update winLossDraw losses
  public void addLoss(){
    winLossDraw[1]++;
  }

  // update winLossDraw draws
  public void addDraw(){
    winLossDraw[2]++;
  }
}