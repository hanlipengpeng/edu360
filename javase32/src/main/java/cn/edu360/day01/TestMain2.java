package cn.edu360.day01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
第一个代码优化
 */
public class TestMain2 {
	public static void main(String[] args) {
		//key--用户名      value--好友列表
		Map<String, List<String>> map =getUserInfo();
		//key--用户名       value--好友长度
		Map<String, Integer> map2 = new HashMap<>();
		Set<Entry<String,List<String>>> entrySet = map.entrySet();
		for (Entry<String, List<String>> entry : entrySet) {
			map2.put(entry.getKey(), entry.getValue().size());
		}
		
		//map-->list,    Entry作为List的泛型
		Set<Entry<String,Integer>> entrySet2 = map2.entrySet();
		ArrayList<Entry<String,Integer>> list = new ArrayList<>(entrySet2);
		//排序
		Collections.sort(list,new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o2.getValue()-o1.getValue();
			}
		});
		//输出
		for (Entry<String, Integer> entry : list) {
			//需要输出到文件
			System.out.println(entry);
		}
	}
	/**
	 * 用户名和用户列表
	 * @return
	 */
	private static Map<String,List<String>> getUserInfo() {
		//1：使用io流读取数据（bufferedReader），每一行数据就读过来了
		Map<String, List<String>> map = new HashMap<>();
		try(BufferedReader br = new BufferedReader(new FileReader("E:\\data\\好友.txt"));) {
			String line = null;
			while((line=br.readLine())!=null){
				//System.out.println(line);
				//2：使用字符串的分割
				//1）：使用冒号分割   用户名，好友列表
				//2）：好友列表进行分割   一个个的好友
				String[] split = line.split(":");
				String userName = split[0];
				String[] fs = split[1].split(",");
				//System.out.println(Arrays.toString(fs));
				//Arrays.asList  不能够进行增加或者删除   创建的是一个固定大小的长度
				map.put(userName, Arrays.asList(fs));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

}
