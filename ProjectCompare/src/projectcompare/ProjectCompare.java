package projectcompare;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProjectCompare {

    //********************Main Function******************/
    public static void main(String[] args) throws FileNotFoundException, IOException {

        FindFollower();
    }

    /**
     * **********Follower Find ***************************
     */
    private static void FindFollower() throws FileNotFoundException, IOException {

        String line;
        String[] key = new String[10000];
        String[] value = new String[10000];
        int[] t_user = new int[10000];
        int len, count = 0, k_count = 0, user = 1, p = 0;
        double[] total = new double[100000];
        double Total = 0;
        int i, j, k;
        int max;

        BufferedReader br = new BufferedReader(new FileReader("sometwitter.txt"));
        while ((line = br.readLine()) != null) {
            String[] str = line.split("\t");

            key[count] = str[0].trim();
            value[count] = str[1].trim();
            count++;
        }
        if (count > 0) {

            p = 0;

            /**
             * *****************User count such as 12=3bar, 13==3bar 14===4 etc ****************
             */
            for (i = 0; i < count; i++) {
                if (key[i].equals(key[i + 1])) {
                    user++;
                } else {
                    t_user[p] = user;
                    user = 1;
                    p++;
                }
            }
            max = Integer.parseInt(key[0]);
            p = 0;

            /**
             * ********************Follower Counts***********************
             */
            for (i = 0; i < count; i++) {
                for (j = i + 1; j < count; j++) {

                    if (value[i].equals((key[j]))) {
                        k_count++;
                    }
                }

                if (Integer.parseInt(key[i]) == max) 
                {
                    Total = Total + ((double) k_count / (double) t_user[p]);
                    max = Integer.parseInt(key[i]);
                } else
                {
                    try {
                        System.out.println("F" + max + " = " + Total);
                        Total = 0;
                        p++;
                        Total = Total + ((double) k_count / (double) t_user[p]);
                        max = Integer.parseInt(key[i]);
                    } catch (ArithmeticException e) {
                        System.out.println("Can't be divided by 0");

                    }
                }
                k_count = 0;
            }

        }
    }
}
