import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class PalindromeChecker {
public void tester()
{
  //String lines[] = loadStrings("palindromes.txt");
  String[] lines = new String[6]; 
    try{
        File myFile = new File("palindromes.txt");
        Scanner myReader = new Scanner(myFile);
        int counter = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines[counter] = data;
            counter++;
        }
        myReader.close();
    }
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
  System.out.println("there are " + lines.length + " lines");
  for (int i=0; i < lines.length; i++) 
  {
    if(palindrome(lines[i])==true)
    {
      System.out.println(lines[i] + " IS a palindrome.");
    }
    else
    {
      System.out.println(lines[i] + " is NOT a palindrome.");
    }
  }
}
public boolean palindrome(String sWord){
  if(reverse(noStuff(sWord)).equals(noStuff(sWord))){return true;}
  
  return false;
}
public String reverse(String str)
{
    String sNew = new String();
  for(int i = str.length()-1; i >= 0; i--){
    sNew += str.substring(i,i+1);
  }
  return sNew;
}
  public String noStuff(String sWord){
      String p = "";
  for(int i = 0; i < sWord.length(); i++){
    if(Character.isLetter(sWord.charAt(i)) == true){
      p += sWord.charAt(i);
    }
  }
  return p.toLowerCase();
}
}
