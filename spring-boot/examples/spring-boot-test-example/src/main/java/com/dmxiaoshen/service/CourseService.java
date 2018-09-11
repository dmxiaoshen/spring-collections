package com.dmxiaoshen.service;

import com.dmxiaoshen.model.Course;

/**
 * Created by hzhsg on 2018/7/24.
 */
public interface CourseService {

    Course getCourseByStudentId(String studentId);
}
