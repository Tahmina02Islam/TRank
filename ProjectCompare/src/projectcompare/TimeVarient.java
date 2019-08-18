package projectcompare;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class TimeVarient {

    private static ArrayList<String> alist = new ArrayList();

    static public void main(String[] args) throws IOException {
        Go_To_Varient();
    }

    private static void Go_To_Varient() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Lab1\\Desktop\\Project\\TwitterProject\\TimeVarient.txt"));
        String line;
        String time, user;
        int count = 0, u1 = 0, u2 = 0, u3 = 0, n1 = 0, n2 = 0, n3 = 0;
       
        /**********  Append File close  ***********/
        FileWriter fddd = new FileWriter("MonthList\\timeCheck.txt", false);
        fddd.write("");
        fddd.close();

        FileWriter fww = new FileWriter("MonthList\\Result.txt", false);
        fww.write("");
        fww.close();
        
        FileWriter f11=new FileWriter("MonthList\\FirstDay.txt",false);
        f11.write("");
        f11.close();
        
        FileWriter f22=new FileWriter("MonthList\\SecondDay.txt",false);
        f22.write("");
        f22.close();
        
//        FileWriter f33=new FileWriter("MonthList\\ThirdMonth.txt",false);
//        f33.write("");
//        f33.close();
       /**********  Append File close  ***********/

        while ((line = br.readLine()) != null) {
            String[] str = line.trim().split("###");
            time = str[0].trim();
            user = str[1].trim();
            String[] time2 = time.trim().split("[-\\s\\:]");
            String date = time2[2].trim();
            int date2 = Integer.parseInt(date);
            FileWriter fw = new FileWriter("MonthList\\timeCheck.txt", true);

            if (date2 >= 1 && date2 <= 15) {
                fw.append(date2 + "\t" + user);
                fw.append("\n");
                fw.close();
            } else if (date2 >= 16 && date2 <= 30) {
                fw.append(date2 + "\t" + user);
                fw.append("\n");
                fw.close();}
//            } else {
//                fw.append(date2 + "\t" + user);
//                fw.append("\n");
//                fw.close();
//            }

        }
        
        

        BufferedReader brr = new BufferedReader(new FileReader("MonthList\\timeCheck.txt"));
        String line2;
        while ((line2 = brr.readLine()) != null) {
            count = 0;
            String[] st = line2.split("\\s+");
            String us = st[1].trim();

            if (alist.contains(us) == true) {
                continue;
            } else {
                alist.add(us);
            }

            String us2 = null, cnt,line3;
            BufferedReader brr2 = new BufferedReader(new FileReader("MonthList\\timeCheck.txt"));

            FileWriter fw1 = null;
            while ((line3 = brr2.readLine()) != null) {

                String[] st2 = line3.split("\\s+");
                cnt = st2[0].trim();
                us2 = st2[1].trim();
                int first = Integer.parseInt(cnt);

                fw1 = new FileWriter("MonthList\\Result.txt", true);
                if (first >= 1 && first <= 15) {
                    if (us.equals(us2)) {
                        u1++;
                        n1 = 1;
                    }
                } else if (first >= 16 && first <= 30) {
                    if (us.equals(us2)) {
                        u2++;
                        n2 = 2;
                    }
//                } else if (first >= 21 && first <= 30) {
//                    if (us.equals(us2)) {
//                        u3++;
//                        n3 = 3;
//                    }
                }
            }
            if (n1 == 1) {
                fw1.append(us + "\t" + u1 + "\t" + n1);
                fw1.append("\n");
            }
            if (n2 == 2) {
                fw1.append(us + "\t" + u2 + "\t" + n2);
                fw1.append("\n");
            }
//            if (n3 == 3) {
//                fw1.append(us + "\t" + u3 + "\t" + n3);
//                fw1.append("\n");
//            }
            fw1.close();
            count = 0;
            u1 = 0;
            u2 = 0;
            u3 = 0;
            n1 = 0;
            n2 = 0;
            n3 = 0;

        }
        brr.close();

        /**
         * * Save data onto new File. ***
         */
       
       BufferedReader file=new BufferedReader(new FileReader("MonthList\\Result.txt"));
       String fline;
       FileWriter f1 = null,f2 = null,f3 = null;
       while((fline=file.readLine())!=null)
       {
           String []data=fline.trim().split("\\s+");
           String a=data[0].trim();
           String b=data[1].trim();
           String c=data[2].trim();
           
           int value=Integer.parseInt(c);
           if(value==1)
           {
               f1=new FileWriter("MonthList\\FirstDay.txt",true);
               f1.append(a+"\t"+b);
               f1.append("\n");
               f1.close();
               
           }
           else if(value==2)
           {
               f2=new FileWriter("MonthList\\SecondDay.txt",true);
               f2.append(a+"\t"+b);
               f2.append("\n");
               f2.close();
           }
//           else{
//               f3=new FileWriter("MonthList\\ThirdMonth.txt",true);
//               f3.append(a+"\t"+b);
//               f3.append("\n");
//               f3.close();
//           }
         
       }
//           f1.close();
//           f2.close();
//           f3.close();
    }
}

