
/**** sometwitter theke Total Follower count from merge file ****/

/***    follower following  
 *          12        13 
 */
package projectcompare;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MRtwtFlowr {
          static HashMap<String, String> map = new HashMap<String, String>();

    public static void main(String[] args) throws FileNotFoundException, IOException {
          userTweet();
    }
    
    /****    Follower  Following ***/
    public static void followerCount() throws FileNotFoundException, IOException
    {
         String line, line2 = null;
         BufferedReader br2 = new BufferedReader(new FileReader("newtwitter.txt"));
         int count=0;
         while((line=br2.readLine())!=null)
         {
             String []str=line.split("\t");
             if(str.length<2)
             {
                 continue;
             }
             String follower=str[0].trim();
             String following=str[1].trim();
             
             if(map.containsKey(follower))
             {
                     String t_follower=map.get(follower);
                     System.out.println(count+" "+follower);
                    count++;
              }
             if(!map.containsKey(follower))
             {
                 count=0;
             }
              count=0;
         }
        
    }
 
     /*****   Time ### User ### Tweet ***/
    private static void userTweet() throws FileNotFoundException, IOException {
        
         String line, line2 = null;
        BufferedReader br = new BufferedReader(new FileReader("Merge.txt"));
       while((line=br.readLine())!=null)
       {
          String[] str = line.split("###");
          if(str.length>=0)
          {
              String key=str[1].trim();
              String value=str[2].trim();
              //System.out.println(key+" "+value);
              map.put(key, value);
          }
          
       }
       followerCount();
       br.close();
       
       
       /***Retweet count
        *   if (count > 0) {
            for (i = 0; i < count; i++) {
                rtweet=0;
                for (j = i + 1; j < count; j++) {

                    if ((value[i]).equals((value[j]))) {
                        rtweet++;
                        //System.out.println(value[i]);
                        fr[j]=0;
                        flag = 1;
                        }
                 }
                if(fr[i]!=0 && flag==1)
                {
                    fr[r]=count;
                    r++;
                    if(key[i].equals(key[i+1]))
                    {
                        sum=sum+rtweet;
                        next=1;
                        v=Integer.parseInt(key[i]);
                    }
                    else {
                        System.out.println("Id " + key[i] + " =  " + rtweet);
                    }
                    p++;
                }
                flag = 0;
            }
            
            
            if(next==1)
            {
                System.out.println("Id " + v + " =  " + sum);
                next=0;
            }
        }
        */
    }
}



