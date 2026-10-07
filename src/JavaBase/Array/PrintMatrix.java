package JavaBase.Array;

public class PrintMatrix {
    static void main() {
        int [][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int [] row : matrix){
            for (int el : row){
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}
