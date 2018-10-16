import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

import static controller.controller.addWordToDatabase;
import static controller.controller.deletaWordFromDatabase;
import static controller.controller.findWord;

public class main {
    public static void main(String args[]) throws SQLException {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("1.Seach word.");
            System.out.println("2.Add word.");
            System.out.println("3.Delete word.");
            System.out.println("4.Exit.");
            String check = sc.nextLine();
            if(check.equals("1")){
                seach();
            }
            if(check.equals("2")){
                add();
            }
            if(check.equals("3")){
                delete();
            }
            if(check.equals("4")){
                return ;
            }
        }
    }

    public static void delete(){
        System.out.print("Nhap tu ban muon xoa: ");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        deletaWordFromDatabase(word);
    }

    public static void seach() throws SQLException {
        System.out.print("Seach: ");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        if(!findWord(word).equals("")){
            System.out.println(word + ": " + findWord(word));
        }
        else{
            System.out.println("Tu ban nhap khong co trong tu dien.");
        }
        System.out.println("Continue ? (y || n)");
        String check = sc.nextLine();
        check = check.toLowerCase();
        if(check.equals("y")){
            seach();
        }
    }

    public static void add(){
        System.out.print("Nhap tu muon them: ");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        System.out.print("Nhap nghia cua tu vua nhap: ");
        String detail = sc.nextLine();
        addWordToDatabase(word, detail);
    }
}