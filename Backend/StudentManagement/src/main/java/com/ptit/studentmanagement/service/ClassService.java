package com.ptit.studentmanagement.service;

public interface ClassService {
    void addClass(String classId, String className);
    // void updateClass(String classId, String className);
    Class getClass(Long id);
    // void deleteClass(Long id);
    // truy van danh sach lop hoc
}
