package com.hzz.thenewsweb.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ActionUtils {

    public static  void backuserData(String str) throws IOException{
        HttpServletResponse response=ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        PrintWriter printWriter=response.getWriter();
        printWriter.write(str);
        printWriter.flush();
        printWriter.close();
    }
	public static void actionPrintWrite(String content) throws IOException {
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter pw=response.getWriter();
		pw.append(content);
		pw.flush();
		pw.close();
	}
	
	/**
	 * MultipartForm鍝嶅簲
	 * @param discCachePath 纾佺洏缂撳瓨璺緞 //娴嬭瘯锛�"/Users/gudonghu/temp"
	 * @param savePath 涓嬭浇鐩綍鐩稿璺緞
	 * @return 鎻愪氦琛ㄥ崟Map
	 * @throws Exception
	 */
	public static Map<String,String> MultipartFormResponse(String discCachePath,String savePath) throws Exception {
		Map<String,String> map=null;
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		String fileName=null;
		String path=ServletActionContext.getServletContext().getRealPath(savePath);
		File uploadPath = new File(path);
        if (!uploadPath.exists()) {
        	uploadPath.mkdirs();
        }
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if(isMultipart){  
        	map=new HashMap<String, String>();
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(1024*1024);  
            //璁剧疆涓�鏃︽枃浠跺ぇ灏忚秴杩噂etSizeThreshold()鐨勫�兼椂鏁版嵁瀛樻斁鍦ㄧ‖鐩樼殑鐩綍   
            factory.setRepository(new File("/Users/gudonghu/temp"));  
            // Create a new file upload handler  
            ServletFileUpload upload = new ServletFileUpload(factory);  
            // 鎸囧畾鍗曚釜涓婁紶鏂囦欢鐨勬渶澶у昂瀵�,鍗曚綅:瀛楄妭锛岃繖閲岃涓�50Mb    
            upload.setFileSizeMax(50 * 1024 * 1024);    
            //鎸囧畾涓�娆′笂浼犲涓枃浠剁殑鎬诲昂瀵�,鍗曚綅:瀛楄妭锛岃繖閲岃涓�50Mb  
            upload.setSizeMax(50 * 1024 * 1024);     
            upload.setHeaderEncoding("UTF-8");
              
            List<FileItem> items = null;  
            // 瑙ｆ瀽request璇锋眰  
            items = upload.parseRequest(request);         
            if(items!=null){  
                //杩唬瑙ｆ瀽琛ㄥ崟椤圭洰  
                Iterator<FileItem> iter = items.iterator();  
                while (iter.hasNext()) {  
                    FileItem item = iter.next(); 

                    if (item.isFormField()) {  

                        String name = item.getFieldName();

                        String value = item.getString();
                        map.put(name, value);
                       
                    }

                    else {  


                        fileName = item.getName();  

                        fileName = fileName.substring(fileName.lastIndexOf("/") + 1);// 鑾峰緱涓婁紶鏂囦欢鐨勬枃浠跺悕  

                        item.write(new File(path, fileName)); 
                        map.put("fileName", fileName);
                    } 
                }  
            }     
        }  
        return map;
	}
	/**

	 */
	public static void ImgsUploadResponse(String discCachePath) throws Exception {
		
	
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		//涓婁紶鏂囦欢鍚� 
		String fileName=null;
		String path="";
        request.setCharacterEncoding("utf-8");  
        response.setCharacterEncoding("utf-8");  
          
        //妫�娴嬫槸涓嶆槸瀛樺湪涓婁紶鏂囦欢  
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);  
          
        if(isMultipart){  
        	
            DiskFileItemFactory factory = new DiskFileItemFactory();  
            //鎸囧畾鍦ㄥ唴瀛樹腑缂撳瓨鏁版嵁澶у皬,鍗曚綅涓篵yte,杩欓噷璁句负1Mb  
            factory.setSizeThreshold(1024*1024);  
            //璁剧疆涓�鏃︽枃浠跺ぇ灏忚秴杩噂etSizeThreshold()鐨勫�兼椂鏁版嵁瀛樻斁鍦ㄧ‖鐩樼殑鐩綍   
            factory.setRepository(new File("/Users/gudonghu/temp"));  
            // Create a new file upload handler  
            ServletFileUpload upload = new ServletFileUpload(factory);  
            // 鎸囧畾鍗曚釜涓婁紶鏂囦欢鐨勬渶澶у昂瀵�,鍗曚綅:瀛楄妭锛岃繖閲岃涓�50Mb    
            upload.setFileSizeMax(50 * 1024 * 1024);    
            //鎸囧畾涓�娆′笂浼犲涓枃浠剁殑鎬诲昂瀵�,鍗曚綅:瀛楄妭锛岃繖閲岃涓�50Mb  
            upload.setSizeMax(50 * 1024 * 1024);     
            upload.setHeaderEncoding("UTF-8");
              
            List<FileItem> items = null;  
            // 瑙ｆ瀽request璇锋眰  
            items = upload.parseRequest(request);         
            if(items!=null){  
                //杩唬瑙ｆ瀽琛ㄥ崟椤圭洰  
                Iterator<FileItem> iter = items.iterator();  
                while (iter.hasNext()) {  
                    FileItem item = iter.next(); 
                    //濡傛灉鏄櫘閫氳〃鍗曞睘鎬�  
                    if (item.isFormField()) {  
                        //鐩稿綋浜巌nput鐨刵ame灞炴��   <input type="text" name="content">  
                        String name = item.getFieldName();
                        //input鐨剉alue灞炴��  
                        String value = item.getString();
                       
                        path=ServletActionContext.getServletContext().getRealPath(value);
                		File uploadPath = new File(path);
                        if (!uploadPath.exists()) {
                        	uploadPath.mkdirs();
                        }
                    }  
                    //濡傛灉鏄笂浼犳枃浠�  
                    else {  
                        //灞炴�у悕  
                        String fieldName = item.getFieldName();                        
                        //璺緞
                        //fileName = item.getName();  
                        //鏂囦欢鍚�
                        //fileName = fileName.substring(fileName.lastIndexOf("/") + 1);// 鑾峰緱涓婁紶鏂囦欢鐨勬枃浠跺悕  
                        //鍐欏叆鏂囦欢
                        item.write(new File(path, fieldName)); 
           
                    } 
                }  
            }     
        } 
	}
}
