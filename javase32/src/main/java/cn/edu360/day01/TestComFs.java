package cn.edu360.day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * 获取两个好友测试
 * @author Administrator
 *
 */
public class TestComFs {
	public static void main(String[] args) {
		Map<String, List<String>> userInfo = TestMain1.getUserInfo();
		String name1="涛哥";
		String name2="远哥";
		//获取用户1的好友列表
		List<String> list1 = userInfo.get(name1);
		List<String> list2 = userInfo.get(name2);
		//取交集的
		ArrayList<String> arrayList = new ArrayList<String>(list1);
		arrayList.retainAll(list2);
		System.out.println(arrayList);
	}

}
