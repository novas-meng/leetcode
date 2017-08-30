package _2017xiaozhao;

import java.util.Scanner;

/**
 * Created by novas on 2017/8/30.
 * 继MIUI8推出手机分身功能之后，MIUI9计划推出一个电话号码分身的功能：首先将电话号码中的每个数字加上8取个位，然后使用对应的大写字母代替 （"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"）， 然后随机打乱这些字母，所生成的字符串即为电话号码对应的分身。
 输入描述:
 第一行是一个整数T（1 ≤ T ≤ 100)表示测试样例数；接下来T行，每行给定一个分身后的电话号码的分身（长度在3到10000之间）。
 输出描述:
 输出T行，分别对应输入中每行字符串对应的分身前的最小电话号码（允许前导0）。
 示例1
 输入

 4
 EIGHT
 ZEROTWOONE
 OHWETENRTEO
 OHEWTIEGTHENRTEO
 输出

 0
 234
 345
 0345
 */
public class 电话号码分身 {
    public static void getMin(String s)
    {
        int[] chars=new int[26];
        char[] array=s.toCharArray();
        for (int i=0;i<array.length;i++)
        {
            chars[array[i]-65]++;
        }
        int[] numbers=new int[10];
        //'Z' 表示 zero
        numbers[0]=chars['Z'-'A'];
        chars['E'-'A']=chars['E'-'A']-chars['Z'-'A'];
        chars['R'-'A']=chars['R'-'A']-chars['Z'-'A'];
        chars['O'-'A']=chars['O'-'A']-chars['Z'-'A'];
        //'W' 表示TWO

        numbers[2]=chars['W'-'A'];
        chars['T'-'A']=chars['T'-'A']-chars['W'-'A'];
        chars['O'-'A']=chars['O'-'A']-chars['W'-'A'];

        //'U' 表示FOUR
        numbers[4]=chars['U'-'A'];
        chars['F'-'A']=chars['F'-'A']-chars['U'-'A'];
        chars['O'-'A']=chars['O'-'A']-chars['U'-'A'];
        chars['R'-'A']=chars['R'-'A']-chars['U'-'A'];

        //X表示SIX
        numbers[6]=chars['X'-'A'];
        chars['S'-'A']=chars['S'-'A']-chars['X'-'A'];
        chars['I'-'A']=chars['I'-'A']-chars['X'-'A'];

        //G表示EIGHT
        numbers[8]=chars['G'-'A'];
        chars['E'-'A']=chars['E'-'A']-chars['G'-'A'];
        chars['I'-'A']=chars['I'-'A']-chars['G'-'A'];
        chars['H'-'A']=chars['H'-'A']-chars['G'-'A'];
        chars['T'-'A']=chars['T'-'A']-chars['G'-'A'];

        //O表示 ONE
        numbers[1]=chars['O'-'A'];
        chars['N'-'A']=chars['N'-'A']-chars['O'-'A'];
        chars['E'-'A']=chars['E'-'A']-chars['O'-'A'];

        //T表示THREE
        numbers[3]=chars['T'-'A'];
        chars['H'-'A']=chars['H'-'A']-chars['T'-'A'];
        chars['R'-'A']=chars['R'-'A']-chars['T'-'A'];
        chars['E'-'A']=chars['E'-'A']-chars['T'-'A'];
        chars['E'-'A']=chars['E'-'A']-chars['T'-'A'];

        //F表示FIVE
        numbers[5]=chars['F'-'A'];
        chars['I'-'A']=chars['I'-'A']-chars['F'-'A'];
        chars['V'-'A']=chars['V'-'A']-chars['F'-'A'];
        chars['E'-'A']=chars['E'-'A']-chars['F'-'A'];

        //S表示SEVEN

        numbers[7]=chars['S'-'A'];
        chars['E'-'A']=chars['E'-'A']-chars['S'-'A'];
        chars['V'-'A']=chars['V'-'A']-chars['S'-'A'];
        chars['E'-'A']=chars['E'-'A']-chars['S'-'A'];
        chars['N'-'A']=chars['N'-'A']-chars['S'-'A'];

        //I表示NINE
        numbers[9]=chars['I'-'A'];
        chars['N'-'A']=chars['N'-'A']-chars['I'-'A'];
        chars['N'-'A']=chars['N'-'A']-chars['I'-'A'];
        chars['E'-'A']=chars['E'-'A']-chars['I'-'A'];


        int[] num_array=new int[10];
        for (int i=0;i<numbers.length;i++)
        {
            num_array[(i+2)%10]=numbers[i];
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<num_array.length;i++)
        {
            for (int j=0;j<num_array[i];j++)
            {
                stringBuilder.append(i);
            }
        }
        System.out.println(stringBuilder.toString());
    }
    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext())
        {
            int t=scanner.nextInt();
            scanner.nextLine();
            for (int i=0;i<t;i++)
            {
                String s=scanner.nextLine();
                getMin(s);
            }

        }
    }
}
