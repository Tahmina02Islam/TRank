package projectcompare;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MathematicalEquation {

    static public void main(String[] args) throws IOException {
        FollowerInfluence();
    }

    static public void FollowerInfluence() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("list.txt"));
        String line, line2;
        String a, value = null, key2 = "", p = "";
        int count = 0, i, j, cal = 0;
        int highest_follower = 0,no_of_follower = 0;
        int max=0;
        double  alpha=0.3;
        double first,second,FI,firstData; 
        
        FileWriter bw = new FileWriter("SaveFile.txt");
        FileWriter table=new FileWriter("table.txt");

        while ((line = br.readLine()) != null) {
            if (line.contains("      ")) {
                String[] str = line.trim().split("\\s+");
                key2 = str[0];
                value = str[1];
            }

            BufferedReader br2 = new BufferedReader(new FileReader("list.txt"));
            while ((line2 = br2.readLine()) != null) {
                if (line2.contains("      ")) {
                    String[] str2 = line2.trim().split("\\s+");
                    String key = str2[0];
                    String val = str2[1];
                    if (value.equals(key)) {
                        count++;
                    }
                }             
            }
            if (p.equals("") || p.equals(key2)) {
                cal = cal + count;
                no_of_follower++;
            } else {
               bw.write(p+"\t"+cal+"\t"+no_of_follower);
               table.write(p);
               bw.write("\n"); 
               table.write("\n");
                if(cal>max)
                {
                    max=cal;
                }
                no_of_follower=1;
                cal = 0;
                count = 0;
                highest_follower = Integer.parseInt(p);
            }

            p = key2;
            count = 0;
         }
        bw.close();
        table.close();
               
               /************   Table Format Create   ******/
                System.out.print("\tAlpha\t");
                BufferedReader tb=new BufferedReader(new FileReader("table.txt"));
                while((line=tb.readLine())!=null)
                {
                    System.out.print("|\t F"+line+"\t");
                }
                System.out.println("|");
                
               /*********************  Final Equation  ********************/
               
               if(alpha==0.3)
               {
                        BufferedReader br3 = new BufferedReader(new FileReader("SaveFile.txt"));
                        System.out.print("\t"+alpha+"\t");
                          while((line=br3.readLine())!=null)
                          {
                              String []st=line.trim().split("\\s+");
                              String parts=st[0].trim();
                              String parts2=st[1].trim();
                              String parts3=st[2].trim();
                              
                              int follower=Integer.parseInt(parts3);
                              int total_following=Integer.parseInt(parts2);
                           
                              first=((double)follower/(double)highest_follower)*alpha;
                              second=(1-alpha)*((double)total_following/(double)max);
                              FI=first+second;
                              System.out.print("|\t"+String.format("%.3f",FI)+"\t");
                          }
                          System.out.println("|");
                          alpha=alpha+0.2;
                            br.close();
               }
               if(alpha==0.5)
               {
                       System.out.print("\t"+alpha+"\t");
                        BufferedReader br3 = new BufferedReader(new FileReader("SaveFile.txt"));
                          while((line=br3.readLine())!=null)
                          {
                              String []st=line.trim().split("\\s+");
                              String parts=st[0].trim();
                              String parts2=st[1].trim();
                              String parts3=st[2].trim();
                              
                              int follower=Integer.parseInt(parts3);
                              int total_following=Integer.parseInt(parts2);
                           
                              first=((double)follower/(double)highest_follower)*alpha;
                              second=(1-alpha)*((double)total_following/(double)max);
                              FI=first+second;
                              System.out.print("|\t"+String.format("%.3f",FI)+"\t");
                          }
                          alpha=alpha+0.2;
                          System.out.println("|");
                            br.close();
               }
               if(alpha==0.7)
               {
                    System.out.print("\t"+alpha+"\t");
                    BufferedReader br3 = new BufferedReader(new FileReader("SaveFile.txt"));
                          while((line=br3.readLine())!=null)
                          {
                              String []st=line.trim().split("\\s+");
                              String parts=st[0].trim();
                              String parts2=st[1].trim();
                              String parts3=st[2].trim();
                              
                              int follower=Integer.parseInt(parts3);
                              int total_following=Integer.parseInt(parts2);
                           
                              first=((double)follower/(double)highest_follower)*alpha;
                              second=(1-alpha)*((double)total_following/(double)max);
                              FI=first+second;
                              System.out.print("|\t"+String.format("%.3f",FI)+"\t");
                          }
                          alpha=alpha+0.2;
                          System.out.println("|");
                            br.close();
               }
        bw.close();
    }
}
