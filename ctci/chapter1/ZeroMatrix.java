import java.util.Arrays;

public class ZeroMatrix {
    public static void setZeros(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
        // go through and zero the rows
        for (int i=0; i < row.length; i++) {
            if(row[i]) {
                for (int k=0; k < matrix[0].length; k++) {
                    matrix[i][k] = 0;
                }
            }
        }

        // go through and zero the columns 
        for (int j=0; j < column.length; j++) {
            if(column[j]) {
                for (int k=0; k < matrix.length; k++) {
                    matrix[k][j] = 0;
                }
            }

        }
    }

    public static void main(String[] args) {
        int[][] testMatrix = {{1,2,0}, {1,2,1}};
        ZeroMatrix.setZeros(testMatrix);
        assert Arrays.deepToString(testMatrix) == "[[0, 0, 0], [1, 2, 0]]";

    }
}