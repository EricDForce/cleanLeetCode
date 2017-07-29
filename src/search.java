public class search {
    public static void main(String[] args){
        int[][] matrix = {{62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80},{63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81},{64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82},{65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83},{66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84},{67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85}};
        System.out.println(new search().searchMatrix(matrix, 81));
    }
    public int searchMatrix(int[][] matrix, int target) {
        int cnt = 0;
        for(int i=0;i<matrix.length;i++){
            System.out.println("i: " + i);
            if(searchArray(matrix[i], target))
                cnt++;
        }
        return cnt;
    }
    public boolean searchArray(int[] array, int target){
        int l = 0, r = array.length-1;
        while(l <= r){
            int mid = (l+r)>>1;
//            System.out.println("mid : " + mid);
            if(array[mid] == target)
                return true;
            else if(array[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return false;
    }
}
