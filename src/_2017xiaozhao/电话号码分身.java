package _2017xiaozhao;

import java.util.Scanner;

/**
 * Created by novas on 2017/8/30.
 * ��MIUI8�Ƴ��ֻ�������֮��MIUI9�ƻ��Ƴ�һ���绰�������Ĺ��ܣ����Ƚ��绰�����е�ÿ�����ּ���8ȡ��λ��Ȼ��ʹ�ö�Ӧ�Ĵ�д��ĸ���� ��"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"���� Ȼ�����������Щ��ĸ�������ɵ��ַ�����Ϊ�绰�����Ӧ�ķ���
 ��������:
 ��һ����һ������T��1 �� T �� 100)��ʾ������������������T�У�ÿ�и���һ�������ĵ绰����ķ���������3��10000֮�䣩��
 �������:
 ���T�У��ֱ��Ӧ������ÿ���ַ�����Ӧ�ķ���ǰ����С�绰���루����ǰ��0����
 ʾ��1
 ����

 4
 EIGHT
 ZEROTWOONE
 OHWETENRTEO
 OHEWTIEGTHENRTEO
 ���

 0
 234
 345
 0345
 */
public class �绰������� {
    public static void getMin(String s)
    {
        int[] chars=new int[26];
        char[] array=s.toCharArray();
        for (int i=0;i<array.length;i++)
        {
            chars[array[i]-65]++;
        }
        int[] numbers=new int[10];
        //'Z' ��ʾ zero
        numbers[0]=chars['Z'-'A'];
        chars['E'-'A']=chars['E'-'A']-chars['Z'-'A'];
        chars['R'-'A']=chars['R'-'A']-chars['Z'-'A'];
        chars['O'-'A']=chars['O'-'A']-chars['Z'-'A'];
        //'W' ��ʾTWO

        numbers[2]=chars['W'-'A'];
        chars['T'-'A']=chars['T'-'A']-chars['W'-'A'];
        chars['O'-'A']=chars['O'-'A']-chars['W'-'A'];

        //'U' ��ʾFOUR
        numbers[4]=chars['U'-'A'];
        chars['F'-'A']=chars['F'-'A']-chars['U'-'A'];
        chars['O'-'A']=chars['O'-'A']-chars['U'-'A'];
        chars['R'-'A']=chars['R'-'A']-chars['U'-'A'];

        //X��ʾSIX
        numbers[6]=chars['X'-'A'];
        chars['S'-'A']=chars['S'-'A']-chars['X'-'A'];
        chars['I'-'A']=chars['I'-'A']-chars['X'-'A'];

        //G��ʾEIGHT
        numbers[8]=chars['G'-'A'];
        chars['E'-'A']=chars['E'-'A']-chars['G'-'A'];
        chars['I'-'A']=chars['I'-'A']-chars['G'-'A'];
        chars['H'-'A']=chars['H'-'A']-chars['G'-'A'];
        chars['T'-'A']=chars['T'-'A']-chars['G'-'A'];

        //O��ʾ ONE
        numbers[1]=chars['O'-'A'];
        chars['N'-'A']=chars['N'-'A']-chars['O'-'A'];
        chars['E'-'A']=chars['E'-'A']-chars['O'-'A'];

        //T��ʾTHREE
        numbers[3]=chars['T'-'A'];
        chars['H'-'A']=chars['H'-'A']-chars['T'-'A'];
        chars['R'-'A']=chars['R'-'A']-chars['T'-'A'];
        chars['E'-'A']=chars['E'-'A']-chars['T'-'A'];
        chars['E'-'A']=chars['E'-'A']-chars['T'-'A'];

        //F��ʾFIVE
        numbers[5]=chars['F'-'A'];
        chars['I'-'A']=chars['I'-'A']-chars['F'-'A'];
        chars['V'-'A']=chars['V'-'A']-chars['F'-'A'];
        chars['E'-'A']=chars['E'-'A']-chars['F'-'A'];

        //S��ʾSEVEN

        numbers[7]=chars['S'-'A'];
        chars['E'-'A']=chars['E'-'A']-chars['S'-'A'];
        chars['V'-'A']=chars['V'-'A']-chars['S'-'A'];
        chars['E'-'A']=chars['E'-'A']-chars['S'-'A'];
        chars['N'-'A']=chars['N'-'A']-chars['S'-'A'];

        //I��ʾNINE
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
