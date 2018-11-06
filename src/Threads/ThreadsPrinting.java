package Threads;

import java.util.*;

public class ThreadsPrinting {
	static ArrayList<Integer> l1= new ArrayList<Integer>();
	static ArrayList<Integer> l2= new ArrayList<Integer>();
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable()
				{

					public void run() {
						for(int i =0; i<10;i++)
						{
							System.out.println("thread id:"+Thread.currentThread().getId()+" value"+i);
							l1.add(i);
						}
						
					}
			
				});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				for(int i =0; i<10;i++)
				{
					System.out.println("thread id:"+Thread.currentThread().getId()+" value"+i);
					l2.add(i);
					
				}
			}

		});
		t1.start();
		t2.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(l1);
		System.out.println(l2);
		
	}

}
