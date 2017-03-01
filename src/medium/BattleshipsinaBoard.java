package medium;

/**
 * Created by novas on 2017/2/25.
 */
public class BattleshipsinaBoard {
    public static void main(String[] args)
    {

    }
    public int countBattleships(char[][] board) {
        int count=0;
       for (int i=0;i<board.length;i++)
       {
           for (int j=0;j<board[i].length;j++)
           {
               if(board[i][j]=='X')
               {
                   if(j-1==-1&&i-1==-1)
                   {
                       count++;
                   }
                   else if(j-1==-1)
                   {
                       if(board[i-1][j]=='.')
                       {
                           count++;
                       }
                   }
                   else if(i-1==-1)
                   {
                       if(board[i][j-1]=='.')
                       {
                           count++;
                       }
                   }
                   else if(board[i][j-1]=='.'&&board[i-1][j]=='.')
                   {
                       count++;
                   }
               }
           }
       }
        return count;
    }
}
