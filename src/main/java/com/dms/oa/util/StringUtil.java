package com.dms.oa.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class StringUtil {

	public static List<Integer> jsonToList(String str){
		List<Integer> list=new ArrayList();
		str=str.replace("[", "").replace("]", "");
		String [] arr=str.split(",");
		for(int i=0;i<arr.length;i++){
			list.add(Integer.parseInt(arr[i]));
		}
		return list;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list=jsonToList("[3,5]");
		System.out.println(list.toString());

	}

}
