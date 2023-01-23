package manytoone_uni.controller;

import manytoone_uni.dao.SchoolCrud;
import manytoone_uni.dao.StudentCrud;
import manytoone_uni.dao.TeacherCrud;
import manytoone_uni.dto.School;
import manytoone_uni.dto.Student;
import manytoone_uni.dto.Teacher;

public class MainTeacher {
	public static void main(String[] args) {
		School school=new School();
		school.setId(139);
		school.setNameString("vidya sagsr");
		Student student=new Student();
		student.setId(139);
		student.setName("mani");
		student.setSchool(school);
		Teacher teacher=new Teacher();
		teacher.setId(129);
		teacher.setName("johny");
		teacher.setSchool(school);
		StudentCrud studentCrud=new StudentCrud();
//		studentCrud.save(student,109);
		SchoolCrud schoolCrud=new SchoolCrud();
		schoolCrud.delete(169);
		TeacherCrud teacherCrud=new TeacherCrud();
//		teacherCrud.save(teacher,169);
	}
}
