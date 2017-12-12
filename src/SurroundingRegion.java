/**
 * Created by mming on 7/11/17.
 */
public class SurroundingRegion {

    int[] father;
    public void surroundedRegions(char[][] board) {
        // Write your code here
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        int m = board.length;
        int n = board[0].length;
        father = new int[ m * n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    father[i * n + j] = -1;
                }else{
                    father[i * n + j] = i * n + j;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    if(i + 1 < m && board[i + 1][j] == 'O'){
                        connect(i * n + j, (i + 1) * n + j);
                    }
                    if(j + 1 < n && board[i][j + 1] == 'O'){
                        connect(i * n + j, i * n + j + 1);
                    }
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(find(i * n + j) != -1){
                    board[i][j] = 'X';
                }
            }
        }
    }
    int find(int x){
        if(father[x] == -1){
            return -1;
        }
        if(father[x] == x){
            return x;
        }
        return father[x] = find(father[x]);
    }
    void connect(int a, int b){
        int root_a  = find(a);
        int root_b = find(b);
        if(root_a != root_b && (root_a == -1 || root_b == -1)){
            father[root_a] = -1;
            father[root_b] = -1;
        }
    }

}
