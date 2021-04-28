package cn.itcast.demo09;

import java.io.File;
import java.io.FileFilter;

/*
 * 自定义过滤器
 * 实现 FileFilter 重写抽象方法
 */
public class MyFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return true;
    }
}
