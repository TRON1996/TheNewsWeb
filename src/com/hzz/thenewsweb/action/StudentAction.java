package com.hzz.thenewsweb.action;



import com.hzz.thenewsweb.model.Testmodel;
import net.sf.json.JSONObject;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ParentPackage("struts-default")
public class StudentAction {
	@Action(value = "studentInfoAction")
	public String studentInfoAction() throws IOException {
		
		
		List<Testmodel> list=new ArrayList<Testmodel>();
		for(int i=0;i<100;i++) {
			Testmodel stu=new Testmodel();
			stu.setId(100+i);
			stu.setUsername("��" +i);
			stu.setSex("��");
			stu.setCity("�õ�"+i);
			stu.setClassify("aaa");
			stu.setExperience(110+i);
			stu.setScore(50+i);
			stu.setSign("bbbbb");
			stu.setWealth(123+i);
			list.add(stu);
		}
		JSONObject result = new JSONObject();
		result.put("code","0");
		result.put("data",list);
		result.put("msg","");
		result.put("count",list.size());
		//JSONArray json=JSONArray.fromObject(result);
		//响应到客户端数据
		//ActionUtils.actionPrintWrite(result.toString());
		return result.toString();
	}


	
	
}
