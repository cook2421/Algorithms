package Sort.Fast;

import java.util.Arrays;

public class A_MergeSort {


    static int[] sorted = new int[8];


    public static void merge(int array[], int left, int mid, int right) {
        int first = left;             // 첫 번째 부분집합의 시작 위치 설정
        int second = mid+1;           // 두 번째 부분집합의 시작 위치 설정
        int index = left;             // 배열 sorted에 정렬된 원소를 저장할 위치 설정

        while(first<=mid && second<=right) {
            if(array[first] <= array[second]) {
                sorted[index] = array[first];
                first++;
            }else {
                sorted[index] = array[second];
                second++;
            }
            index++;
        }

        if(first>mid) {
            for(int i=second; i<=right; i++,index++) {
                sorted[index] = array[i];
            }
        }else {
            for(int i=first; i<=mid; i++,index++) {
                sorted[index] = array[i];
            }
        }

        for(int i=left; i<=right; i++) {
            array[i] = sorted[i];
        }

        System.out.println("병합 정렬 후: "+Arrays.toString(array));
    }


    public static void mergeSort(int array[], int left, int right) {

        int mid;

        if(left < right) {
            mid = (left+right)/2;
            mergeSort(array, left, mid);           // 앞 부분에 대한 분할 작업 수행
            mergeSort(array, mid+1, right);    // 뒷 부분에 대한 분할 작업 수행
            merge(array, left, mid, right);        // 부분집합에 대하여 정렬과 병합 작업 수행
        }
    }


    public static void main(String[] args) {
        int[] array = {30, 70, 40, 20, 10, 50, 80};
        int length = array.length;
        System.out.println("정렬 수행 전: "+Arrays.toString(array));
        System.out.println("-----------------병합 정렬 수행 시작------------------");
        mergeSort(array, 0, length-1);
    }
}
