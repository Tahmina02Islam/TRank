
package projectcompare;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lab1
 */
public class RetweetSecondInterval {
    private static ArrayList<String> alist = new ArrayList();
    static Scanner ob=new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException, IOException {
        RetweetCollection();
    }
     private static void RetweetCollection() throws FileNotFoundException, IOException {

        int i, j, k, count = 0, rtweet = 0, p = 0, flag = 0, r = 0, sum = 0, next = 0, v = 0;
        String key, v1, key2 = null, value2;
        String val, v2, v3, vv1, vv2, vv3;
        String line, line2;
        
            FileWriter fww=new FileWriter("DataList\\FollowerInfluence\\check.txt",false);
            fww.write("");
            fww.close();
            
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Lab1\\Desktop\\Project\\ProjectCompare\\DataList\\FollowerInfluence\\SecondInterval.txt"));
        while ((line = br.readLine()) != null) {

            String[] str = line.split("###");
            key = str[1].trim();
            v1 = str[2].trim(); //pense
            v2 = v1.replace("RT ", "");
            v3 = v1.replace("rt ", "");

            if (alist.contains(v1) == true) {
                continue;
            }
            if (alist.contains(v2) == true) {
                continue;
            }
            if (alist.contains(v3) == true) {
                continue;
            } else {
                alist.add(v3);
            }

            BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\Lab1\\Desktop\\Project\\ProjectCompare\\DataList\\FollowerInfluence\\SecondInterval.txt"));
            
            
            FileWriter fw = new FileWriter("DataList\\FollowerInfluence\\check.txt",true);
            count = 0;
            p = 0;
            while ((line2 = br2.readLine()) != null) {
                String[] str2 = line2.split("###");
                key2 = str2[1].trim();
                vv1 = str2[2].trim();
                vv2 = vv1.replace("RT ", "");
                vv3 = vv1.replace("rt ", "");

                if (v2.equals(vv2) || v2.equals(vv3) || v3.equals(vv2) || v3.equals(vv3)) {
                    count = count + p;
                    p = 1;
                               // System.out.print(key+"\t"+count);

                }
                
            }
                        
            //System.out.println();
            fw.append(key+"\t"+count);
           fw.append("\n");
            fw.close();
        }
                RetweetInfluence();
                System.out.println("Succes");
    }

    /**
     * ********* Find the Retweet Follower   ****
     */
    private static void RetweetInfluence() throws FileNotFoundException, IOException {

        String line, line2;
        double s, a, b = 0, c;
        String parts4=null,aa;

       BufferedReader brr2 = new BufferedReader(new FileReader("DataList\\FollowerInfluence\\check.txt"));
       while ((line = brr2.readLine()) != null) {
           String[] str = line.trim().split("\t");
          
           String parts = str[0].trim(); //53
           String parts2 = str[1].trim();
           a=Double.parseDouble(parts2);
           
           int flag = 0;
           BufferedReader brr = new BufferedReader(new FileReader("SaveFile.txt"));
           while ((line2 = brr.readLine()) != null) {
               String[] str1 = line2.trim().split("\t");
              
               String parts3 = str1[0].trim(); //12 53 ....
                parts4 = str1[2].trim();
               
               if (parts.equals(parts3)) {
                   flag = 1;
                   b=Double.parseDouble(parts4);
                   break;
               }
           }
           if(flag==1)
           {
               s=(double)a/(double)b;
               System.out.println("F"+parts+"-----"+s);
           }
         
       }
    }
}
