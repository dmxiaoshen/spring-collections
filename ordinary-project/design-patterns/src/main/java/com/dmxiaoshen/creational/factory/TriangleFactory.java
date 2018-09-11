package com.dmxiaoshen.creational.factory;

/**
 * Created by hzhsg on 2018/5/2.
 */
public class TriangleFactory implements ShapeFactory{
    @Override
    public Shape getShape() {
        return new Triangle();
    }
}
