package cn.zjyc.together.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zjyc.together.service.AppException;
import cn.zjyc.together.service.ChangeUserIconService;
import cn.zjyc.together.util.ConverterUtil;

/**
 * 
 * @ClassName: AttachmentController
 * @Description:修改头像表示层
 * @author: while_box
 * @date: 2017年10月14日 下午4:51:49 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
@Controller
public class AttachmentController {

	private String filePath = null;
	private String uploadPath = null;// 上传文件的目录
	private String tempPath = null;// 临时文件目录
	private Integer user_id;

	@Resource(name = "changeUserIconService")
	private ChangeUserIconService cuis;

	@RequestMapping("/upload.do")
	@ResponseBody
	public Map<String, Object> upload(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("text/json;charset=utf-8");
		Map<String, Object> state = new HashMap<String, Object>();
		ServletContext servletContext = null;
		servletContext = request.getServletContext();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 获取服务器绝对路径,根据服务器绝对路径打开目录,若目录不存在则创建一个目录
		filePath = servletContext.getRealPath("/");
		uploadPath = filePath + "temp";
		tempPath = filePath + "temp" + File.separator + "buffer" + File.separator;
		File uploadFile = new File(filePath);
		if (!uploadFile.exists()) {
			uploadFile.mkdirs();
		}
		File tempPathFile = new File(tempPath);
		if (!tempPathFile.exists()) {
			tempPathFile.mkdirs();
		}

		// 设置缓冲区大小
		factory.setSizeThreshold(4 * 1024);
		// 设置临时文件目录
		factory.setRepository(tempPathFile);
		// 创建ServletFileUpload实例对象
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 设置允许上传的最大文件大小为4M
		upload.setSizeMax(4 * 1024 * 1024);

		// 防止重名后文件名
		String fileName = null;
		try {
			// 解析HTTP请求消息头
			List<FileItem> items = upload.parseRequest(request);
			// 处理表单元素
			Iterator<FileItem> i = items.iterator();
			while (i.hasNext()) {
				FileItem item = i.next();
				if (item.isFormField()) {
					// 处理表单内容
					// System.out.println("处理表单内容 ...");
					processFormField(item);
				} else {
					// 处理上传的文件
					fileName = processUploadFile(item);
					cuis.changeUserIcon(user_id, fileName);
				}
			}
			// System.out.println("保存成功");
		} catch (Exception e) {
			if (e instanceof AppException) {
				// 应用异常，
				// 明确提示用户采取正确的操作
				System.out.println(e.getMessage());
				state.put("code", 1);
				state.put("msg", e.getMessage());
				return state;
			} else {
				// 系统异常
				// 提示用户稍后重试
				System.out.println("系统异常，提示用户稍后再试");
				state.put("code", 1);
				state.put("msg", "请稍后再试");
				return state;
			}
		}
		state.put("code", 0);
		state.put("msg", "success");
		state.put("data", fileName);
		return state;
	}

	/**
	 * 处理上传文件
	 * 
	 * @param item
	 * @param pw
	 * @throws Exception
	 */
	private String processUploadFile(FileItem item) throws Exception {
		String fileName = item.getName();// 文件名称
		String suffix = fileName.substring(fileName.lastIndexOf('.'));// 文件后缀
		// 文件新名称(唯一)
		String newFileName = null;
		// 获取文件大小
		long fileSize = item.getSize();

		if ("".equals(fileName) || fileSize == 0) {
			System.out.println("文件名为空");
		} else if (fileName != null) {
			newFileName = UUID.randomUUID().toString().replaceAll("-", "") + user_id + suffix;
			File fullFile = new File(newFileName);
			File saveFile = new File(uploadPath, fullFile.getName());
			item.write(saveFile);
			// pw.println(fileName + "文件保存成功");
			// pw.println("文件大小为:" + fileSize + "\r\n");
		}
		return newFileName;
	}

	/**
	 * 处理表单内容
	 * 
	 * @param item
	 * @param pw
	 */
	private void processFormField(FileItem item) {
		// String name = item.getFieldName();
		user_id = ConverterUtil.toInteger(item.getString());
		// System.out.println(user_id);
		// pw.println(name + " : " + user_id + "\r\n");
	}
}
