package projectcompare;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileTransfer {
    static Scanner ob=new Scanner(System.in);

    static public void main(String[] args) throws FileNotFoundException, IOException {
        fileTransfer();
    }

    private static void fileTransfer() throws FileNotFoundException, IOException {
       
        FileWriter fw = new FileWriter("C:\\Users\\Lab1\\Desktop\\Project\\sometwitter.txt");
        String line, line2, key, value, p = "",q;
        int count = 0,kk=0;
        int i, j, k;
        FileReader fr = new FileReader("C:\\Users\\Lab1\\Desktop\\Project\\newtwitter.txt");
        BufferedReader br = new BufferedReader(fr);
        while ((line = br.readLine()) != null) {
            
            String[] str = line.split("\\s");
            key = str[0]; //12  
            value = str[1];
            if(key.equals("13"))
            {
                
                System.out.print(value);
                System.out.println();
                System.out.println(kk);
                q=ob.next();
            }
            if(!key.equals(p))
            {
                count = 0;
            }
            p = key;
            if (count < 3) {
            }
            count++;
            kk++;
        }
        br.close();
    }
}
