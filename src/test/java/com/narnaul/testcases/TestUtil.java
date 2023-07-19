package com.narnaul.testcases;

import org.json.JSONObject;

import com.narnaul.utils.listeners.ExtentListeners;
public class TestUtil
{
	public static boolean jsonHasKey(String json, String key)
	{
		JSONObject jsonObject = new JSONObject(json);
		ExtentListeners.testReport.get().info("validating the presenceof key : " + key);
		return jsonObject.has(key);

	}

	public static String getJsonKeyValue(String json, String key)
	{
		JSONObject jsonObject = new JSONObject(json);
		ExtentListeners.testReport.get().info("validating the presence of key : " + key);
		return jsonObject.get(key).toString();
	}

}
