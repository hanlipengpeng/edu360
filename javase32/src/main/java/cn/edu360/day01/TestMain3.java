package cn.edu360.day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
1：使用io流读取数据（bufferedReader），每一行数据就读过来了
2：使用字符串的分割
	1）：使用冒号分割   用户名，好友列表
	2）：好友列表进行分割   一个个的好友
3：获取好友对应的好友列表
4：获取好友列表进行遍历
两个用户的共同好友
 */
public class TestMain3 {
	public static void main(String[] args) {
		//获取好友以及对应的好友列表
		Map<String, List<String>> userInfo = TestMain1.getUserInfo();
		//获取用户列表
		Set<String> userSet = userInfo.keySet();
		//set转化为list
		ArrayList<String> userList = new ArrayList<>(userSet);
		//循环的比较    类似于冒泡
		for(int i = 0;i<userList.size()-1;i++){//控制轮数
			//获取第一个用户，，，然后获取第一个用户的好友列表
			String user = userList.get(i);
			List<String> list1 = userInfo.get(user);
			for(int j = i+1;j<userList.size();j++){
				//获取第二个用户
				String user2 = userList.get(j);
				//获取值的时候只是做了一个引用
				List<String> list2 = userInfo.get(user2);
				//不能在原始数据上操作
				List<String> list3 = new ArrayList<>(list2);
				//取交集
				list3.retainAll(list1);
				if(list3!=null&&list3.size()>0){
					//保存到文件中
					System.out.println(user+"和"+user2+"的共同好友："+list3);
				}
			}
			
		}

	}

}
