package medium;

import java.util.*;

/**
 * Created by novas on 2017/2/25.
 */
public class QueueReconstructionbyHeight {
    public static void main(String[] args)
    {
       int[][] array={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(array);
    }

    public static int[][] reconstructQueue(int[][] people) {
        int max=0;
        for (int i=0;i<people.length;i++)
        {
            if(people[i][1]>max)
            {
                max=people[i][1];
            }
        }
        int[][] result=new int[people.length][2];
        ArrayList<int[]> resultList=new ArrayList<>();

       // System.out.println("max="+max);
        for (int i=0;i<=max;i++)
        {
           // int[] array=new int[1100];
           // int[] indexarray=new int[1100];
            HashMap<Integer,Integer> heightCountMap=new HashMap<>();
            for (int j=0;j<people.length;j++)
            {
                if(people[j][1]==i)
                {
                   // array[people[j][0]]=1;
                   // indexarray[people[j][0]]=j;
                    int height=people[j][0];
                    int arrayindex=j;
                    heightCountMap.put(height,arrayindex);
                   // System.out.println("i="+i+",j="+people[j][0]+","+people[j][1]);
                }
            }
            ArrayList<Map.Entry<Integer,Integer>> entriesList=new ArrayList<>();
            entriesList.addAll(heightCountMap.entrySet());
            Collections.sort(entriesList, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o1.getKey()-o2.getKey();
                }
            });
            for (int j=0;j<entriesList.size();j++)
           // for (int j=0;j<array.length;j++)
            {
                Map.Entry<Integer,Integer> entry=entriesList.get(j);
                int height=entry.getKey();
                int arrayindex=entry.getValue();
               // System.out.println("height="+height);
             //   if(array[j]!=0)
              //  {
                   // System.out.println("j="+j);
                    if(resultList.size()==0)
                    {
                       // System.out.println("index="+indexarray[j]);
                      //  System.out.println("add "+people[indexarray[j]][0]+","+people[indexarray[j]][1]);
                        resultList.add(people[arrayindex]);
                    }
                    else
                    {
                        int k=0;
                        int m=0;
                      //  System.out.println("size="+resultList.size());
                        for ( m=0;m<resultList.size();m++)
                        {
                         //   System.out.println("m="+resultList.get(m)[0]+","+resultList.get(m)[1]);
                            if(resultList.get(m)[0]>=height)
                            {
                                k++;
                            }
                            if(k==i)
                            {
                                break;
                            }
                        }
                      //  System.out.println("m="+m);
                        m++;
                        while (m<resultList.size()&&resultList.get(m)[1]==i)
                        {
                            m++;
                        }
                        int[] r=new int[2];
                        r[0]=height;
                        r[1]=i;
                      //  System.out.println("add r="+j+","+i);
                        resultList.add(m,r);
                        for (int l=0;l<resultList.size();l++)
                        {
                            //System.out.println("list="+resultList.get(l)[0]+","+resultList.get(l)[1]);
                        }
                    }
               // }
            }
        }
        for (int i=0;i<resultList.size();i++)
        {
            result[i]=resultList.get(i);
            System.out.println(result[i][0] + "," + result[i][1]);
        }
        return result;
    }
}
