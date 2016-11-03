package com.ryl.app.utils;

import com.google.gson.Gson;
import com.ryl.app.MLog;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;

public class GsonParser {
	/**
	 *
	 * @功能描述: gson解析json数据 传递list 和字段标签
	 *
	 * @return
	 */
	public static Object gsonparser(String result, Type type, String tag) {
		try {
			Gson gson = new Gson();
			Object obj = null;
			obj = gson.fromJson(new JSONObject(result).getString(tag), type);
			return obj;
		} catch (Exception e) {
			MLog.e(e.toString());
		}
		return null;
	}

	public static Object gsonparser(String result, Type type) {
		try {
			Gson gson = new Gson();
			Object obj = null;
			obj = gson.fromJson(result, type);
			return obj;
		} catch (Exception e) {
			MLog.e(e.toString());
		}
		return null;
	}

	/**
	 * 转化成joson
	 * @param src
	 * @param type
     * @return
     */
	public static String gsonToJson(Object src, Type type) {
		try {
			Gson gson = new Gson();
			String obj = null;
			obj = gson.toJson(src, type);
			return obj;
		} catch (Exception e) {
			MLog.e(e.toString());
		}
		return null;

	}

	public static Object gsonparser(String result, Type type, String tag,
									int cateId) {
		try {
			Gson gson = new Gson();
			Object obj = null;
			JSONObject json = new JSONObject(result);
			int success = json.getInt("code");
			if (success == 0) {
				MLog.e(result);
			} else {
				// {"categorys":[{"plates":[{"channels":},{"channels":}]}],"code":1,"message":"success"}
				String categorys = json.getString(tag);
				String plates = new JSONObject(categorys).getString("plates");
				JSONArray channels = new JSONArray(plates);
				// for(n:channels){
				//
				// }
				// obj = gson.fromJson(, type);
				return obj;
			}
		} catch (Exception e) {
			MLog.e(e.toString());
		}
		return null;
	}
}
