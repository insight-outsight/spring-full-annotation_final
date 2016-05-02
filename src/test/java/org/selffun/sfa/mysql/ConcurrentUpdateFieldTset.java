package org.selffun.sfa.mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentUpdateFieldTset {

	static int threadsNum = 150;
	
	static ExecutorService executorService = 
			Executors.newFixedThreadPool(threadsNum);
	
	static String url = "jdbc:mysql://localhost:3306/test";
	
	
	public static void main(String[] args) {

		AtomicInteger threadMarker = new AtomicInteger(0);
		
		List<Callable<Void>> threadsTasks = new ArrayList<Callable<Void>>(threadsNum);
		
		for(int i=0;i<threadsNum;i++){
			threadsTasks.add(new Callable<Void>(){

				@Override
				public Void call() throws Exception {
					Connection conn = null;
					
					try{
						conn =   DriverManager.getConnection(url,"root","root");

						conn.createStatement().execute("UPDATE and_bill SET MONTH=MONTH+1 WHERE id=37;");
						
						if(conn != null){
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
						System.out.println(threadMarker.getAndIncrement()+" finished.");

					}catch(Exception e){
						e.printStackTrace();
					}finally{
						if(conn != null){
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
					

					return null;
				}
				
			});
		}


		try {
			List<Future<Void>> results = executorService.invokeAll(threadsTasks);
			for(Future<Void> f:results){
					if(f.isDone()){	
						f.get();
					}
					else{
						System.out.println("压力测试-线程执行未完成。.........................");
					}
			}
			executorService.shutdown();
			executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);
		} 
		catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} 
		
	   
	}
	
}