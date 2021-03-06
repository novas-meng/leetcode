package medium;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by novas on 2017/3/5.
 */
public class NextGreaterElementII {
    public static void main(String[] args)
    {
        int[] array={122,245,300,318,441,465
                ,556,590,648,752,788,892,949,
                1016,1035,1073,1119,1219,1271,
                1301,1346,1349,1397,1411,1512,
                1609,1698,1822,1919,1993,2013,2042,
                2046,2081,2169,2266,2276,2346,2428,2432,
                2441,2544,2639,2682,2705,2793,2830,2857,2950,
                2972,3067,3071,3107,3169,3202,3283,3371,3484,3547,3659,3721,
                3846,3869,3946,4003,4011,4036,4110,4114,4222,4282,4400,4432,
                4458,4545,4599,4610,4708,4735,4739,4833,4839,4894,4980,5090,5115,
                5128,5166,5243,5357,5434,5471,5540,5651,5693,5712,5806,5877,5937,
                6057,6115,6229,6313,6436,6476,6551,6601,6704,6751,6817,6918,6983,
                7054,7145,7155,7241,7327,7406,7529,7599,7667,7685,7694,7726,7748,
                7810,7878,7971,8041,8107,8178,8221,8275,8296,8405,8487,8564,8632,
                8649,8710,8770,8864,8928,8987,9026,9066,9144,9230,9268,9384,9412,
                9458,9497,9513,9634,9741,9794,9905,10024,10065,10084,10176,10208,
                10217,10292,10364,10422,10463,10482,10559,10600,10723,10728,10773,
                10894,10988,11031,11117,11209,11211,11323,11423,11484,11499,11516,
                11556,11559,11579,11696,11813,11830,11854,11978,12034,12117,12176,
                12249,12331,12441,12553,12571,12615,12672,12730,12799,12856,12947,
                12950,13027,13056,13095,13214,13231,13356,13360,13456,13473,13474,
                13573,13636,13672,13706,13830,13844,13935,14052,14177,14224,14307,
                14403,14513,14552,14573,14584,14680,14740,14748,14842,14870,14920,
                15044,15089,15151,15206,15313,15384,15448,15511,15523,15639,15662,
                15682,15687,15797,15876,15974,16052,16123,16168,16228,16248,16349,
                16454,16564,16678,16705,16773,16856,16914,16983,17003,17080,17155,
                17236,17278,17388,17445,17560,17560,17649,17737,17842,17850,17885,
                17944,18068,18069,18087,18097,18118,18128,18180,18297,18416,18492,
                18540,18575,18599,18606,18716,18767,18827,18852,18941,19016,19096,
                19142,19142,19265,19309,19391,19460,19498,19580,19644,19674,19742,
                19806,19914,20033,20097,20183,20209,20259,20342,20424,20449,20505,
                20613,20620,20704,20741,20813,20854,20903,20979,21070,21096,21173,
                21256,21275,21382,21462,21560,21624,21684,21727,21787,21904,22006,
                22076,22142,22150,22201,22260,22336,22425,22454,22544,22583,22641,
                22647,22700,22759,22843,22912,22912,22937,23058,23142,23175,23182,
                23267,23299,23374,23405,23527,23554,23644,23686,23745,23849,23875,
                23962,24053,24119,24164,24175,24291,24378,24433,24487,24551,24641,
                24650,24739,24757,24803,24868,24890,25010,25031,25062,25100,25121,
                25238,25249,25262,25314,25315,25381,25489,25601,25723,25738,25823,
                25907,25970,25972,26033,26068,26172,26200,26306,26311,26327,26441,
                26533,26562,26600,26622,26678,26682,26705,26815,26819,26911,27030,
                27106,27224,27253,27310,27403,27429,27495,27530,27622,27735,27761,
                27865,27880,27986,28091,28121,28223,28300,28410,28510,28552,28603,
                28611,28657,28683,28783,28831,28845,28959,29020,29116,29171,29289,
                29363,29378,29467,29508,29510,29518,29536,29628,29740,29811,29868,
                29969,30028,30053,30087,30091,30183,30288,30362,30404,30456,30527,
                30562,30609,30625,30721,30801,30904,30907,30989,31034,31124,31171};
        nextGreaterElements(array);
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] array=new int[nums.length];
        int[] indexarray=new int[nums.length];
        System.arraycopy(nums, 0, indexarray, 0, indexarray.length);
        System.arraycopy(nums, 0, array, 0, array.length);
        int[] B=new int[nums.length];
        Arrays.sort(array);
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<array.length;i++)
        {
            for (int j=0;j<indexarray.length;j++)
            {
                if(indexarray[j]==array[i])
                {
                    B[i]=j;
                    map.put(j,array[i]);
                    indexarray[j]=Integer.MAX_VALUE;
                    break;
                }
            }
        }
        int length=nums.length;
        HashMap<Integer,Integer> resultmap=new HashMap<>();
        int[] result=new int[nums.length];
        for (int i=0;i<B.length;i++)
        {
            int bignum=-1;
            int min=Integer.MAX_VALUE;
          //  System.out.println("current="+map.get(B[i])+","+B[i]);
            resultmap.put(B[i], bignum);
            for (int j=i+1;j<B.length;j++)
            {
                if(map.get(B[i])!=map.get(B[j]))
                {
                    int minus=0;
                 //   System.out.println("B[j]="+B[j]);
                    if(B[j]<B[i])
                    {
                        minus=B[j]+length-B[i];
                    }
                    else
                    {
                        minus=B[j]-B[i];
                    }
                    if(minus<min)
                    {
                        min=minus;
                        bignum=map.get(B[j]);
                        resultmap.put(B[i],bignum);
                    }
                }
            }
          //  System.out.println(bignum);
        }
        for (int i=0;i<nums.length;i++)
        {
            result[i]=resultmap.get(i);
           // System.out.println(result[i]);
        }
        return result;
    }
}
