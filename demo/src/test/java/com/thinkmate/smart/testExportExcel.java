package com.thinkmate.smart;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import com.thinkmate.smart.entity.CourseEntity;
import com.thinkmate.smart.entity.StudentEntity;
import com.thinkmate.smart.entity.TeacherEntity;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class testExportExcel {

    @Test
    public void testExcel() throws IOException {
        List<CourseEntity> courseEntityList = new ArrayList<CourseEntity>();
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setId("1");
        courseEntity.setName("测试课程");
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setName("张老师");
        teacherEntity.setSex(1);
        courseEntity.setMathTeacher(teacherEntity);

        List<StudentEntity> studentEntities = new ArrayList<StudentEntity>();
        for (int i = 1; i <= 2; i++) {
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setName("学生" + i);
            studentEntity.setSex(i);
            studentEntity.setBirthday(new Date());
            studentEntities.add(studentEntity);
        }
        courseEntity.setStudents(studentEntities);
        courseEntityList.add(courseEntity);
        Date start = new Date();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("导出测试", null, "测试"),
                CourseEntity.class, courseEntityList);
        System.out.println(new Date().getTime() - start.getTime());
        File savefile = new File("D:/excel/");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("D:/excel/教师课程学生导出测试.xls");
        workbook.write(fos);
        fos.close();
    }

    /*@Test
    public void basetest() {
        try {
            ImportParams params = new ImportParams();
            //params.setNeedVerfiy(true);
            params.setVerfiyGroup(new Class[]{ViliGroupOne.class});
            ExcelImportResult<ExcelVerifyEntity> result = ExcelImportUtil.importExcelMore(
                    new File(PoiPublicUtil.getWebRootPath("import/verfiy.xlsx")),
                    ExcelVerifyEntity.class, params);
            FileOutputStream fos = new FileOutputStream("D:/excel/ExcelVerifyTest.basetest.xlsx");
            result.getWorkbook().write(fos);
            fos.close();
            for (int i = 0; i < result.getList().size(); i++) {
                System.out.println(ReflectionToStringBuilder.toString(result.getList().get(i)));
            }
            Assert.assertTrue(result.getList().size() == 1);
            Assert.assertTrue(result.isVerfiyFail());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }*/
}