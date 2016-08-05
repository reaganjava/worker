package com.umbrella.worker.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.umbrella.worker.dto.WorkerItemDO;
import com.umbrella.worker.dto.WorkerStaffDO;
import com.umbrella.worker.dto.WorkerTaskDO;
import com.umbrella.worker.result.ResultDO;
import com.umbrella.worker.service.IWorkerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/daoSource.xml"})
public class WorkerServiceTest {
	
	@Autowired
	private IWorkerService workerService;  

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreate() {
		List<WorkerItemDO> workerItems = new ArrayList<WorkerItemDO>();
		List<WorkerStaffDO> workerStaffs = new ArrayList<WorkerStaffDO>();
		WorkerTaskDO workerTaskDO = new WorkerTaskDO();
		workerTaskDO.setwWName("保洁服务");
		//workerTaskDO.setwWPrice(30);
		workerTaskDO.setwWPriceUnit(1);
		workerTaskDO.setwWType(1);
		workerTaskDO.setCreateAuthor("admin");
		workerTaskDO.setwWSupplier(1);
		WorkerItemDO workerItemDO = new WorkerItemDO();
		workerItemDO.setwWiItem("80平方米");
		workerItemDO.setCreateAuthor("admin");
		workerItems.add(workerItemDO);
		workerTaskDO.setWorkerItems(workerItems);
		WorkerStaffDO workerStaffDO = new WorkerStaffDO();
		workerStaffDO.setwWsStaffCount(1);
		workerStaffDO.setwWsHours(2);
		workerStaffDO.setCreateAuthor("admin");
		workerStaffs.add(workerStaffDO);
		ResultDO resultDO = workerService.create(workerTaskDO);
		assertTrue(resultDO.isSuccess());   
	}

}
