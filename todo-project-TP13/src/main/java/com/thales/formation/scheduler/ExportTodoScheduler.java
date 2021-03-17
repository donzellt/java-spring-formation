package com.thales.formation.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thales.formation.service.TodoService;

@Service
public class ExportTodoScheduler {

	@Autowired
	private TodoService todoService;
	
	@Async
	@Transactional(readOnly = true)
	@Scheduled(fixedDelay = 10000)
	public void doExportTodo() {
		System.out.println("doExportTodo : begin");
		todoService.exportTodos();
		System.out.println("doExportTodo : end");
	}
//	
//	@Scheduled(fixedDelay = 1000)
//	public void doExportTodo2() {
//		log.info("Export doExportTodo2");
//	}
	
//	@Transactional()
//	@Async
//	@Scheduled(fixedRate = 2000)
//	public void doExportTodo3() {
//		try {
//			TimeUnit.SECONDS.sleep(5);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		log.info("Export doExportTodo3");
//	}
	
}
