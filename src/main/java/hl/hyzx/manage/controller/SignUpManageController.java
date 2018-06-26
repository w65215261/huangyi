package hl.hyzx.manage.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hl.hyzx.common.R;
import hl.hyzx.manage.dto.SignUpManageDTO;
import hl.hyzx.manage.dto.SignUpShowManageDTO;
import hl.hyzx.manage.service.SignUpManageService;



@Controller
@RequestMapping("manage/signUp")
public class SignUpManageController {
	@Autowired
	SignUpManageService signUpManageService;
	
	@RequestMapping("getSignUpList")
	@ResponseBody
	public Map<String, Object> getSignUpList(int iDisplayStart, int iDisplayLength) {
		List<SignUpManageDTO> list = signUpManageService.getSignUpList(iDisplayStart, iDisplayLength);
		int size = signUpManageService.getSignUpCount().size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iTotalRecords", size);
		map.put("iTotalDisplayRecords", size);
		map.put("aaData", list);
		return map;
	}

	@RequestMapping("save")
	@ResponseBody
	public R save(int id,String title, String content, int imgId) {
		int result = 0;
		if (id == 0)
			result = signUpManageService.save(title, content, imgId);
		else
			result = signUpManageService.update(id, title, content, imgId);

		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障！");
	}

	@RequestMapping("getSignUp/{id}")
	@ResponseBody
	public R getSignUp(@PathVariable("id") int id) {
		SignUpManageDTO signUp = signUpManageService.getSignUp(id);
		return R.ok().put("signUp", signUp);
	}

	@RequestMapping("del/{id}")
	@ResponseBody
	public R del(@PathVariable("id") int id) {
		int result = signUpManageService.del(id);
		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障");
	}
	
	@RequestMapping("getSignUpShowList")
	@ResponseBody
	public Map<String, Object> getSignUpShowList(int iDisplayStart, int iDisplayLength,String tiaojian) {
		List<SignUpShowManageDTO> list = signUpManageService.getSignUpShowList(iDisplayStart, iDisplayLength, tiaojian);
		int size = signUpManageService.getSignUpShowCount(tiaojian).size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iTotalRecords", size);
		map.put("iTotalDisplayRecords", size);
		map.put("aaData", list);
		return map;
	}
	
	@RequestMapping("getSignUpShow/{id}")
	@ResponseBody
	public R getSignUpShow(@PathVariable("id") int id) {
		SignUpShowManageDTO signUpShow = signUpManageService.getSignUpShow(id);
		return R.ok().put("signUpShow", signUpShow);
	}

	@RequestMapping("delShow/{id}")
	@ResponseBody
	public R delShow(@PathVariable("id") int id) {
		int result = signUpManageService.delShow(id);
		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障");
	}
	
	/**
	 * 导出查询结果到xlsx
	 * 
	 * @param response
	 * @param tiaojian
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("export")
	public void export(HttpServletResponse response, String tiaojian) throws UnsupportedEncodingException {
		XSSFWorkbook wb = new XSSFWorkbook();
		// sheet1
		List<SignUpShowManageDTO> list = signUpManageService.getSignList(tiaojian);
		XSSFSheet sheet = wb.createSheet("报名数（共" + list.size() + "个人）");
		String[] title1 = { "报名人", "报名人手机号", "报名人邮箱", "报名人QQ号", "报名人微信号", "报名标题" };
		Row row = sheet.createRow(0);
		for (int x = 0; x < title1.length; x++) {
			Cell cell = row.createCell(x);
			cell.setCellValue(title1[x]);
		}
		for (int y = 0; y < list.size(); y++) {
			int x = 0;
			row = sheet.createRow(y + 1);
			row.createCell(x++).setCellValue(list.get(y).getSignName() == null ? "" : list.get(y).getSignName().toString());
			row.createCell(x++).setCellValue(list.get(y).getSignPhone() == null ? "" : list.get(y).getSignPhone().toString());
			row.createCell(x++).setCellValue(list.get(y).getSignMailbox() == null ? "" : list.get(y).getSignMailbox().toString());
			row.createCell(x++).setCellValue(list.get(y).getSignQq() == null ? "" : list.get(y).getSignQq().toString());
			row.createCell(x++).setCellValue(list.get(y).getSignWechat() == null ? "" : list.get(y).getSignWechat().toString());
			row.createCell(x++).setCellValue(list.get(y).getSignTitle() == null ? "" : list.get(y).getSignTitle().toString());
		}
		
		OutputStream output = null;
		try {
			output = response.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		response.reset();
		String fileName = "报名人员信息表.xlsx";
		response.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		try {
			wb.write(output);
			output.flush();
			output.close();
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}