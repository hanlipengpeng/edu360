package cn.edu360.day01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.alibaba.fastjson.JSON;

/**
 * key-value  使用冒号分割
 * 每个值使用逗号分割
 * 对象使用{}
 * 使用[]   表示数组
 *
 */
public class JsonTest {
	//http://gc.ditu.aliyun.com/regeocoding?l=41.083778,113.983896&type=010 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("E:\\data\\rating.txt")); 
		
		String line = null;
		while((line=br.readLine())!=null){
			//System.out.println(line);
			//JSON json = new JSON();
			//JSON.parseObject(text, clazz)
			//json.p
			ReatingBean parseObject = JSON.parseObject(line, ReatingBean.class);
			System.out.println(parseObject);
		}
		
		
	}

}
