import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmOA2 {
    public int oa2(int rows, int columns, List<List<Integer>> grids) {
        int blank = 0;
        int hours = 0;
        if (grids == null || grids.size() == 0) {
            return hours;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grids.get(i).get(j) == 0) {
                    blank++;
                }
            }
        }
        while (blank > 0) {
            blank -= oneRound(rows, columns, grids);
            hours++;
        }
        return hours;
    }

    private int oneRound(int rows, int columns,  List<List<Integer>> grids) {
        int fill = 0;
        int[] horizon = new int[]{-1, 0, 1, 0};
        int[] verizon = new int[]{0, 1, 0, -1};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grids.get(i).get(j) == 1) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + horizon[k];
                        int y = j + verizon[k];
                        if (x >= 0 && x < rows && y >= 0 && y < columns && grids.get(x).get(y) == 0) {
                            grids.get(x).set(y, 2);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grids.get(i).get(j) == 2) {
                    grids.get(i).set(j, 1);
                    fill++;
                }
            }
        }
        return fill;
    }
}
