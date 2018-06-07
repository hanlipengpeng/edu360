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
1：使用io流读取数据（bufferedReader），每一行数据就读过来了
2：使用字符串的分割
	1）：使用冒号分割   用户名，好友列表
	2）：好友列表进行分割   一个个的好友
//Map<用户名和好友列表>
//Map<用户名和长度>
//转化为list排序
3：求取用户对应的好友数量（后面的长度）
4：根据数量进行排序
 */
public class TestMain1 {
	public static void main(String[] args) {
		Map<String, List<String>> map =getUserInfo();
		Map<String, Integer> map2 = new HashMap<>();
		Set<Entry<String,List<String>>> entrySet = map.entrySet();
		for (Entry<String, List<String>> entry : entrySet) {
			map2.put(entry.getKey(), entry.getValue().size());
		}
		//System.out.println(map2);
		
		List<UserNameCount> list = new ArrayList<>();
		for (Entry<String, Integer> entry : map2.entrySet()) {
			UserNameCount user = new UserNameCount();
			user.setUserName(entry.getKey());
			user.setCount(entry.getValue());
			list.add(user);
		}
		
		//排序
		Collections.sort(list, new Comparator<UserNameCount>() {

			@Override
			public int compare(UserNameCount o1, UserNameCount o2) {
				// TODO Auto-generated method stub
				return o2.getCount()-o1.getCount();
			}
		});
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
	}
	/**
	 * 用户名和用户列表
	 * @return
	 */
	public static Map<String,List<String>> getUserInfo() {
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
				map.put(userName, new ArrayList<>(Arrays.asList(fs)));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

}
