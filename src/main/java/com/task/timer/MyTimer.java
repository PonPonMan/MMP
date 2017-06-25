//package com.task.timer;
//
//import org.apache.log4j.Logger;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.core.initdata.DeviceServerUtils;
//import com.utils.thread.HandleThread;
//
//@Component
//public class MyTimer {
//	private static Logger log = Logger.getLogger(MyTimer.class);
//	private static JSONArray deviceServerArray = null;
//	private static JSONObject deviceWarning = null;
//	static {
//		deviceServerArray = DeviceServerUtils.getInstance().deviceServerArray;
//		deviceWarning = DeviceServerUtils.getInstance().deviceWarning;
//	}
//
//	// 早上8点到晚上10点间隔5分钟执行
//	@Scheduled(cron = "0 0/5 8-22 * * ?")
//	public void timerT() {
//		for (int i = 0; i < deviceServerArray.size(); i++) {
//			new HandleThread(deviceServerArray.getJSONObject(i), deviceWarning).start();
//		}
//		log.info("早上8点到晚上10点间隔5分钟执行");
//	}
//
//	// @Scheduled(fixedRate = 5000)
//	// public void timerF() {
//	// log.info("获取安卓序列号");
//	// }
//
//	// // 第一次延迟1秒执行，当执行完后3秒再执行
//	// @Scheduled(initialDelay = 1000, fixedDelay = 5000)
//	// public void timerInit() {
//	// System.out.println("1秒执行冯文飞后，任务结束后5秒再执行 ");
//	// }
//	//
//	// // 每天11点10分30秒时执行
//	// @Scheduled(cron = "30 03 14 * * ?")
//	// public void timerCron() {
//	// System.out.println("current time 14点3分30秒时执行 ");
//	// }
//}
