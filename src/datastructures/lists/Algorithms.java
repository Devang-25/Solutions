/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.lists;

/**
 *
 * @author gopimac
 */
public class Algorithms {

    void mergesort(int arr[], int left, int right) {
        int mid = (left + right) / 2;
        while (left < right) {
            mergesort(arr, left, mid);
            mergesort(arr, mid + 1, right);
        }
    }

    void merge(int a[], int left, int mid, int right) {
        int temp[] = new int[left - right + 1];
    }

    public void quicksort(int arr[]) {
        this.quicksort(arr, 0, arr.length - 1);
        System.out.println("");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    private void quicksort(int arr[], int low, int high) {
        if (high > low) {
            int partitionIndex = this.partitionIndex(arr, low, high);
            System.out.println(partitionIndex + ":" + arr[partitionIndex]);
            for (int i = low; i <= partitionIndex - 1; i++) {
                System.out.print(arr[i] + "\t");
            }
            this.quicksort(arr, low, partitionIndex - 1);
            for (int i = partitionIndex + 1; i <= high; i++) {
                System.out.print(arr[i] + "\t");
            }
            this.quicksort(arr, partitionIndex + 1, high);
        }
    }

    int partitionIndex(int A[], int low, int high) {
        int l = low;
        int r = high;
        int pivot = l;
        while (l < r) {
            while (r != pivot && A[r] > A[pivot]) {
                r--;
            }
            if (r == pivot) {
                return r;
            }
            int temp = A[r];
            A[r] = A[l];
            A[l] = temp;
            pivot = r;
            while (A[pivot] > A[l]) {
                l++;
            }
            temp = A[r];
            A[r] = A[l];
            A[l] = temp;
            pivot = l;
        }
        return pivot;
    }
}
