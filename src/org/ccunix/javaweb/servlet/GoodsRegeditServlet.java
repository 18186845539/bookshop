package org.ccunix.javaweb.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.ccunix.javaweb.model.GoodsModel;

public class GoodsRegeditServlet extends HttpServlet{
	
    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";
 
    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		GoodsModel model = new GoodsModel();
		
		String name = request.getParameter("name");
		System.out.println("name=========="+name);
		
		String photo = request.getParameter("photo");
		System.out.println("photo=========="+photo);
		
		//处理文件上传的信息   
		// 检测是否为多媒体上传
        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;//结束函数
        }
        
        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        
        ServletFileUpload upload = new ServletFileUpload(factory);
        
        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);
         
        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // 中文处理
        upload.setHeaderEncoding("UTF-8"); 
        
        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = request.getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
	    System.out.println(uploadPath);
	    
	    // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        //处理数据  多媒体
        String uploadName = "";
        String filePath="";
        try {
			List<FileItem> formItems = upload.parseRequest(request);
			
			if (formItems != null && formItems.size() > 0) {
	                // 迭代表单数据
	                for (FileItem item : formItems) {
	                    // 处理不在表单中的字段
	                    if (!item.isFormField()) {
	                        uploadName = new File(item.getName()).getName();
	                        if(!(uploadName.endsWith(".jpg") || uploadName.endsWith(".png")) ) {
	                        	//继续执行
	                        	System.out.println("图片格式不正确");
	                        	request.setAttribute("message",
	     	                            "图片格式不正确!");
	                        	request.getRequestDispatcher("/html/goods/regedit.jsp").forward(request, response);
	                        }
	                        
	                        filePath = uploadPath + File.separator + uploadName;	                        
	                        File storeFile = new File(filePath);
	                        // 在控制台输出文件的上传路径
	                        System.out.println(filePath);
	                        // 保存文件到硬盘
	                        item.write(storeFile);
	                        request.setAttribute("message",
	                            "文件上传成功!");
	                        //放在商品模型中
	                        model.setImg(uploadName);
	                    }else {
	                    	//普通input信息
	                    	String inputName = item.getFieldName();
	                    	String inputValue = item.getString("utf-8");
	                    	System.out.println(inputName+"============"+inputValue);
	                    	
	                    	if("name".equals(inputName) ) {
	                    		model.setName(inputValue);
	                    	}else if("price".equals(inputName)) {
	                    		double price = Double.parseDouble(inputValue);
	                    		model.setPrice(price);
	                    	}else if("descs".equals(inputName)) {
	                    		model.setDescs(inputValue);
	                    	}
	                    	
	                    	
	                    }
	                }
	            }
			
			//上传成功  显示图片信息
			String realImgPath = request.getContextPath()+File.separator+UPLOAD_DIRECTORY+uploadName;
			response.setContentType("text/html; charset=UTF-8");
			System.out.println("filePath======================"+filePath);
			System.out.println("path========="+request.getContextPath());
			response.getWriter().println("<img src='"+request.getContextPath()+"/upload/"+uploadName+"'>");
			
		} catch (FileUploadException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
