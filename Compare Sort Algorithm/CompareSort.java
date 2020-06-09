import java.util.Arrays;
/*Data Structure Lecture, Assignment 2 : Sorting with Heap
 *In this assignment, randomly assigned arrays were sorted using 3 different sorting algorithms. 
 *Arrays filled with random numbers were first sorted in the heap sort function, 
 *then in the java sort algorithm and finally in the selection sort algorithm. 
 *The sequencing time for each array in each algorithm was measured and averaged.
 *@author Ahsen Amil
 *@date Dec 16, 2019 
 */
public class CompareSort {

	public static void main(String[] args) {
		Integer[] list = new Integer[10000];                                 //create an array
		System.out.println("Array size: " + list.length);
		for(int i = 0; i < list.length; i++) {                               //array filled
			list[i] = (int) (Math.random() * 10000000);                      //array filled with random numbers
		}
		int repeat = 0;                                                      //for use many arrays for heap sort
		double average=0;                                                    //for average time for heap sort
		while(repeat < 10) {

			for(int i = 0; i < list.length; i++) {                           //array filled by repeat
				list[i] = (int) (Math.random() * 10000000);                  
			}

			long startTime = System.nanoTime();                              //start time of function
			heapSort(list);                                                  //implement heap sort
			long finishTime=System.nanoTime();                               //finish time of function
			double elapsedTimeMilliSeconds = (finishTime - startTime) / 1000000.0;     //calculate sorting time and convert to milliseconds
			System.out.println( (repeat+1) + ": " + elapsedTimeMilliSeconds + " msec");//print for each array's sorting times
			average += elapsedTimeMilliSeconds;                              //collect the array's sorting time
			repeat++;	                                                     //repeat all step by repeat's variable
		}
		System.out.println("Average Sort Time for Heap Sort           : "+average/10);//print the average sorting time for heap sort
		int repeat2 = 0;                                                     //for use many arrays for java sort
		double average2=0;                                                   //for average time for java sort
		while(repeat2 < 10) {

			for(int i = 0; i < list.length; i++) {
				list[i] = (int) (Math.random() * 10000000);
			} 
			long startTime = System.nanoTime();                              //start time of function
			javaSort(list);                                                  //implement java sort
			long finishTime=System.nanoTime();                               //finish time of function 
			double elapsedTimeMilliSeconds = (finishTime - startTime) / 1000000.0;//calculate sorting time and convert to milliseconds
			System.out.println( (repeat2+1) + ": " + elapsedTimeMilliSeconds + " msec");//print for each array's sorting times
			average2 += elapsedTimeMilliSeconds;                             //collect the array's sorting time
			repeat2++;	                                                     //repeat all step by repeat's variable
		}
		System.out.println("Average Sort Time for Java Array Sort     : "+average2/10);//print the average sorting time for java sort
		int repeat3 = 0;                                                     //for use many arrays for selection sort
		double average3=0;                                                   //for average time for selection sort
		while(repeat3 < 10) {			
			for(int i = 0; i < list.length; i++) {
				list[i] = (int) (Math.random() * 10000000);
			} 
			long startTime = System.nanoTime();                              //start time of function
			selectionSort(list);                                             //implement selection sort
			long finishTime=System.nanoTime();                               //finish time of function
			double elapsedTimeMilliSeconds = (finishTime - startTime) / 1000000.0;//calculate sorting time and convert to milliseconds
			System.out.println( (repeat3+1) + ": " + elapsedTimeMilliSeconds + " msec");//print for each array's sorting times
			average3 += elapsedTimeMilliSeconds;                             //collect the array's sorting time
			repeat3++;		                                                 //repeat all step by repeat's variable
		}
		System.out.println("Average Sort Time for Selection Sort      : "+average3/10);//print the average sorting time for selection sort
	}
	/*
	 * First a heap structure was created. 
	 * The elements in the array have been added to this heap structure.
	 * Elements in the heap structure have been deleted ending from the start. 
	 */
	public static void heapSort(Integer[] list) {
		Integer[] orjArray = list.clone();                        //to avoid the use of sorted arrays, the original array was cloned.
		Heap<Integer> heap = new Heap<Integer>();                 //create heap
		for (int i = 0; i < orjArray.length; i++)                 //elements have been added to heap
			heap.add(orjArray[i]);
		for (int i = orjArray.length - 1; i >= 0; i--)            //for the sorting elements have been deleted ending from the start
			orjArray[i] = (Integer) heap.remove();
	}
	/*
	 * In this section, use java sort algorithm.
	 */
	public static void javaSort(Integer[] list) {
		Integer[] orjArray = list.clone();                       //to avoid the use of sorted arrays, the original array was cloned.
		Arrays.sort(orjArray);                                   //use java sort algorithm with Arrays.sort
	}
	/*
	 * The smallest element was selected from the unsorted array 
	 * and replaced with the leftmost element, which becomes part of the sorted array. 
	 * This continued to move the unsorted array boundary to the right of an element.
	 */
	public static void selectionSort(Integer[] list) {
		Integer[] orjArray = list.clone();                       //to avoid the use of sorted arrays, the original array was cloned.
		for (int i = 0; i < (orjArray.length)-1; i++)
		{
			int minimumElement = i;                             //selected smallest element
			for (int j = i+1; j < orjArray.length; j++)
				if (orjArray[j] < orjArray[minimumElement])
					minimumElement = j;
			int temp = orjArray[minimumElement];                //swap the minimum element with the leftmost element
			orjArray[minimumElement] = orjArray[i];             //for the new minimum element
			orjArray[i] = temp;
		}
	}
}
